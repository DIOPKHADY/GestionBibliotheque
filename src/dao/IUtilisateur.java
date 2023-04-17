/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Utilisateurs;
import models.Utilisateurs;

/**
 *
 * @author HP
 */
public interface IUtilisateur {


    // Ajouter un nouvel utilisateur
    Utilisateurs ajouterUtilisateur(Utilisateurs utilisateur);

    // Mettre à jour les informations d'un utilisateur existant
     Utilisateurs mettreAJourUtilisateur(Utilisateurs utilisateur);

        Utilisateurs verifUtilisateur(Utilisateurs utilisateur);
    Utilisateurs trouverUtilisateurParId(int id);

    // Récupérer tous les utilisateurs dans la base de doonnées
    List<Utilisateurs> trouverTousLesUtilisateurs();

    public Object verifUtilisateurs(Utilisateurs utilisateur);
}

    

