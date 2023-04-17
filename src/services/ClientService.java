/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.IClient;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import models.Client;
import utils.EntityManagerUtil;

/**
 *
 * @author HP
 */
public class ClientService implements IClient{
      private EntityManager EM = null;

    public ClientService() {
        EM = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
    }
    
    @Override
    public Client findClientByEmail(String email) {
        Client c;
        try {
            c = EM.createNamedQuery("Client.findClientByEmail", Client.class).setParameter("email", email).getSingleResult();
        } catch (Exception ex) {
            System.err.println("Erreur lors  de la recuperation du client:" + ex.getMessage());
            return null;

        }
        return c;
    }

    @Override
    public Client addClient(Client c) {
        
        EntityTransaction et = null;
        Client clientSaved;
        try {
            // Récupération de l'objet de transaction
            et = EM.getTransaction();
            // Début de la transaction
            et.begin();
            // Persistance du client dans la base de données
            EM.persist(c);
            EM.flush(); // Synchronisation de l'état de l'entité avec la base de données
            // Validation de la transaction
            et.commit();
            // Affectation du client persisté à la variable clientSaved
            clientSaved = c;
        } catch (Exception ex) {
            // Gestion des erreurs : annulation de la transaction en cas d'échec
            if (et == null && et.isActive()) {
                et.rollback();
            }
            // Affichage d'un message d'erreur et relance de l'exception
            System.err.println("Erreur lors de l'insertion du client " + ex.getMessage());
            throw ex;
        }
        // Retour du client persisté
        return clientSaved;
    }

    @Override
    public List<Client> AllClients() {
     try {
        CriteriaQuery<Client> cq = EM.getCriteriaBuilder().createQuery(Client.class);
        cq.select(cq.from(Client.class));
        return EM.createQuery(cq).getResultList();
    } catch (Exception ex) {
        System.err.println("Erreur lors de la récupération des clients : " + ex.getMessage());
        return null;
    } 
}
    }