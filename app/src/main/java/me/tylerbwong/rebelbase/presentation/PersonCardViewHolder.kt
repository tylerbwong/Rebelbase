package me.tylerbwong.rebelbase.presentation

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import butterknife.bindView
import me.tylerbwong.rebelbase.R

/**
 * @author Tyler Wong
 */
class PersonCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val mName: TextView by bindView(R.id.name)
    val mBirthYear: TextView by bindView(R.id.birth_year)
}