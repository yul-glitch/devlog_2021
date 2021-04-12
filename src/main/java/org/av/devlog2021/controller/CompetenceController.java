package org.av.devlog2021.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.av.devlog2021.dao.CompetenceDao;
import org.av.devlog2021.model.Competence;
import org.av.devlog2021.view.CustomJsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class CompetenceController
{
    private CompetenceDao competenceDao;

    @Autowired
    public CompetenceController(CompetenceDao competenceDao)
    {
        this.competenceDao = competenceDao;
    }

    @GetMapping("/competences")
    public List<Competence> getCompetence()
    {
        return competenceDao.findAll();
    }

    @GetMapping("/competence/{id}")
    @JsonView({CustomJsonView.VueCompetence.class})
    public Competence getCompetence(@PathVariable int id)
    {
        return competenceDao.findById(id).orElse(null);
    }

    @PostMapping("/competence")
    @JsonView({CustomJsonView.VueCompetence.class})
    public boolean addCompetence(@RequestBody Competence competence)
    {
//        competenceDao.save(competence);
        competenceDao.saveAndFlush(competence);
        return true;
    }

    @DeleteMapping("/competence/{id}")
    public boolean deleteCompetence(@PathVariable int id)
    {
        competenceDao.deleteById(id);
        return true;
    }

}