/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FREDINHO
 */
@Entity
@Table(name = "menage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menage.findAll", query = "SELECT m FROM Menage m"),
    //FrankNBF
    @NamedQuery(name = "Menage.findByProvince", query = "SELECT m FROM Menage m WHERE m.iDPointRetrait.iDQuartier.iDArrondissement.iDDepartement.iDProvince = :iDProvince"),
    @NamedQuery(name = "Menage.findByIDMenage", query = "SELECT m FROM Menage m WHERE m.iDMenage = :iDMenage"),
    @NamedQuery(name = "Menage.findByNomRepresentant", query = "SELECT m FROM Menage m WHERE m.nomRepresentant = :nomRepresentant"),
    @NamedQuery(name = "Menage.findByNumeroCNI", query = "SELECT m FROM Menage m WHERE m.numeroCNI = :numeroCNI"),
    @NamedQuery(name = "Menage.findByNombreResidant", query = "SELECT m FROM Menage m WHERE m.nombreResidant = :nombreResidant"),
    @NamedQuery(name = "Menage.findByNombreExemplaire", query = "SELECT m FROM Menage m WHERE m.nombreExemplaire = :nombreExemplaire")})
public class Menage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Menage")
    private Integer iDMenage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nom_Representant")
    private String nomRepresentant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Numero_CNI")
    private int numeroCNI;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Nombre_Residant")
    private int nombreResidant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Nombre_Exemplaire")
    private int nombreExemplaire;
    @JoinColumn(name = "ID_Statut", referencedColumnName = "ID_Statut")
    @ManyToOne(optional = false)
    private Statut iDStatut;
    @JoinColumn(name = "ID_Recenseur", referencedColumnName = "ID_Recenseur")
    @ManyToOne(optional = false)
    private Recenseur iDRecenseur;
    @JoinColumn(name = "ID_PointRetrait", referencedColumnName = "ID_PointRetrait")
    @ManyToOne(optional = false)
    private Pointretrait iDPointRetrait;

    public Menage() {
    }

    public Menage(Integer iDMenage) {
        this.iDMenage = iDMenage;
    }

    public Menage(Integer iDMenage, String nomRepresentant, int numeroCNI, int nombreResidant, int nombreExemplaire) {
        this.iDMenage = iDMenage;
        this.nomRepresentant = nomRepresentant;
        this.numeroCNI = numeroCNI;
        this.nombreResidant = nombreResidant;
        this.nombreExemplaire = nombreExemplaire;
    }

    public Integer getIDMenage() {
        return iDMenage;
    }

    public void setIDMenage(Integer iDMenage) {
        this.iDMenage = iDMenage;
    }

    public String getNomRepresentant() {
        return nomRepresentant;
    }

    public void setNomRepresentant(String nomRepresentant) {
        this.nomRepresentant = nomRepresentant;
    }

    public int getNumeroCNI() {
        return numeroCNI;
    }

    public void setNumeroCNI(int numeroCNI) {
        this.numeroCNI = numeroCNI;
    }

    public int getNombreResidant() {
        return nombreResidant;
    }

    public void setNombreResidant(int nombreResidant) {
        this.nombreResidant = nombreResidant;
    }

    public int getNombreExemplaire() {
        return nombreExemplaire;
    }

    public void setNombreExemplaire(int nombreExemplaire) {
        this.nombreExemplaire = nombreExemplaire;
    }

    public Statut getIDStatut() {
        return iDStatut;
    }

    public void setIDStatut(Statut iDStatut) {
        this.iDStatut = iDStatut;
    }

    public Recenseur getIDRecenseur() {
        return iDRecenseur;
    }

    public void setIDRecenseur(Recenseur iDRecenseur) {
        this.iDRecenseur = iDRecenseur;
    }

    public Pointretrait getIDPointRetrait() {
        return iDPointRetrait;
    }

    public void setIDPointRetrait(Pointretrait iDPointRetrait) {
        this.iDPointRetrait = iDPointRetrait;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDMenage != null ? iDMenage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menage)) {
            return false;
        }
        Menage other = (Menage) object;
        if ((this.iDMenage == null && other.iDMenage != null) || (this.iDMenage != null && !this.iDMenage.equals(other.iDMenage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Menage[ iDMenage=" + iDMenage + " ]";
    }
    
}
