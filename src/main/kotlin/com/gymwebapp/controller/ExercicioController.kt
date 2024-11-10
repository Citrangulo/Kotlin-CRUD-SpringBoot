package com.gymwebapp.controller


import com.gymwebapp.model.*
import com.gymwebapp.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping


@Controller
class ExercicioController(
    private val treinoRepository: TreinoRepository,
    private val ombroRepository: TreinoOmbroRepository,
    private val peitoRepository: TreinoPeitoRepository,
    private val costasRepository: TreinoCostasRepository,
    private val bracosRepository: TreinoBracosRepository,
    private val quadsRepository: TreinoQuadsRepository,
    private val posteriorRepository: TreinoPosteriorRepository,
    private val abdominalRepository: TreinoAbdominalRepository) {


    @GetMapping("/Cadastro/Treino")
    fun fazerCadastroNovoExercicio(model: Model) : String{

        
        var treino = TreinoGeral()

        var treinoOmbro = TreinoOmbro()

        var treinoCostas = TreinoCostas()

        var treinoPeito = TreinoPeito()

        var treinoBracos = TreinoBracos()

        var treinoQuads = TreinoQuads()

        var treinoPosterior = TreinoPosterior()

        var treinoAbdominal = TreinoAbdominal()

        model.addAttribute("treino", treino)
        model.addAttribute("treinoOmbro", treinoOmbro)
        model.addAttribute("treinopeito", treinoPeito)
        model.addAttribute("treinoCostas", treinoCostas)
        model.addAttribute("treinoBraco", treinoBracos)
        model.addAttribute("treinoQuads", treinoQuads)
        model.addAttribute("treinoPosterior", treinoPosterior)
        model.addAttribute("treinoAbd", treinoAbdominal)

        return "CadastroTreino"
    }

    @PostMapping("/cadastrar") // Salva os treinos no Banco
    fun cadastrarExercicio(
        treino: TreinoGeral,
        treinoOmbro: TreinoOmbro,
        treinoPeito: TreinoPeito,
        treinoCostas: TreinoCostas,
        treinoBracos: TreinoBracos,
        treinoQuads: TreinoQuads,
        treinoPosterior: TreinoPosterior,
        treinoAbdominal: TreinoAbdominal): String{

        treinoRepository.save(treino)
        if (treino.grupomuscular == "Ombro"){
            ombroRepository.save(treinoOmbro)
        }
        // chamada tabela peito
        if (treino.grupomuscular == "Peito"){
            peitoRepository.save(treinoPeito)
        }

        // chamada tabela costas
        if (treino.grupomuscular == "Costas"){
            costasRepository.save(treinoCostas)
        }

        if (treino.grupomuscular == "Braços"){
            bracosRepository.save(treinoBracos)
        }

        // chamada tabela quadr
        if (treino.grupomuscular == "Quadriceps"){
            quadsRepository.save(treinoQuads)
        }

        // chamada tabela post
        if (treino.grupomuscular == "Posterior"){
            posteriorRepository.save(treinoPosterior)
        }
        // chamada tabela abd (fechar o else)
        if (treino.grupomuscular == "Abdominal"){
            abdominalRepository.save(treinoAbdominal)
        }

        return "redirect:/TreinoCadastrado" // independente da condição que caia, tem que gravar na tabela principal que contem todos os treinos e votar a tela inicial.

    }

    @GetMapping("/TreinoCadastrado") // Select os treinos do Banco
    fun listaTreino(model: Model): String{

        val treinos = treinoRepository.findAll()

        //val treinos = ombroRepository.findAll()

        model.addAttribute("treinos", treinos)

        return "Inicial"

    }

    @GetMapping("/treino/edicao/{id}")
    fun tablelaEditarExercicio(
        @PathVariable("id") id:Long, model: Model) : String{

        var treino = treinoRepository.findById(id).orElse(null)

        //var treino = ombroRepository.findById(id).orElse(null)

        model.addAttribute("treino", treino)

        return "EdicaoTreino"
    }

    @PostMapping("/editar/{id}")
    fun editarTreino(
        @PathVariable("id") id: Long,
        treino: TreinoGeral,
        treinoOmbro: TreinoOmbro,
        treinoPeito: TreinoPeito,
        treinoCostas: TreinoCostas,
        treinoQuads: TreinoQuads,
        treinoPosterior: TreinoPosterior,
        treinoAbdominal: TreinoAbdominal): String {

        treinoOmbro.id = id

        treinoRepository.save(treino)

        ombroRepository.save(treinoOmbro)

        return "redirect:/TreinoCadastrado"
    }

    @GetMapping("/excluir/{id}")
    fun excluirExercicio(@PathVariable("id") id: Long) : String{

        treinoRepository.deleteById(id)

        ombroRepository.deleteById(id)

        return "redirect:/TreinoCadastrado"
    }


}