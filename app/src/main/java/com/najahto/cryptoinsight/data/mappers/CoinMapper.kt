package com.najahto.cryptoinsight.data.mappers

import com.najahto.cryptoinsight.data.networking.dto.CoinDto
import com.najahto.cryptoinsight.domain.models.CoinModel


fun CoinDto.toCoin(): CoinModel {
    return CoinModel(
        id = id,
        name = name,
        rank = rank,
        symbol = symbol,
        marketCap = marketCapUsd,
        price = priceUsd,
        changePercent = changePercent24Hr
    )
}