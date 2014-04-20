package ua.cats

class Person extends User {
    static hasMany = [announcement : Announcement, finded : Finded]
    String email
    Double rating
    String nick
    String familyName
    String phoneNumber
    String photo
    String city
    String facebookURL
    String twitterURL
    String googlePlusURL
    String vkURL
    String skype

    static constraints = {
        email unique: true, blank: false
        rating nullable: true
        nick nullable: true
        familyName nullable: true
        phoneNumber nullable: true
        photo nullable: true
        city nullable: true
        facebookURL nullable: true
        twitterURL nullable: true
        googlePlusURL nullable: true
        vkURL nullable: true
        skype nullable: true
    }
}
