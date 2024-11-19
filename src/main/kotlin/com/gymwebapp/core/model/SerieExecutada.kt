package com.gymwebapp.core.model

import jakarta.persistence.*
import java.time.Clock
import java.time.Instant

@Entity
@Table(name = "SERIES")
data class SerieExecutada(


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    var id: Long? = null,

    var datadotreino: Instant = Instant.now(Clock.systemUTC()),
    val repfeitas: Int = 0,
    val pesodaserie: Int = 0,


    override val series: Int = 0,
    override val minrep: String = "",
    override val maxrep: String = "",
    override val peso: Int = 0,
    override val exercicio: String ="",

) : ExercicioBasicLayout(series, minrep, maxrep, peso, exercicio)