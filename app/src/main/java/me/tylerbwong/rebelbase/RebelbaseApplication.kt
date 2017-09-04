package me.tylerbwong.rebelbase

import android.app.Application
import android.arch.persistence.room.Room
import me.tylerbwong.rebelbase.data.database.Rebelbase

/**
 * @author Tyler Wong
 */
class RebelbaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, Rebelbase::class.java, "rebelbase").build()
    }

    companion object {
        var database: Rebelbase? = null
    }
}