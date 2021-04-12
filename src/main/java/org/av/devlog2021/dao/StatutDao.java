package org.av.devlog2021.dao;

import org.av.devlog2021.model.Statut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutDao extends JpaRepository<Statut, Integer>
{

}
