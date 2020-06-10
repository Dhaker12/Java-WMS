/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author azizl
 */
public class post {
    private int id,tag_id,section_id;
    private String title,description,photo;
    private Date postdate;

    public post(int id) {
        this.id = id;
    }

    public post(int tag_id, int section_id, String title, String description, String photo, Date postdate) {
        this.tag_id = tag_id;
        this.section_id = section_id;
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.postdate = postdate;
    }
    
    

    public post(int id ,int section_id , int tag_id, String title, String description, String photo, Date postdate  ) {
        this.id = id;
        this.tag_id = tag_id;
        this.section_id = section_id;
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.postdate = postdate;
    }

    public post(int id, String title, String description, String photo, Date postdate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.postdate = postdate;
    }

    public post(String title, String description, String photo, Date postdate) {
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.postdate = postdate;
    }

    public post() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public int getSection_id() {
        return section_id;
    }

    public void setSection_id(int section_id) {
        this.section_id = section_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }

    @Override
    public String toString() {
        return "post{" + "id=" + id + ", tag_id=" + tag_id + ", section_id=" + section_id + ", title=" + title + ", description=" + description + ", photo=" + photo + ", postdate=" + postdate + '}';
    }
    
    
    
    
}
