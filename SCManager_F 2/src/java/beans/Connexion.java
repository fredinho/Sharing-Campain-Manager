/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import EJB.PersonneFacadeLocal;
import JPA.Arrondissement;
import JPA.Personne;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author FREDINHO
 */
@ManagedBean
@SessionScoped
public class Connexion implements Serializable {
    @EJB
    private PersonneFacadeLocal personneLocal;
    private List<Personne> pers;
    
    private String pseudo;
    private String password;
    
    private int idP;
    private String nomP;
    private String pnomP;
    private String pseudoP;
    private String pwdP;
    private String emailP;
    private String profP;
    private Date datnaisP;
    private Arrondissement idArron;
    
    private Date datjr = new Date();
   
    /**
     * Constructor
     */
    
    public Connexion() {
    }

    /**
     * Getters and Setters
     * @return 
     */
    
    public PersonneFacadeLocal getPersonneLocal() {
        return personneLocal;
    }

    public void setPersonneLocal(PersonneFacadeLocal personneLocal) {
        this.personneLocal = personneLocal;
    }

    public List<Personne> getPers() {
        return pers;
    }

    public void setPers(List<Personne> pers) {
        this.pers = pers;
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

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public String getPnomP() {
        return pnomP;
    }

    public void setPnomP(String pnomP) {
        this.pnomP = pnomP;
    }

    public String getPseudoP() {
        return pseudoP;
    }

    public void setPseudoP(String pseudoP) {
        this.pseudoP = pseudoP;
    }

    public String getPwdP() {
        return pwdP;
    }

    public void setPwdP(String pwdP) {
        this.pwdP = pwdP;
    }

    public String getEmailP() {
        return emailP;
    }

    public void setEmailP(String emailP) {
        this.emailP = emailP;
    }

    public String getProfP() {
        return profP;
    }

    public void setProfP(String profP) {
        this.profP = profP;
    }

    public Date getDatnaisP() {
        return datnaisP;
    }

    public void setDatnaisP(Date datnaisP) {
        this.datnaisP = datnaisP;
    }

    public Date getDatjr() {
        return datjr;
    }

    public void setDatjr(Date datjr) {
        this.datjr = datjr;
    }

    public Arrondissement getIdArron() {
        return idArron;
    }

    public void setIdArron(Arrondissement idArron) {
        this.idArron = idArron;
    }
    
    /**
     * Methods
     * @throws IOException 
     */
    
    public void connect() throws IOException{
        int j = 1;
        pers = new ArrayList<Personne>();
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        List<Personne> person = getPersonneLocal().connexion(getPseudo(), getPassword());
        
            if(person.isEmpty()){
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Connexion Echoué", "Parametre de connexion incorrecte."));
            }else{
                for(int i=0; i<person.size(); i++){
                   System.out.println("Start2");
                   getPers().add(person.get(i));
                   
                   idP = getPers().iterator().next().getIDPersonne();
                   nomP = getPers().iterator().next().getNompersonne();
                   pnomP = getPers().iterator().next().getPrenomPersonne();
                   datnaisP = getPers().iterator().next().getDateNaissance();
                   pseudoP = getPers().iterator().next().getPseudo();
                   pwdP = getPers().iterator().next().getPassword();
                   emailP = getPers().iterator().next().getEmail();
                   profP = getPers().iterator().next().getIDProfile().getNomProfile();
                   idArron = getPers().iterator().next().getIDArrondissement();
                   
                   FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("id", idP);
                   FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nom", nomP);
                   FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("prenom", pnomP);
                   FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("datenaiss", datnaisP);
                   FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pseudo", pseudoP);
                   FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("motpass", pwdP);
                   FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("mail", emailP);
                   FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("profile", profP);
                   FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idarron", idArron);
                   FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("arron", idArron.getNomArrondissement());
                   FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("depart", idArron.getIDDepartement().getNomDepartement());
                   FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("province", idArron.getIDDepartement().getIDProvince().getNomProvince());
                }
            if(getPers().iterator().next().getIDProfile().getIDProfile() == 1){
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/OPS/Enregistrement-des-Menages.xhtml");
            }
            if(getPers().iterator().next().getIDProfile().getIDProfile() == 2){
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/ChefProjet/Suivi-des-agents-de-Recensement.xhtml");
            }
            if(getPers().iterator().next().getIDProfile().getIDProfile() == 3){
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/Admin/Informations-sur-les-agents-de-recensement.xhtml");
            }
            if(getPers().iterator().next().getIDProfile().getIDProfile() == 4){
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/Admin/Informations-sur-la-Campagne.xhtml");
            }
        }
    }
    
    
}
