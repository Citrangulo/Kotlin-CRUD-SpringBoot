package com.gymwebapp.repository

import com.gymwebapp.model.Treino
import com.gymwebapp.model.TreinoOmbro
import org.springframework.data.jpa.repository.JpaRepository

interface TreinoRepository : JpaRepository <Treino, Long> {

}

interface TreinoOmbroRepository : JpaRepository <TreinoOmbro, Long> {

}