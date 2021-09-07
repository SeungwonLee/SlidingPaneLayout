package com.linecorp.largescreen.slidingpane

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.linecorp.largescreen.R

class RecyclerViewAdapter(
    private val arraySet: List<Int>,
    private val onClickItem: (position: Int) -> Unit
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val value = arraySet[position]
        holder.textView.text = value.toString()
        holder.textView.setOnClickListener { onClickItem(value) }
    }

    override fun getItemCount(): Int = arraySet.size
}