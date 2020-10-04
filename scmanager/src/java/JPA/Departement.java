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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "departement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departement.findAll", query = "SELECT d FROM Departement d"),
    @NamedQuery(name = "Departement.findByIDDepartement", query = "SELECT d FROM Departement d WHERE d.iDDepartement = :iDDepartement"),
    @NamedQuery(name = "Departement.findByNomDepartement", query = "SELECT d FROM Departement d WHERE d.nomDepartement = :nomDepartement")})
public class Departement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Departement")
    private Integer iDDepartement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nom_Departement")
    private String nomDepartement;
    @JoinColumn(name = "ID_Province", referencedColumnName = "ID_Province")
    @ManyToOne(optional = false)
    private Province iDProvince;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDDepartement")
    private List<Arrondissement> arrondissementList;

    public Departement() {
    }

    public Departement(Integer iDDepartement) {
        this.iDDepartement = iDDepartement;
    }

    public Departement(Integer iDDepartement, String nomDepartement) {
        this.iDDepartement = iDDepartement;
        this.nomDepartement = nomDepartement;
    }

    public Integer getIDDepartement() {
        return iDDepartement;
    }

    public void setIDDepartement(Integer iDDepartement) {
        this.iDDepartement = iDDepartement;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    public Province getIDProvince() {
        return iDProvince;
    }

    public void setIDProvince(Province iDProvince) {
        this.iDProvince = iDProvince;
    }

    @XmlTransient
    public List<Arrondissement> getArrondissementList() {
        return arrondissementList;
    }

    public void setArrondissementList(List<Arrondissement> arrondissementList) {
        this.arrondissementList = arrondissementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDDepartement != null ? iDDepartement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departement)) {
            return false;
        }
        Departement other = (Departement) object;
        if ((this.iDDepartement == null && other.iDDepartement != null) || (this.iDDepartement != null && !this.iDDepartement.equals(other.iDDepartement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Departement[ iDDepartement=" + iDDepartement + " ]";
    }
    
}
