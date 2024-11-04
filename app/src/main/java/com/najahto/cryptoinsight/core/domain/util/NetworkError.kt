package com.najahto.cryptoinsight.core.domain.util

enum class NetworkError : Error {
    NO_INTERNET,
    SERVER_ERROR,
    REQUEST_TIMEOUT,
    TOO_MANY_REQUESTS,
    SERIALIZATION,
    UNKNOWN
}