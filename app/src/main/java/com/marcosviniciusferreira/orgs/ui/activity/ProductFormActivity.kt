package com.marcosviniciusferreira.orgs.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.marcosviniciusferreira.orgs.R
import com.marcosviniciusferreira.orgs.dao.ProductsDAO
import com.marcosviniciusferreira.orgs.databinding.ActivityMainBinding
import com.marcosviniciusferreira.orgs.databinding.ActivityProductFormBinding
import com.marcosviniciusferreira.orgs.model.Product
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fieldName = binding.editProductName.text.toString()
        val fieldDescription = binding.editProductDescription.text.toString()
        val fieldPrice = binding.editProductPrice.text.toString()

        binding.formButtonSave.setOnClickListener {
            if (validateFormData(fieldName, fieldDescription, fieldPrice)) {
                val newProduct = Product(
                    fieldName,
                    fieldDescription,
                    BigDecimal(fieldPrice)
                )

                ProductsDAO().add(newProduct)
                finish()

            }

        }


    }

    private fun validateFormData(name: String, description: String, price: String): Boolean {
        if (name.isBlank()) {
            Toast.makeText(this, "Product name must be informed!", Toast.LENGTH_SHORT).show()
            return false
        }
        if (description.isBlank()) {
            Toast.makeText(this, "Product description must be informed!", Toast.LENGTH_SHORT).show()
            return false
        }

        if (price.isBlank()) {
            Toast.makeText(this, "Product price must be informed!", Toast.LENGTH_SHORT).show()
            return false
        } else {
            BigDecimal(price)
            return true
        }
    }
}