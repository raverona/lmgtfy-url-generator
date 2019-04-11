package br.com.raverona.lmgtfy.searchType

import java.lang.RuntimeException

enum class SearchTypes(val queryStringValue: String) {
    WEB("w"),
    IMAGE("i"),
    VIDEOS("v"),
    MAPS("m"),
    NEWS("n"),
    SHOPPING("s"),
    BOOKS("b"),
    FINANCE("f"),
    SCHOLAR("sc");

    val queryStringKey = "t"
}

fun getSearchType(searchTypeName: String): SearchTypes {
    try {
        return SearchTypes.valueOf(searchTypeName.toUpperCase())
    } catch (illegalArgumentException: IllegalArgumentException) {
        throw InvalidSearchType(searchTypeName)
    }
}

class InvalidSearchType(val searchType: String): RuntimeException("Invalid search type: $searchType")