package br.com.raverona.lmgtfy.url

import br.com.raverona.lmgtfy.provider.Provider
import br.com.raverona.lmgtfy.provider.UnsupportedSearchType
import br.com.raverona.lmgtfy.query.Query
import br.com.raverona.lmgtfy.searchType.SearchType
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class LmgtfyURL(private val baseURL: String,
                private val provider: Provider,
                private val searchType: SearchType,
                private val query: Query) {
    private val charset = StandardCharsets.UTF_8.toString()

    init {
        if (!provider.availableSearchTypes.contains(searchType))
            throw UnsupportedSearchType(provider::class.simpleName!!, searchType::class.simpleName!!)
    }

    fun toURLString(): String {
        return baseURL + '?' + provider.queryStringKey + '=' + provider.queryStringValue +
                '&' + searchType.queryStringKey + '=' + searchType.queryStringValue +
                '&' + query.queryKey + '=' + URLEncoder.encode(query.queryValue, charset)
    }
}