package br.com.eduardo.jobapi.repository;

import br.com.eduardo.jobapi.model.Pessoa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("SELECT p FROM Pessoa p WHERE p.nomeRazaoSocial like %?1%")
    List<Pessoa> findByNome(String nome);

    @Query("SELECT p FROM Pessoa p WHERE p.ativo = 1")
    List<Pessoa> findAllAtivos();

}
