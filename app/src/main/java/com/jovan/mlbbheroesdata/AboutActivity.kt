package com.jovan.mlbbheroesdata

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "About Me"

        imageCreate()
    }

    @Suppress("DEPRECATION")
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun imageCreate() {
        val imageView: ImageView = findViewById(R.id.about_profile_photo)

        val resourceId = R.drawable.jovan
//        imageView.setImageResource(resourceId)
        Glide.with(this)
            .load(resourceId)
            .circleCrop()
            .into(imageView)
    }
}
