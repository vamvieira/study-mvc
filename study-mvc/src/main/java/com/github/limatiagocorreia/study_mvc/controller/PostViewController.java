package com.github.limatiagocorreia.study_mvc.controller;

import com.github.limatiagocorreia.study_microservice.model.Post;
import com.github.limatiagocorreia.study_microservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("posts")
public class PostViewController {

    private final PostRepository postRepository;

    public PostViewController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping()
    public String viewPosts(Model model) {
        model.addAttribute("instituicao", "FIAP");
        model.addAttribute("posts", postRepository.getPosts());
        return "view-posts";
    }

    @GetMapping("/addPost")
    public String addPostView(Model model) {
        model.addAttribute("post", new Post());
        return "add-post";
    }

    @PostMapping("/addPost")
    public RedirectView addPost(@ModelAttribute("post") Post post, RedirectAttributes attrs) {

        attrs.addFlashAttribute("postId", postRepository.createPost(post));
        attrs.addFlashAttribute("addPostSuccess", true);
        RedirectView redirect = new RedirectView("/view/addPost");
        return redirect;
    }

    @GetMapping("/post/{id}")
    public String findById(@PathVariable Long id,Model model){
        model.addAttribute("post",postRepository.getById(id));
        return "add-post";
    }
}
