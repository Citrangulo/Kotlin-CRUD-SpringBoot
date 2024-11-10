package com.gymwebapp.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.Clock
import java.time.Instant



@Entity
data class TreinoAbdominal (

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    override var id: Long? = null,

    var dataTreino: Instant = Instant.now(Clock.systemUTC()),

    override val exercicio: String = "",
    override val series: String = "",
    override val minrep: String = "",
    override val maxrep: String = "",
    override val peso: String = "",
    override val tdesc: String = "",
    override val modalidade: String = "",
    override val grupomuscular: String= ""
) : TreinoBasicLayout(id, exercicio, series, minrep, maxrep, peso, tdesc, modalidade, grupomuscular) {

}