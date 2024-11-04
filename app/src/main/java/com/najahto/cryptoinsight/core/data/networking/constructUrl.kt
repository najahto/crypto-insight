package com.najahto.cryptoinsight.core.data.networking

import com.najahto.cryptoinsight.BuildConfig

fun constructUrl(url: String): String {
    return when {
        url.contains(BuildConfig.API_BASE_URL) -> url
        url.startsWith("/") -> BuildConfig.API_BASE_URL + url.drop(1)
        else -> BuildConfig.API_BASE_URL + url
    }
}
