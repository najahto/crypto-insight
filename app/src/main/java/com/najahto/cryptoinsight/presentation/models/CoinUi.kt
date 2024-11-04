package com.najahto.cryptoinsight.presentation.models

import android.icu.text.NumberFormat
import androidx.annotation.DrawableRes
import com.najahto.cryptoinsight.domain.models.CoinModel
import com.najahto.cryptoinsight.core.presentation.util.getDrawableIdForCoin
import java.util.Locale

class CoinUi(
    val id: String,
    val name: String,
    val rank: Int,
    val symbol: String,
    val marketCap: DisplayableNumber,
    val price: DisplayableNumber,
    val changePercent: DisplayableNumber,
    @DrawableRes val iconRes: Int
)

data class DisplayableNumber(
    val value: Double,
    val formatted: String
)

fun CoinModel.toCoinUi(): CoinUi {
    return CoinUi(
        id = id,
        name = name,
        rank = rank,
        symbol = symbol,
        marketCap = marketCap.toDisplayableNumber(),
        price = price.toDisplayableNumber(),
        changePercent = changePercent.toDisplayableNumber(),
        iconRes = getDrawableIdForCoin(symbol)
    )
}

fun Double.toDisplayableNumber() : DisplayableNumber {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        maximumFractionDigits = 2
        minimumFractionDigits = 2
    }
    return DisplayableNumber(this, formatter.format(this))
}