package mygrails

class UrlMappings {

    static mappings = {
        "/"(controller: "main")
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/main/index")
        "200"(view: "/user/register")
        "500"(view: '/main/error')
        "404"(view: '/main/notFound')
    }
}
