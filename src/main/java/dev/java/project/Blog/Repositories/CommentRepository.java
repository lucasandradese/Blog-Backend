package dev.java.project.Blog.Repositories;

import dev.java.project.Blog.Models.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentModel, Long> {

}
