package br.com.raverona.lmgtfy.provider

import br.com.raverona.lmgtfy.searchType.Web

object Ask: Provider() {
    override val queryStringValue = 'k'

    override val availableSearchTypes = listOf(
            Web
    )
}
