package dev.java.project.Blog.Repositories;

import dev.java.project.Blog.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
