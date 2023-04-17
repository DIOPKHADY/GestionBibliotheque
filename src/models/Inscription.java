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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import models.Utilisateurs;
/**
 *
 * @author HP
 */
@Entity
@Table(name = "inscription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscription.findAll", query = "SELECT i FROM Inscription i")
    , @NamedQuery(name = "Inscription.findById", query = "SELECT i FROM Inscription i WHERE i.id = :id")
    , @NamedQuery(name = "Inscription.findByStatut", query = "SELECT i FROM Inscription i WHERE i.statut = :statut")
    , @NamedQuery(name = "Inscription.findByDateInscription", query = "SELECT i FROM Inscription i WHERE i.dateInscription = :dateInscription")})
public class Inscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "statut")
    private String statut;
    @Basic(optional = false)
    @Column(name = "date_inscription")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateInscription;
    @JoinColumn(name = "utilisateurs_id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Utilisateurs utilisateursId;

    public Inscription() {
    }

    public Inscription(Integer id) {
        this.id = id;
    }

    public Inscription(Integer id, String statut, Date dateInscription) {
        this.id = id;
        this.statut = statut;
        this.dateInscription = dateInscription;
    }

//    public Inscription(Date date, String nouveau, int id, Utilisateur u) {
//    }

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Utilisateurs getUtilisateursId() {
        return utilisateursId;
    }

    public void setUtilisateursId(Utilisateurs utilisateursId) {
        this.utilisateursId = utilisateursId;
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
        if (!(object instanceof Inscription)) {
            return false;
        }
        Inscription other = (Inscription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Inscription[ id=" + id + " ]";
    }
    
}
