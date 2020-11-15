package com.example.smartplaza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_full_screen_image.*

class FullScreenImageActivity : AppCompatActivity() {

    companion object{
        const val IMAGE_URL = "imageUrl"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_image)

        val photo1 = intent.getStringExtra(IMAGE_URL)

        Picasso
            .get()
            .load(photo1)
            .into(product_full_image)


    }
}