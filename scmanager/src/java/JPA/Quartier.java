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
@Table(name = "quartier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quartier.findAll", query = "SELECT q FROM Quartier q"),
    @NamedQuery(name = "Quartier.findByIDQuartier", query = "SELECT q FROM Quartier q WHERE q.iDQuartier = :iDQuartier"),
    @NamedQuery(name = "Quartier.findByNomQuartier", query = "SELECT q FROM Quartier q WHERE q.nomQuartier = :nomQuartier")})
public class Quartier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Quartier")
    private Integer iDQuartier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nom_Quartier")
    private String nomQuartier;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDQuartier")
    private List<Pointretrait> pointretraitList;
    @JoinColumn(name = "ID_Arrondissement", referencedColumnName = "ID_Arrondissement")
    @ManyToOne(optional = false)
    private Arrondissement iDArrondissement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDQuartier")
    private List<Recenseur> recenseurList;

    public Quartier() {
    }

    public Quartier(Integer iDQuartier) {
        this.iDQuartier = iDQuartier;
    }

    public Quartier(Integer iDQuartier, String nomQuartier) {
        this.iDQuartier = iDQuartier;
        this.nomQuartier = nomQuartier;
    }

    public Integer getIDQuartier() {
        return iDQuartier;
    }

    public void setIDQuartier(Integer iDQuartier) {
        this.iDQuartier = iDQuartier;
    }

    public String getNomQuartier() {
        return nomQuartier;
    }

    public void setNomQuartier(String nomQuartier) {
        this.nomQuartier = nomQuartier;
    }

    @XmlTransient
    public List<Pointretrait> getPointretraitList() {
        return pointretraitList;
    }

    public void setPointretraitList(List<Pointretrait> pointretraitList) {
        this.pointretraitList = pointretraitList;
    }

    public Arrondissement getIDArrondissement() {
        return iDArrondissement;
    }

    public void setIDArrondissement(Arrondissement iDArrondissement) {
        this.iDArrondissement = iDArrondissement;
    }

    @XmlTransient
    public List<Recenseur> getRecenseurList() {
        return recenseurList;
    }

    public void setRecenseurList(List<Recenseur> recenseurList) {
        this.recenseurList = recenseurList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDQuartier != null ? iDQuartier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quartier)) {
            return false;
        }
        Quartier other = (Quartier) object;
        if ((this.iDQuartier == null && other.iDQuartier != null) || (this.iDQuartier != null && !this.iDQuartier.equals(other.iDQuartier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Quartier[ iDQuartier=" + iDQuartier + " ]";
    }
    
}
