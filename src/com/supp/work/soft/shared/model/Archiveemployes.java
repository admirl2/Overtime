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
@Table(name = "Archiveemployes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Archiveemployes.findAll", query = "SELECT a FROM Archiveemployes a"),
    @NamedQuery(name = "Archiveemployes.findByCode", query = "SELECT a FROM Archiveemployes a WHERE a.archiveemployesPK.code = :code"),
    @NamedQuery(name = "Archiveemployes.findByNom", query = "SELECT a FROM Archiveemployes a WHERE a.nom = :nom"),
    @NamedQuery(name = "Archiveemployes.findByPrenom", query = "SELECT a FROM Archiveemployes a WHERE a.prenom = :prenom"),
    @NamedQuery(name = "Archiveemployes.findBySalaire", query = "SELECT a FROM Archiveemployes a WHERE a.salaire = :salaire"),
    @NamedQuery(name = "Archiveemployes.findByFonction", query = "SELECT a FROM Archiveemployes a WHERE a.fonction = :fonction"),
    @NamedQuery(name = "Archiveemployes.findByHoraireRegulier", query = "SELECT a FROM Archiveemployes a WHERE a.horaireRegulier = :horaireRegulier"),
    @NamedQuery(name = "Archiveemployes.findByLundi", query = "SELECT a FROM Archiveemployes a WHERE a.lundi = :lundi"),
    @NamedQuery(name = "Archiveemployes.findByMardi", query = "SELECT a FROM Archiveemployes a WHERE a.mardi = :mardi"),
    @NamedQuery(name = "Archiveemployes.findByMercredi", query = "SELECT a FROM Archiveemployes a WHERE a.mercredi = :mercredi"),
    @NamedQuery(name = "Archiveemployes.findByJeudi", query = "SELECT a FROM Archiveemployes a WHERE a.jeudi = :jeudi"),
    @NamedQuery(name = "Archiveemployes.findByVendredi", query = "SELECT a FROM Archiveemployes a WHERE a.vendredi = :vendredi"),
    @NamedQuery(name = "Archiveemployes.findBySamedi", query = "SELECT a FROM Archiveemployes a WHERE a.samedi = :samedi"),
    @NamedQuery(name = "Archiveemployes.findByDimanche", query = "SELECT a FROM Archiveemployes a WHERE a.dimanche = :dimanche"),
    @NamedQuery(name = "Archiveemployes.findByValeurAPayer", query = "SELECT a FROM Archiveemployes a WHERE a.valeurAPayer = :valeurAPayer"),
    @NamedQuery(name = "Archiveemployes.findByTotalHeuresS", query = "SELECT a FROM Archiveemployes a WHERE a.totalHeuresS = :totalHeuresS"),
    @NamedQuery(name = "Archiveemployes.findByTotalHeureW", query = "SELECT a FROM Archiveemployes a WHERE a.totalHeureW = :totalHeureW"),
    @NamedQuery(name = "Archiveemployes.findByTotalHeures", query = "SELECT a FROM Archiveemployes a WHERE a.totalHeures = :totalHeures"),
    @NamedQuery(name = "Archiveemployes.findByRaison", query = "SELECT a FROM Archiveemployes a WHERE a.raison = :raison"),
    @NamedQuery(name = "Archiveemployes.findByMois", query = "SELECT a FROM Archiveemployes a WHERE a.archiveemployesPK.mois = :mois"),
    @NamedQuery(name = "Archiveemployes.findByDirection", query = "SELECT a FROM Archiveemployes a WHERE a.direction = :direction"),
    @NamedQuery(name = "Archiveemployes.findByService", query = "SELECT a FROM Archiveemployes a WHERE a.service = :service"),
    @NamedQuery(name = "Archiveemployes.findByCreerPar", query = "SELECT a FROM Archiveemployes a WHERE a.creerPar = :creerPar"),
    @NamedQuery(name = "Archiveemployes.findByCreerLe", query = "SELECT a FROM Archiveemployes a WHERE a.creerLe = :creerLe"),
    @NamedQuery(name = "Archiveemployes.findByModifierPar", query = "SELECT a FROM Archiveemployes a WHERE a.modifierPar = :modifierPar"),
    @NamedQuery(name = "Archiveemployes.findByModifierLe", query = "SELECT a FROM Archiveemployes a WHERE a.modifierLe = :modifierLe"),
    @NamedQuery(name = "Archiveemployes.findByConge", query = "SELECT a FROM Archiveemployes a WHERE a.conge = :conge"),
    @NamedQuery(name = "Archiveemployes.findByAnnee", query = "SELECT a FROM Archiveemployes a WHERE a.archiveemployesPK.annee = :annee")})
public class Archiveemployes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArchiveemployesPK archiveemployesPK;
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

    public Archiveemployes() {
    }

    public Archiveemployes(ArchiveemployesPK archiveemployesPK) {
        this.archiveemployesPK = archiveemployesPK;
    }

    public Archiveemployes(ArchiveemployesPK archiveemployesPK, String creerPar, String creerLe) {
        this.archiveemployesPK = archiveemployesPK;
        this.creerPar = creerPar;
        this.creerLe = creerLe;
    }

    public Archiveemployes(String code, String mois, String annee) {
        this.archiveemployesPK = new ArchiveemployesPK(code, mois, annee);
    }

    public ArchiveemployesPK getArchiveemployesPK() {
        return archiveemployesPK;
    }

    public void setArchiveemployesPK(ArchiveemployesPK archiveemployesPK) {
        this.archiveemployesPK = archiveemployesPK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (archiveemployesPK != null ? archiveemployesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Archiveemployes)) {
            return false;
        }
        Archiveemployes other = (Archiveemployes) object;
        if ((this.archiveemployesPK == null && other.archiveemployesPK != null) || (this.archiveemployesPK != null && !this.archiveemployesPK.equals(other.archiveemployesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.supp.work.soft.shared.model.Archiveemployes[ archiveemployesPK=" + archiveemployesPK + " ]";
    }
    
}
