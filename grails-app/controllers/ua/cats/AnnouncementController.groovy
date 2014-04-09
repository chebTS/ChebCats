package ua.cats

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import org.codehaus.groovy.grails.web.json.JSONObject

import javax.swing.JScrollBar

import static org.springframework.http.HttpStatus.*

class AnnouncementController {

    //static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    static allowedMethods = [create:'POST', byuser:'GET', bycat: 'GET', byid: 'GET',index: 'GET']

    @Secured(['ROLE_USER'])
    def index(Integer max) {
        if (params.id){
            render Announcement.findAllById(params.id) as JSON
        }else{
            render Announcement.list() as JSON
        }
    }

    @Secured(['ROLE_USER'])
    def byid(){
        render Announcement.findAllById(params.id) as JSON
    }

    @Secured(['ROLE_USER'])
    def bycat(){
        render Announcement.findAllByCategory(Category.findById(params.id)) as JSON
    }

    @Secured(['ROLE_USER'])
    def byuser(){
        render Announcement.findAllByPerson(Person.findById(params.id)) as JSON
    }

    @Secured(['ROLE_USER'])
    def create() {
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
        }
    }
/*
    def show(Announcement announcementInstance) {
        respond announcementInstance
    }

    @Transactional
    def save(Announcement announcementInstance) {
        if (announcementInstance == null) {
            notFound()
            return
        }

        if (announcementInstance.hasErrors()) {
            respond announcementInstance.errors, view:'create'
            return
        }

        announcementInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'announcementInstance.label', default: 'Announcement'), announcementInstance.id])
                redirect announcementInstance
            }
            '*' { respond announcementInstance, [status: CREATED] }
        }
    }

    def edit(Announcement announcementInstance) {
        respond announcementInstance
    }

    @Transactional
    def update(Announcement announcementInstance) {
        if (announcementInstance == null) {
            notFound()
            return
        }

        if (announcementInstance.hasErrors()) {
            respond announcementInstance.errors, view:'edit'
            return
        }

        announcementInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Announcement.label', default: 'Announcement'), announcementInstance.id])
                redirect announcementInstance
            }
            '*'{ respond announcementInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Announcement announcementInstance) {

        if (announcementInstance == null) {
            notFound()
            return
        }

        announcementInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Announcement.label', default: 'Announcement'), announcementInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'announcementInstance.label', default: 'Announcement'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    */
}
