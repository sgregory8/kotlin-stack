package com.gregory.learning.kotlinwebserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinWebServerApplication

fun main(args: Array<String>) {
	runApplication<KotlinWebServerApplication>(*args)
}