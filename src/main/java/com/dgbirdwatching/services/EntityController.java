package com.dgbirdwatching.services;

import com.dgbirdwatching.data.DatabaseService;
import com.dgbirdwatching.entities.Bond;
import com.dgbirdwatching.entities.Employer;
import com.dgbirdwatching.entities.Profession;
import com.dgbirdwatching.entities.Skill;
import com.dgbirdwatching.entities.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RestController
public class EntityController {
    @Autowired
    private DatabaseService databaseService;

    @CrossOrigin
    @RequestMapping("/skills")
    public List<Skill> getAllSkills() {
        return databaseService.getAllSkills();
    }

    @CrossOrigin
    @RequestMapping("/weapons")
    public Map<String, Map<String, Weapon>> getAllWeapons() {
        return databaseService.getAllWeapons();
    }

    @CrossOrigin
    @RequestMapping("/professions")
    public List<Profession> getAllProfessions() {
        return databaseService.getAllProfessions();
    }

    @CrossOrigin
    @RequestMapping("/employers")
    public Set<Employer> getAllEmployers() {
        return databaseService.getAllEmployers();
    }

    @CrossOrigin
    @RequestMapping("/bonds")
    public List<Bond> getAllBonds() {
        return databaseService.getAllBonds();
    }

    @CrossOrigin
    @RequestMapping("/descriptions")
    public Map<String, List<String>> getAllDescriptions() {
        return databaseService.getAllDescriptions();
    }
}
