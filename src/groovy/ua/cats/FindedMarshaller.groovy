package ua.cats

import grails.converters.JSON

/**
 * Created by cheb on 4/20/14.
 */
class FindedMarshaller {
    void register() {
        JSON.registerObjectMarshaller( Finded) { Finded finded ->
            return [
                    id : finded.id,
                    announcement_id : finded.announcement.id,
                    user_id : finded.person.id,
                    description : finded.description
            ]
        }
    }
}
