package br.senai.desenvolvimentoweb.aula_api.service;

import br.senai.desenvolvimentoweb.aula_api.entity.Estudante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    private List<Estudante> estudantes;

    public EstudanteService(){
        estudantes = new ArrayList<>();
    }

    public List<Estudante> buscarEstudantes(){
        return estudantes;
    }

    public Estudante criarEstudante(Estudante estudante) throws Exception {
        if(estudante.getIdade() < 18)
            throw new Exception("Usuário menor de idade");
        estudantes.add(estudante);
        return estudante;
    }

    public Estudante buscarEstudante(Long codigo) throws Exception {
        Optional<Estudante> estudante = estudantes.stream().filter
                (e -> e.getCodigo() == codigo).findFirst();
        if(estudante.isPresent()){
            return estudante.get();
        } else {
            throw new Exception("Estudante não encontrado!");
        }
    }

}
