package org.av.devlog2021.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.av.devlog2021.view.CustomJsonView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Competence
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({CustomJsonView.VueUtilisateur.class, CustomJsonView.VueCompetence.class})
    private int id;

    @JsonView({CustomJsonView.VueUtilisateur.class, CustomJsonView.VueCompetence.class})
    private String nom;

    //    @JsonIgnore
    @ManyToMany(mappedBy = "listeCompetence")
    @JsonView({CustomJsonView.VueCompetence.class})
    private List<Utilisateur> utilisateurList;

    public Competence() { }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public List<Utilisateur> getUtilisateurList() { return utilisateurList; }

    public void setUtilisateurList(List<Utilisateur> utilisateurList) { this.utilisateurList = utilisateurList; }
}
