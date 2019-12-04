package io.github.sphrak.nestedrecyclerviewkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.sphrak.nestedrecyclerviewkotlin.model.ExampleDataModel
import io.github.sphrak.nestedrecyclerviewkotlin.model.WeatherDataModel
import kotlinx.android.synthetic.main.fragment_list.*
import org.threeten.bp.OffsetDateTime
import kotlin.random.Random

class ListFragment : Fragment() {

    private fun generateExampleDataModel(): List<ExampleDataModel> =
        (0..7L)
            .map { day: Long ->

                val date: OffsetDateTime = OffsetDateTime.now()

                val weather: List<WeatherDataModel> = (0 until 24)
                    .map { integer ->


                        WeatherDataModel(
                            feelsLikeTemp = Random.nextInt(1,10).toString() + "°",
                            temp = Random.nextInt(1,10).toString() + "°",
                            time = (date.hour + integer).toString(),
                            wind = Random.nextInt(30,40).toString() + "m/s"
                        )
                    }

                ExampleDataModel(
                    time = date.plusDays(day),
                    weather = weather
                )
            }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_list, container, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPool = RecyclerView.RecycledViewPool()
        val parentAdapter = ParentAdapter(viewPool = viewPool)
        parentRecyclerView.apply {
            adapter = parentAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        parentAdapter.setList(list = generateExampleDataModel())
    }

}