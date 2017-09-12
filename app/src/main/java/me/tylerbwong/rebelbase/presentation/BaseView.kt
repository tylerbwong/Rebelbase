package me.tylerbwong.rebelbase.presentation

/**
 * @author Tyler Wong
 */
interface BaseView<T> {
    fun setPresenter(presenter: T)
}