package ua.cats

class Image {

    Announcement announcement
    String url

    static constraints = {
        url nullable: false
    }
}
