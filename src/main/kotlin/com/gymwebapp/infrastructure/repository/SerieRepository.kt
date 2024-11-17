package com.gymwebapp.infrastructure.repository

import com.gymwebapp.core.model.SerieExecutada
import org.springframework.data.jpa.repository.JpaRepository

interface SerieRepository : JpaRepository <SerieExecutada, Long> {
}