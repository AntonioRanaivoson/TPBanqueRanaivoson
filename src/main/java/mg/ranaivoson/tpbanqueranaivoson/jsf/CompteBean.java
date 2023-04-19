/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.ranaivoson.tpbanqueranaivoson.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import mg.ranaivoson.tpbanqueranaivoson.ejb.GestionnaireCompte;
import mg.ranaivoson.tpbanqueranaivoson.entities.CompteBancaire;

/**
 *
 * @author Antonio
 */
@Named(value = "compteBean")
@ViewScoped
public class CompteBean implements Serializable {

    private List<CompteBancaire> compteList;
    @EJB
    private GestionnaireCompte gestionnaireCompte;

    public CompteBean() {
    }

    /**
     * Retourne la liste des clients pour affichage dans une DataTable.
     * @return 
     */
    public List<CompteBancaire> getComptes() {
        if (compteList == null) {
           compteList = gestionnaireCompte.getAllComptes();
        }
        return compteList;
    }
}
