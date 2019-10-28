package mygrails

class UserController {
    UserService userService

    def register = {
        def user = userService.userRegistration(params)
        if (Objects.isNull(user)) {
            render([view: "register"])
        } else if (user instanceof LinkedHashMap) {
            return user
        } else {
            redirect(controller: 'main')
        }
    }

    def login = {
        userService.login(params)
        redirect(controller: 'main')
    }

    def logout = {
        session.invalidate()
        redirect(controller: 'main')
    }

    def update = {
        def user = userService.updateUser(params)
        if(Objects.isNull(user)){
          return  render(view: "update", model: [user:session.user])
        }
        redirect(controller: 'main')
    }
}