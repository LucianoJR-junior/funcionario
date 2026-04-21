package com.rh.funcionario.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data   // Lombok: gera getters, setters, toString e equals automaticamente
@Entity // JPA: essa classe representa uma tabela no banco
@Table(name = "funcionarios")  // nome da tabela no banco

public class Funcionario {

    @Id //chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto icremento
    private long id; //long é um tipo de dado primitivo para numeros inteiros grandes

    @Column(nullable = false) //campo obrigatorio no banco
    private String nome;

    @Column(nullable = false, unique = true) //email nao pode repetir
    private String email;

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private BigDecimal salario;
}


/*
@Entity             Diz ao JPA que essa classe vira tabela no banco
@Table              Define o nome da tabela
@Id                 Marca a chave primária
@GeneratedValue     Banco gera o ID automaticamente
@Column             Configura a coluna (obrigatória, única, etc)
@Data               Lombok gera todo o código repetitivo pra você
 */