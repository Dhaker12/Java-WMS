/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author azizl
 */
public class mailNews {
    private int id;
    private String mail;

    public mailNews(int id) {
        this.id = id;
    }

    public mailNews(String mail) {
        this.mail = mail;
    }

    public mailNews(int id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    
}
