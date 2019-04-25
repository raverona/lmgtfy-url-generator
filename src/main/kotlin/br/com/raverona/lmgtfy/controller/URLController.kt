package br.com.raverona.lmgtfy.controller

import br.com.raverona.lmgtfy.provider.Provider
import br.com.raverona.lmgtfy.query.Query
import br.com.raverona.lmgtfy.request.SlackPayload
import br.com.raverona.lmgtfy.response.SlackResponse
import br.com.raverona.lmgtfy.searchType.SearchType
import br.com.raverona.lmgtfy.url.LmgtfyURL
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
class URLController(@Value("\${lmgtfy.base.url}") val lmgtfyBaseURL: String) {

    @RequestMapping(value = ["/"], method = [RequestMethod.POST], produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    fun getLmgtfyURL(slackPayload: SlackPayload): SlackResponse {

        val lmgtfyURL = LmgtfyURL(
                baseURL = lmgtfyBaseURL,
                provider = Provider.getByName(slackPayload.providerName),
                searchType = SearchType.getByName("web"),
                query = Query(slackPayload.text)
        )

        return SlackResponse(response_type = "in_channel", text = lmgtfyURL.toURLString())
    }

    @RequestMapping(value = ["/help"], method = [RequestMethod.POST], produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    fun getHelpMessage(slackPayload: SlackPayload): SlackResponse {
        return SlackResponse(
                response_type = "in_channel",
                text = """Hi *${slackPayload.user_name}*, here's how I work:
                    |type a command followed by a serch criteria and I'll answer you with a link
                    |to solve your search needs based on the command used
                    |the commands have the following format:
                    |`/(provider) (stuff I want to search)`
                    |available providers are: _Aol_, _Ask_, _Bing_, _DuckDuckGo_, _Google_ and _Yahoo_
                    |exemple: `/google I don't know how to google stuff`
                """.trimMargin())
    }
}