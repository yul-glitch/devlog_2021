package org.av.devlog2021.model;

import com.fasterxml.jackson.annotation.JsonView;
import org.av.devlog2021.view.CustomJsonView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Statut
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({CustomJsonView.VueUtilisateur.class, CustomJsonView.VueStatut.class})
    private int id;

    @JsonView({CustomJsonView.VueUtilisateur.class, CustomJsonView.VueStatut.class})
    private String denomination;

//    @JsonView({CustomJsonView.VueStatut.class})
    @OneToMany(mappedBy = "statut")
    private List<Utilisateur> listeUtilisateur;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDenomination()
    {
        return denomination;
    }

    public void setDenomination(String denomination)
    {
        this.denomination = denomination;
    }
}
