package com.omd.pasolinisdv.ui.misc

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import com.omd.pasolinisdv.ApplicationQualifier
import com.omd.pasolinisdv.R
import javax.inject.Inject

/**
 * Simple divider decorator for a RecyclerView.
 *
 * Adapted from https://gist.github.com/polbins/e37206fbc444207c0e92
 */
class SimpleDividerItemDecoration @Inject constructor(@ApplicationQualifier context: Context) : RecyclerView.ItemDecoration() {

    private val divider: Drawable = ContextCompat.getDrawable(context, R.drawable.line_divider)

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for (i in 0..childCount - 1) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + divider.intrinsicHeight

            divider.setBounds(left, top, right, bottom)
            divider.draw(c)
        }
    }
}