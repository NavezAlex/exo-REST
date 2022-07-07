package com.example.tffsjavarestapi.controllers;

import com.example.tffsjavarestapi.models.dtos.jwt.JwtRequest;
import com.example.tffsjavarestapi.models.dtos.jwt.JwtResponse;
import com.example.tffsjavarestapi.services.security.JwtUserDetailsService;
import com.example.tffsjavarestapi.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class AuthenticationController {
    private final Logger logger = LoggerFactory.getLogger("auth");
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService userDetailsService;

    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, JwtUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping(path = "/signin")
    public ResponseEntity<JwtResponse> signInAction(@RequestBody JwtRequest request) throws Exception {
        authenticate(request.getUsername(), request.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        List<String> roles = jwtTokenUtil.getClaimFromToken(token, c -> c.get("roles", List.class));

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDIENTALS", e);
        } catch (Exception e) {
            throw new Exception("OTHER", e);
        }
    }
}
