package com.example.myapplication

class Manager {
    var id: Int = 0
    var gender: String = ""
    var age: Int = 0
    var education: String = ""
    var post: String = ""
    var wages: Int = 0
    var experience: Int = 0

    constructor(gender: String, age: Int, education: String, post: String, wages: Int, experience: Int){
        this.gender = gender
        this.age = age
        this.education = education
        this.post = post
        this.wages = wages
        this.experience = experience
    }

}