package by.adush.cryptocurrency.data.retrofit

import by.adush.cryptocurrency.data.entity.Cryptocurrencies
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface CryptoAPI {
    @GET("cryptocurrency/listings/latest")
    fun getTopCrypto(
        @Query("limit")
        limit : Int,
        @Query("convert")
        convert : String
    ):Deferred<Response<Cryptocurrencies>>
}