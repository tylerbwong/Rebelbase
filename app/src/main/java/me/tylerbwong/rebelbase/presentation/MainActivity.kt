package me.tylerbwong.rebelbase.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import butterknife.bindView
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.tylerbwong.rebelbase.R
import me.tylerbwong.rebelbase.data.models.Person
import me.tylerbwong.rebelbase.data.providers.database.getDatabase
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

        getDatabase(applicationContext)?.personDao()?.getPeopleCount() ?: Flowable.just(0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { count ->
                    if (count > 0) {
                        getDatabase(applicationContext)?.personDao()?.getAllPeople() ?: Flowable.just(listOf<Person>())
                                .subscribeOn(Schedulers.io())
                                .flatMapIterable { people -> people }
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe({ person ->
                                    mAdapter.addPerson(person)
                                }, { e ->
                                    Log.e("", "", e)
                                })
                    }
                    else {
                        getPeople()
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe({ person ->
                                    mAdapter.addPerson(person)
                                }, { e ->
                                    Log.e("", "", e)
                                })
                    }
                }
    }
}
