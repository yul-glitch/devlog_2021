package org.av.devlog2021.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.av.devlog2021.dao.UtilisateurDao;
import org.av.devlog2021.model.Utilisateur;
import org.av.devlog2021.security.JwtUtil;
import org.av.devlog2021.security.UserDetailsServiceCustom;
import org.av.devlog2021.view.CustomJsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class UtilisateurController
{
    private UtilisateurDao utilisateurDao;
    private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;
    private UserDetailsServiceCustom userDetailsServiceCustom;
//
//    @Autowired
//    public UtilisateurController(UtilisateurDao utilisateurDao)
    @Autowired
    UtilisateurController(
            UtilisateurDao utilisateurDao,
            JwtUtil jwtUtil,
            AuthenticationManager authenticationManager,
            UserDetailsServiceCustom userDetailsServiceCustom
    )
    {
        this.utilisateurDao = utilisateurDao;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.userDetailsServiceCustom = userDetailsServiceCustom;
    }

    @PostMapping("/authentification")
    public String authentification(@RequestBody Utilisateur utilisateur)
    {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        utilisateur.getLogin(), utilisateur.getPassword()
                )
        );
        UserDetails userDetails = this.userDetailsServiceCustom.loadUserByUsername(utilisateur.getLogin());
        return jwtUtil.generateToken(userDetails);
    }

    @GetMapping("/user/utilisateurs")
    @JsonView({CustomJsonView.VueUtilisateur.class})
    public List<Utilisateur> getUtilisateur()
    {
        return utilisateurDao.findAll();
    }


    @GetMapping("/user/utilisateur/{id}")
    @JsonView({CustomJsonView.VueUtilisateur.class})
    public Utilisateur getUtilisateur(@PathVariable int id)
    {
        return utilisateurDao.findById(id).orElse(null);
    }

    @PostMapping("/admin/utilisateur")
    public boolean addUtilisateur(@RequestBody Utilisateur utilisateur)
    {
//        utilisateurDao.save(utilisateur);
        utilisateurDao.saveAndFlush(utilisateur);
        return true;
    }

    @DeleteMapping("/admin/utilisateur/{id}")
    public boolean deleteUtilisateur(@PathVariable int id)
    {
        utilisateurDao.deleteById(id);
        return true;
    }

}
