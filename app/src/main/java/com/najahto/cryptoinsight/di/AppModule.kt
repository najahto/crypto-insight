package com.najahto.cryptoinsight.di

import com.najahto.cryptoinsight.core.data.networking.HttpClientFactory
import com.najahto.cryptoinsight.data.networking.datasource.RemoteCoinDataSource
import com.najahto.cryptoinsight.domain.datasource.CoinDataSource
import com.najahto.cryptoinsight.presentation.coin_list.CoinListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()

    viewModelOf(::CoinListViewModel)

}