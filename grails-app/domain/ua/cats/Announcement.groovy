package ua.cats

class Announcement {
    static hasMany = [images : Image, finded : Finded]
    Category category
    Person person
    String title
    Boolean isLost
    String photo
    String about
    String address
    Date dateCreated
    Double lat
    Double lon


    static constraints = {
        category nullable: false
        person nullable: false
        title blank: false, nullable: false
        images nullable: true
        isLost nullable: true
        photo nullable: true
        about nullable: true
        dateCreated nullable: true
        address nullable: true
        lat nullable: true
        lon nullable: true
    }
}
