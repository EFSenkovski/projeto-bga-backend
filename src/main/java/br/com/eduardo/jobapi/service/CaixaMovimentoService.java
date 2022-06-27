package br.com.eduardo.jobapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.eduardo.jobapi.model.CaixaMovimento;
import br.com.eduardo.jobapi.repository.CaixaMovimentoRepository;

@Service
public class CaixaMovimentoService {

    @Autowired
    private CaixaMovimentoRepository caixaMovimentoRepository;

    public CaixaMovimento buscaMovimentoPeloId(Long id){
        CaixaMovimento cm = caixaMovimentoRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        if (cm == null){
            throw new EmptyResultDataAccessException(1);
        }
        return cm;
    }


    public CaixaMovimento atualizar(Long id, CaixaMovimento cm){
        CaixaMovimento cmSalvo = buscaMovimentoPeloId(id);
        BeanUtils.copyProperties(cm, cmSalvo, "id");
        return caixaMovimentoRepository.save(cmSalvo);
    }

    public CaixaMovimento salvar(CaixaMovimento cm){
        return caixaMovimentoRepository.save(cm);
    }
}
