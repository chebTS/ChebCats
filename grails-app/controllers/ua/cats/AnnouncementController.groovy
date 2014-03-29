package ua.cats

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*

class AnnouncementController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_USER'])
    def index(Integer max) {
        render Announcement.list() as JSON
    }

    def show(Announcement announcementInstance) {
        respond announcementInstance
    }

    def create() {
        respond new Announcement(params)
    }
/*
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
