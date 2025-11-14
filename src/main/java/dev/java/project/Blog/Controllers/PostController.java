package dev.java.project.Blog.Controllers;

import dev.java.project.Blog.Models.PostModel;
import dev.java.project.Blog.Services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/getAll")
    public List<PostModel> getAll(){
        return postService.getAll();
    }
    @GetMapping("/get/{id}")
    public PostModel get(@PathVariable Long id){
        return postService.getById(id);
    }
    @PostMapping("/save")
    private PostModel save(@RequestBody PostModel postModel){
        return postService.save(postModel);
    }

    @PatchMapping("/update/{id}")
    private PostModel updade(@PathVariable Long id, PostModel postModel){
        return postService.update(id, postModel);
    }

    @DeleteMapping("delete/{id}")
    private void delete(@PathVariable Long id){
        postService.delete(id);
    }
}
