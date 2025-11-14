package dev.java.project.Blog.Controllers;

import dev.java.project.Blog.Models.UserModel;
import dev.java.project.Blog.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public List<UserModel> getAll(){
        return userService.getAll();
    }

    @GetMapping("/get/{id}")
    public UserModel get(@PathVariable Long id){
        return userService.getById(id);
    }

    @PostMapping("/save")
    private UserModel save(@RequestBody UserModel userModel){
        return userService.save(userModel);
    }

    @PatchMapping("/update/{id}")
    private UserModel updade(@PathVariable Long id, @RequestBody UserModel userModel){
        return userService.update(id, userModel);
    }

    @DeleteMapping("delete/{id}")
    private void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
