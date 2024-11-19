package com.gymwebapp.core.model


// Classe Exercicio herdando de Serie
open class ExercicioBasicLayout(

    override val series: Int = 0,
    override val minrep: String = "",
    override val maxrep: String = "",
    override val peso: Int = 0,

    open val exercicio: String = "",
    open val tdesc: String = "",
    open val modalidade: String = "",
    open val grupomuscular: String = "",
    open var idExercicio: Long? = null
) : SerieBasicLayout(series, minrep, maxrep, peso)