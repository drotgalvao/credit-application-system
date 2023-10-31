package me.dio.credit.application.system.exception

import java.time.LocalDateTime
import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidException(
            ex: MethodArgumentNotValidException
    ): ResponseEntity<ExceptionDetails> {
        val errors = mutableMapOf<String, String?>()
        ex.bindingResult.allErrors.stream().forEach { error: ObjectError ->
            val fieldName: String = (error as FieldError).field
            val messageError: String? = error.defaultMessage
            errors[fieldName] = messageError
        }
        return ResponseEntity(
                ExceptionDetails(
                        title = "Bad Request! Consult the documentation",
                        timestamp = LocalDateTime.now(),
                        status = HttpStatus.BAD_REQUEST.value(),
                        exception = ex.javaClass.toString(), // objectName para ver o arquivo
                        details = errors
                ),
                HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(DataAccessException::class)
    fun handleValidException(ex: DataAccessException): ResponseEntity<ExceptionDetails> {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(
                        ExceptionDetails(
                                title = "Conflict! Consult the documentation",
                                timestamp = LocalDateTime.now(),
                                status = HttpStatus.CONFLICT.value(),
                                exception = ex.javaClass.toString(), // objectName para ver o arquivo
                                details = mutableMapOf(ex.cause.toString() to ex.message)
                        )
                )
    }

    @ExceptionHandler(BusinessException::class)
    fun handleValidException(ex: BusinessException): ResponseEntity<ExceptionDetails> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        ExceptionDetails(
                                title = "Bad Request! Consult the documentation",
                                timestamp = LocalDateTime.now(),
                                status = HttpStatus.BAD_REQUEST.value(),
                                exception = ex.javaClass.toString(), // objectName para ver o arquivo
                                details = mutableMapOf(ex.cause.toString() to ex.message)
                        )
                )
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleValidException(ex: IllegalArgumentException): ResponseEntity<ExceptionDetails> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        ExceptionDetails(
                                title = "Bad Request! Consult the documentation",
                                timestamp = LocalDateTime.now(),
                                status = HttpStatus.BAD_REQUEST.value(),
                                exception = ex.javaClass.toString(), // objectName para ver o arquivo
                                details = mutableMapOf(ex.cause.toString() to ex.message)
                        )
                )
    }
}
