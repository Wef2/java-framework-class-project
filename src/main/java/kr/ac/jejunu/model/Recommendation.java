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
    private int articleId;
    private String userId;
    private boolean value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Recommendation{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", userId='" + userId + '\'' +
                ", value=" + value +
                '}';
    }
}