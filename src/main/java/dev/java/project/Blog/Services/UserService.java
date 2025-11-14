package dev.java.project.Blog.Services;

import dev.java.project.Blog.Models.UserModel;
import dev.java.project.Blog.Repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;
    private final UserModel userModel;

    public UserService(UserRepository userRepository, UserModel userModel) {
        this.userRepository = userRepository;
        this.userModel = userModel;
    }

    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    }

    public List<UserModel> getAll(){
        return userRepository.findAll();
    }

    public UserModel getById(Long id){
        Optional<UserModel> userId = userRepository.findById(id);
        return userId.orElse(null);
    }

    public UserModel update(Long id, UserModel userUpade){
        if (userRepository.existsById(id)) {
            userUpade.setId(id);
            return userRepository.save(userUpade);
        }
        return null;
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
