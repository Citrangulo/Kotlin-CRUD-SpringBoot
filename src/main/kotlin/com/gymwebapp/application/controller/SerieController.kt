package com.gymwebapp.application.controller

import com.gymwebapp.core.model.SerieExecutada
import com.gymwebapp.core.ports.`in`.SerieService
import com.gymwebapp.infrastructure.repository.SerieRepository
import com.gymwebapp.infrastructure.repository.TreinoRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class SerieController(
    private val serieRepository: SerieRepository,
    private val treinoRepository: TreinoRepository,
    private val serieService: SerieService
) {

    @GetMapping("TreinoDisponivel")
    fun listarSerie(model: Model): String {

        /*Dar uma maneira que faça os campos do treino fiquem fixos as series nessa página
        Tem que dar um SELECT exercicio, maxrep, minrep, tdesc para cada exercicio e deixar eles
        com as séries atachadas para cada vez que forem executada para determinado exercicio.
        * */

        val treinos = treinoRepository.findAll()
        val series = serieRepository.findAll()
        model.addAttribute("treinos", treinos)
        model.addAttribute("series", series)

        return "TreinoDisponivel"
    }

    @GetMapping("/adicionar/serie/{id}") // lista as series existente e permite add nova instancia
    fun tabelaAdicionarSerie(
        @PathVariable("id") id: Long,
        model: Model, serie: SerieExecutada): String {

        val serie = serieRepository.findById(id).orElse(null)
        model.addAttribute("serie", serie)
        return "AdicionarSerie"
    }

    @PostMapping("/adicionar/{id}")
    fun adicionarSerie(
        @PathVariable("id") id: Long, repfeitas: Int, pesodaserie: Int,
        serie: SerieExecutada,
        novaSerie: SerieExecutada
    ): String {

        serieService.novaInstanciaSerie(id ,pesodaserie, repfeitas)
        return "redirect:/TreinoDisponivel"
    }

}
