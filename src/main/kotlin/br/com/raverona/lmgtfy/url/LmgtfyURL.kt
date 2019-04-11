package br.com.raverona.lmgtfy.url

import br.com.raverona.lmgtfy.provider.Providers
import br.com.raverona.lmgtfy.query.Query
import br.com.raverona.lmgtfy.searchType.SearchTypes
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class LmgtfyURL(private val baseURL: String,
                private val provider: Providers,
                private val searchType: SearchTypes,
                private val query: Query) {
    private val charset = StandardCharsets.UTF_8.toString()

    fun toURLString(): String {
        return baseURL + '?' + provider.queryStringKey + '=' + provider.queryStringValue +
                '&' + searchType.queryStringKey + '=' + searchType.queryStringValue +
                '&' + query.queryKey + '=' + URLEncoder.encode(query.queryValue, charset)
    }
}