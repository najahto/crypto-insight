package com.najahto.cryptoinsight.domain.datasource

import com.najahto.cryptoinsight.core.domain.util.NetworkError
import com.najahto.cryptoinsight.core.domain.util.Result
import com.najahto.cryptoinsight.domain.models.CoinModel

interface CoinDataSource {
    suspend fun getCoins() : Result<List<CoinModel>, NetworkError>
}