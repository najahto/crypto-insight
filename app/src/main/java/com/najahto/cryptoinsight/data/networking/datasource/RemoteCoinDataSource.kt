package com.najahto.cryptoinsight.data.networking.datasource

import com.najahto.cryptoinsight.core.data.networking.constructUrl
import com.najahto.cryptoinsight.core.data.networking.safeCall
import com.najahto.cryptoinsight.core.domain.util.NetworkError
import com.najahto.cryptoinsight.core.domain.util.Result
import com.najahto.cryptoinsight.core.domain.util.map
import com.najahto.cryptoinsight.data.mappers.toCoin
import com.najahto.cryptoinsight.data.networking.dto.CoinsResponseDto
import com.najahto.cryptoinsight.domain.models.CoinModel
import com.najahto.cryptoinsight.domain.datasource.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
) : CoinDataSource {
    override suspend fun getCoins(): Result<List<CoinModel>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { response->
            response.data.map {
                it.toCoin()
            }
        }
    }
}