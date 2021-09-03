package com.muryno.pokemonapp.utils

import com.muryno.pokemonapp.data.model.Pokemon
import com.muryno.pokemonapp.data.util.Resource
import retrofit2.Response

class ResponseToResourceUtils {
    companion object {
        internal fun responseToResource(
            response: Response<Pokemon>?,
            exception: Exception?
        ): Resource<Pokemon> {
            if (response != null && response.isSuccessful) {

                response.body()?.let { result ->
                    return Resource.Success(result)
                }
            }
            if (exception?.message != null) {
                return Resource.Error(exception.message!!)
            }
            return Resource.Error(response?.message().toString())
        }
    }
}