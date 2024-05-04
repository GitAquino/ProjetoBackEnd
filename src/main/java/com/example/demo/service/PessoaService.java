package com.example.demo.service;

import com.example.demo.model.Pessoa;
import com.example.demo.model.Endereco;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    public Pessoa CriarPessoa(Pessoa pessoa) {
       pessoa = new Pessoa();
       return pessoa;
    }
}
