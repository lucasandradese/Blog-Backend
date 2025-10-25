package dev.java.project.Blog.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java.project.Blog.Enums.RoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 125)
    private String name;

    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "RoleEnum")
    private RoleEnum role;

    @Column(name = "username")
    private String username;

}
