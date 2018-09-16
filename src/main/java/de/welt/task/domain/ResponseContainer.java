package de.welt.task.domain;

/**
 * Combines the results received from remote services
 */
public class ResponseContainer {

    private final User user;
    private final UserPost[] posts;

    public ResponseContainer(User user, UserPost[] posts) {
        this.user = user;
        this.posts = posts;
    }

    public User getUser() {
        return user;
    }

    public UserPost[] getPosts() {
        return posts;
    }
}
