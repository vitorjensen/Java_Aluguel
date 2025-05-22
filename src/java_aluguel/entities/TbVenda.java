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
@Table(name = "tb_venda")
@NamedQueries({
    @NamedQuery(name = "TbVenda.findAll", query = "SELECT t FROM TbVenda t"),
    @NamedQuery(name = "TbVenda.findByVemCodigo", query = "SELECT t FROM TbVenda t WHERE t.vemCodigo = :vemCodigo"),
    @NamedQuery(name = "TbVenda.findByCliNome", query = "SELECT t FROM TbVenda t WHERE t.cliNome = :cliNome"),
    @NamedQuery(name = "TbVenda.findByVemTelefone", query = "SELECT t FROM TbVenda t WHERE t.vemTelefone = :vemTelefone"),
    @NamedQuery(name = "TbVenda.findByVemCpf", query = "SELECT t FROM TbVenda t WHERE t.vemCpf = :vemCpf"),
    @NamedQuery(name = "TbVenda.findByVemRua", query = "SELECT t FROM TbVenda t WHERE t.vemRua = :vemRua"),
    @NamedQuery(name = "TbVenda.findByVemNumero", query = "SELECT t FROM TbVenda t WHERE t.vemNumero = :vemNumero"),
    @NamedQuery(name = "TbVenda.findByVemBairro", query = "SELECT t FROM TbVenda t WHERE t.vemBairro = :vemBairro"),
    @NamedQuery(name = "TbVenda.findByVemCidade", query = "SELECT t FROM TbVenda t WHERE t.vemCidade = :vemCidade"),
    @NamedQuery(name = "TbVenda.findByVemEstado", query = "SELECT t FROM TbVenda t WHERE t.vemEstado = :vemEstado"),
    @NamedQuery(name = "TbVenda.findByVemComplemento", query = "SELECT t FROM TbVenda t WHERE t.vemComplemento = :vemComplemento"),
    @NamedQuery(name = "TbVenda.findByVemDataInicial", query = "SELECT t FROM TbVenda t WHERE t.vemDataInicial = :vemDataInicial"),
    @NamedQuery(name = "TbVenda.findByVemEvento", query = "SELECT t FROM TbVenda t WHERE t.vemEvento = :vemEvento"),
    @NamedQuery(name = "TbVenda.findByVemDataCompra", query = "SELECT t FROM TbVenda t WHERE t.vemDataCompra = :vemDataCompra"),
    @NamedQuery(name = "TbVenda.findByProCodigo", query = "SELECT t FROM TbVenda t WHERE t.proCodigo = :proCodigo"),
    @NamedQuery(name = "TbVenda.findByVemDescricao", query = "SELECT t FROM TbVenda t WHERE t.vemDescricao = :vemDescricao"),
    @NamedQuery(name = "TbVenda.findByVemProduto", query = "SELECT t FROM TbVenda t WHERE t.vemProduto = :vemProduto"),
    @NamedQuery(name = "TbVenda.findByVemCor", query = "SELECT t FROM TbVenda t WHERE t.vemCor = :vemCor"),
    @NamedQuery(name = "TbVenda.findByVemTipo", query = "SELECT t FROM TbVenda t WHERE t.vemTipo = :vemTipo"),
    @NamedQuery(name = "TbVenda.findByVemTamanho", query = "SELECT t FROM TbVenda t WHERE t.vemTamanho = :vemTamanho"),
    @NamedQuery(name = "TbVenda.findByVemQtde", query = "SELECT t FROM TbVenda t WHERE t.vemQtde = :vemQtde"),
    @NamedQuery(name = "TbVenda.findByVemValor", query = "SELECT t FROM TbVenda t WHERE t.vemValor = :vemValor"),
    @NamedQuery(name = "TbVenda.findByVemValorSinal", query = "SELECT t FROM TbVenda t WHERE t.vemValorSinal = :vemValorSinal"),
    @NamedQuery(name = "TbVenda.findByVemRestaPagar", query = "SELECT t FROM TbVenda t WHERE t.vemRestaPagar = :vemRestaPagar"),
    @NamedQuery(name = "TbVenda.findByVemPagoTotal", query = "SELECT t FROM TbVenda t WHERE t.vemPagoTotal = :vemPagoTotal"),
    @NamedQuery(name = "TbVenda.findByVemTipoPagamento", query = "SELECT t FROM TbVenda t WHERE t.vemTipoPagamento = :vemTipoPagamento"),
    @NamedQuery(name = "TbVenda.findByVenNome", query = "SELECT t FROM TbVenda t WHERE t.venNome = :venNome"),
    @NamedQuery(name = "TbVenda.findByVemObservacao", query = "SELECT t FROM TbVenda t WHERE t.vemObservacao = :vemObservacao")})
