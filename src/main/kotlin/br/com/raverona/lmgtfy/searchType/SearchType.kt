package br.com.raverona.lmgtfy.searchType

import java.lang.RuntimeException

abstract class SearchType {
    val queryStringKey = 't'
    abstract val queryStringValue: String

    companion object {

        fun getByName(name: String): SearchType {
            return when (name) {
                "web" -> Web
                "image" -> Image
                "videos" -> Videos
                "maps" -> Maps
                "news" -> News
                "shopping" -> Shopping
                "books" -> Books
                "finance" -> Finance
                "scholar" -> Scholar
                else -> throw InvalidSearchType(name)
            }
        }
    }
}

class InvalidSearchType(val searchType: String): RuntimeException("Invalid search type: $searchType")
