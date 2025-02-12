package com.ubaya.adv160421055_week6.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.adv160421055_week6.model.motorcycle

class motorcycleViewModel (application: Application): AndroidViewModel(application)
{
    val motorcycleLD = MutableLiveData<ArrayList<motorcycle>>()
    val motorcycleLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        loadingLD.value = true
        motorcycleLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/motorcycle/motorcycle.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<motorcycle>>() {}.type
                val result = Gson().fromJson<List<motorcycle>>(it, sType)
                motorcycleLD.value = result as ArrayList<motorcycle>?
                loadingLD.value = false

                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                motorcycleLoadErrorLD.value = false
                loadingLD.value = false
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}