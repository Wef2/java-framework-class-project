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

    public User(String id, String password, String name, String description, String imagePath) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
    }

    @Id
    private String id;
    private String password;
    private String name;
    private String description;
    private String imagePath;

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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
