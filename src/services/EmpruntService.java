/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.IEmprunt;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import models.Emprunt;
import models.Utilisateurs;
import utils.EntityManagerUtil;

/**
 *
 * @author Momar Ndaw THIAM
 */
public class EmpruntService implements IEmprunt{
 private EntityManager EM = null;

    public EmpruntService() {
        EM = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
    }

  

    @Override
    public Emprunt addEmprunt(Emprunt e) {
        EntityTransaction transaction = EM.getTransaction();
        transaction.begin();
        EM.persist(e);
        transaction.commit();
        return e;
    }

    @Override
    public List<Emprunt> allEmprunt() {
        return EM.createQuery("SELECT E FROM Emprunt E", Emprunt.class).getResultList();

    }

    @Override
    public Emprunt getEmpruntByName(String nom) {
                return EM.find(Emprunt.class, nom);

    }

    

   

}