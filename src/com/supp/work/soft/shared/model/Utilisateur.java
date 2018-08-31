/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supp.work.soft.shared.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Myrtha
 */
@Entity
@Table(name = "Utilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findByLogin", query = "SELECT u FROM Utilisateur u WHERE u.login = :login"),
    @NamedQuery(name = "Utilisateur.findByPassword", query = "SELECT u FROM Utilisateur u WHERE u.password = :password"),
    @NamedQuery(name = "Utilisateur.findByTypeUser", query = "SELECT u FROM Utilisateur u WHERE u.typeUser = :typeUser"),
    @NamedQuery(name = "Utilisateur.findByCreerPar", query = "SELECT u FROM Utilisateur u WHERE u.creerPar = :creerPar"),
    @NamedQuery(name = "Utilisateur.findByCreerLe", query = "SELECT u FROM Utilisateur u WHERE u.creerLe = :creerLe"),
    @NamedQuery(name = "Utilisateur.findByModifierPar", query = "SELECT u FROM Utilisateur u WHERE u.modifierPar = :modifierPar"),
    @NamedQuery(name = "Utilisateur.findByModifierLe", query = "SELECT u FROM Utilisateur u WHERE u.modifierLe = :modifierLe"),
    @NamedQuery(name = "Utilisateur.findByNbrFoisLog", query = "SELECT u FROM Utilisateur u WHERE u.nbrFoisLog = :nbrFoisLog")})
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "login")
    private String login;
    @Size(max = 250)
    @Column(name = "password")
    private String password;
    @Size(max = 25)
    @Column(name = "typeUser")
    private String typeUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "creerPar")
    private String creerPar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "creerLe")
    private String creerLe;
    @Size(max = 50)
    @Column(name = "modifierPar")
    private String modifierPar;
    @Size(max = 30)
    @Column(name = "modifierLe")
    private String modifierLe;
    @Size(max = 200)
    @Column(name = "nbrFoisLog")
    private String nbrFoisLog;

    public Utilisateur() {
    }

    public Utilisateur(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public String getCreerPar() {
        return creerPar;
    }

    public void setCreerPar(String creerPar) {
        this.creerPar = creerPar;
    }

    public String getCreerLe() {
        return creerLe;
    }

    public void setCreerLe(String creerLe) {
        this.creerLe = creerLe;
    }

    public String getModifierPar() {
        return modifierPar;
    }

    public void setModifierPar(String modifierPar) {
        this.modifierPar = modifierPar;
    }

    public String getModifierLe() {
        return modifierLe;
    }

    public void setModifierLe(String modifierLe) {
        this.modifierLe = modifierLe;
    }

    public String getNbrFoisLog() {
        return nbrFoisLog;
    }

    public void setNbrFoisLog(String nbrFoisLog) {
        this.nbrFoisLog = nbrFoisLog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.supp.work.soft.shared.modele.Utilisateur[ login=" + login + " ]";
    }
    
}
