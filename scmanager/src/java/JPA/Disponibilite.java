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
@Table(name = "disponibilite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disponibilite.findAll", query = "SELECT d FROM Disponibilite d"),
    @NamedQuery(name = "Disponibilite.findByIDDisponibilite", query = "SELECT d FROM Disponibilite d WHERE d.iDDisponibilite = :iDDisponibilite"),
    @NamedQuery(name = "Disponibilite.findByNomDisponibilite", query = "SELECT d FROM Disponibilite d WHERE d.nomDisponibilite = :nomDisponibilite")})
public class Disponibilite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Disponibilite")
    private Integer iDDisponibilite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nom_Disponibilite")
    private String nomDisponibilite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDDisponibilite")
    private List<Pointretrait> pointretraitList;

    public Disponibilite() {
    }

    public Disponibilite(Integer iDDisponibilite) {
        this.iDDisponibilite = iDDisponibilite;
    }

    public Disponibilite(Integer iDDisponibilite, String nomDisponibilite) {
        this.iDDisponibilite = iDDisponibilite;
        this.nomDisponibilite = nomDisponibilite;
    }

    public Integer getIDDisponibilite() {
        return iDDisponibilite;
    }

    public void setIDDisponibilite(Integer iDDisponibilite) {
        this.iDDisponibilite = iDDisponibilite;
    }

    public String getNomDisponibilite() {
        return nomDisponibilite;
    }

    public void setNomDisponibilite(String nomDisponibilite) {
        this.nomDisponibilite = nomDisponibilite;
    }

    @XmlTransient
    public List<Pointretrait> getPointretraitList() {
        return pointretraitList;
    }

    public void setPointretraitList(List<Pointretrait> pointretraitList) {
        this.pointretraitList = pointretraitList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDDisponibilite != null ? iDDisponibilite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disponibilite)) {
            return false;
        }
        Disponibilite other = (Disponibilite) object;
        if ((this.iDDisponibilite == null && other.iDDisponibilite != null) || (this.iDDisponibilite != null && !this.iDDisponibilite.equals(other.iDDisponibilite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Disponibilite[ iDDisponibilite=" + iDDisponibilite + " ]";
    }
    
}
