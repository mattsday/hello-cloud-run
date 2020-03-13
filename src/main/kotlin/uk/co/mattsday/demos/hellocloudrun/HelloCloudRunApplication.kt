package uk.co.mattsday.demos.hellocloudrun

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class HelloCloudRunApplication

fun main(args: Array<String>) {
	runApplication<HelloCloudRunApplication>(*args)
}

@RestController
class demo {
	@GetMapping("hello")
	fun hello() : List<String> {
		return listOf("hello", "cloud", "run")
	}
}