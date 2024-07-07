package tech.felipe.gadelha.safepass.api.v1.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import tech.felipe.gadelha.safepass.api.dto.request.PassRq
import tech.felipe.gadelha.safepass.api.dto.response.FailureRs
import tech.felipe.gadelha.safepass.domain.service.PassService

@RestController
class ValidatePassController(
    private val passService: PassService
) {
    companion object{
        private val logger: Logger = LoggerFactory.getLogger(ValidatePassController::class.java)
    }

    @PostMapping("validate-password")
    fun validatePass(@RequestBody request: PassRq): ResponseEntity<FailureRs> {
        logger.info("method::validatePass init")
        val failures = passService.validatePass(request.pass)
        if (failures.isEmpty()) {
            return ResponseEntity.noContent().build()
        }
        return ResponseEntity
            .badRequest()
            .body(FailureRs(failures))
    }
}