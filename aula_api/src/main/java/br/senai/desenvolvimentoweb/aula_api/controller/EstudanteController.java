package br.senai.desenvolvimentoweb.aula_api.controller;

import br.senai.desenvolvimentoweb.aula_api.entity.Estudante;
import br.senai.desenvolvimentoweb.aula_api.service.EstudanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudante")
public class EstudanteController {

    final EstudanteService estudanteService;

    public EstudanteController(EstudanteService estudanteService) {
        this.estudanteService = estudanteService;
    }


    @GetMapping("todos")
    public ResponseEntity<?> buscarEstudante(){
        try {
            List<Estudante> lista =
                    estudanteService.buscarEstudantes();
            return new ResponseEntity(lista, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>
                    ("Erro na requisição",
                            HttpStatus.BAD_GATEWAY);
        }
    }
    @PostMapping("add")
    public ResponseEntity<?> criarEstudante(@RequestBody Estudante estudante){
        try{
            estudante = estudanteService.criarEstudante(estudante);
            return new ResponseEntity<>(estudante, HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity(exception.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscarEstudante(@PathVariable("codigo") Long codigo){
        try {
            Estudante estudante = estudanteService.buscarEstudante(codigo);
            return new ResponseEntity(estudante, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
