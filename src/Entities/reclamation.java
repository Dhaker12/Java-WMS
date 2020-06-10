/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author abdallah
 */
public class reclamation {
    private int id_reclamation;
    private String description;
        private Date Date;

  //  private int Employee;

    public reclamation(int id_reclamation, String description, Date Date) {
        this.id_reclamation = id_reclamation;
        this.description = description;
        this.Date = Date;
    }

   

    public reclamation(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "reclamation{" + "id_reclamation=" + id_reclamation + ", description=" + description + ", Date=" + Date + '}';
    }

   

   

   
    
}
