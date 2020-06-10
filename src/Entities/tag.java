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
public class tag {
    private int id;
    private String title;

    public tag(int id) {
        this.id = id;
    }

    public tag(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public tag(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "tag{" + "id=" + id + ", title=" + title + '}';
    }
    
    
    
}
