package vn.jupiter.jmovies.data.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.ToJson
import vn.jupiter.jmovies.data.model.MovieInfo

@JsonClass(generateAdapter = true)
open class BaseResponse {
    @Json(name = "Response")
    lateinit var isSuccess: String
    @Json(name = "Error")
    open var error: String? = null
}

@JsonClass(generateAdapter = true)
data class SearchResponse(
    @Json(name = "Search")
    val search: List<MovieInfo> = emptyList()
) : BaseResponse()
