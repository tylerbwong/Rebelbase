package me.tylerbwong.rebelbase.presentation

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.tylerbwong.rebelbase.R
import me.tylerbwong.rebelbase.data.models.Person

/**
 * @author Tyler Wong
 */
class PeopleAdapter(people: MutableList<Person>) : RecyclerView.Adapter<PersonCardViewHolder>() {

    var mPeople: MutableList<Person>? = null

    init {
        mPeople = people
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PersonCardViewHolder {
        val view: View = LayoutInflater.from(parent!!.context).inflate(R.layout.person_card, parent, false)
        return PersonCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonCardViewHolder?, position: Int) {
        var tempPerson: Person = mPeople!![position]
        holder!!.mName!!.text = tempPerson.name
        System.out.println(position.toString())
    }

    override fun getItemCount(): Int {
        return mPeople!!.size
    }
}