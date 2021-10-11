package com.delta.email.controller

import com.delta.email.dto.EmailRequestDto
import com.delta.email.exception.AwsSesException
import com.delta.email.service.AwsSesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RequestMapping("/api/access")
class EmailController @Autowired constructor(@field:Autowired var awsSesService: AwsSesService) {
    @PostMapping(value = ["/email"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun sendEmail(@RequestBody emailRequestDto: @Valid EmailRequestDto?): ResponseEntity<String> {
        awsSesService.sender = emailRequestDto?.from.toString()
        awsSesService.subject = emailRequestDto?.subject.toString()
        return try {
            awsSesService.sendEmail(emailRequestDto?.email.toString(), emailRequestDto?.body)
            ResponseEntity.ok("Successfully Sent Email")
        } catch (e: AwsSesException) {
            ResponseEntity.status(500).body("Error occurred while sending email $e")
        }
    }
}