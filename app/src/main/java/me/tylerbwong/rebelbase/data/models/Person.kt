package me.tylerbwong.rebelbase.data.models

/**
 * @author Tyler Wong
 */
data class Person(val name: String, val height: String, val mass: String, val hairColor: String,
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
