package com.gymwebapp.core.ports.`in`

import com.gymwebapp.core.model.SerieExecutada
import com.gymwebapp.infrastructure.repository.SerieRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SerieService(
    private val serieRepository: SerieRepository
) {


    @Transactional
    fun novaInstanciaSerie(id: Long, pesodaserie: Int, repfeitas: Int) : SerieExecutada {
        val serieAnterior = serieRepository.findById(id).orElse(null)


        val novaSerie = SerieExecutada(
            series = serieAnterior.series,
            minrep = serieAnterior.minrep,
            maxrep = serieAnterior.maxrep,
            peso = serieAnterior.peso,
            exercicio = serieAnterior.exercicio,
            pesodaserie = pesodaserie,
            repfeitas = repfeitas
        )

        return serieRepository.save(novaSerie)
    }
}