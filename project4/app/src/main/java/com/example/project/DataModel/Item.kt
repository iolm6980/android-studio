package com.example.project.DataModel
class Item{
    var name:String? = null
    var brand:String? = null
    var price:String? = null
    var likes:Int? = null
    lateinit var img: String
    constructor() {}
    constructor(name: String, brand:String, price:String, likes:Int, img: String) {
        this.name = name
        this.img = img
        this.brand = brand
        this.price = price
        this.likes = likes
    }
}
