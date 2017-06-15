package me.tylerbwong.rebelbase.data.database.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import me.tylerbwong.rebelbase.data.models.Person

/**
 * @author Tyler Wong
 */
@Dao
interface PersonDao {

    @Query("SELECT * FROM person")
    fun getAllPeople(): Flowable<List<Person>>

    @Query("SELECT COUNT(*) FROM person")
    fun getPeopleCount(): Flowable<Int>
}