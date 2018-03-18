package com.kmshack.example.fragmenttransitions

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

/**
 * Created by kmshack on 2018. 3. 18..
 */
class SquareImageView : ImageView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}