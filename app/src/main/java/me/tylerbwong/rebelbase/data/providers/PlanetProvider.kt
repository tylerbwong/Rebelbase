@file:JvmName("PlanetProvider")

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

private val planetApiService: RebelApi = getApiService()

fun getPlanet(planetId: Int): Single<Planet> = planetApiService.getPlanet(planetId)

fun getPlanetsByPage(page: Int): Observable<PlanetResponse> = planetApiService.getPlanetsByPage(page)
        .concatMap {
            if (it.next == null) {
                Observable.just(it)
            }
            Observable.just(it).concatWith(getPlanetsByPage(page + 1))
        }

fun getPlanets(): Observable<Planet> = getPlanetsByPage(1)
        .map { it.results }
        .flatMapIterable { it }
