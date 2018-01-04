@file:JvmName("PersonProvider")

package me.tylerbwong.rebelbase.data.providers

import io.reactivex.Flowable
import io.reactivex.Single
import me.tylerbwong.rebelbase.RebelbaseApplication
import me.tylerbwong.rebelbase.data.models.PeopleResponse
import me.tylerbwong.rebelbase.data.models.Person
import me.tylerbwong.rebelbase.data.providers.api.apiService

/**
 * @author Tyler Wong
 */

fun getPerson(personId: Int): Single<Person> = apiService.getPerson(personId)

fun getPeopleByPage(page: Int): Flowable<PeopleResponse> = apiService.getPeopleByPage(page)
        .concatMap {
            if (it.count == 0) {
                Flowable.just(it)
            }
            Flowable.just(it).concatWith(getPeopleByPage(page + 1))
        }

fun getNumLocalPeople(): Single<Int> = RebelbaseApplication.database?.personDao()?.getNumPeople()!!

fun insertPerson(person: Person): Person {
    RebelbaseApplication.database?.personDao()?.insert(person)
    return person
}

fun getLocalPeople(): Flowable<Person> = RebelbaseApplication.database?.personDao()?.getPeople()!!
        .flatMapIterable { it }

fun getPeople(): Flowable<Person> = getPeopleByPage(1)
        .map { it.results }
        .flatMapIterable { it }