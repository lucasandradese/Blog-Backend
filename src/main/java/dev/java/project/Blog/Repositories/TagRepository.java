package dev.java.project.Blog.Repositories;

import dev.java.project.Blog.Models.TagModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagModel, Long> {
}
