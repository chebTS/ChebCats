package chebcats

import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.annotation.Secured
import ua.cats.Person

class LoginController {
    def springSecurityService

    @Secured(['ROLE_USER'])
    def index() {
        def authString = request.getHeader('Authorization')
        if(!authString){
            redirect('401')
        }
        def encodedPair = authString - 'Basic '
        def decodedPair =  new String(new sun.misc.BASE64Decoder().decodeBuffer(encodedPair));
        def credentials = decodedPair.split(':')
        println(credentials[0]+" "+credentials[1])
        Person person = Person.findByUsername(credentials[0]);
        //Person person = Person.findByUsernameAndPassword(credentials[0],credentials[1]);
        render person as JSON

    }
}
