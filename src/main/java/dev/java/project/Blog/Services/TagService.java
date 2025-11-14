package dev.java.project.Blog.Services;

import dev.java.project.Blog.Models.TagModel;
import dev.java.project.Blog.Repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public TagModel save(TagModel tagModel){
        return tagRepository.save(tagModel);
    }

    public List<TagModel> getAll(){
        return tagRepository.findAll();
    }

    public TagModel getById(Long id) {
        Optional<TagModel> tagId = tagRepository.findById(id);
        return tagId.orElse(null);
    }

    public TagModel update(Long id, TagModel tagModel){
        if(tagRepository.existsById(id)){
            return tagRepository.save(tagModel);
        }
        return null;
    }

    public void delete(Long id){
        tagRepository.deleteById(id);
    }
}
