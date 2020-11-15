package com.example.smartplaza.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.smartplaza.FullScreenImageActivity
import com.example.smartplaza.Product
import com.example.smartplaza.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.category_product_item.view.*


class CategoryProductListAdapter(
    private val itemList: List<Product> = listOf(),
    private val onCLikItem:(Product)  -> Unit
):RecyclerView.Adapter<CategoryProductListAdapter.BindViewHolder>()
{

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.category_product_item, parent, false)
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
        @SuppressLint("SetTextI18n")
        fun bindHint(product: Product){

            view.product_title.text = product.name
            val photoUrl = "https://api.smartplaza.kz/mp/products/photos/${product.photo_1}"
            Picasso
                .get()
                .load(photoUrl)
                .into(view.product_img)

            view.product_price.text = "${product.price.toInt()} тг"
            view.product_img.setOnClickListener(View.OnClickListener {
                val intent = Intent(view.context, FullScreenImageActivity::class.java)
                intent.putExtra(FullScreenImageActivity.IMAGE_URL, photoUrl)
                view.context.startActivity(intent)
            })
            view.setOnClickListener {
                onCLikItem(product)
            }


        }
    }
}