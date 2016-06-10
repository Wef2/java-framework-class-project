package kr.ac.jejunu.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by neo-202 on 2016-06-08.
 */
@Entity
public class User {

    public User(){

    }

    @Id
    private String id;
    private String password;
    private String name;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
