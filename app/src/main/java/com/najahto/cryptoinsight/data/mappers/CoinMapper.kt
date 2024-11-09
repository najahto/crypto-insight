package com.najahto.cryptoinsight.data.mappers

import com.najahto.cryptoinsight.data.networking.dto.CoinDto
import com.najahto.cryptoinsight.data.networking.dto.CoinPriceDto
import com.najahto.cryptoinsight.domain.models.CoinModel
import com.najahto.cryptoinsight.domain.models.CoinPriceModel
import java.time.Instant
import java.time.ZoneId


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

fun CoinPriceDto.toCoinPrice(): CoinPriceModel {
    return CoinPriceModel(
        priceUsd = priceUsd,
        dateTime = Instant
            .ofEpochMilli(time)
            .atZone(ZoneId.of("UTC"))
    )
}