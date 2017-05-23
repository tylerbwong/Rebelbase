package me.tylerbwong.rebelbase.presentation

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * @author Tyler Wong
 */
class ItemSpacingDecoration(private var mSpace: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        outRect.top = mSpace
        outRect.left = mSpace
        outRect.right = mSpace

        val itemCount: Int = state!!.itemCount

        if (itemCount > 0 && parent.getChildAdapterPosition(view) == itemCount - 1) {
            outRect.bottom = mSpace
        }
    }
}
