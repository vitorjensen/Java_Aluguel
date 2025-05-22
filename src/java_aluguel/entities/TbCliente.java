/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_aluguel.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author vitor
 */
@Entity
@Table(name = "tb_cliente")
@NamedQueries({
    @NamedQuery(name = "TbCliente.findAll", query = "SELECT t FROM TbCliente t"),
    @NamedQuery(name = "TbCliente.findByCliCodigo", query = "SELECT t FROM TbCliente t WHERE t.cliCodigo = :cliCodigo"),
    @NamedQuery(name = "TbCliente.findByCliNome", query = "SELECT t FROM TbCliente t WHERE t.cliNome = :cliNome"),
    @NamedQuery(name = "TbCliente.findByCliTelefone", query = "SELECT t FROM TbCliente t WHERE t.cliTelefone = :cliTelefone"),
    @NamedQuery(name = "TbCliente.findByCliCpf", query = "SELECT t FROM TbCliente t WHERE t.cliCpf = :cliCpf"),
    @NamedQuery(name = "TbCliente.findByCliRua", query = "SELECT t FROM TbCliente t WHERE t.cliRua = :cliRua"),
    @NamedQuery(name = "TbCliente.findByCliNumero", query = "SELECT t FROM TbCliente t WHERE t.cliNumero = :cliNumero"),
    @NamedQuery(name = "TbCliente.findByCliBairro", query = "SELECT t FROM TbCliente t WHERE t.cliBairro = :cliBairro"),
    @NamedQuery(name = "TbCliente.findByCliCidade", query = "SELECT t FROM TbCliente t WHERE t.cliCidade = :cliCidade"),
    @NamedQuery(name = "TbCliente.findByCliEstado", query = "SELECT t FROM TbCliente t WHERE t.cliEstado = :cliEstado"),
    @NamedQuery(name = "TbCliente.findByCliComplemento", query = "SELECT t FROM TbCliente t WHERE t.cliComplemento = :cliComplemento")})
public class TbCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cli_codigo")
    private Integer cliCodigo;
    @Basic(optional = false)
    @Column(name = "cli_nome")
    private String cliNome;
    @Basic(optional = false)
    @Column(name = "cli_telefone")
    private String cliTelefone;
    @Basic(optional = false)
    @Column(name = "cli_cpf")
    private String cliCpf;
    @Basic(optional = false)
    @Column(name = "cli_rua")
    private String cliRua;
    @Basic(optional = false)
    @Column(name = "cli_numero")
    private String cliNumero;
    @Basic(optional = false)
    @Column(name = "cli_bairro")
    private String cliBairro;
    @Basic(optional = false)
    @Column(name = "cli_cidade")
    private String cliCidade;
    @Basic(optional = false)
    @Column(name = "cli_estado")
    private String cliEstado;
    @Basic(optional = false)
    @Column(name = "cli_complemento")
    private String cliComplemento;

    public TbCliente() {
    }

    public TbCliente(Integer cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public TbCliente(Integer cliCodigo, String cliNome, String cliTelefone, String cliCpf, String cliRua, String cliNumero, String cliBairro, String cliCidade, String cliEstado, String cliComplemento) {
        this.cliCodigo = cliCodigo;
        this.cliNome = cliNome;
        this.cliTelefone = cliTelefone;
        this.cliCpf = cliCpf;
        this.cliRua = cliRua;
        this.cliNumero = cliNumero;
        this.cliBairro = cliBairro;
        this.cliCidade = cliCidade;
        this.cliEstado = cliEstado;
        this.cliComplemento = cliComplemento;
    }

    public TbCliente(String cliNome, String cliTelefone, String cliCpf, String cliRua, String cliNumero, String cliBairro, String cliCidade, String cliEstado, String cliComplemento) {
        this.cliNome = cliNome;
        this.cliTelefone = cliTelefone;
        this.cliCpf = cliCpf;
        this.cliRua = cliRua;
        this.cliNumero = cliNumero;
        this.cliBairro = cliBairro;
        this.cliCidade = cliCidade;
        this.cliEstado = cliEstado;
        this.cliComplemento = cliComplemento;
    }

    public Integer getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(Integer cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    public String getCliTelefone() {
        return cliTelefone;
    }

    public void setCliTelefone(String cliTelefone) {
        this.cliTelefone = cliTelefone;
    }

    public String getCliCpf() {
        return cliCpf;
    }

    public void setCliCpf(String cliCpf) {
        this.cliCpf = cliCpf;
    }

    public String getCliRua() {
        return cliRua;
    }

    public void setCliRua(String cliRua) {
        this.cliRua = cliRua;
    }

    public String getCliNumero() {
        return cliNumero;
    }

    public void setCliNumero(String cliNumero) {
        this.cliNumero = cliNumero;
    }

    public String getCliBairro() {
        return cliBairro;
    }

    public void setCliBairro(String cliBairro) {
        this.cliBairro = cliBairro;
    }

    public String getCliCidade() {
        return cliCidade;
    }

    public void setCliCidade(String cliCidade) {
        this.cliCidade = cliCidade;
    }

    public String getCliEstado() {
        return cliEstado;
    }

    public void setCliEstado(String cliEstado) {
        this.cliEstado = cliEstado;
    }

    public String getCliComplemento() {
        return cliComplemento;
    }

    public void setCliComplemento(String cliComplemento) {
        this.cliComplemento = cliComplemento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliCodigo != null ? cliCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCliente)) {
            return false;
        }
        TbCliente other = (TbCliente) object;
        if ((this.cliCodigo == null && other.cliCodigo != null) || (this.cliCodigo != null && !this.cliCodigo.equals(other.cliCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "java_aluguel.entidades.TbCliente[ cliCodigo=" + cliCodigo + " ]";
    }
    
}
