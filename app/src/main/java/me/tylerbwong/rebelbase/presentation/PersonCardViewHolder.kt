package me.tylerbwong.rebelbase.presentation

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.person_card.view.*

/**
 * @author Tyler Wong
 */
class PersonCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val image: ImageView = itemView.image
}