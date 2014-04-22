package ua.cats

import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Announcement)
class AnnouncementSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }


    void "always green"(){
        expect:
            2 == 2
    }

    void "create announcement without person"() {
//http://www.block-consult.com/blog/2011/08/17/inject-spring-security-service-into-domain-class-for-controller-unit-testing/
        defineBeans {
            springSecurityService(SpringSecurityService)
        }


        setup:
        mockDomain(Announcement)
        mockDomain(Category)
        mockDomain(Person)

        when:
        def cat = new Category(name:"crime").save()
        def per = new Person(email: "chebTS@gmail.com", username: "Cheb", password: "123456").save()
        new Announcement(category: cat, person: per, title: "test").save()


        then:
        Announcement.findByTitle("test") != null


/*
        expect:
         11 == 3*/
    }


}
