package uk.co.mattsday.demos.hellocloudrun

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable

@SpringBootApplication
class HelloCloudRunApplication

fun main(args: Array<String>) {
	runApplication<HelloCloudRunApplication>(*args)
}

// Keeping it all in one file
@RestController
class Demo {
	// Listen on /hello and /
	@GetMapping(value = ["hello", "/"])
	fun hello() : List<String> {
		return listOf("hello", "cloud", "run")
	}

	@GetMapping("hello/{name}")
	fun helloYou(@PathVariable("name") name :String) : List<String> {
		return listOf("hello", name)
	}
}