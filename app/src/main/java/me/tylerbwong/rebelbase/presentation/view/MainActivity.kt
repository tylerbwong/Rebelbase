package me.tylerbwong.rebelbase.presentation.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import me.tylerbwong.rebelbase.R
import me.tylerbwong.rebelbase.data.models.Person
import me.tylerbwong.rebelbase.presentation.view.people.PeopleAdapter

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var adapter: PeopleAdapter

    private var presenter: MainContract.Presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(this.toolbar)
        supportActionBar?.title = getString(R.string.app_name)

        adapter = PeopleAdapter(mutableListOf(), resources.getStringArray(R.array.people_images))
        this.people.adapter = adapter
        this.people.layoutManager = GridLayoutManager(this, 2)

        presenter.subscribe()
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }

    override fun addPerson(person: Person) {
        adapter.addPerson(person)
    }
}
