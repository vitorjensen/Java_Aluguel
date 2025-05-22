/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_aluguel.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author vitor
 */
@Entity
@Table(name = "tb_fornecedor")
@NamedQueries({
    @NamedQuery(name = "TbFornecedor.findAll", query = "SELECT t FROM TbFornecedor t"),
    @NamedQuery(name = "TbFornecedor.findByForCodigo", query = "SELECT t FROM TbFornecedor t WHERE t.forCodigo = :forCodigo"),
    @NamedQuery(name = "TbFornecedor.findByForPessoa", query = "SELECT t FROM TbFornecedor t WHERE t.forPessoa = :forPessoa"),
    @NamedQuery(name = "TbFornecedor.findByForCnpj", query = "SELECT t FROM TbFornecedor t WHERE t.forCnpj = :forCnpj"),
    @NamedQuery(name = "TbFornecedor.findByForRazao", query = "SELECT t FROM TbFornecedor t WHERE t.forRazao = :forRazao"),
    @NamedQuery(name = "TbFornecedor.findByForFantasia", query = "SELECT t FROM TbFornecedor t WHERE t.forFantasia = :forFantasia"),
    @NamedQuery(name = "TbFornecedor.findByForEndereco", query = "SELECT t FROM TbFornecedor t WHERE t.forEndereco = :forEndereco"),
    @NamedQuery(name = "TbFornecedor.findByForNumero", query = "SELECT t FROM TbFornecedor t WHERE t.forNumero = :forNumero"),
    @NamedQuery(name = "TbFornecedor.findByForCidade", query = "SELECT t FROM TbFornecedor t WHERE t.forCidade = :forCidade"),
    @NamedQuery(name = "TbFornecedor.findByForEstado", query = "SELECT t FROM TbFornecedor t WHERE t.forEstado = :forEstado"),
    @NamedQuery(name = "TbFornecedor.findByForTelefone", query = "SELECT t FROM TbFornecedor t WHERE t.forTelefone = :forTelefone"),
    @NamedQuery(name = "TbFornecedor.findByForDataCadastro", query = "SELECT t FROM TbFornecedor t WHERE t.forDataCadastro = :forDataCadastro")})
public class TbFornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "for_codigo")
    private Integer forCodigo;
    @Basic(optional = false)
    @Column(name = "for_pessoa")
    private String forPessoa;
    @Basic(optional = false)
    @Column(name = "for_cnpj")
    private String forCnpj;
    @Basic(optional = false)
    @Column(name = "for_razao")
    private String forRazao;
    @Basic(optional = false)
    @Column(name = "for_fantasia")
    private String forFantasia;
    @Basic(optional = false)
    @Column(name = "for_endereco")
    private String forEndereco;
    @Basic(optional = false)
    @Column(name = "for_numero")
    private String forNumero;
    @Basic(optional = false)
    @Column(name = "for_cidade")
    private String forCidade;
    @Basic(optional = false)
    @Column(name = "for_estado")
    private String forEstado;
    @Basic(optional = false)
    @Column(name = "for_telefone")
    private String forTelefone;
    @Basic(optional = false)
    @Column(name = "for_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date forDataCadastro;

    public TbFornecedor() {
    }

    public TbFornecedor(Integer forCodigo) {
        this.forCodigo = forCodigo;
    }

    public TbFornecedor(Integer forCodigo, String forPessoa, String forCnpj, String forRazao, String forFantasia, String forEndereco, String forNumero, String forCidade, String forEstado, String forTelefone, Date forDataCadastro) {
        this.forCodigo = forCodigo;
        this.forPessoa = forPessoa;
        this.forCnpj = forCnpj;
        this.forRazao = forRazao;
        this.forFantasia = forFantasia;
        this.forEndereco = forEndereco;
        this.forNumero = forNumero;
        this.forCidade = forCidade;
        this.forEstado = forEstado;
        this.forTelefone = forTelefone;
        this.forDataCadastro = forDataCadastro;
    }

    public Integer getForCodigo() {
        return forCodigo;
    }

    public void setForCodigo(Integer forCodigo) {
        this.forCodigo = forCodigo;
    }

    public String getForPessoa() {
        return forPessoa;
    }

    public void setForPessoa(String forPessoa) {
        this.forPessoa = forPessoa;
    }

    public String getForCnpj() {
        return forCnpj;
    }

    public void setForCnpj(String forCnpj) {
        this.forCnpj = forCnpj;
    }

    public String getForRazao() {
        return forRazao;
    }

    public void setForRazao(String forRazao) {
        this.forRazao = forRazao;
    }

    public String getForFantasia() {
        return forFantasia;
    }

    public void setForFantasia(String forFantasia) {
        this.forFantasia = forFantasia;
    }

    public String getForEndereco() {
        return forEndereco;
    }

    public void setForEndereco(String forEndereco) {
        this.forEndereco = forEndereco;
    }

    public String getForNumero() {
        return forNumero;
    }

    public void setForNumero(String forNumero) {
        this.forNumero = forNumero;
    }

    public String getForCidade() {
        return forCidade;
    }

    public void setForCidade(String forCidade) {
        this.forCidade = forCidade;
    }

    public String getForEstado() {
        return forEstado;
    }

    public void setForEstado(String forEstado) {
        this.forEstado = forEstado;
    }

    public String getForTelefone() {
        return forTelefone;
    }

    public void setForTelefone(String forTelefone) {
        this.forTelefone = forTelefone;
    }

    public Date getForDataCadastro() {
        return forDataCadastro;
    }

    public void setForDataCadastro(Date forDataCadastro) {
        this.forDataCadastro = forDataCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (forCodigo != null ? forCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFornecedor)) {
            return false;
        }
        TbFornecedor other = (TbFornecedor) object;
        if ((this.forCodigo == null && other.forCodigo != null) || (this.forCodigo != null && !this.forCodigo.equals(other.forCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "java_aluguel.entidades.TbFornecedor[ forCodigo=" + forCodigo + " ]";
    }
    
}
