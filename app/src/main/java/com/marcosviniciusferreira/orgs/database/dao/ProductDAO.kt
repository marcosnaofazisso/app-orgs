package com.marcosviniciusferreira.orgs.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.marcosviniciusferreira.orgs.model.Product

@Dao
interface ProductDAO {

    @Query("SELECT * FROM Product")
    fun searchAll(): List<Product>

    @Insert
    fun save(product: Product)

}