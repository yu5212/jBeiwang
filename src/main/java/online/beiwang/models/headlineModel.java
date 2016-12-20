package online.beiwang.models;

import java.util.Date;

/**
 * Created by yuying on 2016/12/19.
 */


public class headlineModel {

    /**
     * title :
     * id : 1
     * date : 2016-12-19
     * author :
     */

    private String title;
    private int id;
    private Date date;
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}