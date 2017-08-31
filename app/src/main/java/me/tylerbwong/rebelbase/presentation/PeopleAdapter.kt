package me.tylerbwong.rebelbase.presentation

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import me.tylerbwong.rebelbase.R
import me.tylerbwong.rebelbase.data.models.Person

/**
 * @author Tyler Wong
 */
class PeopleAdapter(people: MutableList<Person>, images: Array<String>) : RecyclerView.Adapter<PersonCardViewHolder>() {

    private var people: MutableList<Person> = people
    private val images: Array<String> = images

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PersonCardViewHolder {
        val view: View = LayoutInflater.from(parent!!.context).inflate(R.layout.person_card, parent, false)
        return PersonCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonCardViewHolder, position: Int) {
        val tempPerson: Person = people[position]
        holder.name.text = tempPerson.name
        holder.birthYear.text = tempPerson.birthYear

        val options: RequestOptions = RequestOptions()
                .centerCrop()
                .dontAnimate()

        Glide.with(holder.itemView)
                .load(images[position])
                .apply(options)
                .into(holder.image)
    }

    fun addPerson(person: Person) {
        people.add(person)
        notifyItemInserted(people.size - 1)
    }

    override fun getItemCount(): Int {
        return people.size
    }
}