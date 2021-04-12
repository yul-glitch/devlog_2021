package org.av.devlog2021.dao;

import org.av.devlog2021.model.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceDao extends JpaRepository<Competence, Integer>
{

}
