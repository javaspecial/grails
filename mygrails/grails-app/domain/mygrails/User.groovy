package mygrails

class User implements Serializable{
    String firstName
    String lastName
    String username
    String password

    static constraints = {
        firstName blank: false,size: 5..15;
        lastName blank: false,size: 5..15;
        username blank: false, size: 5..15, matches: /[\S]+/, unique: true
        password blank: false, size: 5..15, matches: /[\S]+/
    }
}
