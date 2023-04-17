/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.ISuperUtilisateur;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import static models.Inscription_.id;
import models.Utilisateurs;
import utils.EntityManagerUtil;

/**
 *
 * @author HP
 */
public class SuperutilisateurServices  implements ISuperUtilisateur{
     private EntityManager EM=null;
     
     public SuperutilisateurServices(){
         EM=EntityManagerUtil.getEntityManagerFactory().createEntityManager();
     }
 
    @Override
    public Utilisateurs validerInscription(int id) {
Utilisateurs users = null;
    try {
        users = EM.find(Utilisateurs.class, id);
        if (users != null) {
            EM.getTransaction().begin();
//            users.setValide(true);
            EM.merge(users);
            EM.getTransaction().commit();
        }
    } catch (Exception e) {
        System.err.println("Erreur lors de la validation : " + e.getMessage());
    }
    return users;
    }

    @Override
    public Utilisateurs supprimerInscription(int id) {
Utilisateurs utilisateur=null;
        try {
            //recherche l'utilisateur dans la base de donnee
            utilisateur =EM.find(Utilisateurs.class, id);
                 // Début de la transaction
            EM.getTransaction().begin();
             // Suppression de l'utilisateur de la base de données
            EM.remove(utilisateur);
             // Confirmation de la transaction
            EM.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println("Erreur lors de la suppression"+ ex.getMessage());
            return utilisateur;
        }
         return utilisateur;
    }

    @Override
    public Utilisateurs bloquerUtilisateur(int id) {
Utilisateurs u=null;
        try {

            u=EM.find(Utilisateurs.class, id);
            EM.getTransaction().begin();
//            u.setEtat(u.ETAT_BLOQUE);
            EM.persist(u);
        
            EM.getTransaction().commit();
        
        } catch (Exception e) {
            System.err.println("Erreur lors du blocage"+e.getMessage());
            return u;
        }
        return u;
    }

    @Override
    public Utilisateurs debloquerUtilisateur(int id) {
Utilisateurs users=null;
        try {
         users=EM.find(Utilisateurs.class, id);
         EM.getTransaction().begin();
//         users.setEtat(users.ETAT_DEBLOQUE);
         EM.persist(users);
         EM.flush();
         EM.getTransaction().commit();
   
        } catch (Exception e) {
            System.err.println("Erreur lors du deblocage" +e.getMessage());
            return users;
        }
      return users;     
    }

    @Override
    public Utilisateurs modifierRoleUtilisateur(String role) {
   Utilisateurs u = null;
    try {
        u = EM.find(Utilisateurs.class, id);
        if (u != null) {
            EM.getTransaction().begin();
            u.setRole(role);
            EM.merge(u);
            EM.getTransaction().commit();
        }
    } catch (Exception e) {
        System.err.println("Erreur lors de la modification : " + e.getMessage());
    }
    return u;
    }

    @Override
    public Utilisateurs utilisateurEnAttente(int id) {
 Utilisateurs users = null;
    try {
        users = EM.find(Utilisateurs.class, id);
        EM.getTransaction().begin();
//        users.setEtat(Utilisateurs.Etat_ATTENTE);
        EM.persist(users);
        EM.flush();
        EM.getTransaction().commit();
    } catch (Exception e) {
        System.err.println("Erreur lors de la vérification : " + e.getMessage());
    }
    return users; 
    }

    @Override
    public List<Utilisateurs> trouverTousLesUtilisateurs() {
        List<Utilisateurs> usersList;
        try {
            usersList=EM.createNamedQuery("Utlisateur.findAll",Utilisateurs.class).getResultList();
        } catch (Exception e) {
            System.err.println("Erreur lors de la recuperation des categories"+e.getMessage());
            throw e;
        }
        return usersList;
    }

    @Override
    public Utilisateurs ajouterUtilisateur(Utilisateurs u) {
       EntityTransaction et = null;
Utilisateurs savedUser = null;
    try {
        et = EM.getTransaction();
        et.begin();
        EM.persist(u);
        EM.flush();
        et.commit();
        savedUser = u;
    } catch (Exception e) {
        if (et != null && et.isActive()) {
            et.rollback();
        }
        System.err.println("Erreur lors de l'insertion de l'utilisateur : " + e.getMessage());
    }
    return savedUser;
    }

    @Override
    public Utilisateurs mettreAJourUtilisateur(Utilisateurs utilisateur) {
   Utilisateurs updatedUser = null;
    try {
        EM.getTransaction().begin();
        updatedUser = EM.merge(utilisateur);
        EM.getTransaction().commit();
    } catch (Exception e) {
        System.err.println("Erreur lors de la mise à jour de l'utilisateur : " + e.getMessage());
        return updatedUser;
    }
    return updatedUser;
    }
    

    @Override
    public Utilisateurs trouverUtilisateurParId(int id) {
   Utilisateurs utilisateur = null;
    try {
        utilisateur = EM.find(Utilisateurs.class, id);
    } catch (Exception e) {
        System.err.println("Erreur lors de la recherche de l'utilisateur : " + e.getMessage());
    }
    return utilisateur;
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
    public List<Utilisateurs> trouverTousLesUtilisateur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object verifUtilisateurs(Utilisateurs utilisateur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
