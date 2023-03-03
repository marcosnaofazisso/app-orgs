package com.marcosviniciusferreira.orgs.ui.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.marcosviniciusferreira.orgs.R
import com.marcosviniciusferreira.orgs.databinding.ActivityProductDetailsBinding
import com.marcosviniciusferreira.orgs.extensions.tryLoadImage
import com.marcosviniciusferreira.orgs.model.Product
import com.marcosviniciusferreira.orgs.ui.helper.KEY_PRODUCT

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadProducts()
    }

    private fun loadProducts() {

        val loadedProduct =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) (intent.getParcelableExtra(
                KEY_PRODUCT,
                Product::class.java
            ))!!
            else (intent.getParcelableExtra<Product>(KEY_PRODUCT)!!)

        fillDetailsField(loadedProduct)

    }

    private fun fillDetailsField(loadedProduct: Product) {

        binding.imageProductDetail.tryLoadImage(loadedProduct.image)
        binding.textProductDetailPrice.text = "R$ " + loadedProduct.price.toPlainString()
        binding.textProductDetailName.text = loadedProduct.name
        binding.textProductDetailDescription.text = loadedProduct.description


    }

}