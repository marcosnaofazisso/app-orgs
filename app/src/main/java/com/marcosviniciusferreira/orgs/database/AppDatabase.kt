package com.marcosviniciusferreira.orgs.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.marcosviniciusferreira.orgs.database.converter.Converters
import com.marcosviniciusferreira.orgs.database.dao.ProductDAO
import com.marcosviniciusferreira.orgs.model.Product

@Database(entities = [Product::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDAO


}