package me.tylerbwong.rebelbase.data.models

import com.google.gson.annotations.SerializedName

/**
 * @author Tyler Wong
 */
object PlanetResponse {
    @SerializedName(COUNT) var count: Int? = null
    @SerializedName(NEXT) var next: String? = null
    @SerializedName(RESULTS) var results: MutableList<Planet>? = null

    const val COUNT = "count"
    const val NEXT = "next"
    const val RESULTS = "results"
}