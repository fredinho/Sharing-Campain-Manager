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
@Table(name = "organisme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organisme.findAll", query = "SELECT o FROM Organisme o"),
    @NamedQuery(name = "Organisme.findByIDOrganisme", query = "SELECT o FROM Organisme o WHERE o.iDOrganisme = :iDOrganisme"),
    @NamedQuery(name = "Organisme.findByNomOrganisme", query = "SELECT o FROM Organisme o WHERE o.nomOrganisme = :nomOrganisme"),
    @NamedQuery(name = "Organisme.findByResidence", query = "SELECT o FROM Organisme o WHERE o.residence = :residence")})
public class Organisme implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Organisme")
    private Integer iDOrganisme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nom_Organisme")
    private String nomOrganisme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Residence")
    private String residence;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDOrganisme")
    private List<Campagne> campagneList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDOrganisme")
    private List<Article> articleList;

    public Organisme() {
    }

    public Organisme(Integer iDOrganisme) {
        this.iDOrganisme = iDOrganisme;
    }

    public Organisme(Integer iDOrganisme, String nomOrganisme, String residence) {
        this.iDOrganisme = iDOrganisme;
        this.nomOrganisme = nomOrganisme;
        this.residence = residence;
    }

    public Integer getIDOrganisme() {
        return iDOrganisme;
    }

    public void setIDOrganisme(Integer iDOrganisme) {
        this.iDOrganisme = iDOrganisme;
    }

    public String getNomOrganisme() {
        return nomOrganisme;
    }

    public void setNomOrganisme(String nomOrganisme) {
        this.nomOrganisme = nomOrganisme;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    @XmlTransient
    public List<Campagne> getCampagneList() {
        return campagneList;
    }

    public void setCampagneList(List<Campagne> campagneList) {
        this.campagneList = campagneList;
    }

    @XmlTransient
    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDOrganisme != null ? iDOrganisme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organisme)) {
            return false;
        }
        Organisme other = (Organisme) object;
        if ((this.iDOrganisme == null && other.iDOrganisme != null) || (this.iDOrganisme != null && !this.iDOrganisme.equals(other.iDOrganisme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Organisme[ iDOrganisme=" + iDOrganisme + " ]";
    }
    
}
