package me.tylerbwong.rebelbase.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import me.tylerbwong.rebelbase.data.database.dao.PersonDao
import me.tylerbwong.rebelbase.data.models.Person

/**
 * @author Tyler Wong
 */
@Database(entities = arrayOf(Person::class), version = 1)
abstract class Rebelbase : RoomDatabase() {
    abstract fun personDao(): PersonDao
}