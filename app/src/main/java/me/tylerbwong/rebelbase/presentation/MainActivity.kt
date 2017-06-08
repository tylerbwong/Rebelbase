package me.tylerbwong.rebelbase.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import butterknife.bindView
import io.reactivex.android.schedulers.AndroidSchedulers
import me.tylerbwong.rebelbase.R
import me.tylerbwong.rebelbase.data.models.Person
import me.tylerbwong.rebelbase.data.providers.getPeople

class MainActivity : AppCompatActivity() {
    val mPeopleList: RecyclerView by bindView(R.id.people_list)

    lateinit var mAdapter: PeopleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = PeopleAdapter(ArrayList<Person>())
        mPeopleList.adapter = mAdapter
        mPeopleList.addItemDecoration(ItemSpacingDecoration(resources.getDimension(R.dimen.item_spacing).toInt()))
        mPeopleList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onResume() {
        super.onResume()

        getPeople()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ person ->
                    mAdapter.mPeople.add(person)
                    mAdapter.notifyItemInserted(mAdapter.mPeople.size - 1)
                }, { e ->
                    Log.e("", "", e)
                })
    }
}
