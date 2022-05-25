package com.github.limatiagocorreia.study_microservice.repository;

import com.github.limatiagocorreia.study_microservice.model.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostRepository {

    private List<Post> posts;
    private Long currentId = 3L;

    public PostRepository() {
        this.load();
    }

    private void load() {
        posts = new ArrayList<Post>();

        Post post = new Post();
        post.setId(1L);
        post.setTitle("title");
        post.setAuthor("author");

        posts.add(post);

        post = new Post();
        post.setId(3L);
        post.setTitle("title3");
        post.setAuthor("author3");

        posts.add(post);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public Post getById(Long post_id) {
        return posts
                .stream()
                .filter(post -> post.getId().equals(post_id))
                .findFirst()
                .orElse(null);
    }

    public void deleteById(Long post_id) {
        posts.removeIf(item -> item.getId().equals(post_id));
    }

    public Long createPost(Post post) {
        post.setId(++this.currentId);
        posts.add(post);
        return post.getId();
    }

    public Post updatePost(Post post) {
        for (Post p : posts){
            if (p.getId().equals(post.getId())){
                p.setAuthor(post.getAuthor());
                p.setTitle(post.getTitle());
                return p;
            }
        }
        return null;
    }
}
