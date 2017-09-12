package me.tylerbwong.rebelbase.presentation.view

import me.tylerbwong.rebelbase.data.models.Person
import me.tylerbwong.rebelbase.presentation.BasePresenter
import me.tylerbwong.rebelbase.presentation.BaseView

/**
 * @author Tyler Wong
 */
class MainContract {
    interface View : BaseView<Presenter> {
        fun addPerson(person: Person)
    }

    interface Presenter : BasePresenter {
        fun loadPeople()
    }
}