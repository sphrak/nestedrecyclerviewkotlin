package io.github.sphrak.nestedrecyclerviewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.sphrak.nestedrecyclerviewkotlin.model.WeatherDataModel

class ChildAdapter constructor(
    var listOfInts: List<WeatherDataModel>
): RecyclerView.Adapter<ChildAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val temperatureView: TextView = itemView.findViewById(R.id.temperature)
        private val feelslike: TextView = itemView.findViewById(R.id.feelslike)
        private val wind: TextView = itemView.findViewById(R.id.wind)
        private val time: TextView = itemView.findViewById(R.id.time)

        fun bind(dataModel: WeatherDataModel) {
            temperatureView.text = dataModel.temp
            feelslike.text = dataModel.feelsLikeTemp
            wind.text = dataModel.wind
            time.text = dataModel.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.child_item,
                    parent,
                    false
                )
        )

    override fun getItemCount(): Int = listOfInts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int): Unit =
        holder.bind(listOfInts[position])


}