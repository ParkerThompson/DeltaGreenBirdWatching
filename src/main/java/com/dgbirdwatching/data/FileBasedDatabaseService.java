package com.dgbirdwatching.data;

import com.dgbirdwatching.entities.Bond;
import com.dgbirdwatching.entities.Employer;
import com.dgbirdwatching.entities.Profession;
import com.dgbirdwatching.entities.Skill;
import com.dgbirdwatching.entities.Weapon;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FileBasedDatabaseService implements DatabaseService{
    private Gson gson = new Gson();
    private static final String BASE_DIR = "resources/";
    private static final String SKILLS_PATH = BASE_DIR + "skills.txt";
    private static final String EMPLOYER_PATH = BASE_DIR + "employers.txt";
    private static final String PROFESSION_PATH = BASE_DIR + "professions.txt";
    private static final String WEAPON_PATH = BASE_DIR + "weapons.txt";
    private static final String NAME_PATH = BASE_DIR + "names.txt";
    private static final String BONDS_PATH = BASE_DIR + "bonds.txt";
    private static final String DESCRIPTION_PATH = BASE_DIR + "description.txt";
    private Map<String, Skill> skillsMap;
    private Map<String, List<Employer>> employersMap;
    private Map<String, Profession> professionMap = new HashMap<>();
    private Map<String, Map<String, Weapon>> weaponMap;
    private Map<String, Map<String, List<String>>> names;
    private Map<String, Bond> bonds;
    private Map<String, List<String>> descriptions;

    public FileBasedDatabaseService() {
        skillsMap = getFromGson(new TypeToken<Map<String, Skill>>() {}.getType(), SKILLS_PATH);
        employersMap = getFromGson(new TypeToken<Map<String, List<Employer>>>() {}.getType(), EMPLOYER_PATH);
        weaponMap = getFromGson(new TypeToken<Map<String, Map<String, Weapon>>>() {}.getType(), WEAPON_PATH);
        names = getFromGson(new TypeToken<Map<String, Map<String, List<String>>>>() {}.getType(), NAME_PATH);
        bonds = getFromGson(new TypeToken<Map<String, Bond>>() {}.getType(), BONDS_PATH);
        descriptions = getFromGson(new TypeToken<Map<String, List<String>>>() {}.getType(), DESCRIPTION_PATH);
        ((Map<String, Map>) Objects.requireNonNull(getFromGson(new TypeToken<Map>() {
        }.getType(), PROFESSION_PATH))).forEach((key, value) -> {
            List<Employer> employersForProf = new ArrayList<>();
            for (String listName : ((List<String>) value.get("employers"))) {
                employersForProf.addAll(employersMap.get(listName));
            }
            value.put("name", key);
            value.put("employers", employersForProf);
            value.put("weapons", ((List<List<String>>) value.get("weapons"))
                    .stream().map(weaponString ->
                            parseWeapon(weaponString.get(0), weaponString.get(1))).collect(Collectors.toList()));

            value.put("defaultSkills", ((List<Map<String, String>>) value.get("defaultSkills")).stream()
                    .map(this::parseSkill).collect(Collectors.toList()));
            if (value.containsKey("optionalSkills")) {
                value.put("optionalSkills", ((List<Map<String, String>>) value.get("optionalSkills")).stream()
                        .map(this::parseSkill).collect(Collectors.toList()));
            }
            professionMap.put(key, gson.fromJson(gson.toJson(value), Profession.class));
        });
    }

    private Weapon parseWeapon(String name, String friendlyName) {
        Weapon weapon =
                Objects.requireNonNull(weaponMap.values().stream().filter(stringWeaponMap -> stringWeaponMap.containsKey(name)).findAny()
                .orElse(null)).get(name);
            weapon.setWeaponName(name);
            weapon.setFriendlyName(friendlyName);
            return weapon;
    }

    private Skill parseSkill(Map skillMap) {
        String skillName = skillMap.get("name").toString().replaceAll("-", " ");
        String input = null;
        if(skillName.contains("(")) {
            String[]nameParts = skillName.split("\\(");
            skillName = nameParts[0];
            input = nameParts[1].replace(")","");
        }
        Skill skill = skillsMap.get(skillName);
        if(skillMap.containsKey("value")) {
            double value = Double.parseDouble(skillMap.get("value").toString());
            skill.setProfessionBase((int) value);
        }
        if(skillMap.containsKey("exclusive")) {
            skill.setExclusive(skillsMap.get(skillMap.get("exclusive").toString()));
        }
        if(input != null) {
            skill.setInput(input);
        }
        return skill;
    }

    private <T> T getFromGson(Type type, String path) {
        try {
            return gson.fromJson(new FileReader(new File(path)), type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Skill> getAllSkills() {
        return new ArrayList<>(skillsMap.values());
    }

    @Override
    public Map<String, Map<String, Weapon>> getAllWeapons() {
        return weaponMap;
    }

    @Override
    public List<Profession> getAllProfessions() {
        return new ArrayList<>(professionMap.values());
    }

    @Override
    public Set<Employer> getAllEmployers() {
        Set<Employer> out = new HashSet<>();
        employersMap.values().forEach(out::addAll);
        return out;
    }

    @Override
    public Map<String, List<String>> getNamesForNationality(String nationality) {
        return names.get(nationality);
    }

    @Override
    public List<Bond> getAllBonds() {
        return new ArrayList<>(bonds.values());
    }

    @Override
    public Map<String, List<String>> getAllDescriptions() {
        return descriptions;
    }

    @Override
    public Employer getEmployer(String name) {
        return
                employersMap.values().stream().findFirst().map(employerList -> employerList.stream().filter
                        (employer -> employer.getName().equalsIgnoreCase(name)).findFirst().get()).orElse(null);
    }

}
