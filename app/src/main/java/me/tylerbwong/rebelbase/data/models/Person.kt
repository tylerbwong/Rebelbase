package me.tylerbwong.rebelbase.data.models

/**
 * @author Tyler Wong
 */

class Person(name: String, height: String, mass: String, hairColor: String, skinColor: String, eyeColor: String, birthYear: String, gender: String) {

    var name: String? = null
    var height: String? = null
    var mass: String? = null
    var hairColor: String? = null
    var skinColor: String? = null
    var eyeColor: String? = null
    var birthYear: String? = null
    var gender: String? = null

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

    init {
        this.name = name
        this.height = height
        this.mass = mass
        this.hairColor = hairColor
        this.skinColor = skinColor
        this.eyeColor = eyeColor
        this.birthYear = birthYear
        this.gender = gender
    }
}
