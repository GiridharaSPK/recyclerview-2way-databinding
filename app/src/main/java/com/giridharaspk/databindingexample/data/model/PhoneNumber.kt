package com.giridharaspk.databindingexample.data.model

import java.io.Serializable

data class PhoneNumber(var countryCode: String?, var number: String?) : Serializable {
    override fun toString(): String {
        return "$countryCode $number"
    }
}