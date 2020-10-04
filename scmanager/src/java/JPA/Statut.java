/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FREDINHO
 */
@Entity
@Table(name = "statut")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statut.findAll", query = "SELECT s FROM Statut s"),
    @NamedQuery(name = "Statut.findByIDStatut", query = "SELECT s FROM Statut s WHERE s.iDStatut = :iDStatut"),
    @NamedQuery(name = "Statut.findByNomStatut", query = "SELECT s FROM Statut s WHERE s.nomStatut = :nomStatut")})
public class Statut implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Statut")
    private Integer iDStatut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nom_Statut")
    private String nomStatut;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDStatut")
    private List<Menage> menageList;

    public Statut() {
    }

    public Statut(Integer iDStatut) {
        this.iDStatut = iDStatut;
    }

    public Statut(Integer iDStatut, String nomStatut) {
        this.iDStatut = iDStatut;
        this.nomStatut = nomStatut;
    }

    public Integer getIDStatut() {
        return iDStatut;
    }

    public void setIDStatut(Integer iDStatut) {
        this.iDStatut = iDStatut;
    }

    public String getNomStatut() {
        return nomStatut;
    }

    public void setNomStatut(String nomStatut) {
        this.nomStatut = nomStatut;
    }

    @XmlTransient
    public List<Menage> getMenageList() {
        return menageList;
    }

    public void setMenageList(List<Menage> menageList) {
        this.menageList = menageList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDStatut != null ? iDStatut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statut)) {
            return false;
        }
        Statut other = (Statut) object;
        if ((this.iDStatut == null && other.iDStatut != null) || (this.iDStatut != null && !this.iDStatut.equals(other.iDStatut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Statut[ iDStatut=" + iDStatut + " ]";
    }
    
}
