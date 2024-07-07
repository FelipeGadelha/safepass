package tech.felipe.gadelha.safepass

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SafepassApplication

fun main(args: Array<String>) {
	runApplication<SafepassApplication>(*args)
}
