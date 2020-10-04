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
@Table(name = "article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Article.findByIDArticle", query = "SELECT a FROM Article a WHERE a.iDArticle = :iDArticle"),
    @NamedQuery(name = "Article.findByDesignation", query = "SELECT a FROM Article a WHERE a.designation = :designation")})
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Article")
    private Integer iDArticle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Designation")
    private String designation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDArticle")
    private List<Campagne> campagneList;
    @JoinColumn(name = "ID_Organisme", referencedColumnName = "ID_Organisme")
    @ManyToOne(optional = false)
    private Organisme iDOrganisme;

    public Article() {
    }

    public Article(Integer iDArticle) {
        this.iDArticle = iDArticle;
    }

    public Article(Integer iDArticle, String designation) {
        this.iDArticle = iDArticle;
        this.designation = designation;
    }

    public Integer getIDArticle() {
        return iDArticle;
    }

    public void setIDArticle(Integer iDArticle) {
        this.iDArticle = iDArticle;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @XmlTransient
    public List<Campagne> getCampagneList() {
        return campagneList;
    }

    public void setCampagneList(List<Campagne> campagneList) {
        this.campagneList = campagneList;
    }

    public Organisme getIDOrganisme() {
        return iDOrganisme;
    }

    public void setIDOrganisme(Organisme iDOrganisme) {
        this.iDOrganisme = iDOrganisme;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDArticle != null ? iDArticle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.iDArticle == null && other.iDArticle != null) || (this.iDArticle != null && !this.iDArticle.equals(other.iDArticle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Article[ iDArticle=" + iDArticle + " ]";
    }
    
}
