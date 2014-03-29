package ua.cats

class Person extends User {
    static hasMany = [announcement : Announcement]
    String email
    Double rating
    String nick
    String familyName
    String phoneNumber
    String photo
    String city

    static constraints = {
        email unique: true, blank: false
        rating nullable: true
        nick nullable: true
        familyName nullable: true
        phoneNumber nullable: true
        photo nullable: true
        city nullable: true
    }
}
