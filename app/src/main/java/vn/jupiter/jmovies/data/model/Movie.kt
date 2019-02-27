package vn.jupiter.jmovies.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "movies")
data class MovieInfo(
    @Json(name = "imdbID")
    @PrimaryKey
    val id: String,
    @Json(name = "Title")
    val title: String? = null,
    @Json(name = "Poster")
    val poster: String? = null,
    @Json(name = "Year")
    val year: String? = null,
    @Json(name = "BoxOffice")
    val boxOffice: String? = null
)
