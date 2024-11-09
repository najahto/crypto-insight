package com.najahto.cryptoinsight.presentation.coin_list

import androidx.compose.runtime.Immutable
import com.najahto.cryptoinsight.presentation.models.CoinUi

@Immutable
data class CoinListState(
    val coins: List<CoinUi> = emptyList(),
    val isLoading: Boolean = false,
    val selectedCoin: CoinUi? = null
)