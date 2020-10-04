/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import EJB.ArticleFacadeLocal;
import JPA.Article;
import JPA.Organisme;
import config.DataModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author FREDINHO
 */
@ManagedBean
@SessionScoped
public class ArticleBean implements Serializable {
    @EJB
    private ArticleFacadeLocal artLocal;
    private Article art;
    private Article[] selection;
    private List<Article> listart;
    private String nomart;
    private int org;
    private int r;
    DataModel model;
    
    public ArticleBean(){
        
    }

    public ArticleFacadeLocal getArtLocal() {
        return artLocal;
    }

    public void setArtLocal(ArticleFacadeLocal artLocal) {
        this.artLocal = artLocal;
    }

    public Article getArt() {
        return art;
    }

    public void setArt(Article art) {
        this.art = art;
    }

    public Article[] getSelection() {
        return selection;
    }

    public void setSelection(Article[] selection) {
        this.selection = selection;
    }

    public List<Article> getListart() {
        return listart;
    }

    public void setListart(List<Article> listart) {
        this.listart = listart;
    }

    public String getNomart() {
        return nomart;
    }

    public void setNomart(String nomart) {
        this.nomart = nomart;
    }

    public int getOrg() {
        return org;
    }

    public void setOrg(int org) {
        this.org = org;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public DataModel getModel() {
        return model;
    }

    public void setModel(DataModel model) {
        this.model = model;
    }
    
    public void recupererArt(){
        listart = new ArrayList<Article>();
        model = new DataModel(listart);
        List<Article> article = getArtLocal().findAll();
        for(int i=0; i<article.size(); i++){
            getListart().add(article.get(i));
        }    
    }
    
    public void ajouter(){
        art = new Article();
        getArt().setDesignation(getNomart());
        getArt().setIDOrganisme(new Organisme(getOrg()));
        getArtLocal().create(getArt());
    }
    
    public void supprimer(){
        System.out.println("start supp");
        for(int i=0; i<selection.length; i++){
            selection[i].setIDArticle(new Article(selection[i].getIDArticle()).getIDArticle());
            art = getArtLocal().find(selection[i].getIDArticle());
            getArtLocal().remove(art);
        } 
    }
}
