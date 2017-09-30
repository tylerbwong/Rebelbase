package me.tylerbwong.rebelbase.presentation.view.people

import android.app.ActivityOptions
import android.content.Intent
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
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
        val person: Person = people[position]

        val options: RequestOptions = RequestOptions()
                .dontAnimate()

        Glide.with(holder.itemView)
                .load(images[position])
                .apply(options)
                .into(holder.image)

        ViewCompat.setTransitionName(holder.image, images[position])

        holder.image.setOnClickListener {
            val intent = Intent(holder.itemView.context, PersonDetailActivity::class.java)
            intent.putExtra("image", images[position])
            intent.putExtra("name", person.name)
            intent.putExtra("birthYear", person.birthYear)
            intent.putExtra("mass", person.mass)

            val statusBar: View = (it.context as AppCompatActivity).findViewById(android.R.id.statusBarBackground)
            val navigationBar: View = (it.context as AppCompatActivity).findViewById(android.R.id.navigationBarBackground)
            val appBar: View = (it.context as AppCompatActivity).findViewById(R.id.appBar)
            ViewCompat.setTransitionName(appBar, "appBar")

            val transitionOptions = ActivityOptions.makeSceneTransitionAnimation(holder.itemView.context as AppCompatActivity,
                    Pair.create(statusBar, Window.STATUS_BAR_BACKGROUND_TRANSITION_NAME),
                    Pair.create(navigationBar, Window.NAVIGATION_BAR_BACKGROUND_TRANSITION_NAME),
                    Pair.create(appBar, ViewCompat.getTransitionName(appBar)),
                    Pair.create(holder.image, ViewCompat.getTransitionName(holder.image)))

            holder.itemView.context.startActivity(intent, transitionOptions.toBundle())
        }
    }

    fun addPerson(person: Person) {
        people.add(person)
        notifyItemInserted(people.size - 1)
    }

    override fun getItemCount(): Int {
        return people.size
    }
}