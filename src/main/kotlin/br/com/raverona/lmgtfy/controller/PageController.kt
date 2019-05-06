package br.com.raverona.lmgtfy.controller

import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class PageController {

    @RequestMapping(value = ["/"], method = [RequestMethod.GET], produces = [MediaType.TEXT_HTML_VALUE])
    fun getHomePage(): String {
        return "index"
    }
}