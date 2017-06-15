package me.tylerbwong.rebelbase.data.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * @author Tyler Wong
 */
@Entity
data class Person(@PrimaryKey val name: String, val height: String, val mass: String, val hairColor: String,
                  val skinColor: String, val eyeColor: String, val birthYear: String, val gender: String) {

    companion object Person {
        val NAME = "name"
        val HEIGHT = "height"
        val MASS = "mass"
        val HAIR_COLOR = "hair_color"
        val SKIN_COLOR = "skin_color"
        val EYE_COLOR = "eye_color"
        val BIRTH_YEAR = "birth_year"
        val GENDER = "gender"
    }
}
