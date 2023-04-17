/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "auteurs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auteur.findAll", query = "SELECT a FROM Auteur a")
    , @NamedQuery(name = "Auteur.findByIDAuteur", query = "SELECT a FROM Auteur a WHERE a.iDAuteur = :iDAuteur")
    , @NamedQuery(name = "Auteur.findByNomauteur", query = "SELECT a FROM Auteur a WHERE a.nomauteur = :nomauteur")
    , @NamedQuery(name = "Auteur.findByNationalite", query = "SELECT a FROM Auteur a WHERE a.nationalite = :nationalite")
    , @NamedQuery(name = "Auteur.findByDatenaissance", query = "SELECT a FROM Auteur a WHERE a.datenaissance = :datenaissance")})
public class Auteur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_Auteur")
    private Integer iDAuteur;
    @Column(name = "Nom_auteur")
    private String nomauteur;
    @Column(name = "Nationalite")
    private String nationalite;
    @Column(name = "Date_naissance")
    @Temporal(TemporalType.DATE)
    private Date datenaissance;

    public Auteur() {
    }

    public Auteur(Integer iDAuteur) {
        this.iDAuteur = iDAuteur;
    }

    public Integer getIDAuteur() {
        return iDAuteur;
    }

    public void setIDAuteur(Integer iDAuteur) {
        this.iDAuteur = iDAuteur;
    }

    public String getNomauteur() {
        return nomauteur;
    }

    public void setNomauteur(String nomauteur) {
        this.nomauteur = nomauteur;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDAuteur != null ? iDAuteur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auteur)) {
            return false;
        }
        Auteur other = (Auteur) object;
        if ((this.iDAuteur == null && other.iDAuteur != null) || (this.iDAuteur != null && !this.iDAuteur.equals(other.iDAuteur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Auteur[ iDAuteur=" + iDAuteur + " ]";
    }
    
}
