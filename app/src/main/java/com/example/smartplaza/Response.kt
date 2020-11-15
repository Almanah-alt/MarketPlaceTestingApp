package com.example.smartplaza

data class SuperCategory(
    var id: Int,
    var name : String
)

data class Category(
    var id: Int,
    var name : String
)

data class Product(
    var photo_1: String,
    var price: Float,
    var name: String,
    var superCategory: SuperCategory,
    var category: Category
)

data class ProductList(
    var productResponses: List<Product>
)