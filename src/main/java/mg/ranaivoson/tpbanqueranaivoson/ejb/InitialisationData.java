/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.ranaivoson.tpbanqueranaivoson.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.Serializable;
import mg.ranaivoson.tpbanqueranaivoson.entities.CompteBancaire;

/**
 *
 * @author Antonio
 */
@Singleton
@Startup
public class InitialisationData implements Serializable {

    @PersistenceContext(unitName = "banquePU")
    private EntityManager em;

    @PostConstruct
    public void init() {
        // Enregistrer des données dans la base de données
        CompteBancaire entity1 = new CompteBancaire("John Lennon", 150000);
        CompteBancaire entity2 = new CompteBancaire("Paul McCartney", 950000);
        CompteBancaire entity3 = new CompteBancaire("Ringo Starr", 20000);
        CompteBancaire entity4 = new CompteBancaire("Georges Harrisson", 100000);

        em.persist(entity1);
        em.persist(entity2);
        em.persist(entity3);
        em.persist(entity4);
    }

}
