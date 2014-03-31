package ua.cats

import grails.converters.JSON

/**
 * Created by cheb on 3/29/14.
 */
class ImagesMarshaler {
    void register() {
        JSON.registerObjectMarshaller(Image) { Image image->
            return [
                    id : image.id,
                    url : image.url
            ]
        }
    }
}
