package com.gymwebapp.repository

import com.gymwebapp.model.*
import org.springframework.data.jpa.repository.JpaRepository

interface TreinoRepository : JpaRepository <TreinoGeral, Long> {

}

interface TreinoOmbroRepository : JpaRepository <TreinoOmbro, Long> {

}

interface TreinoPeitoRepository : JpaRepository <TreinoPeito, Long> {

}

interface TreinoCostasRepository : JpaRepository <TreinoCostas, Long> {

}

interface TreinoBracosRepository : JpaRepository <TreinoBracos, Long> {

}

interface TreinoAbdominalRepository : JpaRepository <TreinoAbdominal, Long> {

}

interface TreinoQuadsRepository : JpaRepository <TreinoQuads, Long> {

}

interface TreinoPosteriorRepository : JpaRepository <TreinoPosterior, Long> {

}