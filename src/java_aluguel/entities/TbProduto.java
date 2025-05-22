/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_aluguel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "tb_produto")
@NamedQueries({
    @NamedQuery(name = "TbProduto.findAll", query = "SELECT t FROM TbProduto t"),
    @NamedQuery(name = "TbProduto.findByProCodigo", query = "SELECT t FROM TbProduto t WHERE t.proCodigo = :proCodigo"),
    @NamedQuery(name = "TbProduto.findByProFoto", query = "SELECT t FROM TbProduto t WHERE t.proFoto = :proFoto"),
    @NamedQuery(name = "TbProduto.findByForFantasia", query = "SELECT t FROM TbProduto t WHERE t.forFantasia = :forFantasia"),
    @NamedQuery(name = "TbProduto.findByProDescricao", query = "SELECT t FROM TbProduto t WHERE t.proDescricao = :proDescricao"),
    @NamedQuery(name = "TbProduto.findByProDescricaoAdd", query = "SELECT t FROM TbProduto t WHERE t.proDescricaoAdd = :proDescricaoAdd"),
    @NamedQuery(name = "TbProduto.findByProCusto", query = "SELECT t FROM TbProduto t WHERE t.proCusto = :proCusto"),
    @NamedQuery(name = "TbProduto.findByProIndice", query = "SELECT t FROM TbProduto t WHERE t.proIndice = :proIndice"),
    @NamedQuery(name = "TbProduto.findByProValor", query = "SELECT t FROM TbProduto t WHERE t.proValor = :proValor"),
    @NamedQuery(name = "TbProduto.findByProTamanho", query = "SELECT t FROM TbProduto t WHERE t.proTamanho = :proTamanho"),
    @NamedQuery(name = "TbProduto.findByProAluguel", query = "SELECT t FROM TbProduto t WHERE t.proAluguel = :proAluguel"),
    @NamedQuery(name = "TbProduto.findByProQtde", query = "SELECT t FROM TbProduto t WHERE t.proQtde = :proQtde"),
    @NamedQuery(name = "TbProduto.findByProCor", query = "SELECT t FROM TbProduto t WHERE t.proCor = :proCor"),
    @NamedQuery(name = "TbProduto.findByProStatus", query = "SELECT t FROM TbProduto t WHERE t.proStatus = :proStatus"),
    @NamedQuery(name = "TbProduto.findByProTipo", query = "SELECT t FROM TbProduto t WHERE t.proTipo = :proTipo"),
    @NamedQuery(name = "TbProduto.findByProDataCadastro", query = "SELECT t FROM TbProduto t WHERE t.proDataCadastro = :proDataCadastro")})
public class TbProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_codigo")
    private Integer proCodigo;
    @Basic(optional = false)
    @Column(name = "pro_foto")
    private String proFoto;
    @Basic(optional = false)
    @Column(name = "for_fantasia")
    private String forFantasia;
    @Basic(optional = false)
    @Column(name = "pro_descricao")
    private String proDescricao;
    @Basic(optional = false)
    @Column(name = "pro_descricao_add")
    private String proDescricaoAdd;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "pro_custo")
    private BigDecimal proCusto;
    @Basic(optional = false)
    @Column(name = "pro_indice")
    private int proIndice;
    @Basic(optional = false)
    @Column(name = "pro_valor")
    private BigDecimal proValor;
    @Basic(optional = false)
    @Column(name = "pro_tamanho")
    private String proTamanho;
    @Basic(optional = false)
    @Column(name = "pro_aluguel")
    private String proAluguel;
    @Basic(optional = false)
    @Column(name = "pro_qtde")
    private int proQtde;
    @Basic(optional = false)
    @Column(name = "pro_cor")
    private String proCor;
    @Basic(optional = false)
    @Column(name = "pro_status")
    private String proStatus;
    @Basic(optional = false)
    @Column(name = "pro_tipo")
    private String proTipo;
    @Basic(optional = false)
    @Column(name = "pro_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date proDataCadastro;

    public TbProduto() {
    }

    public TbProduto(Integer proCodigo) {
        this.proCodigo = proCodigo;
    }

    public TbProduto(Integer proCodigo, String proFoto, String forFantasia, String proDescricao, String proDescricaoAdd, BigDecimal proCusto, int proIndice, BigDecimal proValor, String proTamanho, String proAluguel, int proQtde, String proCor, String proStatus, String proTipo, Date proDataCadastro) {
        this.proCodigo = proCodigo;
        this.proFoto = proFoto;
        this.forFantasia = forFantasia;
        this.proDescricao = proDescricao;
        this.proDescricaoAdd = proDescricaoAdd;
        this.proCusto = proCusto;
        this.proIndice = proIndice;
        this.proValor = proValor;
        this.proTamanho = proTamanho;
        this.proAluguel = proAluguel;
        this.proQtde = proQtde;
        this.proCor = proCor;
        this.proStatus = proStatus;
        this.proTipo = proTipo;
        this.proDataCadastro = proDataCadastro;
    }

    public Integer getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(Integer proCodigo) {
        this.proCodigo = proCodigo;
    }

    public String getProFoto() {
        return proFoto;
    }

    public void setProFoto(String proFoto) {
        this.proFoto = proFoto;
    }

    public String getForFantasia() {
        return forFantasia;
    }

    public void setForFantasia(String forFantasia) {
        this.forFantasia = forFantasia;
    }

    public String getProDescricao() {
        return proDescricao;
    }

    public void setProDescricao(String proDescricao) {
        this.proDescricao = proDescricao;
    }

    public String getProDescricaoAdd() {
        return proDescricaoAdd;
    }

    public void setProDescricaoAdd(String proDescricaoAdd) {
        this.proDescricaoAdd = proDescricaoAdd;
    }

    public BigDecimal getProCusto() {
        return proCusto;
    }

    public void setProCusto(BigDecimal proCusto) {
        this.proCusto = proCusto;
    }

    public int getProIndice() {
        return proIndice;
    }

    public void setProIndice(int proIndice) {
        this.proIndice = proIndice;
    }

    public BigDecimal getProValor() {
        return proValor;
    }

    public void setProValor(BigDecimal proValor) {
        this.proValor = proValor;
    }

    public String getProTamanho() {
        return proTamanho;
    }

    public void setProTamanho(String proTamanho) {
        this.proTamanho = proTamanho;
    }

    public String getProAluguel() {
        return proAluguel;
    }

    public void setProAluguel(String proAluguel) {
        this.proAluguel = proAluguel;
    }

    public int getProQtde() {
        return proQtde;
    }

    public void setProQtde(int proQtde) {
        this.proQtde = proQtde;
    }

    public String getProCor() {
        return proCor;
    }

    public void setProCor(String proCor) {
        this.proCor = proCor;
    }

    public String getProStatus() {
        return proStatus;
    }

    public void setProStatus(String proStatus) {
        this.proStatus = proStatus;
    }

    public String getProTipo() {
        return proTipo;
    }

    public void setProTipo(String proTipo) {
        this.proTipo = proTipo;
    }

    public Date getProDataCadastro() {
        return proDataCadastro;
    }

    public void setProDataCadastro(Date proDataCadastro) {
        this.proDataCadastro = proDataCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proCodigo != null ? proCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProduto)) {
            return false;
        }
        TbProduto other = (TbProduto) object;
        if ((this.proCodigo == null && other.proCodigo != null) || (this.proCodigo != null && !this.proCodigo.equals(other.proCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "java_aluguel.entidades.TbProduto[ proCodigo=" + proCodigo + " ]";
    }
    
}
