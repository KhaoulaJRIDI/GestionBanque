package app.gestion.banque.controllers;

import app.gestion.banque.entities.User;
import app.gestion.banque.repositories.UserRepository;
import app.gestion.banque.security.JwtService;
import app.gestion.banque.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import app.gestion.banque.dto.AuthentificationDTO;

import java.util.Collection;
import java.util.List;
import java.util.Map;


@AllArgsConstructor
@RestController
public class UserController {

    private AuthenticationManager authenticationManager;
    private UserService utilisateurService;
    private JwtService jwtService;
@Autowired
    UserRepository userRepository;
/*@GetMapping  ("users")
public Collection<User> all(){

    return userRepository.findAll();
    }*/
    @PostMapping(path = "inscription")
    public void inscription(@RequestBody User utilisateur) {

        utilisateurService.inscription(utilisateur);

    }

    @PostMapping(path = "activation")
    public void activation(@RequestBody Map<String, String> activation) {
        this.utilisateurService.activation(activation);
    }

    @PostMapping(path = "connexion")
    public Map<String, String> connexion(@RequestBody AuthentificationDTO authentificationDTO) {
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authentificationDTO.username(), authentificationDTO.password())
        );

        if (authenticate.isAuthenticated()) {
            return this.jwtService.generate(authentificationDTO.username());
        }
        return null;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATEUR')")
    @GetMapping("/users")
    public List<User> liste(){
    return this.utilisateurService.liste();
    }

}