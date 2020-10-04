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
@Table(name = "province")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Province.findAll", query = "SELECT p FROM Province p"),
    @NamedQuery(name = "Province.findByIDProvince", query = "SELECT p FROM Province p WHERE p.iDProvince = :iDProvince"),
    @NamedQuery(name = "Province.findByNomProvince", query = "SELECT p FROM Province p WHERE p.nomProvince = :nomProvince")})
public class Province implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Province")
    private Integer iDProvince;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nom_Province")
    private String nomProvince;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDProvince")
    private List<Departement> departementList;

    public Province() {
    }

    public Province(Integer iDProvince) {
        this.iDProvince = iDProvince;
    }

    public Province(Integer iDProvince, String nomProvince) {
        this.iDProvince = iDProvince;
        this.nomProvince = nomProvince;
    }

    public Integer getIDProvince() {
        return iDProvince;
    }

    public void setIDProvince(Integer iDProvince) {
        this.iDProvince = iDProvince;
    }

    public String getNomProvince() {
        return nomProvince;
    }

    public void setNomProvince(String nomProvince) {
        this.nomProvince = nomProvince;
    }

    @XmlTransient
    public List<Departement> getDepartementList() {
        return departementList;
    }

    public void setDepartementList(List<Departement> departementList) {
        this.departementList = departementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDProvince != null ? iDProvince.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Province)) {
            return false;
        }
        Province other = (Province) object;
        if ((this.iDProvince == null && other.iDProvince != null) || (this.iDProvince != null && !this.iDProvince.equals(other.iDProvince))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Province[ iDProvince=" + iDProvince + " ]";
    }
    
}
