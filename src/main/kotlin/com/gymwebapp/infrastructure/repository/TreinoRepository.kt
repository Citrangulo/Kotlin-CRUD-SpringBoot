package com.gymwebapp.infrastructure.repository

import com.gymwebapp.model.TreinoGeral
import org.springframework.data.jpa.repository.JpaRepository

interface TreinoRepository : JpaRepository <TreinoGeral, Long> {


/*    fun FindByExercice(exercicio: String): List<TreinoGeral>

    @Query("""INSERT INTO series (id, series, minrep, maxrep, peso)
              SELECT id, series, minrep, maxrep, peso
              FROM treino;""")
    fun insertSeriesAndExercicio(@Param("id")id: Long):List<TreinoGeral>

 */
}