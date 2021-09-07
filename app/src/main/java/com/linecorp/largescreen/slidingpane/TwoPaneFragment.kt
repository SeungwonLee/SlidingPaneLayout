package com.linecorp.largescreen.slidingpane

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.linecorp.largescreen.R

class TwoPaneFragment : Fragment(R.layout.slidingpane) {

    private lateinit var slidingPane: SlidingPaneLayout
    private lateinit var list: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        slidingPane = view.findViewById(R.id.sliding_pane_layout)
        list = view.findViewById(R.id.list_pane)
        list.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = RecyclerViewAdapter((1..10).toList()) { position ->
                openDetails(position)
            }
        }
//        slidingPane.lockMode = SlidingPaneLayout.LOCK_MODE_LOCKED
        // Connect the SlidingPaneLayout to the system back button.
        requireActivity().onBackPressedDispatcher
            .addCallback(
                viewLifecycleOwner,
                TwoPaneOnBackPressedCallback(slidingPane)
            )
    }

    private fun openDetails(itemId: Int) {
        childFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                R.id.detail_container,
                ItemFragment::class.java,
                bundleOf("itemId" to itemId)
            )
            // If we're already open and the detail pane is visible,
            // crossfade between the fragments.
            if (slidingPane.isOpen) {
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            }
        }
        slidingPane.open()
    }
}
