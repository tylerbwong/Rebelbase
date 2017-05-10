package me.tylerbwong.rebelbase.data.api

import io.reactivex.Observable
import io.reactivex.Single
import me.tylerbwong.rebelbase.data.models.PeopleResponse
import me.tylerbwong.rebelbase.data.models.Person
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author Tyler Wong
 */
interface RebelApi {

    @GET("/api/people/{personId}/")
    fun getPerson(@Path("personId") personId: Int): Single<Person>

    @GET("/api/people/")
    fun getPeople(@Query("page") page: Int): Observable<PeopleResponse>
}