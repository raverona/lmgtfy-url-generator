package br.com.raverona.lmgtfy.provider

import br.com.raverona.lmgtfy.searchType.Web

object Yahoo: Provider() {
    override val queryStringValue = 'y'

    override val availableSearchTypes = listOf(
            Web
    )
}
