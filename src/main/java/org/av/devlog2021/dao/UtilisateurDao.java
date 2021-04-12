package org.av.devlog2021.dao;

import org.av.devlog2021.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer>
{
    Utilisateur findByLogin(String login);
}
