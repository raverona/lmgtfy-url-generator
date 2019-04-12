package br.com.raverona.lmgtfy.controller

import br.com.raverona.lmgtfy.provider.getProvider
import br.com.raverona.lmgtfy.query.Query
import br.com.raverona.lmgtfy.response.URLSlackResponse
import br.com.raverona.lmgtfy.searchType.getSearchType
import br.com.raverona.lmgtfy.url.LmgtfyURL
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class URLController(@Value("\${lmgtfy.base.url}") val lmgtfyBaseURL: String) {

    @RequestMapping(value = ["/"], method = [RequestMethod.POST], produces = ["application/json"])
    fun getLmgtfyURL(
            @RequestParam
            providerName: String,
            @RequestParam
            searchTypeName: String,
            @RequestParam
            queryText: String): URLSlackResponse {

        val lmgtfyURL = LmgtfyURL(
                baseURL = lmgtfyBaseURL,
                provider = getProvider(providerName),
                searchType = getSearchType(searchTypeName),
                query = Query(queryText)
        )

        return URLSlackResponse(response_type = "in_channel", text = lmgtfyURL.toURLString())
    }
}