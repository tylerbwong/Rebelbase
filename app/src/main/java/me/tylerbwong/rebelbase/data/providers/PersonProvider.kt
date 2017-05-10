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

val apiService: RebelApi? = getApiService()

fun getPerson(personId: Int): Single<Person> {
    return apiService!!.getPerson(personId)
}

fun getPeople(): Observable<PeopleResponse> {
    return Observable.range(1, Integer.MAX_VALUE)
            .concatMap { page -> apiService!!.getPeople(page) }
            .takeUntil { result -> result.next == null }
}