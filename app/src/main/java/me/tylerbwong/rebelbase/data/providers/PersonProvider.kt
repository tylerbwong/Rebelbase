@file:JvmName("PersonProvider")

package me.tylerbwong.rebelbase.data.providers

import io.reactivex.Observable
import io.reactivex.Single
import me.tylerbwong.rebelbase.data.api.RebelApi
import me.tylerbwong.rebelbase.data.models.PeopleResponse
import me.tylerbwong.rebelbase.data.models.Person
import me.tylerbwong.rebelbase.data.providers.api.getApiService

/**
 * @author Tyler Wong
 */

private val personApiService: RebelApi = getApiService()

fun getPerson(personId: Int): Single<Person> = personApiService.getPerson(personId)

fun getPeopleByPage(page: Int): Observable<PeopleResponse> = personApiService.getPeopleByPage(page)
        .concatMap {
            if (it.next == null) {
                Observable.just(it)
            }
            Observable.just(it).concatWith(getPeopleByPage(page + 1))
        }

fun getPeople(): Observable<Person> = getPeopleByPage(1)
        .map { it.results }
        .flatMapIterable { it }