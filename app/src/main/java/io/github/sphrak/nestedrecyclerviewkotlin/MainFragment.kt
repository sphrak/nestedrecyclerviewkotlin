package io.github.sphrak.nestedrecyclerviewkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    val abc: String by lazy {
        ""
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_main, container, false)

    override fun onStart() {
        super.onStart()
        staryNight.onStart()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gradientChart.chartValues = arrayOf(
            10f, 30f, 25f, 32f, 13f, 5f, 18f, 36f, 20f, 30f, 28f, 27f, 29f
        )
    }

    override fun onStop() {
        super.onStop()
        staryNight.onStop()
    }

}