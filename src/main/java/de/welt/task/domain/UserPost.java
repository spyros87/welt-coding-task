package de.welt.task.domain;

/**
 * A simple post entity which considers the id, userId and title as the
 * serialized data.
 */
public class UserPost {
    private Integer id;
    private Integer userId;
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
