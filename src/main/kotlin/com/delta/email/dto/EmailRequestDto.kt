package com.delta.email.dto

import javax.validation.constraints.Email

class EmailRequestDto {
    var otp = 0
    var from: String? = null
    var subject: String? = null

    @Email(message = "Invalid Email address")
    var email: String? = null
    var body: String? = null
}
