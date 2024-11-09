package com.najahto.cryptoinsight.data.networking.datasource

import com.najahto.cryptoinsight.core.data.networking.constructUrl
import com.najahto.cryptoinsight.core.data.networking.safeCall
import com.najahto.cryptoinsight.core.domain.util.NetworkError
import com.najahto.cryptoinsight.core.domain.util.Result
import com.najahto.cryptoinsight.core.domain.util.map
import com.najahto.cryptoinsight.data.mappers.toCoin
import com.najahto.cryptoinsight.data.mappers.toCoinPrice
import com.najahto.cryptoinsight.data.networking.dto.CoinHistoryDto
import com.najahto.cryptoinsight.data.networking.dto.CoinsResponseDto
import com.najahto.cryptoinsight.domain.models.CoinModel
import com.najahto.cryptoinsight.domain.datasource.CoinDataSource
import com.najahto.cryptoinsight.domain.models.CoinPriceModel
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import java.time.ZoneId
import java.time.ZonedDateTime

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

    override suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPriceModel>, NetworkError> {
        val startMillis = start
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()
        val endMillis = end
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()

        return safeCall<CoinHistoryDto> {
            httpClient.get(
                urlString = constructUrl("/assets/$coinId/history")
            ) {
                parameter("interval", "h6")
                parameter("start", startMillis)
                parameter("end", endMillis)
            }
        }.map { response ->
            response.data.map {
                it.toCoinPrice()
            }
        }
    }
}