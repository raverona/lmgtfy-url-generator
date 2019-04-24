package br.com.raverona.lmgtfy.provider

import br.com.raverona.lmgtfy.searchType.Web

object Duckduckgo: Provider() {
    override val queryStringValue = 'd'

    override val availableSearchTypes = listOf(
            Web
    )
}
