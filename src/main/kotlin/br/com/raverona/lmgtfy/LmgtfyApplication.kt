package br.com.raverona.lmgtfy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LmgtfyApplication

fun main(args: Array<String>) {
	runApplication<LmgtfyApplication>(*args)
}