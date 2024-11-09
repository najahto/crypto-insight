package com.najahto.cryptoinsight

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.najahto.cryptoinsight.core.navigation.AdaptiveCoinListDetailPane
import com.najahto.cryptoinsight.core.presentation.util.ObserveAsEvents
import com.najahto.cryptoinsight.core.presentation.util.toString
import com.najahto.cryptoinsight.presentation.coin_detail.CoinDetailScreen
import com.najahto.cryptoinsight.presentation.coin_list.CoinListEvent
import com.najahto.cryptoinsight.presentation.coin_list.CoinListScreen
import com.najahto.cryptoinsight.presentation.coin_list.CoinListViewModel
import com.najahto.cryptoinsight.ui.theme.CryptoInsightTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoInsightTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AdaptiveCoinListDetailPane(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
