package com.github.limatiagocorreia.study_microservice.repository;

import com.github.limatiagocorreia.study_microservice.model.Comment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommentRepository {

    private List<Comment> comments;
    private Long currentComment = 0L;

    public CommentRepository() {
        this.load();
    }

    private void load() {
        comments = new ArrayList<Comment>();

        Comment com = new Comment();
        com.setId(1L);
        com.setBody("primeiro comment");

        comments.add(com);

        com = new Comment();
        com.setId(2L);
        com.setBody("segundo comment");

        comments.add(com);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Comment getById(Long comment_id) {
        return comments
                .stream()
                .filter(comment -> comment.getId().equals(comment_id))
                .findFirst()
                .orElse(null);
    }

    public Long createComment(Comment comment) {
        comment.setId(++this.currentComment);
        comments.add(comment);
        return comment.getId();
    }

    public void deleteCommentById(Long comment_id) {
        comments.removeIf(item -> item.getId().equals(comment_id));
    }

    public Comment updateComment(Comment comment) {
        for (Comment c : comments) {
            if (c.getId().equals(comment.getId())) {
                c.setBody(comment.getBody());
                return c;
            }
        }
        return null;
    }
}
