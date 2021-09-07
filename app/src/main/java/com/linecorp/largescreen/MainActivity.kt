package com.linecorp.largescreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        updateWidthDp()
    }

    // A method on the Fragment that owns the SlidingPaneLayout,
// called by the adapter when an item is selected.

//    private fun updateWidthDp() {
//        val displayMetrics = DisplayMetrics()
//        windowManager.defaultDisplay.getMetrics(displayMetrics)
//        val height = displayMetrics.heightPixels
//        val width = displayMetrics.widthPixels
//
//        val widthDp = convertPixelsToDp(width.toFloat(), this)
//        textView.text = widthDp.toString()
//    }
//
//    override fun onMultiWindowModeChanged(isInMultiWindowMode: Boolean, newConfig: Configuration?) {
//        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig)
//        updateWidthDp()
//    }
//
//    private fun convertPixelsToDp(px: Float, context: Context): Float {
//        return px / (context.getResources()
//            .getDisplayMetrics().densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
//    }
}