package br.com.raverona.lmgtfy.controller

import br.com.raverona.lmgtfy.provider.getProvider
import br.com.raverona.lmgtfy.query.Query
import br.com.raverona.lmgtfy.response.URLResponse
import br.com.raverona.lmgtfy.searchType.getSearchType
import br.com.raverona.lmgtfy.url.LmgtfyURL
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class URLController(@Value("\${lmgtfy.base.url}") val lmgtfyBaseURL: String) {

    @RequestMapping(value = ["/"], method = [RequestMethod.GET], produces = ["application/json"])
    fun getLmgtfyURL(
            @RequestParam
            providerName: String,
            @RequestParam
            searchTypeName: String,
            @RequestParam
            queryText: String): URLResponse {

        val lmgtfyURL = LmgtfyURL(
                baseURL = lmgtfyBaseURL,
                provider = getProvider(providerName),
                searchType = getSearchType(searchTypeName),
                query = Query(queryText)
        )

        return URLResponse(HttpStatus.OK.value(), HttpStatus.OK.reasonPhrase, lmgtfyURL.toURLString())
    }
}