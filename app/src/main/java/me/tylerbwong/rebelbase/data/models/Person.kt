package me.tylerbwong.rebelbase.data.models

/**
 * @author Tyler Wong
 */
data class Person(val name: String, val height: String, val mass: String, val hairColor: String,
                  val skinColor: String, val eyeColor: String, val birthYear: String, val gender: String) {

    companion object Person {
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
