package ua.cats

class Finded {
    Announcement announcement
    Person person
    String description

    static constraints = {
        announcement nullable: false
        person nullable: false
        description nullable: true
    }
}
