package fr.nexhub.homedia.network.error

data class NetworkError(
    val details: APIError,
    val t: Throwable? = null
)