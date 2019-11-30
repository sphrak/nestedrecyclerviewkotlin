package io.github.sphrak.nestedrecyclerviewkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val alphabetList: List<String> by lazy {
        listOf(
            "a",
            "b",
            "c",
            "d",
            "e",
            "f",
            "g",
            "h",
            "i",
            "j",
            "k",
            "l",
            "m",
            "n",
            "o",
            "p",
            "q",
            "r",
            "s",
            "t",
            "u",
            "v",
            "w",
            "x",
            "y",
            "z"
        )
    }

    fun generateExampleDataModel(): List<ExampleDataModel> =
        alphabetList
            .map { title: String ->
                val numbers: List<Int> = (0..1023)
                    .map {
                        Random.nextInt()
                    }

                ExampleDataModel(
                    title = title,
                    numbers = numbers
                )
            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPool = RecyclerView.RecycledViewPool()
        val parentAdapter = ParentAdapter(viewPool = viewPool)
        parentRecyclerView.apply {
            adapter = parentAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        parentAdapter.setList(list = generateExampleDataModel())
    }
}
