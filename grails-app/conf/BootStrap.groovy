import org.springframework.web.context.support.WebApplicationContextUtils
import ua.cats.Announcement
import ua.cats.Person
import ua.cats.Role
import ua.cats.UserRole

class BootStrap {

    def init = { servletContext ->

        def springContext = WebApplicationContextUtils.getWebApplicationContext( servletContext )
        springContext.getBean( "customObjectMarshallers" ).register()

        def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(flush: true)
        def user = Person.findByUsername("tst") ?:
                new Person(
                        username: "tst",
                        email: "chebTS@gmail.com",
                        rating: "1.0d",
                        nick: "Cheb",
                        familyName: "TS",
                        phoneNumber: "5455165156",
                        photo: "dfssd",
                        city: "Cherkassy",
                        password: "foo",
                        enabled: true).save(flush: true)
        UserRole.create(user, userRole, true)
        def cat1 = new ua.cats.Category(name: "Pets").save(flush: true)
        def cat2 = new ua.cats.Category(name: "People").save(flush: true)
        def cat3 = new ua.cats.Category(name: "Things").save(flush: true)
        def cat4 = new ua.cats.Category(name: "Other").save(flush: true)

        def newAnnouncement = new Announcement(title: "Test1", category: cat1, person: user).save(flush: true)
        def newAnnouncement2 = new Announcement(title: "Test2", category: cat3, person: user).save(flush: true)


    }
    def destroy = {
    }
}
