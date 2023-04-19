/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.ranaivoson.tpbanqueranaivoson.jsf;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import mg.ranaivoson.tpbanqueranaivoson.ejb.GestionnaireCompte;
import mg.ranaivoson.tpbanqueranaivoson.entities.CompteBancaire;
import mg.ranaivoson.tpbanqueranaivoson.jsf.util.Util;

/**
 *
 * @author Antonio
 */
@Named(value = "transfert")
@RequestScoped
public class Transfert implements Serializable {

    @EJB
    private GestionnaireCompte gestionnaireCompte;

    private Long idSource;

    private Long idDestination;

    private int montant;

    /**
     * Get the value of montant
     *
     * @return the value of montant
     */
    public int getMontant() {
        return montant;
    }

    /**
     * Set the value of montant
     *
     * @param montant new value of montant
     */
    public void setMontant(int montant) {
        this.montant = montant;
    }

    /**
     * Get the value of idDestination
     *
     * @return the value of idDestination
     */
    public Long getIdDestination() {
        return idDestination;
    }

    /**
     * Set the value of idDestination
     *
     * @param idDestination new value of idDestination
     */
    public void setIdDestination(Long idDestination) {
        this.idDestination = idDestination;
    }

    /**
     * Get the value of idSource
     *
     * @return the value of idSource
     */
    public Long getIdSource() {
        return idSource;
    }

    /**
     * Set the value of idSource
     *
     * @param idSource new value of idSource
     */
    public void setIdSource(Long idSource) {
        this.idSource = idSource;
    }

    /**
     * Creates a new instance of Transfert
     */
    public Transfert() {
    }
    /**
     * Creates a new instance of Transfert
     * @return 
     */

     public String transferer() {
        boolean erreur = false;
        CompteBancaire source = gestionnaireCompte.findById(idSource);
        if (source == null) {
            Util.messageErreur("Aucun compte avec cet id !", "Aucun compte avec cet id !", "form:source");
            erreur = true;
        } else {
            if (source.getSolde() < montant) {
                Util.messageErreur("Solde insuffisant pour ce transfert !", "Solde insuffisant pour ce transfert !", "form:montant");
                erreur = true;
            }
        }
        CompteBancaire destination = gestionnaireCompte.findById(idDestination);
        if (destination == null) {
            Util.messageErreur("Aucun compte avec cet id !", "Aucun compte avec cet id !", "form:destination");
            erreur = true;
        } 
        if (erreur) { 
            return null;
        }
        gestionnaireCompte.transferer(source, destination, montant);
        // Message de succès ; addFlash à cause de la redirection.
        Util.addFlashInfoMessage("Transfert correctement effectué");
        return "listeComptes?faces-redirect=true";
    }
    
    
    
}
