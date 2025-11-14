package dev.java.project.Blog.Controllers;

import dev.java.project.Blog.Models.CommentModel;
import dev.java.project.Blog.Services.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/getAll")
    public List<CommentModel> getAll(){
        return commentService.getAll();
    }
    @GetMapping("/get/{id}")
    public CommentModel get(@PathVariable Long id){
        return commentService.getById(id);
    }
    @PostMapping("/save")
    private CommentModel save(@RequestBody CommentModel commentModel){
        return commentService.save(commentModel);
    }

    @PatchMapping("/update/{id}")
    private CommentModel updade(@PathVariable Long id, @RequestBody CommentModel commentModel){
        return commentService.update(id, commentModel);
    }

    @DeleteMapping("delete/{id}")
    private void delete(@PathVariable Long id){
        commentService.delete(id);
    }

}
