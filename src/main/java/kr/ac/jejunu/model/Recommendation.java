package kr.ac.jejunu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by neo-202 on 2016-06-08.
 */
@Entity
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int article_id;
    private String user_id;
    private boolean type;

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public boolean getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Recommendation{" +
                "id=" + id +
                ", article_id=" + article_id +
                ", user_id='" + user_id + '\'' +
                ", type=" + type +
                '}';
    }
}