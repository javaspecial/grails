package mygrails

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap
import org.grails.web.util.WebUtils
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpMethod

@Transactional
class UserService {
    def userRegistration(params) throws DataIntegrityViolationException{
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
            User u = User.findByUsernameAndPassword(map.username, map.password, [cache: true])
            if (u) {
                session.user = u
                return u
            } else {
                flash.message = "User not found"
                return u
            }
        }
    }

    def updateUser(params) throws DataIntegrityViolationException{
        def request = WebUtils.retrieveGrailsWebRequest().request
        if (request.method == HttpMethod.GET.toString()) {
            return null;
        } else if (request.method == HttpMethod.PUT.toString()) {
            User loadedUser = User.get(params.id)
            loadedUser.firstName = params.firstName
            loadedUser.lastName = params.lastName
            loadedUser.save()
            return loadedUser
        }
    }
}
