package com.muryno.pokemonapp.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.muryno.pokemonapp.R
import com.muryno.pokemonapp.data.model.Move
import com.muryno.pokemonapp.databinding.MoveListItemBinding
import javax.inject.Inject


class PokemonMoveAdapter @Inject constructor() :
    RecyclerView.Adapter<PokemonMoveAdapter.MyViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<Move>() {
        override fun areItemsTheSame(
            oldItem: Move,
            newItem: Move
        ): Boolean {
            return oldItem.move.url == newItem.move.url
        }

        override fun areContentsTheSame(
            oldItem: Move,
            newItem: Move
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
        val statItem = differ.currentList[position]
        holder.bind(statItem)
    }


    inner class MyViewHolder(val binding: MoveListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(move: Move?) {
            binding.title.text = move?.move?.name.toString()
        }
    }

}