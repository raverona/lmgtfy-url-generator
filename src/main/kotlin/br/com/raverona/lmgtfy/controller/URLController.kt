package br.com.raverona.lmgtfy.controller

import br.com.raverona.lmgtfy.provider.getProvider
import br.com.raverona.lmgtfy.query.Query
import br.com.raverona.lmgtfy.request.SlackPayload
import br.com.raverona.lmgtfy.response.SlackResponse
import br.com.raverona.lmgtfy.searchType.getSearchType
import br.com.raverona.lmgtfy.url.LmgtfyURL
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*

@RestController
class URLController(@Value("\${lmgtfy.base.url}") val lmgtfyBaseURL: String) {

    @RequestMapping(value = ["/"], method = [RequestMethod.POST], produces = ["application/json"], consumes = ["application/x-www-form-urlencoded"])
    fun getLmgtfyURL(
            slackPayload: SlackPayload): SlackResponse {

        val lmgtfyURL = LmgtfyURL(
                baseURL = lmgtfyBaseURL,
                provider = getProvider("google"),
                searchType = getSearchType("web"),
                query = Query(slackPayload.text)
        )

        return SlackResponse(response_type = "in_channel", text = lmgtfyURL.toURLString())
    }
}