package br.senai.desenvolvimentoweb.aula_api.controller;

import br.senai.desenvolvimentoweb.aula_api.entity.Estudante;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estudantes")
public class AulaController {

    @GetMapping("/{codigo}")
    public String buscar(@PathVariable("codigo") Long codigo){
        return "Estudantes "+codigo+" !!!";
    }

    @PostMapping("add")
    private String criarEstudante(@RequestBody Estudante estudante){
        return "Estudante "+estudante.getNome()+" Criado";
    }

    @PutMapping("update/{codigo}")
    private String alterarEstudante(@PathVariable Long codigo,
                                    @RequestBody Estudante estudante){
        return "Estudante Alterado";
    }

    @DeleteMapping("delete")
    private String excluirEstudante(){
        return "Estudante Excluído";
    }

}
