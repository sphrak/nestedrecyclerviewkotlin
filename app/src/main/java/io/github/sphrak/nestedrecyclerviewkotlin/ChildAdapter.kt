package io.github.sphrak.nestedrecyclerviewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.child_item.view.*

class ChildAdapter constructor(
    private val listOfInts: List<Int>
): RecyclerView.Adapter<ChildAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(number: String) {
            itemView.numberText.text = number
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
        holder.bind(listOfInts[position].toString())

}