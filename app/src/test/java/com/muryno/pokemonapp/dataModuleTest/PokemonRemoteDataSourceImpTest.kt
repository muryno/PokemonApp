package com.muryno.pokemonapp.dataModuleTest

import com.google.common.truth.Truth.assertThat
import com.muryno.pokemonapp.data.api.PokemonService
import com.muryno.pokemonapp.utils.BaseUnitTest
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@HiltAndroidTest
@ExperimentalCoroutinesApi
class PokemonRemoteDataSourceImpTest : BaseUnitTest() {


    lateinit var pokemonService: PokemonService
    private lateinit var mockWebServer: MockWebServer


    @Before
    fun setsUp() {
        mockWebServer = MockWebServer()
        pokemonService = Retrofit.Builder().baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(PokemonService::class.java)
    }


    fun enqueueMockUpResponse(fileName: String) {
        val inputStream = javaClass.classLoader?.getResourceAsStream(fileName)
        val source = inputStream?.source()?.buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source!!.readString(Charsets.UTF_8))
        mockWebServer.enqueue(mockResponse)
    }


    @Test
    fun getPokemonFakeResponse() {
        runBlocking {
            enqueueMockUpResponse("pokemon_fake_response.json")
            val respose = pokemonService.getPokemonApi(1).body()
            assertThat(respose).isNotNull()
            assertThat(respose?.name).isEqualTo("bulbasaur")
        }
    }


}