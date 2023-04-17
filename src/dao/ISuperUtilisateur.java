/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Superutilisateur;
import models.Utilisateurs;

/**
 *
 * @author HP
 */
public interface ISuperUtilisateur  extends IUtilisateur{
    Utilisateurs validerInscription(int id);

    Utilisateurs supprimerInscription(int id);

    Utilisateurs bloquerUtilisateur(int id);

    Utilisateurs debloquerUtilisateur(int id);

 Utilisateurs modifierRoleUtilisateur(String role);

   Utilisateurs utilisateurEnAttente(int id);

    List<Utilisateurs> trouverTousLesUtilisateur();




}
