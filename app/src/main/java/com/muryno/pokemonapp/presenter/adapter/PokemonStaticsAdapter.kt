package com.muryno.pokemonapp.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.muryno.pokemonapp.R
import com.muryno.pokemonapp.data.model.Stat
import com.muryno.pokemonapp.databinding.MoveListItemBinding
import javax.inject.Inject


class PokemonStaticsAdapter @Inject constructor() :
    RecyclerView.Adapter<PokemonStaticsAdapter.MyViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<Stat>() {
        override fun areItemsTheSame(
            oldItem: Stat,
            newItem: Stat
        ): Boolean {
            return oldItem.stat.url == newItem.stat.url
        }

        override fun areContentsTheSame(
            oldItem: Stat,
            newItem: Stat
        ): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: MoveListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.move_list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val staticItem = differ.currentList[position]
        holder.bind(staticItem)
    }


    inner class MyViewHolder(val binding: MoveListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(stat: Stat?) {
            binding.title.text = stat?.stat?.name.toString()
        }
    }

}