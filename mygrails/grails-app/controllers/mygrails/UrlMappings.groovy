package mygrails

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/main/index")
        "500"(view: '/main/error')
        "404"(view: '/main/notFound')
    }
}
