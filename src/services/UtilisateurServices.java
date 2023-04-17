/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.IUtilisateur;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import models.Utilisateurs;
import utils.EntityManagerUtil;

/**
 *
 * @author HP
 */
public class UtilisateurServices implements IUtilisateur{
  private EntityManager EM = null;

    public UtilisateurServices() {
        EM = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Utilisateurs ajouterUtilisateur(Utilisateurs utilisateur) {
        EntityTransaction transaction = EM.getTransaction();
        transaction.begin();
        EM.persist(utilisateur);
        transaction.commit();
        return utilisateur;
    }

    @Override
    public Utilisateurs mettreAJourUtilisateur(Utilisateurs utilisateur) {
        EntityTransaction transaction = EM.getTransaction();
        transaction.begin();
        Utilisateurs utilisateurMaj = EM.merge(utilisateur);
        transaction.commit();
        return utilisateurMaj;
    }

    @Override
    public Utilisateurs trouverUtilisateurParId(int id) {
        return EM.find(Utilisateurs.class, id);
    }

    @Override
    public List<Utilisateurs> trouverTousLesUtilisateurs() {
        return EM.createQuery("SELECT u FROM Utilisateur u", Utilisateurs.class).getResultList();
        

    }

    @Override
    public Utilisateurs verifUtilisateur(Utilisateurs utilisateur) {
    EntityTransaction transaction = EM.getTransaction();
    transaction.begin();
    TypedQuery<Utilisateurs> query = EM.createQuery("SELECT u FROM Utilisateur u WHERE u.nom_utilisateur = :username AND u.mot_de_passe = :password", Utilisateurs.class);
    query.setParameter("username", utilisateur.getNomUtilisateur());
    query.setParameter("password", utilisateur.getMotDePasse());
    
    Utilisateurs utilisateurResult = query.getSingleResult();
    transaction.commit();
    return utilisateurResult;
    }

    @Override
    public Object verifUtilisateurs(Utilisateurs utilisateur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   

}

    
