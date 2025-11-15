package dev.java.project.Blog.Repositories;

import dev.java.project.Blog.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String login);
}
