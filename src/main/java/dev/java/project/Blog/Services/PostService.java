package dev.java.project.Blog.Services;


import dev.java.project.Blog.Repositories.PostRepostory;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepostory postRepostory;

    public PostService(PostRepostory postRepostory) {
        this.postRepostory = postRepostory;
    }
}
