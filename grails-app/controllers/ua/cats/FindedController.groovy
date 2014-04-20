package ua.cats

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured


class FindedController {

    static allowedMethods = [create:'POST',index: 'GET']

    @Secured(['ROLE_USER'])
    def index() {
        if (params.id){
            render Finded.findAllById(params.id) as JSON
        }else{
            render Finded.list() as JSON
        }
    }

    @Secured(['ROLE_USER'])
    def create() {
        def person = Person.findById(params.userid)
        def announcement = Announcement.findById(params.annid)
        if (person && Announcement){
            def finded = new Finded(
                    person: person,
                    announcement: announcement,
                    description: params.description
            ).save(flush: true)
            render finded as JSON
        }else{
            result["statusCode"] = 409
            result["message"] = "Not enough parameters. Add: 'userid', 'annid' and optional 'description'"
            render( status: 409, text: result as JSON) as JSON
        }

    }
/*
    def person = Person.findById(params.userid)
    def cat = Category.findById(params.catid)
    if((person) && (cat) && (params.title)){
        def ann = new Announcement(
                person: person,
                category: cat,
                lat: params.lat,
                lon: params.lon,
                islost: params.islost,
                date: params.date,
                about: params.about,
                photo: params.photo,
                address: params.address,
                title: params.title).save(flush: true)
        render ann as JSON
    }else{
        def result = [:]
        result["statusCode"] = 409
        result["message"] = "Not enough parameters. Add: 'userid', 'catid' and 'title'"
        render( status: 409, text: result as JSON) as JSON
    }*/


/*
    @Transactional
    def save(Finded findedInstance) {
        if (findedInstance == null) {
            notFound()
            return
        }

        if (findedInstance.hasErrors()) {
            respond findedInstance.errors, view: 'create'
            return
        }

        findedInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'findedInstance.label', default: 'Finded'), findedInstance.id])
                redirect findedInstance
            }
            '*' { respond findedInstance, [status: CREATED] }
        }
    }

    def edit(Finded findedInstance) {
        respond findedInstance
    }

    @Transactional
    def update(Finded findedInstance) {
        if (findedInstance == null) {
            notFound()
            return
        }

        if (findedInstance.hasErrors()) {
            respond findedInstance.errors, view: 'edit'
            return
        }

        findedInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Finded.label', default: 'Finded'), findedInstance.id])
                redirect findedInstance
            }
            '*' { respond findedInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Finded findedInstance) {

        if (findedInstance == null) {
            notFound()
            return
        }

        findedInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Finded.label', default: 'Finded'), findedInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'findedInstance.label', default: 'Finded'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
    */
}
