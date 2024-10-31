package com.najahto.cryptoinsight.presentation.coin_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.najahto.cryptoinsight.presentation.coin_list.components.CoinListItem
import com.najahto.cryptoinsight.presentation.coin_list.components.previewCoin
import com.najahto.cryptoinsight.ui.theme.CryptoInsightTheme

@Composable
fun CoinListScreen(
    state: CoinListState,
    modifier: Modifier = Modifier
) {
    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.coins) { coinUi ->
                CoinListItem(
                    coinUi = coinUi,
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview
@PreviewLightDark
@Composable
private fun CoinListScreenPreview() {
    CryptoInsightTheme {
        CoinListScreen(
            state = CoinListState(
                coins = List(100) {
                    previewCoin
                }
            ),
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}