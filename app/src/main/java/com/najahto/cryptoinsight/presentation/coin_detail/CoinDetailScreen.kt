package com.najahto.cryptoinsight.presentation.coin_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.najahto.cryptoinsight.R
import com.najahto.cryptoinsight.presentation.coin_detail.components.CardInfo
import com.najahto.cryptoinsight.presentation.coin_list.CoinListState
import com.najahto.cryptoinsight.presentation.coin_list.components.previewCoin
import com.najahto.cryptoinsight.presentation.models.toDisplayableNumber
import com.najahto.cryptoinsight.ui.theme.CryptoInsightTheme
import com.najahto.cryptoinsight.ui.theme.greenBackground

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CoinDetailScreen(
    state: CoinListState,
    modifier: Modifier
) {
    val contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    if (state.isLoading) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else if (state.selectedCoin != null) {
        val coin = state.selectedCoin
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = coin.iconRes),
                contentDescription = coin.name,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(100.dp)
            )
            Text(
                text = coin.name,
                fontSize = 38.sp,
                fontWeight = FontWeight.Bold,
                color = contentColor
            )
            Text(
                text = coin.symbol,
                fontSize = 18.sp,
                fontWeight = FontWeight.Light,
                color = contentColor
            )
            Spacer(modifier = Modifier.height(22.dp))
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                val changeFormatted =
                    (coin.price.value * (coin.changePercent.value / 100)).toDisplayableNumber()
                val isPositive = changeFormatted.value > 0.0
                val changeContentColor = if (isPositive) {
                    if (isSystemInDarkTheme()) Color.Green else greenBackground
                } else {
                    MaterialTheme.colorScheme.error
                }
                CardInfo(
                    title = stringResource(id = R.string.price),
                    formattedText = "$ ${coin.price.formatted}",
                    icon = ImageVector.vectorResource(id = R.drawable.dollar)
                )
                CardInfo(
                    title = stringResource(id = R.string.change_last_24h),
                    formattedText = "$ ${changeFormatted.formatted}",
                    icon = if (isPositive) {
                        ImageVector.vectorResource(id = R.drawable.trending)
                    } else {
                        ImageVector.vectorResource(id = R.drawable.trending_down)

                    },
                    contentColor = changeContentColor
                )
                CardInfo(
                    title = stringResource(id = R.string.market_cap),
                    formattedText = "$ ${coin.marketCap.formatted}",
                    icon = ImageVector.vectorResource(id = R.drawable.stock)
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
fun CoinDetailScreenPreview() {
    CryptoInsightTheme {
        CoinDetailScreen(
            state = CoinListState(
                selectedCoin = previewCoin
            ),
            modifier = Modifier.background(
                MaterialTheme.colorScheme.background
            )
        )
    }
}