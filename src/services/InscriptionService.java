/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.IInscription;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Inscription;
import static models.Inscription_.id;
import utils.EntityManagerUtil;

/**
 *
 * @author HP
 */
public class InscriptionService implements IInscription
{
    private  EntityManager EM= null;
    
    public InscriptionService (){
        EM= EntityManagerUtil.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Inscription addInscription(Inscription inscription) {
        EntityTransaction transaction = EM.getTransaction();
        transaction.begin();
        EM.persist(inscription);
        transaction.commit();
        return inscription;
    }

    @Override
    public Inscription trouverInscriptionById(int id) {
                return EM.find(Inscription.class, id);

    }

    @Override
    public List<Inscription> trouverTousInscription() {
        return EM.createQuery("SELECT u FROM Utilisateur u", Inscription.class).getResultList();
    }

    @Override
    public Inscription updateInscription(Inscription inscription) {
       EntityTransaction transaction = EM.getTransaction();
        transaction.begin();
       Inscription  inscrie = EM.merge( inscription);
        transaction.commit();
        return inscrie; 
    }

    @Override
    public Inscription deleteInscription(Inscription inscription) {
        Inscription inscript=null;
        try {
            //recherche l'utilisateur dans la base de donnee
            inscript=EM.find(Inscription.class, id);
                 // Début de la transaction
            EM.getTransaction().begin();
             // Suppression de l'utilisateur de la base de données
            EM.remove(inscript);
             // Confirmation de la transaction
            EM.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println("Erreur lors de la suppression"+ ex.getMessage());
            return inscript;
        }
         return inscript;
    }    
}
   
    

