package dev.java.project.Blog.Services;

import dev.java.project.Blog.Models.CommentModel;
import dev.java.project.Blog.Repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<CommentModel> getAll() {
        return commentRepository.findAll();
    }

    public CommentModel getById(Long id) {
        Optional<CommentModel> commentId = commentRepository.findById(id);
        return commentId.orElse(null);
    }

    public CommentModel save(CommentModel commentModel) {
        return commentRepository.save(commentModel);
    }

    public CommentModel update(Long id, CommentModel commentModel) {
        if(commentRepository.existsById(id)){
            commentRepository.save(commentModel);
        }
        return null;
    }

    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
