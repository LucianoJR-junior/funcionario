package com.rh.funcionario.repository;

import com.rh.funcionario.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    //Spring Data gera todos os metodos CRUD automaticamente
    //não é necessario escrever nada
}