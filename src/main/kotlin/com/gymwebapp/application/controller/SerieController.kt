package com.gymwebapp.application.controller

import com.gymwebapp.core.model.SerieExecutada
import com.gymwebapp.infrastructure.repository.SerieRepository
import com.gymwebapp.infrastructure.repository.TreinoRepository
import com.gymwebapp.model.TreinoGeral
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class SerieController(
    private val serieRepository: SerieRepository,
    private val treinoRepository: TreinoRepository) {

    @GetMapping("TreinoDisponivel")
    fun listarSerie(model: Model): String {

        val treinos = treinoRepository.findAll()
        val series = serieRepository.findAll()
        model.addAttribute("treinos", treinos)
        model.addAttribute("series", series)

        return "TreinoDisponivel"
    }

    @GetMapping("/adicionar/nava/serie/{id}")
    fun tabelaEditarExercicio(@PathVariable("id") id: Long, model: Model): String {

        val serie = serieRepository.findById(id).orElse(null)
        model.addAttribute("serie", serie)
        return "TreinoDisponivel"
    }

    @PostMapping("/adicionar/nova/serie/{id}")
    fun adicionarSerie(@PathVariable("id") id: Long,
                       serie: SerieExecutada,
                       treino: TreinoGeral,
                       ): String {

        treino.id = id
        serie.id = treino.id
        serieRepository.save(serie)
        return "TreinoDisponivel"
    }
}
