package br.com.eduardo.jobapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eduardo.jobapi.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
    
}
