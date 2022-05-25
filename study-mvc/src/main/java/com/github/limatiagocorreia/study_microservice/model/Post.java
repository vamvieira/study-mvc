package com.github.limatiagocorreia.study_microservice.model;

public class Post {

    private Long id;
    private String title;
    private String author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString() {
        return "{ id = ".concat(id.toString())
                .concat(" - title = ").concat(title)
                .concat(" - author = ").concat(author).concat(" }");
    }

}
