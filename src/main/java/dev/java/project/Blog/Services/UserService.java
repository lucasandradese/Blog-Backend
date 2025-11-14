package dev.java.project.Blog.Services;

import dev.java.project.Blog.Repositories.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
