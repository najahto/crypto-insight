package com.najahto.cryptoinsight.domain.models

data class CoinModel(
    val id: String,
    val name: String,
    val rank: Int,
    val symbol: String,
    val price: Double,
    val marketCap: Double,
    val changePercent: Double
)