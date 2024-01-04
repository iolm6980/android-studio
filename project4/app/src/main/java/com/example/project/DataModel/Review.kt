package com.example.project.DataModel

class Review{
    var name:String? = null
    var content:String? = null

    constructor() {}
    constructor(name: String, content:String) {
        this.name = name
        this.content = content
    }
    fun toMap(): Map<String, Any> {
        val result = HashMap<String, Any>()
        result.put("name", name!!)
        result.put("content", content!!)
        return result
    }
}
