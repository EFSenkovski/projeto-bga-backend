package br.com.eduardo.jobapi.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity@Table(name = "pessoas")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome_razaosocial")
    private String nomeRazaoSocial;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @Column(name = "pessoa_fisica_juridica")
    private String pessoaFisicaJuridica;

    @Column(name = "cpf_cnpj")
    private String cpfCnpj;

    @Column(name = "rg_ie")
    private String rgIe;

    @Column(name = "email")
    private String email;

    @Column(name = "data_nascimento_fundacao")
    private LocalDate dataNascimentoFundacao;

    private String endereco;

    private String cidade;

    private String cep;

    private String uf;

    private String telefone;

    private String celular;

    private Integer ativo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "tipo_pessoa")        
    private TipoPessoa tipoPessoa;

    private String observacao;

    @Column(name = "data_hora_criacao")
    private LocalDateTime dataHoraCriacao;

    @Column(name = "data_hora_atualizacao")
    private LocalDateTime dataHoraAtualizacao;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (id != other.id)
            return false;
        return true;
    }

    
}
