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
@Table(name = "etat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etat.findAll", query = "SELECT e FROM Etat e"),
    @NamedQuery(name = "Etat.findByIDEtat", query = "SELECT e FROM Etat e WHERE e.iDEtat = :iDEtat"),
    @NamedQuery(name = "Etat.findByNomEtat", query = "SELECT e FROM Etat e WHERE e.nomEtat = :nomEtat")})
public class Etat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Etat")
    private Integer iDEtat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nom_Etat")
    private String nomEtat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDEtat")
    private List<Campagne> campagneList;

    public Etat() {
    }

    public Etat(Integer iDEtat) {
        this.iDEtat = iDEtat;
    }

    public Etat(Integer iDEtat, String nomEtat) {
        this.iDEtat = iDEtat;
        this.nomEtat = nomEtat;
    }

    public Integer getIDEtat() {
        return iDEtat;
    }

    public void setIDEtat(Integer iDEtat) {
        this.iDEtat = iDEtat;
    }

    public String getNomEtat() {
        return nomEtat;
    }

    public void setNomEtat(String nomEtat) {
        this.nomEtat = nomEtat;
    }

    @XmlTransient
    public List<Campagne> getCampagneList() {
        return campagneList;
    }

    public void setCampagneList(List<Campagne> campagneList) {
        this.campagneList = campagneList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDEtat != null ? iDEtat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etat)) {
            return false;
        }
        Etat other = (Etat) object;
        if ((this.iDEtat == null && other.iDEtat != null) || (this.iDEtat != null && !this.iDEtat.equals(other.iDEtat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Etat[ iDEtat=" + iDEtat + " ]";
    }
    
}
