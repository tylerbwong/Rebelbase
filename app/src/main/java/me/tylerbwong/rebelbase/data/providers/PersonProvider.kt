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

val personApiService: RebelApi? = getApiService()

fun getPerson(personId: Int): Single<Person> {
    return personApiService!!.getPerson(personId)
}

fun getPeopleByPage(page: Int): Observable<PeopleResponse> {
    return personApiService!!.getPeopleByPage(page)
            .concatMap { response ->
                if (response.next == null) {
                    Observable.just(response)
                }
                Observable.just(response).concatWith(getPeopleByPage(page + 1))
            }
}

fun getPeople(): Observable<Person> {
    return getPeopleByPage(1)
            .map { response -> response.results }
            .flatMapIterable { people -> people }
}