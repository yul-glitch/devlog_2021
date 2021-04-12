package org.av.devlog2021.model;

import com.fasterxml.jackson.annotation.JsonView;
import org.av.devlog2021.view.CustomJsonView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({CustomJsonView.VueUtilisateur.class, CustomJsonView.VueRole.class})
    private int id;

    @JsonView({CustomJsonView.VueUtilisateur.class, CustomJsonView.VueRole.class})
    private String denomination;

    @ManyToMany(mappedBy = "listeRole")
    @JsonView({CustomJsonView.VueRole.class})
    private List<Utilisateur> utilisateurList;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getDenomination() { return denomination; }
    public void setDenomination(String denomination) { this.denomination = denomination; }
    public List<Utilisateur> getUtilisateurList() { return utilisateurList; }
    public void setUtilisateurList(List<Utilisateur> utilisateurList) { this.utilisateurList = utilisateurList; }
}
