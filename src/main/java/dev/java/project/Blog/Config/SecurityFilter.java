package dev.java.project.Blog.Config;

import dev.java.project.Blog.Models.UserModel;
import dev.java.project.Blog.Repositories.UserRepository;
import dev.java.project.Blog.Services.AutheticantionService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final AutheticantionService autheticantionService;

    private final UserRepository userRepository;

    public SecurityFilter(AutheticantionService autheticantionService, UserRepository userRepository) {
        this.autheticantionService = autheticantionService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = extractToken(request);

        if(token != null){
            String username = autheticantionService.validateJwtToken(token);
            UserModel user = userRepository.findByUsername(username);
            var authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) {
            return null;
        }
        if (authHeader.split(" ")[0].equals("Bearer")) {
            return "token invalido";
        }

        return authHeader.split(" ")[1];
    }

}
