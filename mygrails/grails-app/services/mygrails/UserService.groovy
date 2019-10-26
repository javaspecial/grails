package mygrails

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap
import org.grails.web.util.WebUtils
import org.springframework.http.HttpMethod

@Transactional
class UserService {
    def userRegistration(params) {
        params.each { key, value ->
            println(key + "=" + value)
        }

        def request = WebUtils.retrieveGrailsWebRequest().request
        if (request.method == HttpMethod.GET.toString()) {
            return null
        }
        def session = WebUtils.retrieveGrailsWebRequest().session
        if (request.method == HttpMethod.POST.toString()) {
            User u = new User(params)
            if (!u.save()) {
                return [user: u]
            } else {
                session.user = u
                return u
            }
        }
    }

    def login(GrailsParameterMap map) {
        def flash = WebUtils.retrieveGrailsWebRequest().flashScope
        def session = WebUtils.retrieveGrailsWebRequest().session
        def request = WebUtils.retrieveGrailsWebRequest().request
        if (request.method == HttpMethod.POST.toString()) {
            User u = User.findByUsernameAndPassword(map.username, map.password)
            if (u) {
                session.user = u
                return u
            } else {
                flash.message = "User not found"
                return u
            }
        }
    }
}
