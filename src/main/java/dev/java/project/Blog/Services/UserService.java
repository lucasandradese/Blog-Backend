package dev.java.project.Blog.Services;

import dev.java.project.Blog.Models.UserModel;
import dev.java.project.Blog.Repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserModel save(UserModel userModel){
        String passwordHash = passwordEncoder.encode(userModel.getPassword());
        userModel.setPassword(passwordHash);
        return userRepository.save(userModel);
    }

    public List<UserModel> getAll(){
        return userRepository.findAll();
    }

    public UserModel getById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public UserModel update(Long id, UserModel userUpdate){
        if (userRepository.existsById(id)) {
            userUpdate.setId(id);

            // criptografa senha se foi alterada
            String passwordHash = passwordEncoder.encode(userUpdate.getPassword());
            userUpdate.setPassword(passwordHash);

            return userRepository.save(userUpdate);
        }
        return null;
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}