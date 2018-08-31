/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supp.work.soft.shared.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Myrtha
 */
@Embeddable
public class ArchiveemployesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "mois")
    private String mois;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "annee")
    private String annee;

    public ArchiveemployesPK() {
    }
    

    public ArchiveemployesPK(String code, String mois, String annee) {
        this.code = code;
        this.mois = mois;
        this.annee = annee;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        hash += (mois != null ? mois.hashCode() : 0);
        hash += (annee != null ? annee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArchiveemployesPK)) {
            return false;
        }
        ArchiveemployesPK other = (ArchiveemployesPK) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        if ((this.mois == null && other.mois != null) || (this.mois != null && !this.mois.equals(other.mois))) {
            return false;
        }
        if ((this.annee == null && other.annee != null) || (this.annee != null && !this.annee.equals(other.annee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.supp.work.soft.shared.model.ArchiveemployesPK[ code=" + code + ", mois=" + mois + ", annee=" + annee + " ]";
    }
    
}
