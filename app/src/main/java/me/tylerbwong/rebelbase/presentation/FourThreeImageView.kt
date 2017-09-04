package me.tylerbwong.rebelbase.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView

/**
 * @author Tyler Wong
 */
class FourThreeImageView(context: Context, attrs: AttributeSet) : ImageView(context, attrs) {
    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        val fourThreeHeight = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthSpec) * 3 / 4,
                View.MeasureSpec.EXACTLY)
        super.onMeasure(widthSpec, fourThreeHeight)
    }
}