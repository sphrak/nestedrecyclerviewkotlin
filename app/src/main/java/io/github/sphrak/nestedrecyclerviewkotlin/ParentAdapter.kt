package io.github.sphrak.nestedrecyclerviewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.child_viewholder.view.*
import java.util.*

class ParentAdapter constructor(
    private val viewPool: RecyclerView.RecycledViewPool
): RecyclerView.Adapter<ParentAdapter.ViewHolder>() {

    private val exampleDataModelList: MutableList<ExampleDataModel> by lazy {
        mutableListOf<ExampleDataModel>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.child_viewholder,
                    parent,
                    false
                )
        )

    override fun getItemCount(): Int = exampleDataModelList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(title: String) {
            itemView.title.text = title.toUpperCase(Locale.getDefault())
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(exampleDataModelList[position].title)
        holder
            .itemView
            .childRecyclerView
            ?.apply {
                layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
                adapter = ChildAdapter(exampleDataModelList[position].numbers)
                setRecycledViewPool(viewPool)
            }
    }

    fun setList(list: List<ExampleDataModel>) {
        exampleDataModelList.clear()
        exampleDataModelList.addAll(list)
        notifyDataSetChanged()
    }

}