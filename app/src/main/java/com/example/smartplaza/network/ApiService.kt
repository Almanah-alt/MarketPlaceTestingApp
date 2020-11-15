package com.example.smartplaza.network

import com.example.smartplaza.ProductList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("mp/products/products?highCost=2000&sortName=costAscend&lowCost=100&pageSize=12&pageNumber=1")
    fun getProductByCustomFilter(): Call<ProductList>

    @GET("mp/products/products?highCost=2000&sortName=costAscend&lowCost=100&pageSize=12&pageNumber=1")
    fun getProductByTitle(@Query("search") title: String): Call<ProductList>
}
