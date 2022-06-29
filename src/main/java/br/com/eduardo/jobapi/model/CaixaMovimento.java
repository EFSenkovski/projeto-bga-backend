package br.com.eduardo.jobapi.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import lombok.NonNull;

@Entity
@Table(name = "caixas_movimentacao")
public class CaixaMovimento {
         
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_caixa")
    private Caixa caixa;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_usuario")     
    private Usuario usuario;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_centro_custo")     
    private CentroCusto centroCusto;  

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_pessoa")     
    private Pessoa pessoa;  

    private String descricao;

    private Double valor;

    @NonNull
    @Column(name = "tipo_movimento")
    private String tipoMovimento;

    @NonNull
    @Column(name = "data_movimento")
    private LocalDateTime dataMovimento;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "pessoas_comissoes",
        joinColumns={@JoinColumn(name="id_pessoa_comissao")},
        inverseJoinColumns={@JoinColumn(name="id_pessoa")})
    private List<Pessoa> pessoasComissoes;

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
        CaixaMovimento other = (CaixaMovimento) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public LocalDateTime getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(LocalDateTime dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public CentroCusto getCentroCusto() {
        return centroCusto;
    }

    public void setCentroCusto(CentroCusto centroCusto) {
        this.centroCusto = centroCusto;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoasComissoes() {
        return pessoasComissoes;
    }

    public void setPessoasComissoes(List<Pessoa> pessoasComissoes) {
        this.pessoasComissoes = pessoasComissoes;
    }

    

    
    
}
