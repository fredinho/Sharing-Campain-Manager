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
@Table(name = "profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p"),
    @NamedQuery(name = "Profile.findByIDProfile", query = "SELECT p FROM Profile p WHERE p.iDProfile = :iDProfile"),
    @NamedQuery(name = "Profile.findByNomProfile", query = "SELECT p FROM Profile p WHERE p.nomProfile = :nomProfile")})
public class Profile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Profile")
    private Integer iDProfile;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nom_Profile")
    private String nomProfile;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDProfile")
    private List<Personne> personneList;

    public Profile() {
    }

    public Profile(Integer iDProfile) {
        this.iDProfile = iDProfile;
    }

    public Profile(Integer iDProfile, String nomProfile) {
        this.iDProfile = iDProfile;
        this.nomProfile = nomProfile;
    }

    public Integer getIDProfile() {
        return iDProfile;
    }

    public void setIDProfile(Integer iDProfile) {
        this.iDProfile = iDProfile;
    }

    public String getNomProfile() {
        return nomProfile;
    }

    public void setNomProfile(String nomProfile) {
        this.nomProfile = nomProfile;
    }

    @XmlTransient
    public List<Personne> getPersonneList() {
        return personneList;
    }

    public void setPersonneList(List<Personne> personneList) {
        this.personneList = personneList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDProfile != null ? iDProfile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.iDProfile == null && other.iDProfile != null) || (this.iDProfile != null && !this.iDProfile.equals(other.iDProfile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Profile[ iDProfile=" + iDProfile + " ]";
    }
    
}
