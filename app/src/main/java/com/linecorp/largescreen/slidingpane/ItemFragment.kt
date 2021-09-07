package com.linecorp.largescreen.slidingpane

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.linecorp.largescreen.R
import java.util.Random

class ItemFragment : Fragment(R.layout.example_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<TextView>(R.id.textView1)
        val it = arguments?.get("itemId") as? Int ?: return
        textView.text = it.toString()

        val container = view.findViewById<LinearLayout>(R.id.container)
        container.setBackgroundColor(getRandomColor())
    }

    private fun getRandomColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}