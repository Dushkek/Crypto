package by.adush.cryptocurrency.data.retrofit

import android.content.Context
import by.adush.cryptocurrency.data.network.ConnectivityInterceptorImpl
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val BASE_URL = "https://pro-api.coinmarketcap.com/v1/"


 object CryptoAPIFactory {
    const val KEY_NAME = "X-CMC_PRO_API_KEY"
    const val KEY_VALUE = "b6c7fb36-4ba1-4b29-bb2c-9f686d7bcefd"


    private val httpClient = OkHttpClient.Builder().addNetworkInterceptor(object : Interceptor{
            override fun intercept(chain: Interceptor.Chain): Response {
                val request = chain.request().newBuilder().addHeader(KEY_NAME, KEY_VALUE).build()

                return chain.proceed(request)
             }
        })


    fun getRetrofit():CryptoAPI{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(httpClient.build())
            .build()

        return retrofit.create()
    }

}