@file:JvmName("PlanetProvider")

package me.tylerbwong.rebelbase.data.providers

import io.reactivex.Observable
import io.reactivex.Single
import me.tylerbwong.rebelbase.data.models.Planet
import me.tylerbwong.rebelbase.data.models.PlanetResponse
import me.tylerbwong.rebelbase.data.providers.api.apiService

/**
 * @author Tyler Wong
 */

fun getPlanet(planetId: Int): Single<Planet> = apiService.getPlanet(planetId)

fun getPlanetsByPage(page: Int): Observable<PlanetResponse> = apiService.getPlanetsByPage(page)
        .concatMap {
            if (it.count == 0) {
                Observable.just(it)
            }
            Observable.just(it).concatWith(getPlanetsByPage(page + 1))
        }

fun getPlanets(): Observable<Planet> = getPlanetsByPage(1)
        .map { it.results }
        .flatMapIterable { it }
