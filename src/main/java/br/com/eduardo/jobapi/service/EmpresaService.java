package br.com.eduardo.jobapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.eduardo.jobapi.model.Empresa;
import br.com.eduardo.jobapi.repository.EmpresaRepository;

@Service
public class EmpresaService {
    
    @Autowired
    private EmpresaRepository empresaRepository; 

    public Empresa buscaUsuarioPeloId(Long id){
        Empresa usuario = empresaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        if (usuario == null){
            throw new EmptyResultDataAccessException(1);
        }
        return usuario;
    }

    public Empresa atualizar(Long id, Empresa empresa){
        Empresa usuarioSalvo = buscaUsuarioPeloId(id);
        BeanUtils.copyProperties(empresa, usuarioSalvo, "id");
        return empresaRepository.save(usuarioSalvo);
    }

    public Empresa salvar(Empresa empresa){
        return empresaRepository.save(empresa);
    }

}
