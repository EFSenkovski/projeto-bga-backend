package br.com.eduardo.jobapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.eduardo.jobapi.model.Usuario;
import br.com.eduardo.jobapi.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
        
    public Usuario buscaUsuarioPeloId(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        if (usuario == null){
            throw new EmptyResultDataAccessException(1);
        }
        return usuario;
    }

    public Usuario atualizar(Long id, Usuario usuario){
        Usuario usuarioSalvo = buscaUsuarioPeloId(id);
        BeanUtils.copyProperties(usuario, usuarioSalvo, "id");
        return usuarioRepository.save(usuarioSalvo);
    }

    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
