package com.marcosviniciusferreira.orgs.dao

import com.marcosviniciusferreira.orgs.model.Product

class ProductsDAO {

    fun add(product: Product) {
        products.add(product)
    }

    fun searchAll(): List<Product> {
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Product>()
    }
}