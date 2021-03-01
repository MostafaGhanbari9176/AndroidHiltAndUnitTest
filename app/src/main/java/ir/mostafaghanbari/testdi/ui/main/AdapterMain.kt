package ir.mostafaghanbari.testdi.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.qualifiers.ActivityContext
import ir.mostafaghanbari.testdi.R
import ir.mostafaghanbari.testdi.model.Post
import kotlinx.android.synthetic.main.item_post.view.*
import javax.inject.Inject

class AdapterMain(
    private val data: List<Post>
) : RecyclerView.Adapter<AdapterMain.MyHolder>() {

    @ActivityContext
    @Inject
    lateinit var ctx: Context

    class MyHolder(v: View) : RecyclerView.ViewHolder(v)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(ctx).inflate(R.layout.item_post, parent, false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.itemView.apply {
            txtItemOwner.text = data[position].username
            txtItemTitle.text = data[position].title
        }
    }

    override fun getItemCount(): Int = data.size

}