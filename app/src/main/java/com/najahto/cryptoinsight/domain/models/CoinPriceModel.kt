package com.najahto.cryptoinsight.domain.models

import java.time.ZonedDateTime

data class CoinPriceModel(
    val priceUsd: Double,
    val dateTime: ZonedDateTime
)