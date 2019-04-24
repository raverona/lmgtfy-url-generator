package br.com.raverona.lmgtfy.provider

import br.com.raverona.lmgtfy.searchType.Web

object Aol: Provider() {
    override val queryStringValue = 'a'

    override val availableSearchTypes = listOf(
            Web
    )
}
