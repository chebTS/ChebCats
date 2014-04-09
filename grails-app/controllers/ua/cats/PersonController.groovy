package ua.cats

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import org.codehaus.groovy.grails.web.json.JSONObject

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

//@Transactional(readOnly = true)
class PersonController {

    static allowedMethods = [index: "GET", create: "POST"]

    @Secured(['ROLE_USER'])
    def index() {
        render Person.list() as JSON
    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def create() {
        if (Person.findByEmail(params.email) ){
            def result = [:]
            result["statusCode"] = 409
            result["message"] = "Email already exist."
            render( status: 409, text: result as JSON) as JSON
        } else if (Person.findByUsername(params.username)){
            def result = [:]
            result["statusCode"] = 409
            result["message"] = "Username already exist."
            render( status: 409, text: result as JSON) as JSON
        }else{
            def person = new Person(
                    rating: 0,
                    nick: params.nick,
                    familyName: params.familyName,
                    phoneNumber: params.phoneNumber,
                    photo: params.photo,
                    city: params.city,
                    facebookURL: params.facebookURL,
                    twitterURL: params.twitterURL,
                    googlePlusURL: params.googlePlusURL,
                    vkURL: params.vkURL,
                    skype: params.skype,
                    username: params.username,
                    email: params.email,
                    password: params.password).save(flush: true)
            def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(flush: true)
            UserRole.create(person, userRole, true)
            render person as JSON
        }
    }
/*
    def show(Person personInstance) {
        respond personInstance
    }

    @Transactional
    def save(Person personInstance) {
        if (personInstance == null) {
            notFound()
            return
        }

        if (personInstance.hasErrors()) {
            respond personInstance.errors, view: 'create'
            return
        }

        personInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'personInstance.label', default: 'Person'), personInstance.id])
                redirect personInstance
            }
            '*' { respond personInstance, [status: CREATED] }
        }
    }

    def edit(Person personInstance) {
        respond personInstance
    }

    @Transactional
    def update(Person personInstance) {
        if (personInstance == null) {
            notFound()
            return
        }

        if (personInstance.hasErrors()) {
            respond personInstance.errors, view: 'edit'
            return
        }

        personInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Person.label', default: 'Person'), personInstance.id])
                redirect personInstance
            }
            '*' { respond personInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Person personInstance) {

        if (personInstance == null) {
            notFound()
            return
        }

        personInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Person.label', default: 'Person'), personInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'personInstance.label', default: 'Person'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }*/
}
