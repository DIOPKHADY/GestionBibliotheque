/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Livre;

/**
 *
 * @author Momar Ndaw THIAM
 */
public interface ILivre {
        
    Livre addlivre(Livre L);

   
    List<Livre> allLivres();

    
    Livre  getLivreByName(String name);
    
}
