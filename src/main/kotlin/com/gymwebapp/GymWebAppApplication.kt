package com.gymwebapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GymWebAppApplication

fun main(args: Array<String>) {
	runApplication<GymWebAppApplication>(*args)
}
