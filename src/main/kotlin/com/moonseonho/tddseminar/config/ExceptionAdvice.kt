package com.moonseonho.tddseminar.config

import com.moonseonho.tddseminar.common.dto.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.RuntimeException

@RestControllerAdvice
class ExceptionAdvice {

    @ExceptionHandler
    fun handleException(runtimeException: RuntimeException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.badRequest().body(ErrorResponse(runtimeException.message ?: "알 수 없는 에러가 발생했습니다."))
    }
}