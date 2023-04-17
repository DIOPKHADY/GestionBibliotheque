/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Emprunt;

/**
 *
 * @author Momar Ndaw THIAM
 */
public interface IEmprunt {
Emprunt  addEmprunt (Emprunt  E);

   
    List<Emprunt> allEmprunt();

    
      Emprunt  getEmpruntByName(String name);
    
    
}
