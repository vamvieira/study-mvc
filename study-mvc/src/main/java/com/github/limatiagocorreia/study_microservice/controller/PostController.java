package com.github.limatiagocorreia.study_microservice.controller;

import com.github.limatiagocorreia.study_microservice.model.Post;
import com.github.limatiagocorreia.study_microservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/posts")
public class PostController {

    private PostRepository postRepository = new PostRepository();

    @GetMapping
    public List<Post> getPosts() {
        System.out.println("Listando todos os posts");
        return postRepository.getPosts();
    }

    @GetMapping("{post_id}")
    public Post getById(@PathVariable Long post_id) {
        return postRepository.getById(post_id);
    }

    @DeleteMapping("delete/{post_id}")
    public void deletePost(@PathVariable Long post_id) {
        System.out.println("Apagando o post de id= " + post_id);
        postRepository.deleteById(post_id);
    }

    @PostMapping("create")
    public Long createPost(@RequestBody Post post) {
        return postRepository.createPost(post);
    }

    @PutMapping("update")
    public Post updatePost(@RequestBody Post post) {
        return postRepository.updatePost(post);
    }
}