public class TbVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vem_codigo")
    private Integer vemCodigo;
    @Column(name = "cli_nome")
    private String cliNome;
    @Column(name = "vem_telefone")
    private String vemTelefone;
    @Column(name = "vem_cpf")
    private String vemCpf;
    @Column(name = "vem_rua")
    private String vemRua;
    @Column(name = "vem_numero")
    private String vemNumero;
    @Column(name = "vem_bairro")
    private String vemBairro;
    @Column(name = "vem_cidade")
    private String vemCidade;
    @Column(name = "vem_estado")
    private String vemEstado;
    @Column(name = "vem_complemento")
    private String vemComplemento;
    @Basic(optional = false)
    @Column(name = "vem_data_inicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vemDataInicial;
    @Basic(optional = false)
    @Column(name = "vem_evento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vemEvento;
    @Basic(optional = false)
    @Column(name = "vem_data_compra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vemDataCompra;
    @Column(name = "pro_codigo")
    private Integer proCodigo;
    @Column(name = "vem_descricao")
    private String vemDescricao;
    @Column(name = "vem_produto")
    private String vemProduto;
    @Column(name = "vem_cor")
    private String vemCor;
    @Column(name = "vem_tipo")
    private String vemTipo;
    @Column(name = "vem_tamanho")
    private String vemTamanho;
    @Column(name = "vem_qtde")
    private Integer vemQtde;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vem_valor")
    private BigDecimal vemValor;
    @Column(name = "vem_valor_sinal")
    private BigDecimal vemValorSinal;
    @Column(name = "vem_resta_pagar")
    private BigDecimal vemRestaPagar;
    @Column(name = "vem_pago_total")
    private String vemPagoTotal;
    @Column(name = "vem_tipo_pagamento")
    private String vemTipoPagamento;
    @Column(name = "ven_nome")
    private String venNome;
    @Basic(optional = false)
    @Column(name = "vem_observacao")
    private String vemObservacao;

    public TbVenda() {
    }

    public TbVenda(Integer vemCodigo) {
        this.vemCodigo = vemCodigo;
    }

    public TbVenda(Integer vemCodigo, Date vemDataInicial, Date vemEvento, Date vemDataCompra, String vemObservacao) {
        this.vemCodigo = vemCodigo;
        this.vemDataInicial = vemDataInicial;
        this.vemEvento = vemEvento;
        this.vemDataCompra = vemDataCompra;
        this.vemObservacao = vemObservacao;
    }

    public Integer getVemCodigo() {
        return vemCodigo;
    }

    public void setVemCodigo(Integer vemCodigo) {
        this.vemCodigo = vemCodigo;
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    public String getVemTelefone() {
        return vemTelefone;
    }

    public void setVemTelefone(String vemTelefone) {
        this.vemTelefone = vemTelefone;
    }

    public String getVemCpf() {
        return vemCpf;
    }

    public void setVemCpf(String vemCpf) {
        this.vemCpf = vemCpf;
    }

    public String getVemRua() {
        return vemRua;
    }

    public void setVemRua(String vemRua) {
        this.vemRua = vemRua;
    }

    public String getVemNumero() {
        return vemNumero;
    }

    public void setVemNumero(String vemNumero) {
        this.vemNumero = vemNumero;
    }

    public String getVemBairro() {
        return vemBairro;
    }

    public void setVemBairro(String vemBairro) {
        this.vemBairro = vemBairro;
    }

    public String getVemCidade() {
        return vemCidade;
    }

    public void setVemCidade(String vemCidade) {
        this.vemCidade = vemCidade;
    }

    public String getVemEstado() {
        return vemEstado;
    }

    public void setVemEstado(String vemEstado) {
        this.vemEstado = vemEstado;
    }

    public String getVemComplemento() {
        return vemComplemento;
    }

    public void setVemComplemento(String vemComplemento) {
        this.vemComplemento = vemComplemento;
    }

    public Date getVemDataInicial() {
        return vemDataInicial;
    }

    public void setVemDataInicial(Date vemDataInicial) {
        this.vemDataInicial = vemDataInicial;
    }

    public Date getVemEvento() {
        return vemEvento;
    }

    public void setVemEvento(Date vemEvento) {
        this.vemEvento = vemEvento;
    }

    public Date getVemDataCompra() {
        return vemDataCompra;
    }

    public void setVemDataCompra(Date vemDataCompra) {
        this.vemDataCompra = vemDataCompra;
    }

    public Integer getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(Integer proCodigo) {
        this.proCodigo = proCodigo;
    }

    public String getVemDescricao() {
        return vemDescricao;
    }

    public void setVemDescricao(String vemDescricao) {
        this.vemDescricao = vemDescricao;
    }

    public String getVemProduto() {
        return vemProduto;
    }

    public void setVemProduto(String vemProduto) {
        this.vemProduto = vemProduto;
    }

    public String getVemCor() {
        return vemCor;
    }

    public void setVemCor(String vemCor) {
        this.vemCor = vemCor;
    }

    public String getVemTipo() {
        return vemTipo;
    }

    public void setVemTipo(String vemTipo) {
        this.vemTipo = vemTipo;
    }

    public String getVemTamanho() {
        return vemTamanho;
    }

    public void setVemTamanho(String vemTamanho) {
        this.vemTamanho = vemTamanho;
    }

    public Integer getVemQtde() {
        return vemQtde;
    }

    public void setVemQtde(Integer vemQtde) {
        this.vemQtde = vemQtde;
    }

    public BigDecimal getVemValor() {
        return vemValor;
    }

    public void setVemValor(BigDecimal vemValor) {
        this.vemValor = vemValor;
    }

    public BigDecimal getVemValorSinal() {
        return vemValorSinal;
    }

    public void setVemValorSinal(BigDecimal vemValorSinal) {
        this.vemValorSinal = vemValorSinal;
    }

    public BigDecimal getVemRestaPagar() {
        return vemRestaPagar;
    }

    public void setVemRestaPagar(BigDecimal vemRestaPagar) {
        this.vemRestaPagar = vemRestaPagar;
    }

    public String getVemPagoTotal() {
        return vemPagoTotal;
    }

    public void setVemPagoTotal(String vemPagoTotal) {
        this.vemPagoTotal = vemPagoTotal;
    }

    public String getVemTipoPagamento() {
        return vemTipoPagamento;
    }

    public void setVemTipoPagamento(String vemTipoPagamento) {
        this.vemTipoPagamento = vemTipoPagamento;
    }

    public String getVenNome() {
        return venNome;
    }

    public void setVenNome(String venNome) {
        this.venNome = venNome;
    }

    public String getVemObservacao() {
        return vemObservacao;
    }

    public void setVemObservacao(String vemObservacao) {
        this.vemObservacao = vemObservacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vemCodigo != null ? vemCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbVenda)) {
            return false;
        }
        TbVenda other = (TbVenda) object;
        if ((this.vemCodigo == null && other.vemCodigo != null) || (this.vemCodigo != null && !this.vemCodigo.equals(other.vemCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "java_aluguel.entidades.TbVenda[ vemCodigo=" + vemCodigo + " ]";
    }
    
}
