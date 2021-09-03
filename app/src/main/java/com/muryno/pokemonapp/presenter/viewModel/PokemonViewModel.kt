package com.muryno.pokemonapp.presenter.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muryno.pokemonapp.App
import com.muryno.pokemonapp.data.model.Pokemon
import com.muryno.pokemonapp.data.util.Resource
import com.muryno.pokemonapp.domain.UseCase.GetPokemonUseCase
import com.muryno.pokemonapp.utils.NetworkAvailabilityCheckUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase,
) : ViewModel() {




    val pokemonLiveData: MutableLiveData<Resource<Pokemon>> = MutableLiveData()
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.IO)




    fun getPokemonLiveData(id : Long) = coroutineScope.launch {

        pokemonLiveData.postValue(Resource.Loading())
        try {
            if (NetworkAvailabilityCheckUtils.isNetworkAvailable(App.instance?.applicationContext)) {
                val apiResult = getPokemonUseCase.execute(id);
                pokemonLiveData.postValue(apiResult)
            } else {
                pokemonLiveData.postValue(Resource.Error("Internet is not available"))
            }
        } catch (e: Exception) {
            pokemonLiveData.postValue(Resource.Error(e.message.toString()))
        }
    }



    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}





