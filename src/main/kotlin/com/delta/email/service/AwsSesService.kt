package com.delta.email.service

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService
import com.amazonaws.services.simpleemail.model.SendEmailRequest
import org.springframework.beans.factory.annotation.Autowired
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.delta.email.exception.AwsSesException
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service


@Service
class AwsSesService @Autowired constructor(
    private val emailService: AmazonSimpleEmailService,
    @param:Value("patilaniruddha98@gmail.com") var sender: String
) {
    private val accessKey = "AKIAV22YJWZIJPAD72HR"
    private val secretKey = "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"
    var subject: String? = null

    /**
     * This method send email using the aws ses sdk
     *
     * @param email email
     * @param body  body
     */
    fun sendEmail(email: String?, body: String?) {
        val credentials: AWSCredentials = BasicAWSCredentials(accessKey, secretKey)
        try {

            // The time for request/response round trip to aws in milliseconds
            val requestTimeout = 3000
            val request = SendEmailRequest()
                .withDestination(
                    Destination().withToAddresses(email)
                )
                .withMessage(
                    Message()
                        .withBody(
                            Body()
                                .withText(
                                    Content()
                                        .withCharset(CHAR_SET).withData(body)
                                )
                        )
                        .withSubject(
                            Content()
                                .withCharset(CHAR_SET).withData(subject)
                        )
                )
                .withSource(sender).withSdkRequestTimeout<SendEmailRequest>(requestTimeout)
            emailService.sendEmail(request)
        } catch (e: RuntimeException) {
            //log.error("Error occurred sending email to {} ", email, e);
            throw AwsSesException("Failed to send email ", e)
        }
    }

    companion object {
        private const val CHAR_SET = "UTF-8"
    }
}
