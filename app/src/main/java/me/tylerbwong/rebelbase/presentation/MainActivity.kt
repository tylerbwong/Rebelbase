package me.tylerbwong.rebelbase.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import me.tylerbwong.rebelbase.R
import me.tylerbwong.rebelbase.data.models.Person
import me.tylerbwong.rebelbase.data.providers.getPeople

class MainActivity : AppCompatActivity() {
    var mPeopleList: RecyclerView? = null

    var mAdapter: PeopleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPeopleList = findViewById(R.id.people_list) as RecyclerView

        mAdapter = PeopleAdapter(ArrayList<Person>())
        mPeopleList!!.adapter = mAdapter
        mPeopleList!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onResume() {
        super.onResume()

        getPeople()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    people ->
                        mAdapter!!.mPeople!!.addAll(people.results!!)
                        mAdapter!!.notifyDataSetChanged()
                }, {
                    e -> Log.e("", "", e)
                })
    }
}