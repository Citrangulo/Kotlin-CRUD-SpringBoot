package com.gymwebapp.model

//import jakarta.persistence.Entity
//import jakarta.persistence.GeneratedValue
//import jakarta.persistence.GenerationType
//import jakarta.persistence.Id
//import java.time.Clock
//import java.time.Instant


open class TreinoBasicLayout (

    open var id: Long? = null,

    open val exercicio: String = "",
    open val series: String = "",
    open val minrep: String = "",
    open val maxrep: String = "",
    open val peso: String = "",
    open val tdesc: String = "",
    open val modalidade: String = "",
    open val grupomuscular: String= ""
) {

}