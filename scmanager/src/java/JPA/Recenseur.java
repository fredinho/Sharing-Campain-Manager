/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FREDINHO
 */
@Entity
@Table(name = "recenseur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recenseur.findAll", query = "SELECT r FROM Recenseur r"),
    @NamedQuery(name = "Recenseur.findByIDRecenseur", query = "SELECT r FROM Recenseur r WHERE r.iDRecenseur = :iDRecenseur"),
    @NamedQuery(name = "Recenseur.findByNomRecenseur", query = "SELECT r FROM Recenseur r WHERE r.nomRecenseur = :nomRecenseur"),
    @NamedQuery(name = "Recenseur.findByPrenomRecenseur", query = "SELECT r FROM Recenseur r WHERE r.prenomRecenseur = :prenomRecenseur"),
    @NamedQuery(name = "Recenseur.findByDateNaissance", query = "SELECT r FROM Recenseur r WHERE r.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Recenseur.findByNumeroCNI", query = "SELECT r FROM Recenseur r WHERE r.numeroCNI = :numeroCNI")})
public class Recenseur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Recenseur")
    private Integer iDRecenseur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nom_Recenseur")
    private String nomRecenseur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Prenom_Recenseur")
    private String prenomRecenseur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Naissance")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Numero_CNI")
    private int numeroCNI;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDRecenseur")
    private List<Menage> menageList;
    @JoinColumn(name = "ID_Quartier", referencedColumnName = "ID_Quartier")
    @ManyToOne(optional = false)
    private Quartier iDQuartier;

    public Recenseur() {
    }

    public Recenseur(Integer iDRecenseur) {
        this.iDRecenseur = iDRecenseur;
    }

    public Recenseur(Integer iDRecenseur, String nomRecenseur, String prenomRecenseur, Date dateNaissance, int numeroCNI) {
        this.iDRecenseur = iDRecenseur;
        this.nomRecenseur = nomRecenseur;
        this.prenomRecenseur = prenomRecenseur;
        this.dateNaissance = dateNaissance;
        this.numeroCNI = numeroCNI;
    }

    public Integer getIDRecenseur() {
        return iDRecenseur;
    }

    public void setIDRecenseur(Integer iDRecenseur) {
        this.iDRecenseur = iDRecenseur;
    }

    public String getNomRecenseur() {
        return nomRecenseur;
    }

    public void setNomRecenseur(String nomRecenseur) {
        this.nomRecenseur = nomRecenseur;
    }

    public String getPrenomRecenseur() {
        return prenomRecenseur;
    }

    public void setPrenomRecenseur(String prenomRecenseur) {
        this.prenomRecenseur = prenomRecenseur;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getNumeroCNI() {
        return numeroCNI;
    }

    public void setNumeroCNI(int numeroCNI) {
        this.numeroCNI = numeroCNI;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDRecenseur != null ? iDRecenseur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recenseur)) {
            return false;
        }
        Recenseur other = (Recenseur) object;
        if ((this.iDRecenseur == null && other.iDRecenseur != null) || (this.iDRecenseur != null && !this.iDRecenseur.equals(other.iDRecenseur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Recenseur[ iDRecenseur=" + iDRecenseur + " ]";
    }
    
}
