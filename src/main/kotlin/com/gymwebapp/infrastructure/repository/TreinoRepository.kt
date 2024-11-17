package com.gymwebapp.infrastructure.repository

import com.gymwebapp.model.TreinoGeral
import org.springframework.data.jpa.repository.JpaRepository

interface TreinoRepository : JpaRepository <TreinoGeral, Long> {
}