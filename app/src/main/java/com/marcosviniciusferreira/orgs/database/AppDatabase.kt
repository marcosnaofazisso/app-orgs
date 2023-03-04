package com.marcosviniciusferreira.orgs.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.marcosviniciusferreira.orgs.database.dao.ProductDAO
import com.marcosviniciusferreira.orgs.model.Product

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDAO


}