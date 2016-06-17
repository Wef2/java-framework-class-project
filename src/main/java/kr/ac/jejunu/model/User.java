package kr.ac.jejunu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by neo-202 on 2016-06-08.
 */
@Entity
public class User {

    public User(){

    }

    public User(String id, String password, String name, String description, String imageFileName) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.description = description;
        this.imageFileName = imageFileName;
    }

    @Id
    private String id;
    @JsonIgnore
    private String password;
    private String name;
    private String description;
    private String imageFileName;

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

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    @Override
    public String toString() {
        return "User{" +
                "imageFileName='" + imageFileName + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
