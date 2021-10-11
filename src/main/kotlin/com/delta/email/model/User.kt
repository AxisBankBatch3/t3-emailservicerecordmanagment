package com.delta.email.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document



@Document(collection = "user")
class User {

    @Id
     lateinit var id: String

    lateinit var fullName: String

    lateinit var organization: String

    lateinit var username: String

    lateinit var mobile: String

    lateinit var password: String

    lateinit var role: String

    constructor(){
    }

    constructor(
        id: String, fullName: String, organization: String, username: String, mobile: String, password: String,
        role: String
    ) {

        this.id = id
        this.fullName = fullName
        this.organization = organization
        this.username = username
        this.mobile = mobile
        this.password = password
        this.role = role
    }
}