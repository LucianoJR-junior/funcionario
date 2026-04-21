package com.rh.funcionario.service;

import com.rh.funcionario.model.Funcionario;
import com.rh.funcionario.repository.FuncionarioRepository;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Spring gerencia essa classe automaticamente
@RequiredArgsConstructor //Lombok gera o construtor com os atributos obrigatorios
public class FuncionarioService {

    //final garante a criação do repository, não tendo como fazer o Service sem ele (repository)
    private final FuncionarioRepository repository;  //injeção de dependencia

    public List<Funcionario> listarTodos() {
        return repository.findAll();
    }

    public Funcionario buscarPorId(long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("funcionario nao encontrado"));
    }

    public Funcionario salvar(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public Funcionario atualizar(Long id, Funcionario dados) {
        Funcionario funcionario = buscarPorId(id);
        funcionario.setNome(dados.getNome());
        funcionario.setEmail(dados.getEmail());
        funcionario.setCargo(dados.getCargo());
        funcionario.setSalario(dados.getSalario());
        return repository.save(funcionario);
    }

    public void deletar(long id){
        buscarPorId(id);
        repository.deleteById(id);
    }
}