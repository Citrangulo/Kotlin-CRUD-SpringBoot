package com.gymwebapp.model

import jakarta.persistence.Entity

@Entity
data class Treino (

    val exercicio: String = "",
    val series: String = "",
    val minrep: String = "",
    val maxrep: String = "",
    val peso: String = "",
    val tdesc: String = "",
    val modalidade: String = "",
    val grupomuscular: String = ""
) {
}