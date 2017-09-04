package me.tylerbwong.rebelbase.data.models

import com.google.gson.annotations.SerializedName

/**
 * @author Tyler Wong
 */
data class PlanetResponse(@SerializedName(COUNT) var count: Int,
                          @SerializedName(NEXT) var next: String,
                          @SerializedName(RESULTS) var results: MutableList<Planet>) {

    companion object {
        const val COUNT = "count"
        const val NEXT = "next"
        const val RESULTS = "results"
    }
}