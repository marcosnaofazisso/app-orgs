package com.marcosviniciusferreira.orgs.dao

import com.marcosviniciusferreira.orgs.model.Product

class ProductsDAO {

    companion object {
        private val products = mutableListOf<Product>()
    }

    fun add(product: Product) {
        products.add(product)
    }

    fun searchAll(): List<Product> {
        return products.toList()
    }

}