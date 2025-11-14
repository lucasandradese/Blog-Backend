package dev.java.project.Blog.Controllers;

import dev.java.project.Blog.Models.TagModel;
import dev.java.project.Blog.Services.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tag")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/getAll")
    public List<TagModel> getAll(){
        return tagService.getAll();
    }
    @GetMapping("/get/{id}")
    public TagModel get(@PathVariable Long id){
        return tagService.getById(id);
    }
    @PostMapping("/save")
    private TagModel save(@RequestBody TagModel tagModel){
        return tagService.save(tagModel);
    }

    @PatchMapping("/update/{id}")
    private TagModel updade(@PathVariable Long id, @RequestBody TagModel tagModel){
        return tagService.update(id, tagModel);
    }

    @DeleteMapping("delete/{id}")
    private void delete(Long id){
        tagService.delete(id);
    }
}
