package com.example.smartplaza.network

import android.util.Log
import com.example.smartplaza.ProductList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataLoaderByTitle (
    private val onSuccess: (ProductList) -> Unit,
    private val onError: (Throwable) -> Unit,
    private val search: String
){

    fun loadDataByTitle(){
        ApiFactory.getApiService()
            .getProductByTitle(search)
            .enqueue(object : Callback<ProductList> {
                override fun onResponse(
                    call: Call<ProductList>,
                    response: Response<ProductList>
                ) {
                    if (response.isSuccessful){
                        Log.d("raaaaag", response.body().toString())
                        onSuccess(response.body()!!)
                    }
                    else{
                        Log.d("hhhhhhh", "${response}")
                    }

                }

                override fun onFailure(call: Call<ProductList>, t: Throwable) {
                    Log.d("taaaaaaaaaag", t.message.toString())
                    onError(t)
                }
            })
    }

}