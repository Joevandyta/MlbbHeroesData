package com.jovan.mlbbheroesdata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HeroesListAdapter(private val listHeroes: ArrayList<MlbbHeroes>) : RecyclerView.Adapter<HeroesListAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_heroes_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_heroes_name)
        val tvHeroesRole: TextView = itemView.findViewById(R.id.tv_heroes_role)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_row_item, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listHeroes.size

    override fun onBindViewHolder(
        holder: ListViewHolder,
        position: Int,
    ) {
        val (name, photo, heroesRole) = listHeroes[position]

        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvHeroesRole.text = heroesRole
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listHeroes[holder.adapterPosition], position) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(
            data: MlbbHeroes,
            position: Int,
        )
    }
}
