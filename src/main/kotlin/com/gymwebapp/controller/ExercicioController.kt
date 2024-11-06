package com.gymwebapp.controller

import com.gymwebapp.model.Treino
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping


@Controller
class ExercicioController {

    @GetMapping("/Cadastro/Treino")
    fun fazerCadastroNovoExercicio(model: Model) : String{

        val treino = Treino()

        model.addAttribute("treino", treino)

        return "CadastroTreino"
    }

    @PostMapping("/cadastrar")
    fun cadastrarExercicio(treino: Treino): String{

        println(treino)

        return "Inicial"

    }
}