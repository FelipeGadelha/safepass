package tech.felipe.gadelha.safepass.domain.service

import org.springframework.stereotype.Service
import java.util.regex.Pattern

@Service
class PassService {

    fun validatePass(pass: String): List<String> {
        val failures = ArrayList<String>()
        validateLength(pass, failures)
        validateUppercase(pass, failures)
        validateLowercase(pass, failures)
        validateNumber(pass, failures)
        validateSpecialCharacter(pass, failures)
        return failures
    }

    private fun validateLength(pass: String, failures: ArrayList<String>) {
        if (pass.length < 8) {
            failures.add("A senha deve possuir pelo menos 8 caracteres.")
        }
    }
    private fun validateUppercase(pass: String, failures: ArrayList<String>) {
        if (!Pattern.matches("^.*[A-Z].*\$", pass)) {
            failures.add("A senha deve possuir pelo menos 1 letra maiúscula.")
        }
    }
    private fun validateLowercase(pass: String, failures: ArrayList<String>) {
        if (!Pattern.matches("^.*[a-z].*\$", pass)) {
            failures.add("A senha deve possuir pelo menos 1 letra minúscula.")
        }
    }
    private fun validateNumber(pass: String, failures: ArrayList<String>) {
        if (!Pattern.matches("^.*[0-9].*\$", pass)) {
            failures.add("A senha deve possuir pelo menos 1 dígito numérico.")
        }
    }
    private fun validateSpecialCharacter(pass: String, failures: ArrayList<String>) {
        if (!Pattern.matches("^.*\\W.*\$", pass)) {
            failures.add("A senha deve possuir pelo menos 1 caracter especial (e.g !@#$%).")
        }
    }
}