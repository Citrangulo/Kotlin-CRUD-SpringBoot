package com.gymwebapp.application.controller


import com.gymwebapp.core.model.*
import com.gymwebapp.infrastructure.repository.*
import com.gymwebapp.model.TreinoGeral
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping


@Controller
class TreinoController(
    private val treinoRepository: TreinoRepository,
    private val serieRepository: SerieRepository,
) {

    //chama a pagina inicial
    @GetMapping("/home")
    fun home(): String {
        return "home"
    }

    //Cadastra novo exercicio no treino e as series, atreladas ao novo treino
    @GetMapping("/Cadastro/Treino")
    fun fazerCadastroNovoExercicio(model: Model, treinoGeral: TreinoGeral, serieExecutada: SerieExecutada): String {

        model.addAttribute("treino", treinoGeral)
        model.addAttribute("serie", serieExecutada)
        return "CadastroTreino"
    }

    //Cadastra novo exercicio no treino e as series, atreladas ao novo treino
    @PostMapping("/cadastrar") // Salva os treinos no Banco
    fun cadastrarExercicio(@PathVariable("id") id: Long?, treino: TreinoGeral, serie: SerieExecutada): String {

        treino.id = id
        serie.id = treino.id
        treinoRepository.save(treino)
        serieRepository.save(serie)

        return "redirect:/TreinoCadastrado"

    }

    @GetMapping("/TreinoCadastrado") // Select os treinos do Banco
    fun listaTreino(model: Model): String {

        val treinos = treinoRepository.findAll()
        model.addAttribute("treinos", treinos)
        return "TreinoCadastrado"
    }

    @GetMapping("/treino/edicao/{id}")
    fun tabelaEditarExercicio(@PathVariable("id") id: Long, model: Model): String {

        val treino = treinoRepository.findById(id).orElse(null)
        model.addAttribute("treino", treino)
        return "EdicaoTreino"
    }

    @PostMapping("/editar/{id}")
    fun editarTreino(
        @PathVariable("id") id: Long,
        treino: TreinoGeral
    ): String {

        treino.id = id
        treinoRepository.save(treino)
        return "redirect:/TreinoCadastrado"
    }

    @GetMapping("/excluir/{id}")
    fun excluirExercicio(@PathVariable("id") id: Long, treino: TreinoGeral): String {

        treinoRepository.deleteById(id)
        return "redirect:/TreinoCadastrado"
    }
}