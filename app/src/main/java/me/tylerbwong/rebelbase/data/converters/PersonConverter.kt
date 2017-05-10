package me.tylerbwong.rebelbase.data.converters

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import me.tylerbwong.rebelbase.data.models.Person
import java.lang.reflect.Type

/**
 * @author Tyler Wong
 */
class PersonConverter : JsonDeserializer<Person> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Person {
        val jsonObject: JsonObject = json!!.asJsonObject
        val person: Person = Person(jsonObject[Person.NAME].asString,
                jsonObject[Person.HEIGHT].asString,
                jsonObject[Person.MASS].asString,
                jsonObject[Person.HAIR_COLOR].asString,
                jsonObject[Person.SKIN_COLOR].asString,
                jsonObject[Person.EYE_COLOR].asString,
                jsonObject[Person.BIRTH_YEAR].asString,
                jsonObject[Person.GENDER].asString)
        return person
    }
}