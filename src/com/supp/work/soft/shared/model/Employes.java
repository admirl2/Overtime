package com.supp.work.soft.shared.model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


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
@Table(name = "Employes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employes.findAll", query = "SELECT e FROM Employes e"),
    @NamedQuery(name = "Employes.findByCode", query = "SELECT e FROM Employes e WHERE e.code = :code"),
    @NamedQuery(name = "Employes.findByNom", query = "SELECT e FROM Employes e WHERE e.nom = :nom"),
    @NamedQuery(name = "Employes.findByPrenom", query = "SELECT e FROM Employes e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Employes.findBySalaire", query = "SELECT e FROM Employes e WHERE e.salaire = :salaire"),
    @NamedQuery(name = "Employes.findByFonction", query = "SELECT e FROM Employes e WHERE e.fonction = :fonction"),
    @NamedQuery(name = "Employes.findByHoraireRegulier", query = "SELECT e FROM Employes e WHERE e.horaireRegulier = :horaireRegulier"),
    @NamedQuery(name = "Employes.findByLundi", query = "SELECT e FROM Employes e WHERE e.lundi = :lundi"),
    @NamedQuery(name = "Employes.findByMardi", query = "SELECT e FROM Employes e WHERE e.mardi = :mardi"),
    @NamedQuery(name = "Employes.findByMercredi", query = "SELECT e FROM Employes e WHERE e.mercredi = :mercredi"),
    @NamedQuery(name = "Employes.findByJeudi", query = "SELECT e FROM Employes e WHERE e.jeudi = :jeudi"),
    @NamedQuery(name = "Employes.findByVendredi", query = "SELECT e FROM Employes e WHERE e.vendredi = :vendredi"),
    @NamedQuery(name = "Employes.findBySamedi", query = "SELECT e FROM Employes e WHERE e.samedi = :samedi"),
    @NamedQuery(name = "Employes.findByDimanche", query = "SELECT e FROM Employes e WHERE e.dimanche = :dimanche"),
    @NamedQuery(name = "Employes.findByValeurAPayer", query = "SELECT e FROM Employes e WHERE e.valeurAPayer = :valeurAPayer"),
    @NamedQuery(name = "Employes.findByTotalHeuresS", query = "SELECT e FROM Employes e WHERE e.totalHeuresS = :totalHeuresS"),
    @NamedQuery(name = "Employes.findByTotalHeureW", query = "SELECT e FROM Employes e WHERE e.totalHeureW = :totalHeureW"),
    @NamedQuery(name = "Employes.findByTotalHeures", query = "SELECT e FROM Employes e WHERE e.totalHeures = :totalHeures"),
    @NamedQuery(name = "Employes.findByRaison", query = "SELECT e FROM Employes e WHERE e.raison = :raison"),
    @NamedQuery(name = "Employes.findByMois", query = "SELECT e FROM Employes e WHERE e.mois = :mois"),
    @NamedQuery(name = "Employes.findByDirection", query = "SELECT e FROM Employes e WHERE e.direction = :direction"),
    @NamedQuery(name = "Employes.findByService", query = "SELECT e FROM Employes e WHERE e.service = :service"),
    @NamedQuery(name = "Employes.findByCreerPar", query = "SELECT e FROM Employes e WHERE e.creerPar = :creerPar"),
    @NamedQuery(name = "Employes.findByCreerLe", query = "SELECT e FROM Employes e WHERE e.creerLe = :creerLe"),
    @NamedQuery(name = "Employes.findByModifierPar", query = "SELECT e FROM Employes e WHERE e.modifierPar = :modifierPar"),
    @NamedQuery(name = "Employes.findByModifierLe", query = "SELECT e FROM Employes e WHERE e.modifierLe = :modifierLe"),
    @NamedQuery(name = "Employes.findByConge", query = "SELECT e FROM Employes e WHERE e.conge = :conge"),
    @NamedQuery(name = "Employes.findByAnnee", query = "SELECT e FROM Employes e WHERE e.annee = :annee")})
