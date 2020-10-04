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
@Table(name = "arrondissement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arrondissement.findAll", query = "SELECT a FROM Arrondissement a"),
    @NamedQuery(name = "Arrondissement.findByIDArrondissement", query = "SELECT a FROM Arrondissement a WHERE a.iDArrondissement = :iDArrondissement"),
    @NamedQuery(name = "Arrondissement.findByNomArrondissement", query = "SELECT a FROM Arrondissement a WHERE a.nomArrondissement = :nomArrondissement")})
public class Arrondissement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Arrondissement")
    private Integer iDArrondissement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nom_Arrondissement")
    private String nomArrondissement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDArrondissement")
    private List<Personne> personneList;
    @JoinColumn(name = "ID_Departement", referencedColumnName = "ID_Departement")
    @ManyToOne(optional = false)
    private Departement iDDepartement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDArrondissement")
    private List<Quartier> quartierList;

    public Arrondissement() {
    }

    public Arrondissement(Integer iDArrondissement) {
        this.iDArrondissement = iDArrondissement;
    }

    public Arrondissement(Integer iDArrondissement, String nomArrondissement) {
        this.iDArrondissement = iDArrondissement;
        this.nomArrondissement = nomArrondissement;
    }

    public Integer getIDArrondissement() {
        return iDArrondissement;
    }

    public void setIDArrondissement(Integer iDArrondissement) {
        this.iDArrondissement = iDArrondissement;
    }

    public String getNomArrondissement() {
        return nomArrondissement;
    }

    public void setNomArrondissement(String nomArrondissement) {
        this.nomArrondissement = nomArrondissement;
    }

    @XmlTransient
    public List<Personne> getPersonneList() {
        return personneList;
    }

    public void setPersonneList(List<Personne> personneList) {
        this.personneList = personneList;
    }

    public Departement getIDDepartement() {
        return iDDepartement;
    }

    public void setIDDepartement(Departement iDDepartement) {
        this.iDDepartement = iDDepartement;
    }

    @XmlTransient
    public List<Quartier> getQuartierList() {
        return quartierList;
    }

    public void setQuartierList(List<Quartier> quartierList) {
        this.quartierList = quartierList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDArrondissement != null ? iDArrondissement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arrondissement)) {
            return false;
        }
        Arrondissement other = (Arrondissement) object;
        if ((this.iDArrondissement == null && other.iDArrondissement != null) || (this.iDArrondissement != null && !this.iDArrondissement.equals(other.iDArrondissement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Arrondissement[ iDArrondissement=" + iDArrondissement + " ]";
    }
    
}
