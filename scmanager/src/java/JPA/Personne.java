/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FREDINHO
 */
@Entity
@Table(name = "personne")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p"),
    @NamedQuery(name = "Personne.findByIDPersonne", query = "SELECT p FROM Personne p WHERE p.iDPersonne = :iDPersonne"),
    @NamedQuery(name = "Personne.findByNompersonne", query = "SELECT p FROM Personne p WHERE p.nompersonne = :nompersonne"),
    @NamedQuery(name = "Personne.findByPrenomPersonne", query = "SELECT p FROM Personne p WHERE p.prenomPersonne = :prenomPersonne"),
    @NamedQuery(name = "Personne.findByDateNaissance", query = "SELECT p FROM Personne p WHERE p.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Personne.findByPseudo", query = "SELECT p FROM Personne p WHERE p.pseudo = :pseudo"),
    @NamedQuery(name = "Personne.findByPassword", query = "SELECT p FROM Personne p WHERE p.password = :password"),
    @NamedQuery(name = "Personne.findByConnection", query = "SELECT p FROM Personne p WHERE p.pseudo = :pseudo AND p.password = :pass"),
    @NamedQuery(name = "Personne.findByEmail", query = "SELECT p FROM Personne p WHERE p.email = :email")})
public class Personne implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Personne")
    private Integer iDPersonne;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nom_personne")
    private String nompersonne;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Prenom_Personne")
    private String prenomPersonne;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Naissance")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Pseudo")
    private String pseudo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "ID_Profile", referencedColumnName = "ID_Profile")
    @ManyToOne(optional = false)
    private Profile iDProfile;
    @JoinColumn(name = "ID_Arrondissement", referencedColumnName = "ID_Arrondissement")
    @ManyToOne(optional = false)
    private Arrondissement iDArrondissement;

    public Personne() {
    }

    public Personne(Integer iDPersonne) {
        this.iDPersonne = iDPersonne;
    }

    public Personne(Integer iDPersonne, String nompersonne, String prenomPersonne, Date dateNaissance, String pseudo, String password, String email) {
        this.iDPersonne = iDPersonne;
        this.nompersonne = nompersonne;
        this.prenomPersonne = prenomPersonne;
        this.dateNaissance = dateNaissance;
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
    }

    public Integer getIDPersonne() {
        return iDPersonne;
    }

    public void setIDPersonne(Integer iDPersonne) {
        this.iDPersonne = iDPersonne;
    }

    public String getNompersonne() {
        return nompersonne;
    }

    public void setNompersonne(String nompersonne) {
        this.nompersonne = nompersonne;
    }

    public String getPrenomPersonne() {
        return prenomPersonne;
    }

    public void setPrenomPersonne(String prenomPersonne) {
        this.prenomPersonne = prenomPersonne;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profile getIDProfile() {
        return iDProfile;
    }

    public void setIDProfile(Profile iDProfile) {
        this.iDProfile = iDProfile;
    }

    public Arrondissement getIDArrondissement() {
        return iDArrondissement;
    }

    public void setIDArrondissement(Arrondissement iDArrondissement) {
        this.iDArrondissement = iDArrondissement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDPersonne != null ? iDPersonne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.iDPersonne == null && other.iDPersonne != null) || (this.iDPersonne != null && !this.iDPersonne.equals(other.iDPersonne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Personne[ iDPersonne=" + iDPersonne + " ]";
    }
    
}
