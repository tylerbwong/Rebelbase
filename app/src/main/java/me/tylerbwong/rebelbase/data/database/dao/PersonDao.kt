package me.tylerbwong.rebelbase.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import io.reactivex.Single
import me.tylerbwong.rebelbase.data.models.Person

/**
 * @author Tyler Wong
 */
@Dao
interface PersonDao {
    @Query("SELECT * FROM person")
    fun getPeople(): Single<List<Person>>

    @Update
    fun updatePerson(person: Person)

    @Insert
    fun insert(person: Person)
}