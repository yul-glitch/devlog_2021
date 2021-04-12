package org.av.devlog2021.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.av.devlog2021.dao.StatutDao;
import org.av.devlog2021.model.Statut;
import org.av.devlog2021.view.CustomJsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class StatutController
{
    private StatutDao statutDao;

    @Autowired
    public StatutController(StatutDao statutDao)
    {
        this.statutDao = statutDao;
    }

    @GetMapping("/statuts")
    @JsonView({CustomJsonView.VueStatut.class})
    public List<Statut> getStatut()
    {
        return statutDao.findAll();
    }

    @GetMapping("/statut/{id}")
    @JsonView({CustomJsonView.VueStatut.class})
    public Statut getStatut(@PathVariable int id)
    {
        return statutDao.findById(id).orElse(null);
    }

    @PostMapping("/statut")
    @JsonView({CustomJsonView.VueStatut.class})
    public boolean addStatut(@RequestBody Statut statut)
    {
        statutDao.save(statut);
        return true;
    }

    @DeleteMapping("/statut/{id}")
    public boolean deleteStatut(@PathVariable int id)
    {
        statutDao.deleteById(id);
        return true;
    }

}