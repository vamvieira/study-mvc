package com.github.limatiagocorreia.study_mvc.controller;

import com.github.limatiagocorreia.study_microservice.model.Comment;
import com.github.limatiagocorreia.study_microservice.repository.CommentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("comments")
public class CommentViewController {

    private final CommentRepository commentRepository;

    public CommentViewController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping
    public String viewComments(Model model) {
        model.addAttribute("comments", commentRepository.getComments());
        return "view-comments";
    }

    @GetMapping("/addComment")
    public String addCommentView(Model model) {
        model.addAttribute("comment", new Comment());
        return "add-comment";
    }

    @PostMapping("/addComment")
    public RedirectView addComment(@ModelAttribute("comment") Comment comment, RedirectAttributes attrs) {

        attrs.addFlashAttribute("commentId", commentRepository.createComment(comment));
        attrs.addFlashAttribute("addCommentSuccess", true);
        RedirectView redirect = new RedirectView("/comments/addComment");
        return redirect;
    }

    @GetMapping("/comment/{id}")
    public String findById(@PathVariable Long id, Model model) {
        model.addAttribute("comment", commentRepository.getById(id));
        return "add-comment";
    }
}
