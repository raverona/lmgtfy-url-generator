package br.com.raverona.lmgtfy.provider

import br.com.raverona.lmgtfy.searchType.*

object Google: Provider() {
    override val queryStringValue = 'g'

    override val availableSearchTypes = listOf(
            Web, Image, Videos, Maps, News, Shopping, Books, Finance, Scholar
    )
}