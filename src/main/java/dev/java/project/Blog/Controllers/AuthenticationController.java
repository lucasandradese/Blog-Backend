package dev.java.project.Blog.Controllers;

import dev.java.project.Blog.Request.AuthRequest;
import dev.java.project.Blog.Response.AuthResponse;
import dev.java.project.Blog.Services.AutheticantionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AutheticantionService autheticantionService;

    @PostMapping(path="/login")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public AuthResponse login(@RequestBody final AuthRequest auth) {

        UsernamePasswordAuthenticationToken userAuthenticationToken = new UsernamePasswordAuthenticationToken(auth.getUsername(), auth.getPassword());

        authenticationManager.authenticate(userAuthenticationToken);

        return new AuthResponse(autheticantionService.getToken(auth));
    }
}
