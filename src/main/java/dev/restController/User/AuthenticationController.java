package dev.restController.User;

import dev.domain.User.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
public class AuthenticationController {


    private AuthenticationManager authenticationManager;
    @PostMapping("/authenticate") // Choose a suitable endpoint name
  /*  @PreAuthorize("isAuthenticated()") // Ensure authentication is required*/
    public ResponseEntity<HttpStatus> authenticate(@RequestBody LoginRequest loginRequest) throws Exception {
        Authentication authentication;
       try{
           authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
           SecurityContextHolder.getContext().setAuthentication(authentication);
       }catch ( BadCredentialsException e){
           throw new Exception("invalid");
       }
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
}

