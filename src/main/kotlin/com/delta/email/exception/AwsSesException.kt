package com.delta.email.exception

class AwsSesException
    (errorMessage: String?, throwable: Throwable?) : RuntimeException(errorMessage, throwable)