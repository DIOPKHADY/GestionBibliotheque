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

/**
 *
 * @author HP
 */
@Entity
@Table(name = "emprunts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emprunt.findAll", query = "SELECT e FROM Emprunt e")
    , @NamedQuery(name = "Emprunt.findById", query = "SELECT e FROM Emprunt e WHERE e.id = :id")
    , @NamedQuery(name = "Emprunt.findByDateEmprunt", query = "SELECT e FROM Emprunt e WHERE e.dateEmprunt = :dateEmprunt")
    , @NamedQuery(name = "Emprunt.findByDateRetourPrevu", query = "SELECT e FROM Emprunt e WHERE e.dateRetourPrevu = :dateRetourPrevu")
    , @NamedQuery(name = "Emprunt.findByDateRetourEffective", query = "SELECT e FROM Emprunt e WHERE e.dateRetourEffective = :dateRetourEffective")})
public class Emprunt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DateEmprunt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEmprunt;
    @Basic(optional = false)
    @Column(name = "DateRetourPrevu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRetourPrevu;
    @Column(name = "DateRetourEffective")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRetourEffective;
    @JoinColumn(name = "ClientID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Client clientID;
    @JoinColumn(name = "LivreID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Livre livreID;

    public Emprunt() {
    }

    public Emprunt(Integer id) {
        this.id = id;
    }

    public Emprunt(Integer id, Date dateEmprunt, Date dateRetourPrevu) {
        this.id = id;
        this.dateEmprunt = dateEmprunt;
        this.dateRetourPrevu = dateRetourPrevu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRetourPrevu() {
        return dateRetourPrevu;
    }

    public void setDateRetourPrevu(Date dateRetourPrevu) {
        this.dateRetourPrevu = dateRetourPrevu;
    }

    public Date getDateRetourEffective() {
        return dateRetourEffective;
    }

    public void setDateRetourEffective(Date dateRetourEffective) {
        this.dateRetourEffective = dateRetourEffective;
    }

    public Client getClientID() {
        return clientID;
    }

    public void setClientID(Client clientID) {
        this.clientID = clientID;
    }

    public Livre getLivreID() {
        return livreID;
    }

    public void setLivreID(Livre livreID) {
        this.livreID = livreID;
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
        if (!(object instanceof Emprunt)) {
            return false;
        }
        Emprunt other = (Emprunt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Emprunt[ id=" + id + " ]";
    }
    
}
