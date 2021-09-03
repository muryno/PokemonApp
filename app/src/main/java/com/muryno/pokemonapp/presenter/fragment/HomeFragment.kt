package com.muryno.pokemonapp.presenter.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.muryno.pokemonapp.R
import com.muryno.pokemonapp.data.model.Pokemon
import com.muryno.pokemonapp.data.util.Resource
import com.muryno.pokemonapp.databinding.FragmentHomeBinding
import com.muryno.pokemonapp.presenter.adapter.PokemonMoveAdapter
import com.muryno.pokemonapp.presenter.adapter.PokemonStaticsAdapter
import com.muryno.pokemonapp.presenter.viewModel.WeightWatcherViewModel
import com.muryno.pokemonapp.utils.randomNumberWithIn800
import com.muryno.pokemonapp.utils.showToast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    @Inject
    lateinit var moveAdapter: PokemonMoveAdapter


    @Inject
    lateinit var pokemonStaticsAdapter: PokemonStaticsAdapter



    private val viewModel by viewModels<WeightWatcherViewModel>()

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        inits()

        viewModel.pokemonLiveData.observe(viewLifecycleOwner, { response ->
                when (response) {
                    is Resource.Success -> {
                        response.data?.let {
                            context?.let { it1 -> displayUi(pokemon = it,context= it1) }
                        }
                        hideProgressBar()
                    }
                    is Resource.Error -> {
                        hideProgressBar()
                        response.message?.let {
                            showToast(it)
                        }

                    }
                    is Resource.Loading -> {
                        showProgressBar()
                    }
                }
            })

        binding.refresh.setOnClickListener {
            inits()
        }
    }



    fun inits(){
        viewModel.getPokemonLiveData(randomNumberWithIn800())
    }

    private fun initRecyclerView() {
        binding.apply {
            //moves recycler view
            movesRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
            movesRecyclerView.adapter = moveAdapter
            // statistics recycler view
            statisticsRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
            statisticsRecyclerView.adapter = pokemonStaticsAdapter
        }

    }


    private fun displayUi( pokemon: Pokemon?,context: Context){


        binding.apply {
            moveAdapter.differ.submitList(pokemon?.moves?.toList())
            pokemonStaticsAdapter.differ.submitList(pokemon?.stats?.toList())

            title.text = pokemon?.name.toString()
            Glide.with(context)
                .load(pokemon?.sprites?.back_default)
                .placeholder(R.drawable.ic_baseline_image_24)
                .into(binding.backImage)

            Glide.with(context)
                .load(pokemon?.sprites?.front_default)
                .placeholder(R.drawable.ic_baseline_image_24)
                .into(binding.frontImageView)
            }
    }

    private fun showProgressBar() {
        binding.strProgressBar.visibility = View.VISIBLE
        binding.moveProgressBar.visibility = View.VISIBLE

        binding.movesRecyclerView.visibility = View.GONE
        binding.statisticsRecyclerView.visibility = View.GONE
        binding.moves.visibility = View.GONE
        binding.statistics.visibility = View.GONE

    }

    private fun hideProgressBar() {
        binding.strProgressBar.visibility = View.GONE
        binding.moveProgressBar.visibility = View.GONE

        binding.movesRecyclerView.visibility = View.VISIBLE
        binding.statisticsRecyclerView.visibility = View.VISIBLE
        binding.moves.visibility = View.VISIBLE
        binding.statistics.visibility = View.VISIBLE
    }


}