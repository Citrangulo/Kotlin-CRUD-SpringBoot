package com.gymwebapp.application.controller.requests

data class CreateWorkoutRequest(
    val workouName: String,
    val exercicios: List <ExercicioRequest>
) {
    data class ExercicioRequest(

        val id: Long,
        val series: Int = 0,
        val minrep: String = "",
        val maxrep: String = "",
        val tdesc: String = ""

    )
}