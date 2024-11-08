package com.gymwebapp.repository

import com.gymwebapp.model.Treino
import org.springframework.data.jpa.repository.JpaRepository

interface TreinoRepository : JpaRepository <Treino, Long> {

}

interface TreinoOmbroRepository : JpaRepository <Treino.treinoOmbro, Long> {

}