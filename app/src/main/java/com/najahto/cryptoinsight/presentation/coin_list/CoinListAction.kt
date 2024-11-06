package com.najahto.cryptoinsight.presentation.coin_list

import com.najahto.cryptoinsight.presentation.models.CoinUi

sealed interface CoinListAction {
    data class OnCoinClick(val coinUi: CoinUi) : CoinListAction
}