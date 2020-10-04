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
@Table(name = "campagne")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campagne.findAll", query = "SELECT c FROM Campagne c"),
    @NamedQuery(name = "Campagne.findByIDCampagne", query = "SELECT c FROM Campagne c WHERE c.iDCampagne = :iDCampagne"),
    @NamedQuery(name = "Campagne.findByDescription", query = "SELECT c FROM Campagne c WHERE c.description = :description"),
    @NamedQuery(name = "Campagne.findByDateDebut", query = "SELECT c FROM Campagne c WHERE c.dateDebut = :dateDebut"),
    @NamedQuery(name = "Campagne.findByDateFin", query = "SELECT c FROM Campagne c WHERE c.dateFin = :dateFin")})
public class Campagne implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Campagne")
    private Integer iDCampagne;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Debut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @JoinColumn(name = "ID_Organisme", referencedColumnName = "ID_Organisme")
    @ManyToOne(optional = false)
    private Organisme iDOrganisme;
    @JoinColumn(name = "ID_Etat", referencedColumnName = "ID_Etat")
    @ManyToOne(optional = false)
    private Etat iDEtat;
    @JoinColumn(name = "ID_Article", referencedColumnName = "ID_Article")
    @ManyToOne(optional = false)
    private Article iDArticle;

    public Campagne() {
    }

    public Campagne(Integer iDCampagne) {
        this.iDCampagne = iDCampagne;
    }

    public Campagne(Integer iDCampagne, String description, Date dateDebut, Date dateFin) {
        this.iDCampagne = iDCampagne;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Integer getIDCampagne() {
        return iDCampagne;
    }

    public void setIDCampagne(Integer iDCampagne) {
        this.iDCampagne = iDCampagne;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Organisme getIDOrganisme() {
        return iDOrganisme;
    }

    public void setIDOrganisme(Organisme iDOrganisme) {
        this.iDOrganisme = iDOrganisme;
    }

    public Etat getIDEtat() {
        return iDEtat;
    }

    public void setIDEtat(Etat iDEtat) {
        this.iDEtat = iDEtat;
    }

    public Article getIDArticle() {
        return iDArticle;
    }

    public void setIDArticle(Article iDArticle) {
        this.iDArticle = iDArticle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDCampagne != null ? iDCampagne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campagne)) {
            return false;
        }
        Campagne other = (Campagne) object;
        if ((this.iDCampagne == null && other.iDCampagne != null) || (this.iDCampagne != null && !this.iDCampagne.equals(other.iDCampagne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Campagne[ iDCampagne=" + iDCampagne + " ]";
    }
    
}
