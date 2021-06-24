package com.dgbirdwatching.data;

import com.dgbirdwatching.entities.Bond;
import com.dgbirdwatching.entities.Employer;
import com.dgbirdwatching.entities.Profession;
import com.dgbirdwatching.entities.Skill;
import com.dgbirdwatching.entities.Weapon;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DatabaseService {
    List<Skill> getAllSkills();
    Map<String, Map<String, Weapon>> getAllWeapons();
    List<Profession> getAllProfessions();
    Set<Employer> getAllEmployers();
    Map<String, List<String>> getNamesForNationality(String nationality);
    List<Bond> getAllBonds();
    Map<String, List<String>> getAllDescriptions();
    Employer getEmployer(String name);
}
