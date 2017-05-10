package me.tylerbwong.rebelbase.data.converters

import com.google.gson.*
import me.tylerbwong.rebelbase.data.models.PeopleResponse
import me.tylerbwong.rebelbase.data.models.Person
import java.lang.reflect.Type

/**
 * @author Tyler Wong
 */
class PeopleResponseConverter : JsonDeserializer<PeopleResponse> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): PeopleResponse {
        val response: PeopleResponse = PeopleResponse
        val jsonObject: JsonObject = json!!.asJsonObject
        val peopleArray: JsonArray = jsonObject[PeopleResponse.RESULTS].asJsonArray

        response.count = jsonObject[PeopleResponse.COUNT].asInt

        if (!jsonObject[PeopleResponse.NEXT].isJsonNull) {
            response.next = jsonObject[PeopleResponse.NEXT].asString
        }

        response.results = mutableListOf<Person>()

        var personJsonObject: JsonObject
        var person: Person

        peopleArray.forEach {
            jsonPerson ->
                personJsonObject = jsonPerson.asJsonObject
                person = Person(personJsonObject[Person.NAME].asString,
                    personJsonObject[Person.HEIGHT].asString,
                    personJsonObject[Person.MASS].asString,
                    personJsonObject[Person.HAIR_COLOR].asString,
                    personJsonObject[Person.SKIN_COLOR].asString,
                    personJsonObject[Person.EYE_COLOR].asString,
                    personJsonObject[Person.BIRTH_YEAR].asString,
                    personJsonObject[Person.GENDER].asString)
                response.results!!.add(person)
        }
        return response
    }
}