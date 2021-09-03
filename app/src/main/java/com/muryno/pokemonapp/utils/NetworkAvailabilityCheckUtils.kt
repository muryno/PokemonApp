package com.muryno.pokemonapp.utils

import android.content.Context
import android.net.ConnectivityManager


class NetworkAvailabilityCheckUtils {
    companion object {
        internal fun isNetworkAvailable(context: Context?): Boolean {
            if (context == null) return false
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
            return false

        }
    }

}