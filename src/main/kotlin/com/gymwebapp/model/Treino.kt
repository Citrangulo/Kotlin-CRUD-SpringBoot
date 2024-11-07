package com.gymwebapp.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
data class Treino (

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    var id: Long? = null,

    val exercicio: String = "",
    val series: String = "",
    val minrep: String = "",
    val maxrep: String = "",
    val peso: String = "",
    val tdesc: String = "",
    val modalidade: String = "",
    val grupomuscular: String= ""
) {
}