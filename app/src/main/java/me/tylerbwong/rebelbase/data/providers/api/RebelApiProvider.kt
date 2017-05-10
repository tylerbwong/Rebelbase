package me.tylerbwong.rebelbase.data.providers.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.schedulers.Schedulers
import me.tylerbwong.rebelbase.BuildConfig
import me.tylerbwong.rebelbase.data.api.RebelApi
import me.tylerbwong.rebelbase.data.converters.PeopleResponseConverter
import me.tylerbwong.rebelbase.data.converters.PersonConverter
import me.tylerbwong.rebelbase.data.models.PeopleResponse
import me.tylerbwong.rebelbase.data.models.Person
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * The Game API Provider provides an instance of
 * the API service built by Retrofit.

 * @author Tyler Wong
 * *
 * @version 1.0
 */
private var apiService: RebelApi? = null
private val CONNECTION_TIMEOUT: Long = 10

/**
 * This method provides and handles the creation of
 * the Game API service.

 * @return An instance of a Game API service
 */
fun getApiService(): RebelApi? {
    if (apiService == null) {
        apiService = Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_ENDPOINT)
                .client(makeOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create(setupGson()))
                .build()
                .create(RebelApi::class.java)
    }

    return apiService
}

/**
 * This method provides and handles the creation of an OkHttpClient.
 * If we are an a debug build, add a logging interceptor,
 * otherwise provide no logging interceptor.

 * @return The development or production OkHttpClient
 */
private fun makeOkHttpClient(): OkHttpClient {
    val okHttpClientBuilder = OkHttpClient.Builder()
            .readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)

    if (BuildConfig.DEBUG) {
        try {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpClientBuilder.addInterceptor(interceptor)
        }
        catch (e: IOException) {

        }
    }

    return okHttpClientBuilder.build()
}

/**
 * This method provides and handles the creation of a Gson parser.
 * It will add all of the necessary Type Adapters to serialize and
 * deserialize objects passed to and from the server.

 * @return The Gson parser to be used with a Retrofit instance
 */
private fun setupGson(): Gson {
    val builder = GsonBuilder()
    builder.registerTypeAdapter(Person.javaClass, PersonConverter())
    builder.registerTypeAdapter(PeopleResponse.javaClass, PeopleResponseConverter())
    builder.excludeFieldsWithoutExposeAnnotation()
    return builder.create()
}