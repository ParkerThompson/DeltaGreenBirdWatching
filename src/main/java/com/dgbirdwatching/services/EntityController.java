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

    @RequestMapping("/skills")
    public List<Skill> getAllSkills() {
        return databaseService.getAllSkills();
    }

    @RequestMapping("/weapons")
    public Map<String, Map<String, Weapon>> getAllWeapons() {
        return databaseService.getAllWeapons();
    }

    @RequestMapping("/professions")
    public List<Profession> getAllProfessions() {
        return databaseService.getAllProfessions();
    }

    @RequestMapping("/employers")
    public Set<Employer> getAllEmployers() {
        return databaseService.getAllEmployers();
    }

    @RequestMapping("/bonds")
    public List<Bond> getAllBonds() {
        return databaseService.getAllBonds();
    }

    @RequestMapping("/descriptions")
    public Map<String, List<String>> getAllDescriptions() {
        return databaseService.getAllDescriptions();
    }
}
