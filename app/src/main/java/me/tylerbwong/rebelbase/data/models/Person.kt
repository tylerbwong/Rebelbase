package me.tylerbwong.rebelbase.data.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * @author Tyler Wong
 */
@Entity
data class Person(@PrimaryKey val name: String, val height: String, val mass: String, val hairColor: String,
                  val skinColor: String, val eyeColor: String, val birthYear: String, val gender: String) {

    var imageUrl:String? = null

    companion object {
        const val NAME = "name"
        const val HEIGHT = "height"
        const val MASS = "mass"
        const val HAIR_COLOR = "hair_color"
        const val SKIN_COLOR = "skin_color"
        const val EYE_COLOR = "eye_color"
        const val BIRTH_YEAR = "birth_year"
        const val GENDER = "gender"
    }
}
