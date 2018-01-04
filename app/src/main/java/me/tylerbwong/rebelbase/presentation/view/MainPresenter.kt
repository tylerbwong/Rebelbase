package me.tylerbwong.rebelbase.presentation.view

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import me.tylerbwong.rebelbase.data.providers.getLocalPeople
import me.tylerbwong.rebelbase.data.providers.getNumLocalPeople
import me.tylerbwong.rebelbase.data.providers.getPeople
import me.tylerbwong.rebelbase.data.providers.insertPerson
import timber.log.Timber

/**
 * @author Tyler Wong
 */
class MainPresenter(private val mainView: MainContract.View) : MainContract.Presenter {

    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun loadPeople() {
        val disposable = getNumLocalPeople()
                .subscribeOn(Schedulers.io())
                .subscribe { numPeople ->
                    if (numPeople > 0) {
                        val disposable = getLocalPeople()
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(mainView::addPerson, Timber::e)
                        disposables.add(disposable)
                    }
                    else {
                        val disposable = getPeople()
                                .map { insertPerson(it) }
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(mainView::addPerson, Timber::e)
                        disposables.add(disposable)
                    }
                }
        disposables.add(disposable)
    }

    override fun subscribe() {
        loadPeople()
    }

    override fun unsubscribe() {
        disposables.clear()
    }
}