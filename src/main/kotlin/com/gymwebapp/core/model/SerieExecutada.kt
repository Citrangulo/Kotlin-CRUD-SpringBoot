package com.gymwebapp.core.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.Clock
import java.time.Instant

@Entity
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
    override val peso: Int = 0

) : SerieBasicLayout(series, minrep, maxrep, peso)