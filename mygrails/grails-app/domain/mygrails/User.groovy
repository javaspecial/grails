package mygrails

class User {
    // properties
    int id
    String firstName
    String lastName
    String username
    String password        // plain text, not stored

    // constraints
    static constraints = {
        id generator: 'assigned'
        firstName blank: false;
        lastName blank: false;
        username blank: false, size: 5..15, matches: /[\S]+/, unique: true
        password blank: false, size: 5..15, matches: /[\S]+/
    }
}
