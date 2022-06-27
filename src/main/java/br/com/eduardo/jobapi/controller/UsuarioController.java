package br.com.eduardo.jobapi.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eduardo.jobapi.event.RecursoCriadoEvent;
import br.com.eduardo.jobapi.model.Empresa;
import br.com.eduardo.jobapi.model.Usuario;
import br.com.eduardo.jobapi.repository.UsuarioRepository;
import br.com.eduardo.jobapi.service.UsuarioService;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository 
    usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_LISTAR_USUARIOS') and hasAuthority('SCOPE_read')")
    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_LISTAR_USUARIOS') and hasAuthority('SCOPE_read')")
	public ResponseEntity<Usuario> buscarPeloId(@PathVariable Long id){
		Optional<Usuario> usuarioRecuperado = usuarioRepository.findById(id);
		return usuarioRecuperado.isPresent() ?
				ResponseEntity.ok(usuarioRecuperado.get()) : ResponseEntity.notFound().build();
	}
	

    @PostMapping
    public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario usuario, HttpServletResponse response){
        Usuario usuarioSalvo = usuarioService.salvar(usuario);        
        publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuario){
        Usuario usuarioSalvo = usuarioService.atualizar(id, usuario);
        return ResponseEntity.ok(usuarioSalvo);
    }

    @GetMapping("/{id}/empresas")
    public List<Empresa> getEmpresasUsuario(@PathVariable Long id){
        Usuario usuario = usuarioService.buscaUsuarioPeloId(id);
		return usuario.getEmpresas();
    }

}
