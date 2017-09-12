package me.tylerbwong.rebelbase.data.api

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import me.tylerbwong.rebelbase.data.models.PeopleResponse
import me.tylerbwong.rebelbase.data.models.Person
import me.tylerbwong.rebelbase.data.models.Planet
import me.tylerbwong.rebelbase.data.models.PlanetResponse
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
    fun getPeopleByPage(@Query("page") page: Int): Flowable<PeopleResponse>

    @GET("/api/planets/{planetId}/")
    fun getPlanet(@Path("planetId") planetId: Int): Single<Planet>

    @GET("/api/planets/")
    fun getPlanetsByPage(@Query("page") page: Int): Observable<PlanetResponse>
}