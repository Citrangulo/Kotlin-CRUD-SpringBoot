package com.gymwebapp.model

import com.gymwebapp.core.model.ExercicioBasicLayout


open class TreinoBasicLayout(

    open var id: Long? = null,

    override val exercicio: String = "",
    override val tdesc: String = "",
    override val modalidade: String = "",
    override val grupomuscular: String= ""

): ExercicioBasicLayout(exercicio, tdesc, modalidade, grupomuscular)

