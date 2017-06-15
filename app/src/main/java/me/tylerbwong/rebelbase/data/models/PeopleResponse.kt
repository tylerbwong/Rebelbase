package me.tylerbwong.rebelbase.data.models

import com.google.gson.annotations.SerializedName

/**
 * @author Tyler Wong
 */
data class PeopleResponse(@SerializedName(PeopleResponse.COUNT) var count: Int,
                          @SerializedName(PeopleResponse.NEXT) var next: String,
                          @SerializedName(PeopleResponse.RESULTS) var results: MutableList<Person>) {
    companion object PeopleResponse {
        const val COUNT = "count"
        const val NEXT = "next"
        const val RESULTS = "results"
    }
}