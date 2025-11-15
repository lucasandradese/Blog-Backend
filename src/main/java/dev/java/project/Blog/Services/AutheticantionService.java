package dev.java.project.Blog.Services;

import dev.java.project.Blog.Request.AuthRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AutheticantionService extends UserDetailsService {

    String getToken(AuthRequest auth);

    String validateJwtToken(String token);
}
