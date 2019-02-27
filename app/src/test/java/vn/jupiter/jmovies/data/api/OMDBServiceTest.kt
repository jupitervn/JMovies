package vn.jupiter.jmovies.data.api

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import java.security.KeyStore

class OMDBServiceTest {
    private val mockWebServer: MockWebServer by lazy {
        MockWebServer()
    }

    private lateinit var mediaService: OMDBService

    @Before
    fun setup() {
        mockWebServer.start(8080)
        val retrofit = DaggerNetworkTestComponent
            .create()
            .getRetrofit()
            .newBuilder()
            .baseUrl("http://localhost:8080")
            .build()
        mediaService = retrofit.create(OMDBService::class.java)
    }

    @Test
    fun shouldSearchOk() {
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(fromFile("success_search"))
        mockWebServer.enqueue(mockResponse)
        val searchObs = mediaService.search("avenger", 1)

        searchObs.test()
            .assertComplete()
            .assertNoErrors()
            .assertValue { value ->
                value.search.isNotEmpty() && value.search.size == 10
            }
    }

    private fun fromFile(fileName: String): String {
        val inputStream = javaClass.getResourceAsStream("/json/$fileName.json")
        return String(inputStream.readBytes())
    }
}
