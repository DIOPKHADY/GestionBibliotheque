/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "livres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livre.findAll", query = "SELECT l FROM Livre l")
    , @NamedQuery(name = "Livre.findById", query = "SELECT l FROM Livre l WHERE l.id = :id")
    , @NamedQuery(name = "Livre.findByTitre", query = "SELECT l FROM Livre l WHERE l.titre = :titre")
    , @NamedQuery(name = "Livre.findByAuteur", query = "SELECT l FROM Livre l WHERE l.auteur = :auteur")
    , @NamedQuery(name = "Livre.findByAnneePublication", query = "SELECT l FROM Livre l WHERE l.anneePublication = :anneePublication")
    , @NamedQuery(name = "Livre.findByGenre", query = "SELECT l FROM Livre l WHERE l.genre = :genre")
    , @NamedQuery(name = "Livre.findByQuantite", query = "SELECT l FROM Livre l WHERE l.quantite = :quantite")
    , @NamedQuery(name = "Livre.findByQuantiteDisponible", query = "SELECT l FROM Livre l WHERE l.quantiteDisponible = :quantiteDisponible")
    , @NamedQuery(name = "Livre.findByIsActive", query = "SELECT l FROM Livre l WHERE l.isActive = :isActive")})
public class Livre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Titre")
    private String titre;
    @Basic(optional = false)
    @Column(name = "Auteur")
    private String auteur;
    @Basic(optional = false)
    @Column(name = "AnneePublication")
    private int anneePublication;
    @Basic(optional = false)
    @Column(name = "Genre")
    private String genre;
    @Basic(optional = false)
    @Column(name = "Quantite")
    private int quantite;
    @Basic(optional = false)
    @Column(name = "QuantiteDisponible")
    private int quantiteDisponible;
    @Basic(optional = false)
    @Column(name = "IsActive")
    private boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "livreID", fetch = FetchType.EAGER)
    private List<Reservation> reservationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "livreID", fetch = FetchType.EAGER)
    private List<Emprunt> empruntList;

    public Livre() {
    }

    public Livre(Integer id) {
        this.id = id;
    }

    public Livre(Integer id, String titre, String auteur, int anneePublication, String genre, int quantite, int quantiteDisponible, boolean isActive) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.genre = genre;
        this.quantite = quantite;
        this.quantiteDisponible = quantiteDisponible;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    public void setAnneePublication(int anneePublication) {
        this.anneePublication = anneePublication;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getQuantiteDisponible() {
        return quantiteDisponible;
    }

    public void setQuantiteDisponible(int quantiteDisponible) {
        this.quantiteDisponible = quantiteDisponible;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @XmlTransient
    public List<Emprunt> getEmpruntList() {
        return empruntList;
    }

    public void setEmpruntList(List<Emprunt> empruntList) {
        this.empruntList = empruntList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livre)) {
            return false;
        }
        Livre other = (Livre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Livre[ id=" + id + " ]";
    }
    
}
