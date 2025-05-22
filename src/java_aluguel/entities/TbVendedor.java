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
@Table(name = "tb_vendedor")
@NamedQueries({
    @NamedQuery(name = "TbVendedor.findAll", query = "SELECT t FROM TbVendedor t"),
    @NamedQuery(name = "TbVendedor.findByVenCodigo", query = "SELECT t FROM TbVendedor t WHERE t.venCodigo = :venCodigo"),
    @NamedQuery(name = "TbVendedor.findByVenNome", query = "SELECT t FROM TbVendedor t WHERE t.venNome = :venNome"),
    @NamedQuery(name = "TbVendedor.findByVenEmpresa", query = "SELECT t FROM TbVendedor t WHERE t.venEmpresa = :venEmpresa"),
    @NamedQuery(name = "TbVendedor.findByVenEmail", query = "SELECT t FROM TbVendedor t WHERE t.venEmail = :venEmail"),
    @NamedQuery(name = "TbVendedor.findByVenDataCadastro", query = "SELECT t FROM TbVendedor t WHERE t.venDataCadastro = :venDataCadastro")})
public class TbVendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ven_codigo")
    private Integer venCodigo;
    @Basic(optional = false)
    @Column(name = "ven_nome")
    private String venNome;
    @Basic(optional = false)
    @Column(name = "ven_empresa")
    private String venEmpresa;
    @Basic(optional = false)
    @Column(name = "ven_email")
    private String venEmail;
    @Basic(optional = false)
    @Column(name = "ven_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date venDataCadastro;

    public TbVendedor() {
    }

    public TbVendedor(Integer venCodigo) {
        this.venCodigo = venCodigo;
    }

    public TbVendedor(Integer venCodigo, String venNome, String venEmpresa, String venEmail, Date venDataCadastro) {
        this.venCodigo = venCodigo;
        this.venNome = venNome;
        this.venEmpresa = venEmpresa;
        this.venEmail = venEmail;
        this.venDataCadastro = venDataCadastro;
    }

    public Integer getVenCodigo() {
        return venCodigo;
    }

    public void setVenCodigo(Integer venCodigo) {
        this.venCodigo = venCodigo;
    }

    public String getVenNome() {
        return venNome;
    }

    public void setVenNome(String venNome) {
        this.venNome = venNome;
    }

    public String getVenEmpresa() {
        return venEmpresa;
    }

    public void setVenEmpresa(String venEmpresa) {
        this.venEmpresa = venEmpresa;
    }

    public String getVenEmail() {
        return venEmail;
    }

    public void setVenEmail(String venEmail) {
        this.venEmail = venEmail;
    }

    public Date getVenDataCadastro() {
        return venDataCadastro;
    }

    public void setVenDataCadastro(Date venDataCadastro) {
        this.venDataCadastro = venDataCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (venCodigo != null ? venCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbVendedor)) {
            return false;
        }
        TbVendedor other = (TbVendedor) object;
        if ((this.venCodigo == null && other.venCodigo != null) || (this.venCodigo != null && !this.venCodigo.equals(other.venCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "java_aluguel.entidades.TbVendedor[ venCodigo=" + venCodigo + " ]";
    }
    
}
