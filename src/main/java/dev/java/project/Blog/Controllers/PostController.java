package dev.java.project.Blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/post")
public class PostController {
    @GetMapping("/getAll")
    public String getAll(){
        return "getAll";
    }
    @GetMapping("/get/{id}")
    public String get(){
        return "get";
    }
    @PostMapping("/save")
    private String save(){
        return "save";
    }

    @PatchMapping("/update/{id}")
    private String updade(){
        return "update";
    }

    @DeleteMapping("delete/{id}")
    private void delete(){

    }
}
