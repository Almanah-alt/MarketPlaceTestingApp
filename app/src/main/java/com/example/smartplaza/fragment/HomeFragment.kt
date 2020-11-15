package com.example.smartplaza.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smartplaza.Category
import com.example.smartplaza.ProductList
import com.example.smartplaza.R
import com.example.smartplaza.SuperCategory
import com.example.smartplaza.adapter.CategoryListAdapter
import com.example.smartplaza.network.DataLoader
import com.example.smartplaza.network.DataLoaderByTitle

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        DataLoader(
            onSuccess = { response ->
                showAllProducts(view, response)
                Log.d("taaaaaag", response.toString())
            },
            onError = {
                Log.d("taaag", it.message.toString())
            }
        ).loadData()

        find(view)
        super.onViewCreated(view, savedInstanceState)
    }

    private fun find(view: View){
        val search = view.findViewById<SearchView>(R.id.product_search)
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                loadProductByTitle(view, query)
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                loadProductByTitle(view, newText)
                return false
            }
        })
    }

    private fun loadProductByTitle(view: View, title: String){
        DataLoaderByTitle(
            onSuccess = { response ->
                showAllProducts(view, response)

            },
            onError = {
                Log.d("taaag", it.message.toString())
            },
            search = title
        ).loadDataByTitle()
    }


    private fun showAllProducts(view: View, productList: ProductList){

        var superCategoryList = ArrayList<SuperCategory>()

        for (i in productList.productResponses){
            if (i.category.name != null){
                superCategoryList.add(i.superCategory)
            }
        }

        val recyclerProductList = view.findViewById<RecyclerView>(R.id.category_list)
        recyclerProductList.layoutManager = LinearLayoutManager(activity)

        recyclerProductList.adapter = CategoryListAdapter(itemList = superCategoryList.distinct(),productList = productList.productResponses)

    }


}