package com.giridharaspk.databindingexample.data.model

import java.io.Serializable

data class Employee(
    var name: String,
    var empCode: String,
    var phoneNumbers: ArrayList<PhoneNumber>
) : Serializable {
    override fun toString(): String {
        return "name : $name\nphoneNumbers : $phoneNumbers"
    }
}