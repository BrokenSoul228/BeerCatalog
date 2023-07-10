package com.example.beercatalog.dto

data class BeerCatalog(
    val title : String,
    val logo : Int,
    val price : String,
    val desc : String,
    var isExpandable : Boolean = false
)
