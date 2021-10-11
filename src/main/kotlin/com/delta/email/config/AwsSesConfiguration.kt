package com.delta.email.config

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AwsSesConfiguration(@param:Value("ap-south-1") private val region: String) {
    @Bean
    fun amazonSimpleEmailService(): AmazonSimpleEmailService {
        return AmazonSimpleEmailServiceClientBuilder.standard()
            .withRegion(region).build()
    }
}
