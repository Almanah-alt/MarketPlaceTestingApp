package com.example.smartplaza.adapter

import android.graphics.Paint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smartplaza.Category
import com.example.smartplaza.Product
import com.example.smartplaza.R
import com.example.smartplaza.SuperCategory
import kotlinx.android.synthetic.main.category_item.view.*

class CategoryListAdapter(
    private val itemList: List<SuperCategory> = listOf(),
    private val productList: List<Product> = listOf()
):RecyclerView.Adapter<CategoryListAdapter.BindViewHolder>()
{

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.category_item, parent, false)
            return BindViewHolder(view)
        }

        override fun getItemCount(): Int {
            return itemList.count()
        }

        @RequiresApi(Build.VERSION_CODES.O)
        override fun onBindViewHolder(holder: BindViewHolder, position: Int) {
            holder.bindHint(itemList[position])
        }

    inner class BindViewHolder(
        private val view: View
    ):RecyclerView.ViewHolder(view){
        fun bindHint(superCategory: SuperCategory){

            var newProductList = ArrayList<Product>()

            val recyclerProductListInCategory = view.findViewById<RecyclerView>(R.id.category_item_list)
            val layoutManager = LinearLayoutManager(view.context)
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL
            recyclerProductListInCategory.layoutManager = layoutManager
            recyclerProductListInCategory.itemAnimator = DefaultItemAnimator()


                for (product in productList){
                    if (superCategory.name == product.superCategory.name){
                        newProductList.add(product)
                    }
                }

            recyclerProductListInCategory.adapter = CategoryProductListAdapter(itemList = newProductList, onCLikItem =
            { item ->

            })
                view.category_title.text = superCategory.name
                view.look_all_label.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        }
    }
}