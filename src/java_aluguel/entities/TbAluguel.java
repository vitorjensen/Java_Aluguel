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
@Table(name = "tb_aluguel")
@NamedQueries({
    @NamedQuery(name = "TbAluguel.findAll", query = "SELECT t FROM TbAluguel t"),
    @NamedQuery(name = "TbAluguel.findByAluCodigo", query = "SELECT t FROM TbAluguel t WHERE t.aluCodigo = :aluCodigo"),
    @NamedQuery(name = "TbAluguel.findByCliCodigo", query = "SELECT t FROM TbAluguel t WHERE t.cliCodigo = :cliCodigo"),
    @NamedQuery(name = "TbAluguel.findByAluDataInicial", query = "SELECT t FROM TbAluguel t WHERE t.aluDataInicial = :aluDataInicial"),
    @NamedQuery(name = "TbAluguel.findByAluDataFinal", query = "SELECT t FROM TbAluguel t WHERE t.aluDataFinal = :aluDataFinal"),
    @NamedQuery(name = "TbAluguel.findByProCodigo", query = "SELECT t FROM TbAluguel t WHERE t.proCodigo = :proCodigo"),
    @NamedQuery(name = "TbAluguel.findByAluValor", query = "SELECT t FROM TbAluguel t WHERE t.aluValor = :aluValor"),
    @NamedQuery(name = "TbAluguel.findByAluValorSinal", query = "SELECT t FROM TbAluguel t WHERE t.aluValorSinal = :aluValorSinal"),
    @NamedQuery(name = "TbAluguel.findByAluRestaPagar", query = "SELECT t FROM TbAluguel t WHERE t.aluRestaPagar = :aluRestaPagar"),
    @NamedQuery(name = "TbAluguel.findByAluPagoTotal", query = "SELECT t FROM TbAluguel t WHERE t.aluPagoTotal = :aluPagoTotal"),
    @NamedQuery(name = "TbAluguel.findByAluTipoPagamento", query = "SELECT t FROM TbAluguel t WHERE t.aluTipoPagamento = :aluTipoPagamento"),
    @NamedQuery(name = "TbAluguel.findByVenNome", query = "SELECT t FROM TbAluguel t WHERE t.venNome = :venNome"),
    @NamedQuery(name = "TbAluguel.findByAluObservacao", query = "SELECT t FROM TbAluguel t WHERE t.aluObservacao = :aluObservacao"),
    @NamedQuery(name = "TbAluguel.findByAluStatus", query = "SELECT t FROM TbAluguel t WHERE t.aluStatus = :aluStatus"),
    @NamedQuery(name = "TbAluguel.findByAluQtde", query = "SELECT t FROM TbAluguel t WHERE t.aluQtde = :aluQtde")})
public class TbAluguel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "alu_codigo")
    private Integer aluCodigo;
    @Column(name = "cli_codigo")
    private Integer cliCodigo;
    @Basic(optional = false)
    @Column(name = "alu_data_inicial")
    @Temporal(TemporalType.DATE)
    private Date aluDataInicial;
    @Basic(optional = false)
    @Column(name = "alu_data_final")
    @Temporal(TemporalType.DATE)
    private Date aluDataFinal;
    @Column(name = "pro_codigo")
    private Integer proCodigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "alu_valor")
    private BigDecimal aluValor;
    @Column(name = "alu_valor_sinal")
    private BigDecimal aluValorSinal;
    @Column(name = "alu_resta_pagar")
    private BigDecimal aluRestaPagar;
    @Column(name = "alu_pago_total")
    private String aluPagoTotal;
    @Column(name = "alu_tipo_pagamento")
    private String aluTipoPagamento;
    @Column(name = "ven_nome")
    private String venNome;
    @Basic(optional = false)
    @Column(name = "alu_observacao")
    private String aluObservacao;
    @Column(name = "alu_status")
    private String aluStatus;
    @Column(name = "alu_qtde")
    private Integer aluQtde;

    public TbAluguel() {
    }

    public TbAluguel(Integer aluCodigo) {
        this.aluCodigo = aluCodigo;
    }

    public TbAluguel(Integer aluCodigo, Date aluDataInicial, Date aluDataFinal, String aluObservacao) {
        this.aluCodigo = aluCodigo;
        this.aluDataInicial = aluDataInicial;
        this.aluDataFinal = aluDataFinal;
        this.aluObservacao = aluObservacao;
    }

    public Integer getAluCodigo() {
        return aluCodigo;
    }

    public void setAluCodigo(Integer aluCodigo) {
        this.aluCodigo = aluCodigo;
    }

    public Integer getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(Integer cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public Date getAluDataInicial() {
        return aluDataInicial;
    }

    public void setAluDataInicial(Date aluDataInicial) {
        this.aluDataInicial = aluDataInicial;
    }

    public Date getAluDataFinal() {
        return aluDataFinal;
    }

    public void setAluDataFinal(Date aluDataFinal) {
        this.aluDataFinal = aluDataFinal;
    }

    public Integer getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(Integer proCodigo) {
        this.proCodigo = proCodigo;
    }

    public BigDecimal getAluValor() {
        return aluValor;
    }

    public void setAluValor(BigDecimal aluValor) {
        this.aluValor = aluValor;
    }

    public BigDecimal getAluValorSinal() {
        return aluValorSinal;
    }

    public void setAluValorSinal(BigDecimal aluValorSinal) {
        this.aluValorSinal = aluValorSinal;
    }

    public BigDecimal getAluRestaPagar() {
        return aluRestaPagar;
    }

    public void setAluRestaPagar(BigDecimal aluRestaPagar) {
        this.aluRestaPagar = aluRestaPagar;
    }

    public String getAluPagoTotal() {
        return aluPagoTotal;
    }

    public void setAluPagoTotal(String aluPagoTotal) {
        this.aluPagoTotal = aluPagoTotal;
    }

    public String getAluTipoPagamento() {
        return aluTipoPagamento;
    }

    public void setAluTipoPagamento(String aluTipoPagamento) {
        this.aluTipoPagamento = aluTipoPagamento;
    }

    public String getVenNome() {
        return venNome;
    }

    public void setVenNome(String venNome) {
        this.venNome = venNome;
    }

    public String getAluObservacao() {
        return aluObservacao;
    }

    public void setAluObservacao(String aluObservacao) {
        this.aluObservacao = aluObservacao;
    }

    public String getAluStatus() {
        return aluStatus;
    }

    public void setAluStatus(String aluStatus) {
        this.aluStatus = aluStatus;
    }

    public Integer getAluQtde() {
        return aluQtde;
    }

    public void setAluQtde(Integer aluQtde) {
        this.aluQtde = aluQtde;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aluCodigo != null ? aluCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAluguel)) {
            return false;
        }
        TbAluguel other = (TbAluguel) object;
        if ((this.aluCodigo == null && other.aluCodigo != null) || (this.aluCodigo != null && !this.aluCodigo.equals(other.aluCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "java_aluguel.entidades.TbAluguel[ aluCodigo=" + aluCodigo + " ]";
    }
    
}
