package br.com.raverona.lmgtfy.provider

import br.com.raverona.lmgtfy.searchType.Web

object Bing: Provider() {
    override val queryStringValue = 'b'

    override val availableSearchTypes = listOf(
            Web
    )
}
