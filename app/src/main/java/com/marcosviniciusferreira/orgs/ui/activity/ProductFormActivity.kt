package com.marcosviniciusferreira.orgs.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.marcosviniciusferreira.orgs.dao.ProductsDAO
import com.marcosviniciusferreira.orgs.databinding.ActivityProductFormBinding
import com.marcosviniciusferreira.orgs.model.Product
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fieldName = binding.editProductName
        val fieldDescription = binding.editProductDescription
        val fieldPrice = binding.editProductPrice

        binding.formButtonSave.setOnClickListener {

            val name = fieldName.text.toString()
            val description = fieldDescription.text.toString()
            val price = fieldPrice.text.toString()

            if (validateFormData(name, description, price)) {
                val newProduct = Product(
                    name,
                    description,
                    BigDecimal(price)
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
        }
        return true
    }
}