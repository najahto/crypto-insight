package com.najahto.cryptoinsight.presentation.coin_list

import com.najahto.cryptoinsight.core.domain.util.NetworkError

sealed interface CoinListEvent {

    data class Error(val error: NetworkError): CoinListEvent

}