public class Employes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "code")
    private String code;
    @Size(max = 100)
    @Column(name = "nom")
    private String nom;
    @Size(max = 100)
    @Column(name = "prenom")
    private String prenom;
    @Size(max = 10)
    @Column(name = "salaire")
    private String salaire;
    @Size(max = 100)
    @Column(name = "fonction")
    private String fonction;
    @Size(max = 100)
    @Column(name = "horaireRegulier")
    private String horaireRegulier;
    @Size(max = 100)
    @Column(name = "lundi")
    private String lundi;
    @Size(max = 100)
    @Column(name = "mardi")
    private String mardi;
    @Size(max = 100)
    @Column(name = "mercredi")
    private String mercredi;
    @Size(max = 100)
    @Column(name = "jeudi")
    private String jeudi;
    @Size(max = 100)
    @Column(name = "vendredi")
    private String vendredi;
    @Size(max = 100)
    @Column(name = "samedi")
    private String samedi;
    @Size(max = 100)
    @Column(name = "dimanche")
    private String dimanche;
    @Size(max = 100)
    @Column(name = "valeurAPayer")
    private String valeurAPayer;
    @Size(max = 100)
    @Column(name = "totalHeuresS")
    private String totalHeuresS;
    @Size(max = 100)
    @Column(name = "totalHeureW")
    private String totalHeureW;
    @Size(max = 100)
    @Column(name = "totalHeures")
    private String totalHeures;
    @Size(max = 200)
    @Column(name = "raison")
    private String raison;
    @Size(max = 100)
    @Column(name = "mois")
    private String mois;
    @Size(max = 100)
    @Column(name = "direction")
    private String direction;
    @Size(max = 100)
    @Column(name = "service")
    private String service;
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
    @Size(max = 10)
    @Column(name = "conge")
    private String conge;
    @Size(max = 10)
    @Column(name = "annee")
    private String annee;

    public Employes() {
    }

    public Employes(String code) {
        this.code = code;
    }

    public Employes(String code, String creerPar, String creerLe) {
        this.code = code;
        this.creerPar = creerPar;
        this.creerLe = creerLe;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSalaire() {
        return salaire;
    }

    public void setSalaire(String salaire) {
        this.salaire = salaire;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getHoraireRegulier() {
        return horaireRegulier;
    }

    public void setHoraireRegulier(String horaireRegulier) {
        this.horaireRegulier = horaireRegulier;
    }

    public String getLundi() {
        return lundi;
    }

    public void setLundi(String lundi) {
        this.lundi = lundi;
    }

    public String getMardi() {
        return mardi;
    }

    public void setMardi(String mardi) {
        this.mardi = mardi;
    }

    public String getMercredi() {
        return mercredi;
    }

    public void setMercredi(String mercredi) {
        this.mercredi = mercredi;
    }

    public String getJeudi() {
        return jeudi;
    }

    public void setJeudi(String jeudi) {
        this.jeudi = jeudi;
    }

    public String getVendredi() {
        return vendredi;
    }

    public void setVendredi(String vendredi) {
        this.vendredi = vendredi;
    }

    public String getSamedi() {
        return samedi;
    }

    public void setSamedi(String samedi) {
        this.samedi = samedi;
    }

    public String getDimanche() {
        return dimanche;
    }

    public void setDimanche(String dimanche) {
        this.dimanche = dimanche;
    }

    public String getValeurAPayer() {
        return valeurAPayer;
    }

    public void setValeurAPayer(String valeurAPayer) {
        this.valeurAPayer = valeurAPayer;
    }

    public String getTotalHeuresS() {
        return totalHeuresS;
    }

    public void setTotalHeuresS(String totalHeuresS) {
        this.totalHeuresS = totalHeuresS;
    }

    public String getTotalHeureW() {
        return totalHeureW;
    }

    public void setTotalHeureW(String totalHeureW) {
        this.totalHeureW = totalHeureW;
    }

    public String getTotalHeures() {
        return totalHeures;
    }

    public void setTotalHeures(String totalHeures) {
        this.totalHeures = totalHeures;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
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

    public String getConge() {
        return conge;
    }

    public void setConge(String conge) {
        this.conge = conge;
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
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employes)) {
            return false;
        }
        Employes other = (Employes) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.supp.work.soft.shared.model.Employes[ code=" + code + " ]";
    }
    
}
