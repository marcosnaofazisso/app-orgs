package com.marcosviniciusferreira.orgs.database.converter

import androidx.room.TypeConverter
import java.math.BigDecimal

class Converters {

    @TypeConverter
    fun fromDouble(value: Double?): BigDecimal {
        return value?.let {
            BigDecimal(value.toString())
        }
            ?: BigDecimal.ZERO

    }
    
    @TypeConverter
    fun bigDecimalToDouble(value: BigDecimal?): Double? {
        return value?.let {
            value.toDouble()
        }
    }

}