package dev.java.project.Blog.Repositories;

import dev.java.project.Blog.Models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepostory extends JpaRepository<PostModel, Long> {
}
