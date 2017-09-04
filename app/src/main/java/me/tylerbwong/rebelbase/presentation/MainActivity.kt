package me.tylerbwong.rebelbase.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import me.tylerbwong.rebelbase.R
import me.tylerbwong.rebelbase.data.providers.getPeople
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: PeopleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(this.toolbar)
        supportActionBar?.title = getString(R.string.app_name)

        adapter = PeopleAdapter(mutableListOf(), resources.getStringArray(R.array.people_images))
        this.people.adapter = adapter
        this.people.layoutManager = GridLayoutManager(this, 2)

        getPeople()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(adapter::addPerson, Timber::e)
    }
}
