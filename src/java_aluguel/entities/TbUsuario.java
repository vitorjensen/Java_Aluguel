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
@Table(name = "tb_usuario")
@NamedQueries({
    @NamedQuery(name = "TbUsuario.findAll", query = "SELECT t FROM TbUsuario t"),
    @NamedQuery(name = "TbUsuario.findByUsuCodigo", query = "SELECT t FROM TbUsuario t WHERE t.usuCodigo = :usuCodigo"),
    @NamedQuery(name = "TbUsuario.findByUsuNome", query = "SELECT t FROM TbUsuario t WHERE t.usuNome = :usuNome"),
    @NamedQuery(name = "TbUsuario.findByUsuTelefone", query = "SELECT t FROM TbUsuario t WHERE t.usuTelefone = :usuTelefone"),
    @NamedQuery(name = "TbUsuario.findByUsuCidade", query = "SELECT t FROM TbUsuario t WHERE t.usuCidade = :usuCidade"),
    @NamedQuery(name = "TbUsuario.findByUsuBairro", query = "SELECT t FROM TbUsuario t WHERE t.usuBairro = :usuBairro")})
public class TbUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usu_codigo")
    private Integer usuCodigo;
    @Basic(optional = false)
    @Column(name = "usu_nome")
    private String usuNome;
    @Basic(optional = false)
    @Column(name = "usu_telefone")
    private String usuTelefone;
    @Basic(optional = false)
    @Column(name = "usu_cidade")
    private String usuCidade;
    @Basic(optional = false)
    @Column(name = "usu_bairro")
    private String usuBairro;

    public TbUsuario() {
    }

    public TbUsuario(Integer usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    public TbUsuario(Integer usuCodigo, String usuNome, String usuTelefone, String usuCidade, String usuBairro) {
        this.usuCodigo = usuCodigo;
        this.usuNome = usuNome;
        this.usuTelefone = usuTelefone;
        this.usuCidade = usuCidade;
        this.usuBairro = usuBairro;
    }

    public Integer getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Integer usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    public String getUsuNome() {
        return usuNome;
    }

    public void setUsuNome(String usuNome) {
        this.usuNome = usuNome;
    }

    public String getUsuTelefone() {
        return usuTelefone;
    }

    public void setUsuTelefone(String usuTelefone) {
        this.usuTelefone = usuTelefone;
    }

    public String getUsuCidade() {
        return usuCidade;
    }

    public void setUsuCidade(String usuCidade) {
        this.usuCidade = usuCidade;
    }

    public String getUsuBairro() {
        return usuBairro;
    }

    public void setUsuBairro(String usuBairro) {
        this.usuBairro = usuBairro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuCodigo != null ? usuCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUsuario)) {
            return false;
        }
        TbUsuario other = (TbUsuario) object;
        if ((this.usuCodigo == null && other.usuCodigo != null) || (this.usuCodigo != null && !this.usuCodigo.equals(other.usuCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "java_aluguel.entidades.TbUsuario[ usuCodigo=" + usuCodigo + " ]";
    }
    
}
