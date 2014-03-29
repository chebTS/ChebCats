package util.marshalling

/**
 * Created by cheb on 3/29/14.
 */
class CustomObjectMarshallers {
    List marshallers = []

    def register() {
        marshallers.each{ it.register() }
    }
}
