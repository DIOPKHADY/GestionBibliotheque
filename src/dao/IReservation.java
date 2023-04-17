/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Reservation;

/**
 *
 * @author Momar Ndaw THIAM
 */
public interface IReservation {
      Reservation addReservation (Reservation  R);

   
    List<Reservation> allReservation();

    
       Reservation  getReservationByName(String name);
    
    
}
