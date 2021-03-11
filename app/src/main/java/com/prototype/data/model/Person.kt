package com.prototype.data.model

import java.io.Serializable

data class Person(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val birthday: String,
    var age: String?,
    val mobileNumber: String,
    val address: String,
    val contactPerson: String,
    val contactPersonNumber: String
) : Serializable