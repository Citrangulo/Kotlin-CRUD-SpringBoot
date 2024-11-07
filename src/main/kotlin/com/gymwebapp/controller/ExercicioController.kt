package com.gymwebapp.controller

import com.gymwebapp.model.Treino
import com.gymwebapp.repository.TreinoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping


@Controller
class ExercicioController {

    @Autowired
    lateinit var treinoRepository: TreinoRepository

    @GetMapping("/Cadastro/Treino")
    fun fazerCadastroNovoExercicio(model: Model) : String{


        
        var treino = Treino()

        model.addAttribute("treino", treino)

        return "CadastroTreino"
    }

    @PostMapping("/cadastrar") // Salva os treinos no Banco
    fun cadastrarExercicio(treino: Treino): String{

        println(treino)
        treinoRepository.save(treino)

        return "redirect:/TreinoCadastrado"

    }

    @GetMapping("/TreinoCadastrado") // Select os treinos do Banco
    fun listaTreino(model: Model): String{

        val treinos = treinoRepository.findAll()

        model.addAttribute("treinos", treinos)

        return "Inicial"

    }

    @GetMapping("/treino/edicao/{id}")
    fun tablelaEditarExercicio(@PathVariable("id") id:Long, model: Model) : String{

        var treino = treinoRepository.findById(id).orElse(null)

        model.addAttribute("treino", treino)

        return "EdicaoTreino"
    }

    @PostMapping("/editar/{id}")
    fun editarTreino(@PathVariable("id") id: Long, treino: Treino): String {

        treino.id = id

        treinoRepository.save(treino)

        return "redirect:/TreinoCadastrado"
    }

    @GetMapping("/excluir/{id}")
    fun excluirExercicio(@PathVariable("id") id: Long) : String{

        treinoRepository.deleteById(id)

        return "redirect:/TreinoCadastrado"
    }


}