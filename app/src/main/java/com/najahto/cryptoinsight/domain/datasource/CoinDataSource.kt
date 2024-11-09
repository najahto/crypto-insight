package com.najahto.cryptoinsight.domain.datasource

import com.najahto.cryptoinsight.core.domain.util.NetworkError
import com.najahto.cryptoinsight.core.domain.util.Result
import com.najahto.cryptoinsight.domain.models.CoinModel
import com.najahto.cryptoinsight.domain.models.CoinPriceModel
import java.time.ZonedDateTime

interface CoinDataSource {

    suspend fun getCoins(): Result<List<CoinModel>, NetworkError>

    suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPriceModel>, NetworkError>

}