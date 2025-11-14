package dev.java.project.Blog.Services;


import dev.java.project.Blog.Models.PostModel;
import dev.java.project.Blog.Repositories.PostRepostory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepostory postRepostory;

    public PostService(PostRepostory postRepostory) {
        this.postRepostory = postRepostory;
    }


    public PostModel save(PostModel postModel) {
        return postRepostory.save(postModel);
    }

    public List<PostModel> getAll() {
        return postRepostory.findAll();
    }

    public PostModel getById(Long id) {
        Optional<PostModel> postID = postRepostory.findById(id);
        return postID.orElse(null);
    }

    public PostModel update(Long id, PostModel postModel) {
        if(postRepostory.existsById(id)){
            return postRepostory.save(postModel);
        }
        return null;
    }

    public void delete(Long id) {
        postRepostory.deleteById(id);
    }
}
