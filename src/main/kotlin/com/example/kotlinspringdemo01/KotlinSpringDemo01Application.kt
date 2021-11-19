package com.example.kotlinspringdemo01

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*

val animais = mutableListOf<Animal>()

@SpringBootApplication
class KotlinSpringDemo01Application

fun main(args: Array<String>) {
	//animais.add(Animal("Rex", Especie.CACHORRO, 10.5))
	runApplication<KotlinSpringDemo01Application>(*args)
}
 @RestController
 @RequestMapping("hello")
class HelloWorld {

	 @GetMapping
	fun hello(): String {
		return "Hello World"
	}

	 @GetMapping("2")
    fun helloWorld2(): String {
        return "Olá mundo 2"

	}

}
enum class Especie{ CACHORRO, GATO, PASSARO }

data class  Animal(val nome: String, val especie: Especie, val peso: Double)


@RestController
@RequestMapping("animais")
class animalcontroller {

	@GetMapping
	fun index() = animais

	@PostMapping
	fun create(@RequestBody animal: Animal): Animal  {
		animais.add(animal)
		return animal


	}
}