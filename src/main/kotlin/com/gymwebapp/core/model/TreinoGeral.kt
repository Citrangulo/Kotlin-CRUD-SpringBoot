package com.gymwebapp.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.Clock
import java.time.Instant


@Entity
data class TreinoGeral (

    var data: Instant = Instant.now(Clock.systemUTC()),

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    override var id: Long? = null,
    override val exercicio: String = "",
    override val series: Int = 0,
    override val minrep: String = "",
    override val maxrep: String = "",
    override val peso: Int = 0,
    override val tdesc: String = "",
    override val modalidade: String = "",
    override val grupomuscular: String= "",

) : TreinoBasicLayout(id)