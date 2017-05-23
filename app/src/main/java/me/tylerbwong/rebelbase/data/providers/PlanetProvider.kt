package me.tylerbwong.rebelbase.data.providers

import io.reactivex.Observable
import io.reactivex.Single
import me.tylerbwong.rebelbase.data.api.RebelApi
import me.tylerbwong.rebelbase.data.models.Planet
import me.tylerbwong.rebelbase.data.models.PlanetResponse
import me.tylerbwong.rebelbase.data.providers.api.getApiService

/**
 * @author Tyler Wong
 */

val planetApiService: RebelApi? = getApiService()

fun getPlanet(planetId: Int): Single<Planet> = planetApiService!!.getPlanet(planetId)

fun getPlanetsByPage(page: Int): Observable<PlanetResponse> = personApiService!!.getPlanetsByPage(page)
        .concatMap { response ->
            if (response.next == null) {
                Observable.just(response)
            }
            Observable.just(response).concatWith(getPlanetsByPage(page + 1))
        }

fun getPlanets(): Observable<Planet> = getPlanetsByPage(1)
        .map { response -> response.results }
        .flatMapIterable { planets -> planets }
