package fr.nexhub.homedia.network

import fr.nexhub.homedia.network.error.APIError
import fr.nexhub.homedia.network.error.NetworkError
import retrofit2.HttpException
import java.io.IOException

fun Throwable.toGeneralError(): NetworkError {
    val details = when (this) {
        is IOException -> APIError.NetworkError
        is HttpException -> {
            APIError.fromCode(this.code())
        }
        else -> APIError.UnknownError
    }
    return NetworkError(
        details = details,
        t = this
    )
}