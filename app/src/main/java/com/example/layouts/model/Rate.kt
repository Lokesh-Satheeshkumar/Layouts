package com.example.layouts.model

data class Rate(
    val discount: Int?,
    val effectiveDate: String?,
    val id: String?,
    val localDiscount: Int?,
    val localPrice: Int?,
    val notes: String?,
    val price: Double?,
    val roomId: String?
)