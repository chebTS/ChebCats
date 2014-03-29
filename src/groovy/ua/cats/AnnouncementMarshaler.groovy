package ua.cats

import grails.converters.JSON

/**
 * Created by cheb on 3/29/14.
 */
class AnnouncementMarshaler {
    void register() {
        JSON.registerObjectMarshaller( Announcement) { Announcement announcement ->
            return [
                    id : announcement.id,
                    title : announcement.title,
                    category : announcement.category.id,
                    person : announcement.person.id,
                    lat : announcement.lat,
                    lon : announcement.lon,
                    islost : announcement.isLost,
                    photo : announcement.photo,
                    date : announcement.dateCreated,
                    about : announcement.about,
                    address : announcement.address
            ]
        }
    }
}
