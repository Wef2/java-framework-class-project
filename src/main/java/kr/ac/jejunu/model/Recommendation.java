package kr.ac.jejunu.model;

/**
 * Created by neo-202 on 2016-06-08.
 */
public class Recommendation {

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

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }
}