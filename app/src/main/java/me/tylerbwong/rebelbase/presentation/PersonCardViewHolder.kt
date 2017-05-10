package me.tylerbwong.rebelbase.presentation

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import me.tylerbwong.rebelbase.R

/**
 * @author Tyler Wong
 */
class PersonCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mName: TextView? = null

    init {
        mName = itemView.findViewById(R.id.name) as TextView
    }
}