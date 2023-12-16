package com.example.nearbyapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.repos.RetrofitModule
import com.example.nearbyapp.database.NearbyDatabaseReo
import com.example.nearbyapp.database.NearbyDatabaseRepo
import com.example.nearbyapp.models.LocationDataModel
import com.example.nearbyapp.models.Venues
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NearbyViewModel(application: Application) : AndroidViewModel(application) {
    private val apiInterface = RetrofitModule.getApi()
    val venueLiveData: MutableLiveData<List<Venues>>
        get() = _venueLiveData
    private val _venueLiveData = MutableLiveData<List<Venues>>()

    fun fetchNearbyVenues(lat:String,long:String,dist : String){
        CoroutineScope(Dispatchers.IO).launch {
            val localData = getDataFromDb()
            if (localData.isNotEmpty()) {
                _venueLiveData.postValue(localData)
            }
        }
        apiInterface.fetchLocation(1,lat,long,dist).enqueue(object : Callback<LocationDataModel> {
            override fun onResponse(
                call: Call<LocationDataModel>,
                response: Response<LocationDataModel>
            ) {
                if(response.isSuccessful){
                    response.body()?.venues?.let {
                        _venueLiveData.postValue(it)
                        saveDataLocally(it)
                    }
                }
            }

            override fun onFailure(call: Call<LocationDataModel>, t: Throwable) {
                t.printStackTrace()
                CoroutineScope(Dispatchers.IO).launch {
                    val localData = getDataFromDb()
                    if (localData.isNotEmpty()) {
                        _venueLiveData.postValue(localData)
                    }
                }
            }

        })
    }

    private fun saveDataLocally(data: List<Venues>) {
        CoroutineScope(Dispatchers.IO).launch {
            NearbyDatabaseRepo.addNearbyRepos(getApplication<Application>(), data)
        }
    }

    private suspend fun getDataFromDb(): List<Venues> {
        return withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
            NearbyDatabaseRepo.getNearbyRepos(getApplication<Application>())
        }
    }

   /* fun fetchMoreVenues(position: Int,lat:String,long:String,dist : String){
        apiInterface.fetchLocation(position,lat,long,dist).enqueue(object : Callback<LocationDataModel> {
            override fun onResponse(
                call: Call<LocationDataModel>,
                response: Response<LocationDataModel>
            ) {
                if(response.isSuccessful){
                    _venueLiveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LocationDataModel>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }*/
}