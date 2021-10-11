package com.delta.email

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(info = Info(title = "Email Service", version = "1.2.32", description = "Sending Email using AWS Simple Email Service"))
class EmailApplication

fun main(args: Array<String>) {
	runApplication<EmailApplication>(*args)
}
