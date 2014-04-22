package ua.cats

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Finded)
class FindedSpec extends Specification {

    def setup() {

    }

    def cleanup() {
    }
/*
    when:
    def cat = new Category(name:"crime").save()
    def per = new Person(email: "chebTS@gmail.com", username: "Cheb", password: "123456").save()
    new Announcement(category: cat, person: per, title: "test").save()


    then:
    Announcement.findByTitle("test") != null*/

    void "test something"() {

        expect:
            11 == 11
    }
}
