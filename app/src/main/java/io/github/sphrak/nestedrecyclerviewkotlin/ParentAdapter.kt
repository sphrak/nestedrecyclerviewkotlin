package io.github.sphrak.nestedrecyclerviewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.sphrak.nestedrecyclerviewkotlin.model.ExampleDataModel
import kotlinx.android.synthetic.main.child_viewholder.view.*
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle
import java.util.*

class ParentAdapter constructor(
    private val viewPool: RecyclerView.RecycledViewPool
): RecyclerView.Adapter<ParentAdapter.ViewHolder>() {

    private val formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)

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
        fun bind(title: OffsetDateTime) {
            itemView.title.text = title.toLocalDateTime().format(formatter)
        }
    }

    private val childAdapter = ChildAdapter(emptyList())

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(exampleDataModelList[position].time)
        holder
            .itemView
            .childRecyclerView
            ?.apply {
                layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.VERTICAL, false)
                adapter = childAdapter.listOfInts(exampleDataModelList[position].weather)
                setRecycledViewPool(viewPool)
            }
    }

    fun setList(list: List<ExampleDataModel>) {
        exampleDataModelList.clear()
        exampleDataModelList.addAll(list)
        notifyDataSetChanged()
    }

}