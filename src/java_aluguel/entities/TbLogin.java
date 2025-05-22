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
@Table(name = "tb_login")
@NamedQueries({
    @NamedQuery(name = "TbLogin.findAll", query = "SELECT t FROM TbLogin t"),
    @NamedQuery(name = "TbLogin.findByLogCodigo", query = "SELECT t FROM TbLogin t WHERE t.logCodigo = :logCodigo"),
    @NamedQuery(name = "TbLogin.findByLogNome", query = "SELECT t FROM TbLogin t WHERE t.logNome = :logNome"),
    @NamedQuery(name = "TbLogin.findByLogLogin", query = "SELECT t FROM TbLogin t WHERE t.logLogin = :logLogin"),
    @NamedQuery(name = "TbLogin.findByLogSenha", query = "SELECT t FROM TbLogin t WHERE t.logSenha = :logSenha")})
public class TbLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "log_codigo")
    private Integer logCodigo;
    @Column(name = "log_nome")
    private String logNome;
    @Column(name = "log_login")
    private String logLogin;
    @Column(name = "log_senha")
    private String logSenha;

    public TbLogin() {
    }

    public TbLogin(Integer logCodigo) {
        this.logCodigo = logCodigo;
    }

    public Integer getLogCodigo() {
        return logCodigo;
    }

    public void setLogCodigo(Integer logCodigo) {
        this.logCodigo = logCodigo;
    }

    public String getLogNome() {
        return logNome;
    }

    public void setLogNome(String logNome) {
        this.logNome = logNome;
    }

    public String getLogLogin() {
        return logLogin;
    }

    public void setLogLogin(String logLogin) {
        this.logLogin = logLogin;
    }

    public String getLogSenha() {
        return logSenha;
    }

    public void setLogSenha(String logSenha) {
        this.logSenha = logSenha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logCodigo != null ? logCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbLogin)) {
            return false;
        }
        TbLogin other = (TbLogin) object;
        if ((this.logCodigo == null && other.logCodigo != null) || (this.logCodigo != null && !this.logCodigo.equals(other.logCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "java_aluguel.entidades.TbLogin[ logCodigo=" + logCodigo + " ]";
    }
    
}
