package me.tylerbwong.rebelbase.data.providers.database

import android.arch.persistence.room.Room
import android.content.Context
import me.tylerbwong.rebelbase.data.database.AppDatabase

/**
 * @author Tyler Wong
 */

private var database: AppDatabase? = null
private const val REBELBASE: String = "rebelbase"

fun getDatabase(context: Context): AppDatabase? {
    if (database == null) {
        database = Room.databaseBuilder(context, AppDatabase::class.java, REBELBASE).build()
    }
    return database
}