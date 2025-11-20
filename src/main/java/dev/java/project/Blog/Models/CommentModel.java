package dev.java.project.Blog.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comment")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CommentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    private Date data;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel userId;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostModel postId;

}
