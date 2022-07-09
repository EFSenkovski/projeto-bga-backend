package br.com.eduardo.jobapi.service;

import br.com.eduardo.jobapi.model.TipoPessoa;
import br.com.eduardo.jobapi.repository.TipoPessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class TipoPessoaService {

    @Autowired
    private TipoPessoaRepository tipoPessoaRepository;

    public TipoPessoa buscaTipoPessoaPeloId(Long id){
        TipoPessoa usuario = tipoPessoaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        if (usuario == null){
            throw new EmptyResultDataAccessException(1);
        }
        return usuario;
    }

    public TipoPessoa atualizar(Long id, TipoPessoa tipoPessoa){
        TipoPessoa tipoPessoaSalvo = buscaTipoPessoaPeloId(id);
        BeanUtils.copyProperties(tipoPessoa, tipoPessoaSalvo, "id");
        return tipoPessoaRepository.save(tipoPessoaSalvo);
    }

    public TipoPessoa salvar(TipoPessoa tipoPessoa){
        return tipoPessoaRepository.save(tipoPessoa);
    }
}
