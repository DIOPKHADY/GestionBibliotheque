/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Inscription;

/**
 *
 * @author HP
 */
public interface IInscription {
    
    Inscription addInscription(Inscription inscription);
     Inscription trouverInscriptionById(int id);
      List<Inscription> trouverTousInscription();
     Inscription updateInscription (Inscription inscription);
      Inscription deleteInscription(Inscription inscription);

}
