import ua.cats.AnnouncementMarshaler
import ua.cats.CategoryMarshaller
import ua.cats.ImagesMarshaler
import ua.cats.PersonMarshaler
import util.marshalling.CustomObjectMarshallers

// Place your Spring DSL code here
beans = {
    customObjectMarshallers( CustomObjectMarshallers ) {
        marshallers = [
                new CategoryMarshaller(),
                new AnnouncementMarshaler(),
                new PersonMarshaler(),
                new ImagesMarshaler()

        ]
    }
}
