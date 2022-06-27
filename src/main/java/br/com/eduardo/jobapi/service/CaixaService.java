package br.com.eduardo.jobapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.eduardo.jobapi.model.Caixa;
import br.com.eduardo.jobapi.repository.CaixaRepository;

@Service
public class CaixaService {

    @Autowired
    private CaixaRepository caixaRepository;

    public Caixa buscarCaixaPeloId(Long id){
        Caixa caixa = caixaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        if (caixa == null){
            throw new EmptyResultDataAccessException(1);
        }
        return caixa;
    }

    public Caixa atualizar(Long id, Caixa caixa){
        Caixa caixaSalvo = buscarCaixaPeloId(id);
        BeanUtils.copyProperties(caixa, caixaSalvo, "id");
        return caixaRepository.save(caixaSalvo);
    }

    public Caixa salvar(Caixa caixa){
        return caixaRepository.save(caixa);
    }
}
