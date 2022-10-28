package com.sorabh.grabfood.util

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "QNA_TABLE")
data class QNAData(
    @PrimaryKey
    val sno: Int,
    val question: String,
    val answer: String
)
