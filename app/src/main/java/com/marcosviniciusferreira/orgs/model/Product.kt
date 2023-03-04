package com.marcosviniciusferreira.orgs.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
@Entity
data class Product(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    val name: String,
    val description: String,
    val price: BigDecimal,
    val image: String? = null
) : Parcelable
