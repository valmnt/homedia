package fr.nexhub.homedia.network.error

import fr.nexhub.homedia.R

enum class APIError(val code: Int?, val messageId: Int) {
    BadRequest(400, R.string.the_server_could_not_process_the_request),
    Unauthorized(401, R.string.access_is_denied_due_to_invalid_credentials),
    NotFound(404, R.string.the_requested_resource_could_not_be_located_on_the_server),
    InternalServerError(500, R.string.the_server_encountered_an_unexpected_condition),
    NetworkError(599, R.string.unable_to_connect_to_the_server),
    UnknownError(520, R.string.the_operation_could_not_be_completed);

    companion object {
        fun fromCode(code: Int): APIError {
            return APIError.entries.find { it.code == code } ?: UnknownError
        }
    }
}