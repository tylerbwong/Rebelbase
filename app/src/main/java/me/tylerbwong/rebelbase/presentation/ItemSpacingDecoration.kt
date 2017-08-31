package me.tylerbwong.rebelbase.presentation

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * @author Tyler Wong
 */
class ItemSpacingDecoration(private var space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        outRect.top = space
        outRect.left = space
        outRect.right = space

        val itemCount: Int = state?.itemCount ?: 0

        if (itemCount > 0 && parent.getChildAdapterPosition(view) == itemCount - 1) {
            outRect.bottom = space
        }
    }
}
