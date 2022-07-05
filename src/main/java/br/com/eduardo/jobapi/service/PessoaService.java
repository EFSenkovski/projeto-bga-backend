package br.com.eduardo.jobapi.service;

import br.com.eduardo.jobapi.model.Pessoa;
import br.com.eduardo.jobapi.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa buscaPessoaPeloId(Long id){
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        if (pessoa == null){
            throw new EmptyResultDataAccessException(1);
        }
        return pessoa;
    }

    public Pessoa atualizar(Long id, Pessoa pessoa){
        Pessoa pessoaSalva = buscaPessoaPeloId(id);
        BeanUtils.copyProperties(pessoa, pessoaSalva, "id");
        return pessoaRepository.save(pessoaSalva);
    }

    public Pessoa salvar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }
}
