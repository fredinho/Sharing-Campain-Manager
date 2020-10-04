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
@Table(name = "pointretrait")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pointretrait.findAll", query = "SELECT p FROM Pointretrait p"),
    @NamedQuery(name = "Pointretrait.findByIDPointRetrait", query = "SELECT p FROM Pointretrait p WHERE p.iDPointRetrait = :iDPointRetrait"),
    @NamedQuery(name = "Pointretrait.findByIDDisponibilite", query = "SELECT p FROM Pointretrait p WHERE p.iDDisponibilite = :iDDisponibilite"),
    @NamedQuery(name = "Pointretrait.findByNomPointRetrait", query = "SELECT p FROM Pointretrait p WHERE p.nomPointRetrait = :nomPointRetrait")})
public class Pointretrait implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PointRetrait")
    private Integer iDPointRetrait;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nom_PointRetrait")
    private String nomPointRetrait;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDPointRetrait")
    private List<Menage> menageList;
    @JoinColumn(name = "ID_Quartier", referencedColumnName = "ID_Quartier")
    @ManyToOne(optional = false)
    private Quartier iDQuartier;
    @JoinColumn(name = "ID_Disponibilite", referencedColumnName = "ID_Disponibilite")
    @ManyToOne(optional = false)
    private Disponibilite iDDisponibilite;

    public Pointretrait() {
    }

    public Pointretrait(Integer iDPointRetrait) {
        this.iDPointRetrait = iDPointRetrait;
    }

    public Pointretrait(Integer iDPointRetrait, String nomPointRetrait) {
        this.iDPointRetrait = iDPointRetrait;
        this.nomPointRetrait = nomPointRetrait;
    }

    public Integer getIDPointRetrait() {
        return iDPointRetrait;
    }

    public void setIDPointRetrait(Integer iDPointRetrait) {
        this.iDPointRetrait = iDPointRetrait;
    }

    public String getNomPointRetrait() {
        return nomPointRetrait;
    }

    public void setNomPointRetrait(String nomPointRetrait) {
        this.nomPointRetrait = nomPointRetrait;
    }

    @XmlTransient
    public List<Menage> getMenageList() {
        return menageList;
    }

    public void setMenageList(List<Menage> menageList) {
        this.menageList = menageList;
    }

    public Quartier getIDQuartier() {
        return iDQuartier;
    }

    public void setIDQuartier(Quartier iDQuartier) {
        this.iDQuartier = iDQuartier;
    }

    public Disponibilite getIDDisponibilite() {
        return iDDisponibilite;
    }

    public void setIDDisponibilite(Disponibilite iDDisponibilite) {
        this.iDDisponibilite = iDDisponibilite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDPointRetrait != null ? iDPointRetrait.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pointretrait)) {
            return false;
        }
        Pointretrait other = (Pointretrait) object;
        if ((this.iDPointRetrait == null && other.iDPointRetrait != null) || (this.iDPointRetrait != null && !this.iDPointRetrait.equals(other.iDPointRetrait))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Pointretrait[ iDPointRetrait=" + iDPointRetrait + " ]";
    }
    
}
