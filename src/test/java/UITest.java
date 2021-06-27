import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.assertj.core.data.MapEntry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class UITest {

    private WebDriver driver;

    private static final String ANTHROPOLOGIST = "anthropologist";
    private static final String ENGINEER = "engineer";
    private static final String FEDERAL_AGENT = "federal-agent";
    private static final String SPECIAL_OPERATOR = "special-operator";
    private static final String PHYSICIAN = "physician";
    private static final String SCIENTIST = "scientist";
    private static final String CRIMINAL = "criminal";
    private static final String FIREFIGHTER = "firefighter";
    private static final String FOREIGN_SERVICE_OFFICER = "foreign-service-officer";
    private static final String INTELLIGENCE_ANALYST = "intelligence-analyst";
    private static final String INTELLIGENCE_OFFICER = "intelligence-case-officer";
    private static final String LAWYER = "lawyer";
    private static final String MEDIA_SPECIALIST = "media-specialist";
    private static final String NURSE = "nurse";
    private static final String PILOT = "pilot";
    private static final String POLICE_OFFICER = "police-officer";
    private static final String PROGRAM_MANAGER = "program-manager";
    private static final String SOLDIER = "soldier";

    private static final String ACCOUNTING = "accounting";
    private static final String HISTORY = "history";
    private static final String UNNATURAL = "unnatural";
    private static final String ALERTNESS = "alertness";
    private static final String HUMINT = "humint";
    private static final String ANTHROPOLOGY = "anthropology";
    private static final String LAW = "law";
    private static final String ARCHEOLOGY = "archeology";
    private static final String MEDICINE = "medicine";
    private static final String ARTILLERY = "artillery";
    private static final String MELEE_WEAPONS = "melee-weapons";
    private static final String ATHLETICS = "athletics";
    private static final String NAVIGATE = "navigate";
    private static final String BUREAUCRACY = "bureaucracy";
    private static final String OCCULT = "occult";
    private static final String COMPUTER_SCIENCE = "computer-science";
    private static final String PERSUADE = "persuade";
    private static final String CRIMINOLOGY = "criminology";
    private static final String PHARMACY = "pharmacy";
    private static final String DEMOLITIONS = "demolitions";
    private static final String PSYCHOTHERAPY = "psychotherapy";
    private static final String DISGUISE = "disguise";
    private static final String RIDE = "ride";
    private static final String DODGE = "dodge";
    private static final String SEARCH = "search";
    private static final String DRIVE = "drive";
    private static final String SIGINT = "sigint";
    private static final String FIREARMS = "firearms";
    private static final String STEALTH = "stealth";
    private static final String FIRST_AID = "first-aid";
    private static final String SURGERY = "surgery";
    private static final String FORENSICS = "forensics";
    private static final String SURVIVAL = "survival";
    private static final String HEAVY_MACHINERY = "heavy-machinery";
    private static final String SWIM = "swim";
    private static final String HEAVY_WEAPONS = "heavy-weapons";
    private static final String UNARMED_COMBAT = "unarmed-combat";

    private static final String CRAFT = "craft";
    private static final String CRAFT_CHECK = "craft-check";
    private static final String SCIENCE = "science";
    private static final String SCIENCE_CHECK = "science-check";
    private static final String MILITARY_SCIENCE = "military-science";
    private static final String MILITARY_SCIENCE_CHECK = "military-science-check";
    private static final String ART = "art";
    private static final String ART_CHECK = "art-check";
    private static final String PILOT_SKILL = "pilot";
    private static final String PILOT_SKILL_CHECK = "pilot-check";
    private static final String FOREIGN_LANGUAGE = "foreign-language";
    private static final String FOREIGN_LANGUAGE_CHECK = "foreign-language-check";

    private static final List<String> ALL_SKILLS = Arrays.asList(ACCOUNTING, HISTORY, UNNATURAL, ALERTNESS, HUMINT,
            ANTHROPOLOGY, LAW, ARCHEOLOGY, MEDICINE, ARTILLERY, MELEE_WEAPONS, ATHLETICS, NAVIGATE, BUREAUCRACY,
            OCCULT, COMPUTER_SCIENCE, PERSUADE, CRIMINOLOGY, PHARMACY, DEMOLITIONS, PSYCHOTHERAPY, DISGUISE, RIDE,
            DODGE, SEARCH, DRIVE, SIGINT, FIREARMS, STEALTH, FIRST_AID, SURGERY, FORENSICS, SURVIVAL, HEAVY_MACHINERY,
            SWIM, HEAVY_WEAPONS, UNARMED_COMBAT, CRAFT, SCIENCE, MILITARY_SCIENCE, ART, PILOT_SKILL, FOREIGN_LANGUAGE);
    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("http://dgbirdwatching.com/CharacterSheet.html");
    }

    @After
    public void teardown() {
        driver.close();
    }

    private void click(String id) {
        WebElement element = driver.findElement(By.id(id));
        element.click();
    }

    private void inputText(String id, String text) {
        WebElement language = driver.findElement(By.id(id));
        language.clear();
        language.sendKeys(text);
    }

    private String getSkillString(String profession, String skill) {
        return profession + "-" + skill;
    }

    private String getValue(String id) {
        WebElement element = driver.findElement(By.id(id));
        return element.getAttribute("value");
    }

    private void checkAllSkillValues(Map<String, String> skillMap) {
        List<WebElement> skills = driver.findElements(By.className("skill"));
        for(String skillKey: skillMap.keySet()) {
            driver.findElement(By.id(skillKey));
        }
        for (WebElement skill : skills) {
            if (!skillMap.containsKey(skill.getAttribute("id"))) {
                assertThat(skill.getAttribute("base")).as(skill.getAttribute("id")).isEqualTo(skill.getAttribute("value"));
            } else {
                assertThat(skillMap.get(skill.getAttribute("id"))).as(skill.getAttribute("id")).isEqualTo(skill.getAttribute("value"));
            }
        }
    }

    private void checkAllEnabled(List<String> enabled) {
        checkAllEnabled(enabled, Collections.emptyList());
    }

    private void checkAllEnabled(List<String> enabled, List<String> disabled) {
        for (String id : enabled) {
            WebElement element = driver.findElement(By.id(id));
            assertThat(element.isEnabled()).as(id + " enabled").isTrue();
        }

        for (String id : disabled) {
            WebElement element = driver.findElement(By.id(id));
            assertThat(element.isEnabled()).as(id + " enabled").isFalse();
        }

    }

    private void checkAllEnabled(Map<String, Boolean> skills) {
        for (Map.Entry<String, Boolean> skillEntry : skills.entrySet()) {
            WebElement element = driver.findElement(By.id(skillEntry.getKey()));
            assertThat(element.isEnabled()).as(skillEntry.getKey() + " enabled").isEqualTo(skillEntry.getValue());
        }
    }

    private void assertOtherSkill(int position, String text, String value) {
        assertEquals(driver.findElements(By.className("other-skill-name")).get(position).getAttribute("value"), text);
        assertEquals(driver.findElements(By.className("other-skill")).get(position).getAttribute("value"), value);
    }

    private void openProfessionModal() {
        click("professions");
    }

    private void selectProfession(String currentProfession, String newProfession) {
        select(currentProfession + "-professions", newProfession);
    }

    private void select(String id, String value) {
        Select select = new Select(driver.findElement(By.id(id)));
        select.selectByValue(value);
    }

    private String getChildElementValue(WebElement parent, String className) {
        return parent.findElement(By.className(className)).getAttribute("value");
    }

    private void testWeapon(WebElement parent, String weaponName, String skill, String range, String damage, String piercing, String lethality, String killRadius, String ammo) {
        testWeapon(parent, weaponName, skill, range, Collections.singletonList(damage), piercing, lethality, killRadius, ammo);
    }

    private void testWeapon(WebElement parent, String weaponName, String skill, String range, List<String> damage, String piercing, String lethality, String killRadius, String ammo) {
        assertThat(getChildElementValue(parent, "weapon-name")).isEqualTo(weaponName);
        assertThat(getChildElementValue(parent, "weapon-skill")).isEqualTo(skill);
        assertThat(getChildElementValue(parent, "weapon-range")).isEqualTo(range);
        assertThat(getChildElementValue(parent, "weapon-piercing")).isEqualTo(piercing);
        assertThat(getChildElementValue(parent, "weapon-lethality")).isEqualTo(lethality);
        assertThat(getChildElementValue(parent, "weapon-kill-radius")).isEqualTo(killRadius);
        assertThat(getChildElementValue(parent, "weapon-ammo")).isEqualTo(ammo);
        if(damage.size() > 1) {
            for (int i = 1; i < 19; i++) {
                driver.findElement(By.id("str-score")).clear();
                driver.findElement(By.id("str-score")).sendKeys(i + "");
                driver.findElement(By.id("dex-score")).click();
                assertThat(getChildElementValue(parent, "weapon-damage")).isEqualTo(damage.get((i-1)/4));
                //1-4: 0
                //5-8: 1
                //9-12: 2
                //13-16: 3
                //17-18: 4
            }
        }
        else {
            assertThat(getChildElementValue(parent, "weapon-damage")).isEqualTo(damage.get(0));
        }

    }

    private boolean listContainsOtherSkillsByRegex(List<String> otherSkills, List<String> skills) {
        for(String skill: skills) {
            otherSkills.removeIf(skill::matches);
        }
        return otherSkills.isEmpty();
    }

    private boolean listContainsOtherSkills(List<String> otherSkills, List<String> skills) {
        for(String skill: skills) {
            otherSkills.removeIf(skill::equals);
        }
        return otherSkills.isEmpty();
    }

    @Test
    public void testAnthropologistAnthroArchHumint() {
        openProfessionModal();
        click(ANTHROPOLOGIST + "-" + ANTHROPOLOGY + "Opt");
        inputText(getSkillString(ANTHROPOLOGIST, FOREIGN_LANGUAGE) + "1", "Spanish");

        checkAllEnabled(Arrays.asList(
                getSkillString(ANTHROPOLOGIST, ARCHEOLOGY),
                getSkillString(ANTHROPOLOGIST, HUMINT),
                getSkillString(ANTHROPOLOGIST, NAVIGATE),
                getSkillString(ANTHROPOLOGIST, RIDE),
                getSkillString(ANTHROPOLOGIST, SEARCH),
                getSkillString(ANTHROPOLOGIST, SURVIVAL),
                getSkillString(ANTHROPOLOGIST, FOREIGN_LANGUAGE) + "1"),
                Collections.emptyList());

        click(getSkillString(ANTHROPOLOGIST, ARCHEOLOGY));
        click(getSkillString(ANTHROPOLOGIST, HUMINT));

        checkAllEnabled(Arrays.asList(
                getSkillString(ANTHROPOLOGIST, ARCHEOLOGY),
                getSkillString(ANTHROPOLOGIST, HUMINT)),
                Arrays.asList(
                        getSkillString(ANTHROPOLOGIST, NAVIGATE),
                        getSkillString(ANTHROPOLOGIST, RIDE),
                        getSkillString(ANTHROPOLOGIST, SEARCH),
                        getSkillString(ANTHROPOLOGIST, SURVIVAL)));

        click(ANTHROPOLOGIST + "Confirm");

        Map<String, String> skillMap = Map.of(
                ANTHROPOLOGY, "50",
                HISTORY, "40",
                OCCULT, "40",
                PERSUADE, "40",
                ARCHEOLOGY, "50",
                HUMINT, "50");
        checkAllSkillValues(skillMap);

        assertOtherSkill(0, "Foreign Language 40%\n(Spanish)", "40");
    }

    private String selectWeapon(WebElement selectElement, String value) {
        Select select = new Select(selectElement);
        select.selectByValue(value);
        String id = (selectElement.getAttribute("id"));
        String[] idSplit = id.split("-");
        return idSplit[0] + "-row-" + idSplit[1];
    }

    @Test
    public void testAnthropologistArchNavigateRide() {
        openProfessionModal();
        click(getSkillString(ANTHROPOLOGIST, ARCHEOLOGY) + "Opt");
        inputText(getSkillString(ANTHROPOLOGIST, FOREIGN_LANGUAGE) + "1", "Spanish");

        checkAllEnabled(
                Arrays.asList(
                        getSkillString(ANTHROPOLOGIST, ANTHROPOLOGY),
                        getSkillString(ANTHROPOLOGIST, HUMINT),
                        getSkillString(ANTHROPOLOGIST, NAVIGATE),
                        getSkillString(ANTHROPOLOGIST, RIDE),
                        getSkillString(ANTHROPOLOGIST, SEARCH),
                        getSkillString(ANTHROPOLOGIST, SURVIVAL),
                        getSkillString(ANTHROPOLOGIST, FOREIGN_LANGUAGE) + "1"),
                Collections.singletonList(getSkillString(ANTHROPOLOGIST, ARCHEOLOGY)));

        click(getSkillString(ANTHROPOLOGIST, NAVIGATE));
        click(getSkillString(ANTHROPOLOGIST, RIDE));

        checkAllEnabled(Arrays.asList(getSkillString(ANTHROPOLOGIST, NAVIGATE), getSkillString(ANTHROPOLOGIST, RIDE), getSkillString(ANTHROPOLOGIST, FOREIGN_LANGUAGE) + "1"),
                Arrays.asList(getSkillString(ANTHROPOLOGIST, HUMINT), getSkillString(ANTHROPOLOGIST, SEARCH), getSkillString(ANTHROPOLOGIST, ARCHEOLOGY), getSkillString(ANTHROPOLOGIST, SURVIVAL)));

        click(ANTHROPOLOGIST + "Confirm");

        Map<String, String> skillMap = Map.of(ARCHEOLOGY, "50", HISTORY, "40", OCCULT,
                "40", PERSUADE, "40", NAVIGATE, "50", RIDE, "50");
        checkAllSkillValues(skillMap);

        assertEquals(driver.findElements(By.className("other-skill-name")).get(0).getAttribute("value"), "Foreign Language 40%\n(Spanish)");
        assertEquals(driver.findElements(By.className("other-skill")).get(0).getAttribute("value"), "40");
    }

    @Test
    public void testAnthropologistArchSearchSurvival() {
        openProfessionModal();
        click(getSkillString(ANTHROPOLOGIST, ARCHEOLOGY) + "Opt");
        inputText(getSkillString(ANTHROPOLOGIST, FOREIGN_LANGUAGE) + "1", "Spanish");

        checkAllEnabled(Arrays.asList(getSkillString(ANTHROPOLOGIST, ANTHROPOLOGY), getSkillString(ANTHROPOLOGIST, HUMINT), getSkillString(ANTHROPOLOGIST, NAVIGATE),
                getSkillString(ANTHROPOLOGIST, RIDE), getSkillString(ANTHROPOLOGIST, SEARCH), getSkillString(ANTHROPOLOGIST, SURVIVAL)),
                Collections.singletonList(getSkillString(ANTHROPOLOGIST, ARCHEOLOGY)));

        click(getSkillString(ANTHROPOLOGIST, SEARCH));
        click(getSkillString(ANTHROPOLOGIST, SURVIVAL));

        checkAllEnabled(Arrays.asList(getSkillString(ANTHROPOLOGIST, SEARCH), getSkillString(ANTHROPOLOGIST, SURVIVAL),
                getSkillString(ANTHROPOLOGIST, FOREIGN_LANGUAGE) + "1"),
                Arrays.asList(getSkillString(ANTHROPOLOGIST, ANTHROPOLOGY), getSkillString(ANTHROPOLOGIST, HUMINT), getSkillString(ANTHROPOLOGIST, ARCHEOLOGY),
                        getSkillString(ANTHROPOLOGIST, NAVIGATE), getSkillString(ANTHROPOLOGIST, RIDE)));

        click(ANTHROPOLOGIST + "Confirm");

        Map<String, String> skillMap = Map.of(ARCHEOLOGY, "50", HISTORY, "40", OCCULT,
                "40", PERSUADE, "40", SEARCH, "60", SURVIVAL, "50");
        checkAllSkillValues(skillMap);

        assertEquals(driver.findElements(By.className("other-skill-name")).get(0).getAttribute("value"), "Foreign Language 40%\n(Spanish)");
        assertEquals(driver.findElements(By.className("other-skill")).get(0).getAttribute("value"), "40");
    }

    @Test
    public void testEngineerLanguageAccountingBureaucracyCraft() {
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, ENGINEER);

        checkAllEnabled(Arrays.asList(getSkillString(ENGINEER, ACCOUNTING), getSkillString(ENGINEER, BUREAUCRACY), getSkillString(ENGINEER, CRAFT),
                getSkillString(ENGINEER, FOREIGN_LANGUAGE), getSkillString(ENGINEER, HEAVY_MACHINERY), getSkillString(ENGINEER, LAW), getSkillString(ENGINEER, SCIENCE)),
                Collections.emptyList());

        click(getSkillString(ENGINEER, FOREIGN_LANGUAGE) + "-check");
        inputText(getSkillString(ENGINEER, FOREIGN_LANGUAGE), "French");

        click(getSkillString(ENGINEER, ACCOUNTING));
        click(getSkillString(ENGINEER, BUREAUCRACY));

        click(getSkillString(ENGINEER, CRAFT) + "-check");
        inputText(getSkillString(ENGINEER, CRAFT), "Weaving");

        checkAllEnabled(Arrays.asList(getSkillString(ENGINEER, FOREIGN_LANGUAGE), getSkillString(ENGINEER, ACCOUNTING), getSkillString(ENGINEER, BUREAUCRACY),
                getSkillString(ENGINEER, CRAFT) + "-check"),
                Arrays.asList(getSkillString(ENGINEER, HEAVY_MACHINERY), getSkillString(ENGINEER, LAW), getSkillString(ENGINEER, SCIENCE) + "-check"));

        click(ENGINEER + "Confirm");

        Map<String, String> skillMap = Map.of(COMPUTER_SCIENCE, "60", SIGINT, "40", ACCOUNTING,
                "50", BUREAUCRACY, "50");

        checkAllSkillValues(skillMap);
        assertEquals(driver.findElements(By.className("other-skill-name")).get(0).getAttribute("value"), "Craft 30%:\n(Electrician) ");
        assertEquals(driver.findElements(By.className("other-skill")).get(0).getAttribute("value"), "30");

        assertEquals(driver.findElements(By.className("other-skill-name")).get(1).getAttribute("value"), "Craft 30%:\n(Mechanic) ");
        assertEquals(driver.findElements(By.className("other-skill")).get(1).getAttribute("value"), "30");

        assertEquals(driver.findElements(By.className("other-skill-name")).get(2).getAttribute("value"), "Craft 40%:\n(Microelectronics) ");
        assertEquals(driver.findElements(By.className("other-skill")).get(2).getAttribute("value"), "40");

        assertEquals(driver.findElements(By.className("other-skill-name")).get(3).getAttribute("value"), "Science 40%:\n(Mathematics) ");
        assertEquals(driver.findElements(By.className("other-skill")).get(3).getAttribute("value"), "40");

        assertEquals(driver.findElements(By.className("other-skill-name")).get(4).getAttribute("value"), "Craft 40%:\n(Weaving) ");
        assertEquals(driver.findElements(By.className("other-skill")).get(4).getAttribute("value"), "40");

        assertEquals(driver.findElements(By.className("other-skill-name")).get(5).getAttribute("value"), "Foreign Language 40%:\n(French) ");
        assertEquals(driver.findElements(By.className("other-skill")).get(5).getAttribute("value"), "40");
    }

    @Test
    public void testEngineerLanguageHeavyMachineryLawScience() {
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, ENGINEER);

        checkAllEnabled(Arrays.asList(getSkillString(ENGINEER, ACCOUNTING), getSkillString(ENGINEER, BUREAUCRACY), getSkillString(ENGINEER, CRAFT),
                getSkillString(ENGINEER, FOREIGN_LANGUAGE), getSkillString(ENGINEER, HEAVY_MACHINERY), getSkillString(ENGINEER, LAW), getSkillString(ENGINEER, SCIENCE)),
                Collections.emptyList());

        click(getSkillString(ENGINEER, FOREIGN_LANGUAGE) + "-check");
        inputText(getSkillString(ENGINEER, FOREIGN_LANGUAGE), "Danish");

        click(getSkillString(ENGINEER, HEAVY_MACHINERY));
        click(getSkillString(ENGINEER, LAW));

        click(getSkillString(ENGINEER, SCIENCE) + "-check");
        inputText(getSkillString(ENGINEER, SCIENCE), "Biology");

        checkAllEnabled(Arrays.asList(getSkillString(ENGINEER, FOREIGN_LANGUAGE), getSkillString(ENGINEER, HEAVY_MACHINERY), getSkillString(ENGINEER, LAW),
                getSkillString(ENGINEER, SCIENCE)),
                Arrays.asList(getSkillString(ENGINEER, ACCOUNTING),
                        getSkillString(ENGINEER, BUREAUCRACY), getSkillString(ENGINEER, CRAFT) + "-check"));

        click(ENGINEER + "Confirm");

        Map<String, String> skillMap = Map.of(COMPUTER_SCIENCE, "60", SIGINT, "40", HEAVY_MACHINERY,
                "50", LAW, "40");

        checkAllSkillValues(skillMap);
        assertEquals(driver.findElements(By.className("other-skill-name")).get(0).getAttribute("value"), "Craft 30%:\n(Electrician) ");
        assertEquals(driver.findElements(By.className("other-skill")).get(0).getAttribute("value"), "30");

        assertEquals(driver.findElements(By.className("other-skill-name")).get(1).getAttribute("value"), "Craft 30%:\n(Mechanic) ");
        assertEquals(driver.findElements(By.className("other-skill")).get(1).getAttribute("value"), "30");

        assertEquals(driver.findElements(By.className("other-skill-name")).get(2).getAttribute("value"), "Craft 40%:\n(Microelectronics) ");
        assertEquals(driver.findElements(By.className("other-skill")).get(2).getAttribute("value"), "40");

        assertEquals(driver.findElements(By.className("other-skill-name")).get(3).getAttribute("value"), "Science 40%:\n(Mathematics) ");
        assertEquals(driver.findElements(By.className("other-skill")).get(3).getAttribute("value"), "40");

        assertEquals(driver.findElements(By.className("other-skill-name")).get(4).getAttribute("value"), "Foreign Language 40%:\n(Danish) ");
        assertEquals(driver.findElements(By.className("other-skill")).get(4).getAttribute("value"), "40");
    }

    @Test
    public void testFederalAgentAccounting() {
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, FEDERAL_AGENT);

        checkAllEnabled(Arrays.asList(
                getSkillString(FEDERAL_AGENT, ACCOUNTING),
                getSkillString(FEDERAL_AGENT, COMPUTER_SCIENCE),
                getSkillString(FEDERAL_AGENT, FOREIGN_LANGUAGE),
                getSkillString(FEDERAL_AGENT, FOREIGN_LANGUAGE) + "-check",
                getSkillString(FEDERAL_AGENT, HEAVY_WEAPONS),
                getSkillString(FEDERAL_AGENT, PHARMACY)));

        inputText(getSkillString(FEDERAL_AGENT, FOREIGN_LANGUAGE), "German");

        click(getSkillString(FEDERAL_AGENT, ACCOUNTING));

        checkAllEnabled(
                Collections.singletonList(getSkillString(FEDERAL_AGENT, ACCOUNTING)),
                Arrays.asList(
                        getSkillString(FEDERAL_AGENT, COMPUTER_SCIENCE),
                        getSkillString(FEDERAL_AGENT, FOREIGN_LANGUAGE) + "-check",
                        getSkillString(FEDERAL_AGENT, HEAVY_WEAPONS),
                        getSkillString(FEDERAL_AGENT, PHARMACY))
        );

        click(FEDERAL_AGENT + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "50")
                .put(BUREAUCRACY, "40")
                .put(CRIMINOLOGY, "50")
                .put(DRIVE, "50")
                .put(FIREARMS, "50")
                .put(FORENSICS, "30")
                .put(HUMINT, "60")
                .put(LAW, "30")
                .put(PERSUADE, "50")
                .put(SEARCH, "50")
                .put(UNARMED_COMBAT, "60")
                .put(ACCOUNTING, "60").build();

        checkAllSkillValues(skillMap);
    }

    @Test
    public void testFederalAgentComputerScience() {
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, FEDERAL_AGENT);

        checkAllEnabled(Arrays.asList(
                getSkillString(FEDERAL_AGENT, ACCOUNTING),
                getSkillString(FEDERAL_AGENT, COMPUTER_SCIENCE),
                getSkillString(FEDERAL_AGENT, FOREIGN_LANGUAGE),
                getSkillString(FEDERAL_AGENT, FOREIGN_LANGUAGE) + "-check",
                getSkillString(FEDERAL_AGENT, HEAVY_WEAPONS),
                getSkillString(FEDERAL_AGENT, PHARMACY)));

        inputText(getSkillString(FEDERAL_AGENT, FOREIGN_LANGUAGE), "German");

        click(getSkillString(FEDERAL_AGENT, COMPUTER_SCIENCE));

        checkAllEnabled(
                Collections.singletonList(getSkillString(FEDERAL_AGENT, COMPUTER_SCIENCE)),
                Arrays.asList(
                        getSkillString(FEDERAL_AGENT, ACCOUNTING),
                        getSkillString(FEDERAL_AGENT, FOREIGN_LANGUAGE) + "-check",
                        getSkillString(FEDERAL_AGENT, HEAVY_WEAPONS),
                        getSkillString(FEDERAL_AGENT, PHARMACY))
        );

        click(FEDERAL_AGENT + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "50")
                .put(BUREAUCRACY, "40")
                .put(CRIMINOLOGY, "50")
                .put(DRIVE, "50")
                .put(FIREARMS, "50")
                .put(FORENSICS, "30")
                .put(HUMINT, "60")
                .put(LAW, "30")
                .put(PERSUADE, "50")
                .put(SEARCH, "50")
                .put(UNARMED_COMBAT, "60")
                .put(COMPUTER_SCIENCE, "50").build();

        checkAllSkillValues(skillMap);
    }

    @Test
    public void testFederalAgentHeavyWeapons() {
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, FEDERAL_AGENT);

        checkAllEnabled(Arrays.asList(
                getSkillString(FEDERAL_AGENT, ACCOUNTING),
                getSkillString(FEDERAL_AGENT, COMPUTER_SCIENCE),
                getSkillString(FEDERAL_AGENT, FOREIGN_LANGUAGE),
                getSkillString(FEDERAL_AGENT, FOREIGN_LANGUAGE) + "-check",
                getSkillString(FEDERAL_AGENT, HEAVY_WEAPONS),
                getSkillString(FEDERAL_AGENT, PHARMACY)));

        inputText(getSkillString(FEDERAL_AGENT, FOREIGN_LANGUAGE), "German");

        click(getSkillString(FEDERAL_AGENT, HEAVY_WEAPONS));

        checkAllEnabled(
                Collections.singletonList(getSkillString(FEDERAL_AGENT, HEAVY_WEAPONS)),
                Arrays.asList(
                        getSkillString(FEDERAL_AGENT, COMPUTER_SCIENCE),
                        getSkillString(FEDERAL_AGENT, FOREIGN_LANGUAGE) + "-check",
                        getSkillString(FEDERAL_AGENT, ACCOUNTING),
                        getSkillString(FEDERAL_AGENT, PHARMACY))
        );

        click(FEDERAL_AGENT + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "50")
                .put(BUREAUCRACY, "40")
                .put(CRIMINOLOGY, "50")
                .put(DRIVE, "50")
                .put(FIREARMS, "50")
                .put(FORENSICS, "30")
                .put(HUMINT, "60")
                .put(LAW, "30")
                .put(PERSUADE, "50")
                .put(SEARCH, "50")
                .put(UNARMED_COMBAT, "60")
                .put(HEAVY_WEAPONS, "50").build();

        checkAllSkillValues(skillMap);
    }

    @Test
    public void testFederalAgentLanguage() {
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, FEDERAL_AGENT);

        checkAllEnabled(Arrays.asList(
                getSkillString(FEDERAL_AGENT, ACCOUNTING),
                getSkillString(FEDERAL_AGENT, COMPUTER_SCIENCE),
                getSkillString(FEDERAL_AGENT, FOREIGN_LANGUAGE),
                getSkillString(FEDERAL_AGENT, FOREIGN_LANGUAGE) + "-check",
                getSkillString(FEDERAL_AGENT, HEAVY_WEAPONS),
                getSkillString(FEDERAL_AGENT, PHARMACY)));

        inputText(getSkillString(FEDERAL_AGENT, FOREIGN_LANGUAGE), "German");

        click(getSkillString(FEDERAL_AGENT, FOREIGN_LANGUAGE) + "-check");

        checkAllEnabled(
                Collections.singletonList(getSkillString(FEDERAL_AGENT, FOREIGN_LANGUAGE)),
                Arrays.asList(
                        getSkillString(FEDERAL_AGENT, ACCOUNTING),
                        getSkillString(FEDERAL_AGENT, COMPUTER_SCIENCE),
                        getSkillString(FEDERAL_AGENT, HEAVY_WEAPONS),
                        getSkillString(FEDERAL_AGENT, PHARMACY))
        );

        click(FEDERAL_AGENT + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "50")
                .put(BUREAUCRACY, "40")
                .put(CRIMINOLOGY, "50")
                .put(DRIVE, "50")
                .put(FIREARMS, "50")
                .put(FORENSICS, "30")
                .put(HUMINT, "60")
                .put(LAW, "30")
                .put(PERSUADE, "50")
                .put(SEARCH, "50")
                .put(UNARMED_COMBAT, "60").build();

        checkAllSkillValues(skillMap);

        assertOtherSkill(0, "Foreign Language 50%:\n(German) ", "50");
    }

    @Test
    public void testFederalAgentPharmacy() {
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, FEDERAL_AGENT);

        checkAllEnabled(Arrays.asList(
                getSkillString(FEDERAL_AGENT, ACCOUNTING),
                getSkillString(FEDERAL_AGENT, COMPUTER_SCIENCE),
                getSkillString(FEDERAL_AGENT, FOREIGN_LANGUAGE),
                getSkillString(FEDERAL_AGENT, FOREIGN_LANGUAGE) + "-check",
                getSkillString(FEDERAL_AGENT, HEAVY_WEAPONS),
                getSkillString(FEDERAL_AGENT, PHARMACY)));

        inputText(getSkillString(FEDERAL_AGENT, FOREIGN_LANGUAGE), "German");

        click(getSkillString(FEDERAL_AGENT, PHARMACY));

        checkAllEnabled(
                Collections.singletonList(getSkillString(FEDERAL_AGENT, PHARMACY)),
                Arrays.asList(
                        getSkillString(FEDERAL_AGENT, ACCOUNTING),
                        getSkillString(FEDERAL_AGENT, COMPUTER_SCIENCE),
                        getSkillString(FEDERAL_AGENT, HEAVY_WEAPONS),
                        getSkillString(FEDERAL_AGENT, FOREIGN_LANGUAGE) + "-check")
        );

        click(FEDERAL_AGENT + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "50")
                .put(BUREAUCRACY, "40")
                .put(CRIMINOLOGY, "50")
                .put(DRIVE, "50")
                .put(FIREARMS, "50")
                .put(FORENSICS, "30")
                .put(HUMINT, "60")
                .put(LAW, "30")
                .put(PERSUADE, "50")
                .put(SEARCH, "50")
                .put(UNARMED_COMBAT, "60")
                .put(PHARMACY, "50").build();

        checkAllSkillValues(skillMap);
    }

    @Test
    public void testPhysicianForensicsPsychotherapy() {
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, PHYSICIAN);

        checkAllEnabled(Arrays.asList(
                getSkillString(PHYSICIAN, FORENSICS),
                getSkillString(PHYSICIAN, PSYCHOTHERAPY),
                getSkillString(PHYSICIAN, SURGERY),
                getSkillString(PHYSICIAN, SCIENCE) + "-check"));

        click(getSkillString(PHYSICIAN, FORENSICS));
        click(getSkillString(PHYSICIAN, PSYCHOTHERAPY));

        checkAllEnabled(
                Arrays.asList(
                        getSkillString(PHYSICIAN, FORENSICS),
                        getSkillString(PHYSICIAN, PSYCHOTHERAPY)),
                Arrays.asList(
                        getSkillString(PHYSICIAN, SURGERY),
                        getSkillString(PHYSICIAN, SCIENCE) + "-check")
        );

        click(PHYSICIAN + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(BUREAUCRACY, "50")
                .put(FIRST_AID, "60")
                .put(MEDICINE, "60")
                .put(PHARMACY, "50")
                .put(PERSUADE, "40")
                .put(SEARCH, "40")
                .put(PSYCHOTHERAPY, "60")
                .put(FORENSICS, "50").build();
        checkAllSkillValues(skillMap);
        assertOtherSkill(0, "Science 60%:\n(Biology) ", "60");
    }

    @Test
    public void testPhysicianSurgeryScience() {
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, PHYSICIAN);

        checkAllEnabled(Arrays.asList(
                getSkillString(PHYSICIAN, FORENSICS),
                getSkillString(PHYSICIAN, PSYCHOTHERAPY),
                getSkillString(PHYSICIAN, SURGERY),
                getSkillString(PHYSICIAN, SCIENCE) + "-check"));

        click(getSkillString(PHYSICIAN, SURGERY));
        inputText(getSkillString(PHYSICIAN, SCIENCE), "Chemistry");
        click(getSkillString(PHYSICIAN, SCIENCE) + "-check");

        checkAllEnabled(
                Arrays.asList(
                        getSkillString(PHYSICIAN, SURGERY),
                        getSkillString(PHYSICIAN, SCIENCE) + "-check"),
                Arrays.asList(
                        getSkillString(PHYSICIAN, FORENSICS),
                        getSkillString(PHYSICIAN, PSYCHOTHERAPY))
        );

        click(PHYSICIAN + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(BUREAUCRACY, "50")
                .put(FIRST_AID, "60")
                .put(MEDICINE, "60")
                .put(PHARMACY, "50")
                .put(PERSUADE, "40")
                .put(SEARCH, "40")
                .put(SURGERY, "50").build();
        checkAllSkillValues(skillMap);
        assertOtherSkill(0, "Science 60%:\n(Biology) ", "60");
        assertOtherSkill(1, "Science 50%:\n(Chemistry) ", "50");
    }

    @Test
    public void testScientistAccountingLanguageCraft() {
        String profession = SCIENTIST;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(Arrays.asList(
                getSkillString(profession, ACCOUNTING),
                getSkillString(profession, CRAFT_CHECK),
                getSkillString(profession, FOREIGN_LANGUAGE_CHECK),
                getSkillString(profession, FORENSICS),
                getSkillString(profession, LAW),
                getSkillString(profession, PHARMACY)));

        inputText(getSkillString(profession, SCIENCE) + "1", "Physics");
        inputText(getSkillString(profession, SCIENCE) + "2", "Chemistry");
        inputText(getSkillString(profession, SCIENCE) + "3", "Materials Science");

        click(getSkillString(profession, ACCOUNTING));
        inputText(getSkillString(profession, FOREIGN_LANGUAGE), "Japanese");
        click(getSkillString(profession, FOREIGN_LANGUAGE_CHECK));
        inputText(getSkillString(profession, CRAFT), "origami");
        click(getSkillString(profession, CRAFT_CHECK));

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ACCOUNTING), Boolean.TRUE)
                        .put(getSkillString(profession, CRAFT_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, FORENSICS), Boolean.FALSE)
                        .put(getSkillString(profession, LAW), Boolean.FALSE)
                        .put(getSkillString(profession, PHARMACY), Boolean.FALSE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(BUREAUCRACY, "40")
                .put(COMPUTER_SCIENCE, "40")
                .put(ACCOUNTING, "50").build();
        checkAllSkillValues(skillMap);
        assertOtherSkill(0, "Science 60%\n(Physics)", "60");
        assertOtherSkill(1, "Science 50%\n(Chemistry)", "50");
        assertOtherSkill(2, "Science 50%\n(Materials Science)", "50");
    }

    @Test
    public void testScientistForensicsLawPharmacy() {
        String profession = SCIENTIST;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(Arrays.asList(
                getSkillString(profession, ACCOUNTING),
                getSkillString(profession, CRAFT_CHECK),
                getSkillString(profession, FOREIGN_LANGUAGE_CHECK),
                getSkillString(profession, FORENSICS),
                getSkillString(profession, LAW),
                getSkillString(profession, PHARMACY)));

        inputText(getSkillString(profession, SCIENCE) + "1", "Physics");
        inputText(getSkillString(profession, SCIENCE) + "2", "Chemistry");
        inputText(getSkillString(profession, SCIENCE) + "3", "Materials Science");

        click(getSkillString(profession, FORENSICS));
        click(getSkillString(profession, LAW));
        click(getSkillString(profession, PHARMACY));

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ACCOUNTING), Boolean.FALSE)
                        .put(getSkillString(profession, CRAFT_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, FORENSICS), Boolean.TRUE)
                        .put(getSkillString(profession, LAW), Boolean.TRUE)
                        .put(getSkillString(profession, PHARMACY), Boolean.TRUE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(BUREAUCRACY, "40")
                .put(COMPUTER_SCIENCE, "40")
                .put(FORENSICS, "40")
                .put(LAW, "40")
                .put(PHARMACY, "40").build();
        checkAllSkillValues(skillMap);
        assertOtherSkill(0, "Science 60%\n(Physics)", "60");
        assertOtherSkill(1, "Science 50%\n(Chemistry)", "50");
        assertOtherSkill(2, "Science 50%\n(Materials Science)", "50");
    }

    @Test
    public void testSpecialOperator() {
        String profession = SPECIAL_OPERATOR;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "60")
                .put(ATHLETICS, "60")
                .put(DEMOLITIONS, "40")
                .put(FIREARMS, "60")
                .put(HEAVY_WEAPONS, "50")
                .put(MELEE_WEAPONS, "50")
                .put(NAVIGATE, "50")
                .put(STEALTH, "50")
                .put(SURVIVAL, "50")
                .put(SWIM, "50")
                .put(UNARMED_COMBAT, "60")
                .build();
        checkAllSkillValues(skillMap);
        assertOtherSkill(0, "Military Science 60%:\n(Land) ", "60");
    }

    @Test
    public void testCriminalCraftDemolitions() {
        String profession = CRIMINAL;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, DEMOLITIONS), Boolean.TRUE)
                        .put(getSkillString(profession, DISGUISE), Boolean.TRUE)
                        .put(getSkillString(profession, CRAFT), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, FORENSICS), Boolean.TRUE)
                        .put(getSkillString(profession, HUMINT), Boolean.TRUE)
                        .put(getSkillString(profession, NAVIGATE), Boolean.TRUE)
                        .put(getSkillString(profession, OCCULT), Boolean.TRUE)
                        .put(getSkillString(profession, PHARMACY), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, CRAFT));
        click(getSkillString(profession, DEMOLITIONS));

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, DEMOLITIONS), Boolean.TRUE)
                        .put(getSkillString(profession, DISGUISE), Boolean.FALSE)
                        .put(getSkillString(profession, CRAFT), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, FORENSICS), Boolean.FALSE)
                        .put(getSkillString(profession, HUMINT), Boolean.FALSE)
                        .put(getSkillString(profession, NAVIGATE), Boolean.FALSE)
                        .put(getSkillString(profession, OCCULT), Boolean.FALSE)
                        .put(getSkillString(profession, PHARMACY), Boolean.FALSE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "50")
                .put(CRIMINOLOGY, "60")
                .put(DEMOLITIONS, "40")
                .put(DODGE, "40")
                .put(DRIVE, "50")
                .put(FIREARMS, "40")
                .put(LAW, "40")
                .put(MELEE_WEAPONS, "40")
                .put(PERSUADE, "50")
                .put(STEALTH, "50")
                .put(UNARMED_COMBAT, "50")
                .build();
        checkAllSkillValues(skillMap);
        assertOtherSkill(0, "Craft 40%\n (Locksmithing)", "40");
    }

    @Test
    public void testCriminalDisguiseLanguage() {
        String profession = CRIMINAL;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, DEMOLITIONS), Boolean.TRUE)
                        .put(getSkillString(profession, DISGUISE), Boolean.TRUE)
                        .put(getSkillString(profession, CRAFT), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, FORENSICS), Boolean.TRUE)
                        .put(getSkillString(profession, HUMINT), Boolean.TRUE)
                        .put(getSkillString(profession, NAVIGATE), Boolean.TRUE)
                        .put(getSkillString(profession, OCCULT), Boolean.TRUE)
                        .put(getSkillString(profession, PHARMACY), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, DISGUISE));
        click(getSkillString(profession, FOREIGN_LANGUAGE_CHECK));
        inputText(getSkillString(profession, FOREIGN_LANGUAGE), "Italian");

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, DEMOLITIONS), Boolean.FALSE)
                        .put(getSkillString(profession, CRAFT), Boolean.FALSE)
                        .put(getSkillString(profession, DISGUISE), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, FORENSICS), Boolean.FALSE)
                        .put(getSkillString(profession, HUMINT), Boolean.FALSE)
                        .put(getSkillString(profession, NAVIGATE), Boolean.FALSE)
                        .put(getSkillString(profession, OCCULT), Boolean.FALSE)
                        .put(getSkillString(profession, PHARMACY), Boolean.FALSE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "50")
                .put(CRIMINOLOGY, "60")
                .put(DISGUISE, "50")
                .put(DODGE, "40")
                .put(DRIVE, "50")
                .put(FIREARMS, "40")
                .put(LAW, "40")
                .put(MELEE_WEAPONS, "40")
                .put(PERSUADE, "50")
                .put(STEALTH, "50")
                .put(UNARMED_COMBAT, "50")
                .build();
        checkAllSkillValues(skillMap);

        assertOtherSkill(0, "Foreign Language 40%:\n(Italian) ", "40");
    }

    @Test
    public void testCriminalForensicsHumint() {
        String profession = CRIMINAL;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, DEMOLITIONS), Boolean.TRUE)
                        .put(getSkillString(profession, DISGUISE), Boolean.TRUE)
                        .put(getSkillString(profession, CRAFT), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, FORENSICS), Boolean.TRUE)
                        .put(getSkillString(profession, HUMINT), Boolean.TRUE)
                        .put(getSkillString(profession, NAVIGATE), Boolean.TRUE)
                        .put(getSkillString(profession, OCCULT), Boolean.TRUE)
                        .put(getSkillString(profession, PHARMACY), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, FORENSICS));
        click(getSkillString(profession, HUMINT));

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, DEMOLITIONS), Boolean.FALSE)
                        .put(getSkillString(profession, CRAFT), Boolean.FALSE)
                        .put(getSkillString(profession, DISGUISE), Boolean.FALSE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, FORENSICS), Boolean.TRUE)
                        .put(getSkillString(profession, HUMINT), Boolean.TRUE)
                        .put(getSkillString(profession, NAVIGATE), Boolean.FALSE)
                        .put(getSkillString(profession, OCCULT), Boolean.FALSE)
                        .put(getSkillString(profession, PHARMACY), Boolean.FALSE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "50")
                .put(CRIMINOLOGY, "60")
                .put(FORENSICS, "40")
                .put(HUMINT, "50")
                .put(DODGE, "40")
                .put(DRIVE, "50")
                .put(FIREARMS, "40")
                .put(LAW, "40")
                .put(MELEE_WEAPONS, "40")
                .put(PERSUADE, "50")
                .put(STEALTH, "50")
                .put(UNARMED_COMBAT, "50")
                .build();
        checkAllSkillValues(skillMap);

    }

    @Test
    public void testCriminalNavigateOccult() {
        String profession = CRIMINAL;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, DEMOLITIONS), Boolean.TRUE)
                        .put(getSkillString(profession, DISGUISE), Boolean.TRUE)
                        .put(getSkillString(profession, CRAFT), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, FORENSICS), Boolean.TRUE)
                        .put(getSkillString(profession, HUMINT), Boolean.TRUE)
                        .put(getSkillString(profession, NAVIGATE), Boolean.TRUE)
                        .put(getSkillString(profession, OCCULT), Boolean.TRUE)
                        .put(getSkillString(profession, PHARMACY), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, NAVIGATE));
        click(getSkillString(profession, OCCULT));

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, DEMOLITIONS), Boolean.FALSE)
                        .put(getSkillString(profession, CRAFT), Boolean.FALSE)
                        .put(getSkillString(profession, DISGUISE), Boolean.FALSE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, FORENSICS), Boolean.FALSE)
                        .put(getSkillString(profession, HUMINT), Boolean.FALSE)
                        .put(getSkillString(profession, NAVIGATE), Boolean.TRUE)
                        .put(getSkillString(profession, OCCULT), Boolean.TRUE)
                        .put(getSkillString(profession, PHARMACY), Boolean.FALSE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "50")
                .put(CRIMINOLOGY, "60")
                .put(NAVIGATE, "50")
                .put(OCCULT, "50")
                .put(DODGE, "40")
                .put(DRIVE, "50")
                .put(FIREARMS, "40")
                .put(LAW, "40")
                .put(MELEE_WEAPONS, "40")
                .put(PERSUADE, "50")
                .put(STEALTH, "50")
                .put(UNARMED_COMBAT, "50")
                .build();
        checkAllSkillValues(skillMap);

    }

    @Test
    public void testCriminalOccultPharmacy() {
        String profession = CRIMINAL;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, DEMOLITIONS), Boolean.TRUE)
                        .put(getSkillString(profession, DISGUISE), Boolean.TRUE)
                        .put(getSkillString(profession, CRAFT), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, FORENSICS), Boolean.TRUE)
                        .put(getSkillString(profession, HUMINT), Boolean.TRUE)
                        .put(getSkillString(profession, NAVIGATE), Boolean.TRUE)
                        .put(getSkillString(profession, OCCULT), Boolean.TRUE)
                        .put(getSkillString(profession, PHARMACY), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, OCCULT));
        click(getSkillString(profession, PHARMACY));

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, DEMOLITIONS), Boolean.FALSE)
                        .put(getSkillString(profession, CRAFT), Boolean.FALSE)
                        .put(getSkillString(profession, DISGUISE), Boolean.FALSE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, FORENSICS), Boolean.FALSE)
                        .put(getSkillString(profession, HUMINT), Boolean.FALSE)
                        .put(getSkillString(profession, NAVIGATE), Boolean.FALSE)
                        .put(getSkillString(profession, OCCULT), Boolean.TRUE)
                        .put(getSkillString(profession, PHARMACY), Boolean.TRUE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "50")
                .put(CRIMINOLOGY, "60")
                .put(OCCULT, "50")
                .put(PHARMACY, "40")
                .put(DODGE, "40")
                .put(DRIVE, "50")
                .put(FIREARMS, "40")
                .put(LAW, "40")
                .put(MELEE_WEAPONS, "40")
                .put(PERSUADE, "50")
                .put(STEALTH, "50")
                .put(UNARMED_COMBAT, "50")
                .build();
        checkAllSkillValues(skillMap);

    }

    @Test
    public void testFirefighter() {
        String profession = FIREFIGHTER;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "50")
                .put(ATHLETICS, "60")
                .put(DEMOLITIONS, "50")
                .put(DRIVE, "50")
                .put(FIRST_AID, "50")
                .put(FORENSICS, "40")
                .put(HEAVY_MACHINERY, "50")
                .put(NAVIGATE, "50")
                .put(SEARCH, "40")
                .build();
        checkAllSkillValues(skillMap);
        assertOtherSkill(0, "Craft 40%:\n(Electrician) ", "40");
        assertOtherSkill(1, "Craft 40%:\n(Mechanic) ", "40");
    }


    @Test
    public void testForeignServiceOfficer() {
        String profession = FOREIGN_SERVICE_OFFICER;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        inputText(getSkillString(profession, FOREIGN_LANGUAGE) + "1", "Arabic");
        inputText(getSkillString(profession, FOREIGN_LANGUAGE) + "2", "Latin");
        inputText(getSkillString(profession, FOREIGN_LANGUAGE) + "3", "Russian");

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ACCOUNTING, "40")
                .put(ANTHROPOLOGY, "40")
                .put(BUREAUCRACY, "60")
                .put(HISTORY, "40")
                .put(HUMINT, "50")
                .put(LAW, "40")
                .put(PERSUADE, "50")
                .build();
        checkAllSkillValues(skillMap);
        assertOtherSkill(0, "Foreign Language 50%\n(Arabic)", "50");
        assertOtherSkill(1, "Foreign Language 50%\n(Latin)", "50");
        assertOtherSkill(2, "Foreign Language 40%\n(Russian)", "40");
    }

    @Test
    public void testIntelligenceAnalyist() {
        String profession = INTELLIGENCE_ANALYST;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        inputText(getSkillString(profession, FOREIGN_LANGUAGE) + "1", "Arabic");
        inputText(getSkillString(profession, FOREIGN_LANGUAGE) + "2", "Latin");
        inputText(getSkillString(profession, FOREIGN_LANGUAGE) + "3", "Russian");

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ANTHROPOLOGY, "40")
                .put(BUREAUCRACY, "50")
                .put(COMPUTER_SCIENCE, "40")
                .put(CRIMINOLOGY, "40")
                .put(HISTORY, "40")
                .put(HUMINT, "50")
                .put(SIGINT, "40")
                .build();
        checkAllSkillValues(skillMap);
        assertOtherSkill(0, "Foreign Language 50%\n(Arabic)", "50");
        assertOtherSkill(1, "Foreign Language 50%\n(Latin)", "50");
        assertOtherSkill(2, "Foreign Language 40%\n(Russian)", "40");
    }

    @Test
    public void testIntelligenceCaseOfficer() {
        String profession = INTELLIGENCE_OFFICER;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        inputText(getSkillString(profession, FOREIGN_LANGUAGE) + "1", "Arabic");
        inputText(getSkillString(profession, FOREIGN_LANGUAGE) + "2", "Latin");

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "50")
                .put(BUREAUCRACY, "40")
                .put(CRIMINOLOGY, "50")
                .put(DISGUISE, "50")
                .put(DRIVE, "40")
                .put(FIREARMS, "40")
                .put(HUMINT, "60")
                .put(PERSUADE, "60")
                .put(SIGINT, "40")
                .put(STEALTH, "50")
                .put(UNARMED_COMBAT, "50")
                .build();
        checkAllSkillValues(skillMap);
        assertOtherSkill(0, "Foreign Language 50%\n(Arabic)", "50");
        assertOtherSkill(1, "Foreign Language 40%\n(Latin)", "40");
    }

    @Test
    public void testLawyerComputerScienceCriminologyLanguageLaw() {
        String profession = LAWYER;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, COMPUTER_SCIENCE), Boolean.TRUE)
                        .put(getSkillString(profession, CRIMINOLOGY), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, LAW), Boolean.TRUE)
                        .put(getSkillString(profession, PHARMACY), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, COMPUTER_SCIENCE));
        click(getSkillString(profession, CRIMINOLOGY));
        click(getSkillString(profession, FOREIGN_LANGUAGE_CHECK));
        inputText(getSkillString(profession, FOREIGN_LANGUAGE), "Norwegian");
        click(getSkillString(profession, LAW));

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, COMPUTER_SCIENCE), Boolean.TRUE)
                        .put(getSkillString(profession, CRIMINOLOGY), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, LAW), Boolean.TRUE)
                        .put(getSkillString(profession, PHARMACY), Boolean.FALSE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ACCOUNTING, "50")
                .put(BUREAUCRACY, "50")
                .put(HUMINT, "40")
                .put(PERSUADE, "60")
                .put(COMPUTER_SCIENCE, "50")
                .put(CRIMINOLOGY, "60")
                .put(LAW, "50")
                .build();
        checkAllSkillValues(skillMap);

        assertOtherSkill(0, "Foreign Language 50%:\n(Norwegian) ", "50");
    }

    @Test
    public void testLawyerCriminologyLanguageLawPharmacy() {
        String profession = LAWYER;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, COMPUTER_SCIENCE), Boolean.TRUE)
                        .put(getSkillString(profession, CRIMINOLOGY), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, LAW), Boolean.TRUE)
                        .put(getSkillString(profession, PHARMACY), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, CRIMINOLOGY));
        click(getSkillString(profession, FOREIGN_LANGUAGE_CHECK));
        inputText(getSkillString(profession, FOREIGN_LANGUAGE), "Norwegian");
        click(getSkillString(profession, LAW));
        click(getSkillString(profession, PHARMACY));

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, COMPUTER_SCIENCE), Boolean.FALSE)
                        .put(getSkillString(profession, CRIMINOLOGY), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, LAW), Boolean.TRUE)
                        .put(getSkillString(profession, PHARMACY), Boolean.TRUE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ACCOUNTING, "50")
                .put(BUREAUCRACY, "50")
                .put(HUMINT, "40")
                .put(PERSUADE, "60")
                .put(CRIMINOLOGY, "60")
                .put(LAW, "50")
                .put(PHARMACY, "50")
                .build();
        checkAllSkillValues(skillMap);
        assertOtherSkill(0, "Foreign Language 50%:\n(Norwegian) ", "50");
    }

    @Test
    public void testMediaSpecialistAnthroComputer() {
        String profession = MEDIA_SPECIALIST;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ANTHROPOLOGY), Boolean.TRUE)
                        .put(getSkillString(profession, ARCHEOLOGY), Boolean.TRUE)
                        .put(getSkillString(profession, BUREAUCRACY), Boolean.TRUE)
                        .put(getSkillString(profession, COMPUTER_SCIENCE), Boolean.TRUE)
                        .put(getSkillString(profession, CRIMINOLOGY), Boolean.TRUE)
                        .put(getSkillString(profession, LAW), Boolean.TRUE)
                        .put(getSkillString(profession, OCCULT), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, MILITARY_SCIENCE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, SCIENCE_CHECK), Boolean.TRUE)
                        .build());

        inputText(getSkillString(profession, ART) + "1", "Painting");
        click(getSkillString(profession, ANTHROPOLOGY));
        click(getSkillString(profession, ARCHEOLOGY));
        click(getSkillString(profession, BUREAUCRACY));
        click(getSkillString(profession, COMPUTER_SCIENCE));
        inputText(getSkillString(profession, ART), "Macreme");
        click(getSkillString(profession, ART_CHECK));

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ANTHROPOLOGY), Boolean.TRUE)
                        .put(getSkillString(profession, ARCHEOLOGY), Boolean.TRUE)
                        .put(getSkillString(profession, BUREAUCRACY), Boolean.TRUE)
                        .put(getSkillString(profession, COMPUTER_SCIENCE), Boolean.TRUE)
                        .put(getSkillString(profession, CRIMINOLOGY), Boolean.FALSE)
                        .put(getSkillString(profession, LAW), Boolean.FALSE)
                        .put(getSkillString(profession, OCCULT), Boolean.FALSE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, MILITARY_SCIENCE_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, SCIENCE_CHECK), Boolean.FALSE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(HISTORY, "40")
                .put(HUMINT, "40")
                .put(PERSUADE, "50")
                .put(ANTHROPOLOGY, "40")
                .put(ARCHEOLOGY, "40")
                .put(BUREAUCRACY, "50")
                .put(COMPUTER_SCIENCE, "40")
                .build();
        checkAllSkillValues(skillMap);

        assertOtherSkill(0, "Art 60%\n(Painting)", "60");
        assertOtherSkill(1, "Art 40%:\n(Macreme) ", "40");
    }


    //    Art 60%
//    History 40%
//    HUMINT 40%
//    Persuade 50%
//    Choose five from:
//
//    Anthropology 40%
//    Archeology 40%
//    Art (choose one) 40%
//    Bureaucracy 50%
//    Computer Science 40%

    //    Criminology 50%
//    Foreign Language (choose one) 40%
//    Law 40%
//    Military Science (choose one) 40%
//    Occult 50%
    @Test
    public void testMediaSpecialistCriminologyOccult() {
        String profession = MEDIA_SPECIALIST;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ANTHROPOLOGY), Boolean.TRUE)
                        .put(getSkillString(profession, ARCHEOLOGY), Boolean.TRUE)
                        .put(getSkillString(profession, BUREAUCRACY), Boolean.TRUE)
                        .put(getSkillString(profession, COMPUTER_SCIENCE), Boolean.TRUE)
                        .put(getSkillString(profession, CRIMINOLOGY), Boolean.TRUE)
                        .put(getSkillString(profession, LAW), Boolean.TRUE)
                        .put(getSkillString(profession, OCCULT), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, MILITARY_SCIENCE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, SCIENCE_CHECK), Boolean.TRUE)
                        .build());

        inputText(getSkillString(profession, ART) + "1", "Painting");
        click(getSkillString(profession, CRIMINOLOGY));
        click(getSkillString(profession, FOREIGN_LANGUAGE_CHECK));
        inputText(getSkillString(profession, FOREIGN_LANGUAGE), "Hungarian");
        click(getSkillString(profession, LAW));
        inputText(getSkillString(profession, MILITARY_SCIENCE), "Land");
        click(getSkillString(profession, MILITARY_SCIENCE_CHECK));
        click(getSkillString(profession, OCCULT));

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ANTHROPOLOGY), Boolean.FALSE)
                        .put(getSkillString(profession, ARCHEOLOGY), Boolean.FALSE)
                        .put(getSkillString(profession, BUREAUCRACY), Boolean.FALSE)
                        .put(getSkillString(profession, COMPUTER_SCIENCE), Boolean.FALSE)
                        .put(getSkillString(profession, CRIMINOLOGY), Boolean.TRUE)
                        .put(getSkillString(profession, LAW), Boolean.TRUE)
                        .put(getSkillString(profession, OCCULT), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, MILITARY_SCIENCE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, SCIENCE_CHECK), Boolean.FALSE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(HISTORY, "40")
                .put(HUMINT, "40")
                .put(PERSUADE, "50")
                .put(CRIMINOLOGY, "50")
                .put(LAW, "40")
                .put(OCCULT, "50")
                .build();
        checkAllSkillValues(skillMap);

        assertOtherSkill(0, "Art 60%\n(Painting)", "60");
        assertOtherSkill(1, "Foreign Language 40%:\n(Hungarian) ", "40");
        assertOtherSkill(2, "Military Science 40%:\n(Land) ", "40");
    }

    @Test
    public void testMediaSpecialistScience() {
        String profession = MEDIA_SPECIALIST;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ANTHROPOLOGY), Boolean.TRUE)
                        .put(getSkillString(profession, ARCHEOLOGY), Boolean.TRUE)
                        .put(getSkillString(profession, BUREAUCRACY), Boolean.TRUE)
                        .put(getSkillString(profession, COMPUTER_SCIENCE), Boolean.TRUE)
                        .put(getSkillString(profession, CRIMINOLOGY), Boolean.TRUE)
                        .put(getSkillString(profession, LAW), Boolean.TRUE)
                        .put(getSkillString(profession, OCCULT), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, MILITARY_SCIENCE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, SCIENCE_CHECK), Boolean.TRUE)
                        .build());

        inputText(getSkillString(profession, ART) + "1", "Painting");
        click(getSkillString(profession, FOREIGN_LANGUAGE_CHECK));
        inputText(getSkillString(profession, FOREIGN_LANGUAGE), "Hungarian");
        click(getSkillString(profession, LAW));
        inputText(getSkillString(profession, MILITARY_SCIENCE), "Land");
        click(getSkillString(profession, MILITARY_SCIENCE_CHECK));
        click(getSkillString(profession, OCCULT));
        inputText(getSkillString(profession, SCIENCE), "Astrobiology");
        click(getSkillString(profession, SCIENCE_CHECK));

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ANTHROPOLOGY), Boolean.FALSE)
                        .put(getSkillString(profession, ARCHEOLOGY), Boolean.FALSE)
                        .put(getSkillString(profession, BUREAUCRACY), Boolean.FALSE)
                        .put(getSkillString(profession, COMPUTER_SCIENCE), Boolean.FALSE)
                        .put(getSkillString(profession, CRIMINOLOGY), Boolean.FALSE)
                        .put(getSkillString(profession, LAW), Boolean.TRUE)
                        .put(getSkillString(profession, OCCULT), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, MILITARY_SCIENCE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, SCIENCE_CHECK), Boolean.TRUE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(HISTORY, "40")
                .put(HUMINT, "40")
                .put(PERSUADE, "50")
                .put(LAW, "40")
                .put(OCCULT, "50")
                .build();
        checkAllSkillValues(skillMap);

        assertOtherSkill(0, "Art 60%\n(Painting)", "60");
        assertOtherSkill(1, "Foreign Language 40%:\n(Hungarian) ", "40");
        assertOtherSkill(2, "Military Science 40%:\n(Land) ", "40");
        assertOtherSkill(3, "Science 40%:\n(Astrobiology) ", "40");
    }

    @Test
    public void testNurseDriveForensics() {
        String profession = NURSE;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, DRIVE), Boolean.TRUE)
                        .put(getSkillString(profession, FORENSICS), Boolean.TRUE)
                        .put(getSkillString(profession, NAVIGATE), Boolean.TRUE)
                        .put(getSkillString(profession, PSYCHOTHERAPY), Boolean.TRUE)
                        .put(getSkillString(profession, SEARCH), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, DRIVE));
        click(getSkillString(profession, FORENSICS));

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, DRIVE), Boolean.TRUE)
                        .put(getSkillString(profession, FORENSICS), Boolean.TRUE)
                        .put(getSkillString(profession, NAVIGATE), Boolean.FALSE)
                        .put(getSkillString(profession, PSYCHOTHERAPY), Boolean.FALSE)
                        .put(getSkillString(profession, SEARCH), Boolean.FALSE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "40")
                .put(BUREAUCRACY, "40")
                .put(FIRST_AID, "60")
                .put(HUMINT, "40")
                .put(MEDICINE, "40")
                .put(PERSUADE, "40")
                .put(PHARMACY, "40")
                .put(FORENSICS, "40")
                .put(DRIVE, "60")
                .build();
        checkAllSkillValues(skillMap);
    }

    @Test
    public void testNurseNavigatePsychotherapy() {
        String profession = NURSE;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, DRIVE), Boolean.TRUE)
                        .put(getSkillString(profession, FORENSICS), Boolean.TRUE)
                        .put(getSkillString(profession, NAVIGATE), Boolean.TRUE)
                        .put(getSkillString(profession, PSYCHOTHERAPY), Boolean.TRUE)
                        .put(getSkillString(profession, SEARCH), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, NAVIGATE));
        click(getSkillString(profession, PSYCHOTHERAPY));

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, DRIVE), Boolean.FALSE)
                        .put(getSkillString(profession, FORENSICS), Boolean.FALSE)
                        .put(getSkillString(profession, NAVIGATE), Boolean.TRUE)
                        .put(getSkillString(profession, PSYCHOTHERAPY), Boolean.TRUE)
                        .put(getSkillString(profession, SEARCH), Boolean.FALSE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "40")
                .put(BUREAUCRACY, "40")
                .put(FIRST_AID, "60")
                .put(HUMINT, "40")
                .put(MEDICINE, "40")
                .put(PERSUADE, "40")
                .put(PHARMACY, "40")
                .put(NAVIGATE, "50")
                .put(PSYCHOTHERAPY, "50")
                .build();
        checkAllSkillValues(skillMap);
    }

    @Test
    public void testNurseNavigateSearch() {
        String profession = NURSE;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, DRIVE), Boolean.TRUE)
                        .put(getSkillString(profession, FORENSICS), Boolean.TRUE)
                        .put(getSkillString(profession, NAVIGATE), Boolean.TRUE)
                        .put(getSkillString(profession, PSYCHOTHERAPY), Boolean.TRUE)
                        .put(getSkillString(profession, SEARCH), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, NAVIGATE));
        click(getSkillString(profession, SEARCH));

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, DRIVE), Boolean.FALSE)
                        .put(getSkillString(profession, FORENSICS), Boolean.FALSE)
                        .put(getSkillString(profession, NAVIGATE), Boolean.TRUE)
                        .put(getSkillString(profession, PSYCHOTHERAPY), Boolean.FALSE)
                        .put(getSkillString(profession, SEARCH), Boolean.TRUE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "40")
                .put(BUREAUCRACY, "40")
                .put(FIRST_AID, "60")
                .put(HUMINT, "40")
                .put(MEDICINE, "40")
                .put(PERSUADE, "40")
                .put(PHARMACY, "40")
                .put(NAVIGATE, "50")
                .put(SEARCH, "60")
                .build();
        checkAllSkillValues(skillMap);
    }

    @Test
    public void testPilotLanguagePilot() {
        String profession = PILOT;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, PILOT_SKILL_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_WEAPONS), Boolean.TRUE)
                        .put(getSkillString(profession, MILITARY_SCIENCE_CHECK), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, FOREIGN_LANGUAGE_CHECK));
        inputText(getSkillString(profession, FOREIGN_LANGUAGE), "Catalan");

        click(getSkillString(profession, PILOT_SKILL_CHECK));
        inputText(getSkillString(profession, PILOT_SKILL) + "8", "Aircraft");

        inputText(getSkillString(profession, PILOT_SKILL), "Boats");

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, PILOT_SKILL_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_WEAPONS), Boolean.FALSE)
                        .put(getSkillString(profession, MILITARY_SCIENCE_CHECK), Boolean.FALSE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "60")
                .put(BUREAUCRACY, "30")
                .put(NAVIGATE, "50")
                .put(SWIM, "40")
                .build();
        checkAllSkillValues(skillMap);

        assertOtherSkill(0, "Craft 40%:\n(Electrician) ", "40");
        assertOtherSkill(1, "Craft 40%:\n(Mechanic) ", "40");
        assertOtherSkill(2, "Science 40%:\n(Meteorology) ", "40");
        assertOtherSkill(3, "Pilot 60%\n(Aircraft)", "60");
        assertOtherSkill(4, "Foreign Language 50%:\n(Catalan) ", "50");
        assertOtherSkill(5, "Pilot 50%:\n(Boats) ", "50");
    }

    @Test
    public void testPilotHeavyWeaponsMilitaryScience() {
        String profession = PILOT;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, PILOT_SKILL_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_WEAPONS), Boolean.TRUE)
                        .put(getSkillString(profession, MILITARY_SCIENCE_CHECK), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, HEAVY_WEAPONS));
        click(getSkillString(profession, MILITARY_SCIENCE_CHECK));
        inputText(getSkillString(profession, MILITARY_SCIENCE), "Sea");
        click(getSkillString(profession, PILOT_SKILL_CHECK));
        inputText(getSkillString(profession, PILOT_SKILL) + "8", "Aircraft");

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, PILOT_SKILL_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, HEAVY_WEAPONS), Boolean.TRUE)
                        .put(getSkillString(profession, MILITARY_SCIENCE_CHECK), Boolean.TRUE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "60")
                .put(BUREAUCRACY, "30")
                .put(NAVIGATE, "50")
                .put(SWIM, "40")
                .put(HEAVY_WEAPONS, "50")
                .build();
        checkAllSkillValues(skillMap);

        assertOtherSkill(0, "Craft 40%:\n(Electrician) ", "40");
        assertOtherSkill(1, "Craft 40%:\n(Mechanic) ", "40");
        assertOtherSkill(2, "Science 40%:\n(Meteorology) ", "40");
        assertOtherSkill(3, "Pilot 60%\n(Aircraft)", "60");
        assertOtherSkill(4, "Military Science 50%:\n(Sea) ", "50");
    }

    @Test
    public void testPoliceOfficerForensics() {
        String profession = POLICE_OFFICER;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, FORENSICS), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_MACHINERY), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_WEAPONS), Boolean.TRUE)
                        .put(getSkillString(profession, RIDE), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, FORENSICS));

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, FORENSICS), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_MACHINERY), Boolean.FALSE)
                        .put(getSkillString(profession, HEAVY_WEAPONS), Boolean.FALSE)
                        .put(getSkillString(profession, RIDE), Boolean.FALSE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "60")
                .put(BUREAUCRACY, "40")
                .put(CRIMINOLOGY, "40")
                .put(DRIVE, "50")
                .put(FIREARMS, "40")
                .put(FIRST_AID, "30")
                .put(HUMINT, "50")
                .put(LAW, "30")
                .put(MELEE_WEAPONS, "50")
                .put(NAVIGATE, "40")
                .put(PERSUADE, "40")
                .put(SEARCH, "40")
                .put(UNARMED_COMBAT, "60")
                .put(FORENSICS, "50")
                .build();
        checkAllSkillValues(skillMap);
    }

    @Test
    public void testPoliceOfficeHeavyMachinery() {
        String profession = POLICE_OFFICER;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, FORENSICS), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_MACHINERY), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_WEAPONS), Boolean.TRUE)
                        .put(getSkillString(profession, RIDE), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, HEAVY_MACHINERY));
        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, FORENSICS), Boolean.FALSE)
                        .put(getSkillString(profession, HEAVY_MACHINERY), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_WEAPONS), Boolean.FALSE)
                        .put(getSkillString(profession, RIDE), Boolean.FALSE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "60")
                .put(BUREAUCRACY, "40")
                .put(CRIMINOLOGY, "40")
                .put(DRIVE, "50")
                .put(FIREARMS, "40")
                .put(FIRST_AID, "30")
                .put(HUMINT, "50")
                .put(LAW, "30")
                .put(MELEE_WEAPONS, "50")
                .put(NAVIGATE, "40")
                .put(PERSUADE, "40")
                .put(SEARCH, "40")
                .put(UNARMED_COMBAT, "60")
                .put(HEAVY_MACHINERY, "60")
                .build();
        checkAllSkillValues(skillMap);
    }

    @Test
    public void testPoliceOfficeHeavyWeapons() {
        String profession = POLICE_OFFICER;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, FORENSICS), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_MACHINERY), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_WEAPONS), Boolean.TRUE)
                        .put(getSkillString(profession, RIDE), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, HEAVY_WEAPONS));
        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, FORENSICS), Boolean.FALSE)
                        .put(getSkillString(profession, HEAVY_MACHINERY), Boolean.FALSE)
                        .put(getSkillString(profession, HEAVY_WEAPONS), Boolean.TRUE)
                        .put(getSkillString(profession, RIDE), Boolean.FALSE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "60")
                .put(BUREAUCRACY, "40")
                .put(CRIMINOLOGY, "40")
                .put(DRIVE, "50")
                .put(FIREARMS, "40")
                .put(FIRST_AID, "30")
                .put(HUMINT, "50")
                .put(LAW, "30")
                .put(MELEE_WEAPONS, "50")
                .put(NAVIGATE, "40")
                .put(PERSUADE, "40")
                .put(SEARCH, "40")
                .put(UNARMED_COMBAT, "60")
                .put(HEAVY_WEAPONS, "50")
                .build();
        checkAllSkillValues(skillMap);
    }

    @Test
    public void testPoliceOfficeRide() {
        String profession = POLICE_OFFICER;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, FORENSICS), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_MACHINERY), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_WEAPONS), Boolean.TRUE)
                        .put(getSkillString(profession, RIDE), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, RIDE));

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, FORENSICS), Boolean.FALSE)
                        .put(getSkillString(profession, HEAVY_MACHINERY), Boolean.FALSE)
                        .put(getSkillString(profession, HEAVY_WEAPONS), Boolean.FALSE)
                        .put(getSkillString(profession, RIDE), Boolean.TRUE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "60")
                .put(BUREAUCRACY, "40")
                .put(CRIMINOLOGY, "40")
                .put(DRIVE, "50")
                .put(FIREARMS, "40")
                .put(FIRST_AID, "30")
                .put(HUMINT, "50")
                .put(LAW, "30")
                .put(MELEE_WEAPONS, "50")
                .put(NAVIGATE, "40")
                .put(PERSUADE, "40")
                .put(SEARCH, "40")
                .put(UNARMED_COMBAT, "60")
                .put(RIDE, "60")
                .build();
        checkAllSkillValues(skillMap);
    }

    @Test
    public void testProgramManagerAnthropology() {
        String profession = PROGRAM_MANAGER;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ANTHROPOLOGY), Boolean.TRUE)
                        .put(getSkillString(profession, ART_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, CRAFT_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, SCIENCE_CHECK), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, ANTHROPOLOGY));
        inputText(getSkillString(profession, FOREIGN_LANGUAGE) + "1", "Hindi");
        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ANTHROPOLOGY), Boolean.TRUE)
                        .put(getSkillString(profession, ART_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, CRAFT_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, SCIENCE_CHECK), Boolean.FALSE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ACCOUNTING, "60")
                .put(BUREAUCRACY, "60")
                .put(COMPUTER_SCIENCE, "50")
                .put(CRIMINOLOGY, "30")
                .put(HISTORY, "40")
                .put(LAW, "40")
                .put(PERSUADE, "50")
                .put(ANTHROPOLOGY, "30")
                .build();
        checkAllSkillValues(skillMap);

        assertOtherSkill(0, "Foreign Language 50%\n(Hindi)", "50");
    }

    @Test
    public void testProgramManagerArt() {
        String profession = PROGRAM_MANAGER;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ANTHROPOLOGY), Boolean.TRUE)
                        .put(getSkillString(profession, ART_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, CRAFT_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, SCIENCE_CHECK), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, ART_CHECK));
        inputText(getSkillString(profession, FOREIGN_LANGUAGE) + "1", "Hindi");
        inputText(getSkillString(profession, ART), "Sculpting");

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ANTHROPOLOGY), Boolean.FALSE)
                        .put(getSkillString(profession, ART_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, CRAFT_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, SCIENCE_CHECK), Boolean.FALSE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ACCOUNTING, "60")
                .put(BUREAUCRACY, "60")
                .put(COMPUTER_SCIENCE, "50")
                .put(CRIMINOLOGY, "30")
                .put(HISTORY, "40")
                .put(LAW, "40")
                .put(PERSUADE, "50")
                .build();
        checkAllSkillValues(skillMap);

        assertOtherSkill(0, "Foreign Language 50%\n(Hindi)", "50");
        assertOtherSkill(1, "Art 30%:\n(Sculpting) ", "30");
    }

    @Test
    public void testProgramManagerCraft() {
        String profession = PROGRAM_MANAGER;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ANTHROPOLOGY), Boolean.TRUE)
                        .put(getSkillString(profession, ART_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, CRAFT_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, SCIENCE_CHECK), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, CRAFT_CHECK));
        inputText(getSkillString(profession, CRAFT), "Cross Stich");
        inputText(getSkillString(profession, FOREIGN_LANGUAGE) + "1", "Hindi");

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ANTHROPOLOGY), Boolean.FALSE)
                        .put(getSkillString(profession, ART_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, CRAFT_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, SCIENCE_CHECK), Boolean.FALSE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ACCOUNTING, "60")
                .put(BUREAUCRACY, "60")
                .put(COMPUTER_SCIENCE, "50")
                .put(CRIMINOLOGY, "30")
                .put(HISTORY, "40")
                .put(LAW, "40")
                .put(PERSUADE, "50")
                .build();
        checkAllSkillValues(skillMap);

        assertOtherSkill(0, "Foreign Language 50%\n(Hindi)", "50");
        assertOtherSkill(1, "Craft 30%:\n(Cross Stich) ", "30");
    }

    @Test
    public void testProgramManagerScience() {
        String profession = PROGRAM_MANAGER;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ANTHROPOLOGY), Boolean.TRUE)
                        .put(getSkillString(profession, ART_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, CRAFT_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, SCIENCE_CHECK), Boolean.TRUE)
                        .build());

        inputText(getSkillString(profession, FOREIGN_LANGUAGE) + "1", "Hindi");
        inputText(getSkillString(profession, SCIENCE), "Biology");
        click(getSkillString(profession, SCIENCE_CHECK));

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ANTHROPOLOGY), Boolean.FALSE)
                        .put(getSkillString(profession, ART_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, CRAFT_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, SCIENCE_CHECK), Boolean.TRUE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ACCOUNTING, "60")
                .put(BUREAUCRACY, "60")
                .put(COMPUTER_SCIENCE, "50")
                .put(CRIMINOLOGY, "30")
                .put(HISTORY, "40")
                .put(LAW, "40")
                .put(PERSUADE, "50")
                .build();
        checkAllSkillValues(skillMap);

        assertOtherSkill(0, "Foreign Language 50%\n(Hindi)", "50");
        assertOtherSkill(1, "Science 30%:\n(Biology) ", "30");
    }

    @Test
    public void testSoldierArtilleryComputerCraft() {
        String profession = SOLDIER;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ARTILLERY), Boolean.TRUE)
                        .put(getSkillString(profession, COMPUTER_SCIENCE), Boolean.TRUE)
                        .put(getSkillString(profession, CRAFT_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, DEMOLITIONS), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_MACHINERY), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_WEAPONS), Boolean.TRUE)
                        .put(getSkillString(profession, SEARCH), Boolean.TRUE)
                        .put(getSkillString(profession, SIGINT), Boolean.TRUE)
                        .put(getSkillString(profession, SWIM), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, ARTILLERY));
        click(getSkillString(profession, COMPUTER_SCIENCE));
        click(getSkillString(profession, CRAFT_CHECK));
        inputText(getSkillString(profession, CRAFT), "Origami");

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ARTILLERY), Boolean.TRUE)
                        .put(getSkillString(profession, COMPUTER_SCIENCE), Boolean.TRUE)
                        .put(getSkillString(profession, CRAFT_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, DEMOLITIONS), Boolean.FALSE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, HEAVY_MACHINERY), Boolean.FALSE)
                        .put(getSkillString(profession, HEAVY_WEAPONS), Boolean.FALSE)
                        .put(getSkillString(profession, SEARCH), Boolean.FALSE)
                        .put(getSkillString(profession, SIGINT), Boolean.FALSE)
                        .put(getSkillString(profession, SWIM), Boolean.FALSE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "50")
                .put(ATHLETICS, "50")
                .put(BUREAUCRACY, "30")
                .put(DRIVE, "40")
                .put(FIREARMS, "40")
                .put(FIRST_AID, "40")
                .put(NAVIGATE, "40")
                .put(PERSUADE, "30")
                .put(UNARMED_COMBAT, "50")
                .put(ARTILLERY, "40")
                .put(COMPUTER_SCIENCE, "40")
                .build();
        checkAllSkillValues(skillMap);

        assertOtherSkill(0, "Military Science 40%:\n(Land) ", "40");
        assertOtherSkill(1, "Craft 40%:\n(Origami) ", "40");
    }

    @Test
    public void testSoldierDemolitionsLanguageHeavyMachinery() {
        String profession = SOLDIER;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ARTILLERY), Boolean.TRUE)
                        .put(getSkillString(profession, COMPUTER_SCIENCE), Boolean.TRUE)
                        .put(getSkillString(profession, CRAFT_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, DEMOLITIONS), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_MACHINERY), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_WEAPONS), Boolean.TRUE)
                        .put(getSkillString(profession, SEARCH), Boolean.TRUE)
                        .put(getSkillString(profession, SIGINT), Boolean.TRUE)
                        .put(getSkillString(profession, SWIM), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, DEMOLITIONS));
        click(getSkillString(profession, HEAVY_MACHINERY));
        click(getSkillString(profession, FOREIGN_LANGUAGE_CHECK));
        inputText(getSkillString(profession, FOREIGN_LANGUAGE), "Farsi");

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ARTILLERY), Boolean.FALSE)
                        .put(getSkillString(profession, COMPUTER_SCIENCE), Boolean.FALSE)
                        .put(getSkillString(profession, CRAFT_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, DEMOLITIONS), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_MACHINERY), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_WEAPONS), Boolean.FALSE)
                        .put(getSkillString(profession, SEARCH), Boolean.FALSE)
                        .put(getSkillString(profession, SIGINT), Boolean.FALSE)
                        .put(getSkillString(profession, SWIM), Boolean.FALSE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "50")
                .put(ATHLETICS, "50")
                .put(BUREAUCRACY, "30")
                .put(DRIVE, "40")
                .put(FIREARMS, "40")
                .put(FIRST_AID, "40")
                .put(NAVIGATE, "40")
                .put(PERSUADE, "30")
                .put(UNARMED_COMBAT, "50")
                .put(DEMOLITIONS, "40")
                .put(HEAVY_MACHINERY, "50")
                .build();
        checkAllSkillValues(skillMap);

        assertOtherSkill(0, "Military Science 40%:\n(Land) ", "40");
        assertOtherSkill(1, "Foreign Language 40%:\n(Farsi) ", "40");
    }

    @Test
    public void testSoldierHeavyWeaponsSearchSigint() {
        String profession = SOLDIER;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ARTILLERY), Boolean.TRUE)
                        .put(getSkillString(profession, COMPUTER_SCIENCE), Boolean.TRUE)
                        .put(getSkillString(profession, CRAFT_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, DEMOLITIONS), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_MACHINERY), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_WEAPONS), Boolean.TRUE)
                        .put(getSkillString(profession, SEARCH), Boolean.TRUE)
                        .put(getSkillString(profession, SIGINT), Boolean.TRUE)
                        .put(getSkillString(profession, SWIM), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, HEAVY_WEAPONS));
        click(getSkillString(profession, SEARCH));
        click(getSkillString(profession, SIGINT));

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ARTILLERY), Boolean.FALSE)
                        .put(getSkillString(profession, COMPUTER_SCIENCE), Boolean.FALSE)
                        .put(getSkillString(profession, CRAFT_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, DEMOLITIONS), Boolean.FALSE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, HEAVY_MACHINERY), Boolean.FALSE)
                        .put(getSkillString(profession, HEAVY_WEAPONS), Boolean.TRUE)
                        .put(getSkillString(profession, SEARCH), Boolean.TRUE)
                        .put(getSkillString(profession, SIGINT), Boolean.TRUE)
                        .put(getSkillString(profession, SWIM), Boolean.FALSE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "50")
                .put(ATHLETICS, "50")
                .put(BUREAUCRACY, "30")
                .put(DRIVE, "40")
                .put(FIREARMS, "40")
                .put(FIRST_AID, "40")
                .put(NAVIGATE, "40")
                .put(PERSUADE, "30")
                .put(UNARMED_COMBAT, "50")
                .put(HEAVY_WEAPONS, "40")
                .put(SEARCH, "60")
                .put(SIGINT, "40")
                .build();
        checkAllSkillValues(skillMap);
    }

    @Test
    public void testSoldierSearchSigintSwim() {
        String profession = SOLDIER;
        openProfessionModal();

        selectProfession(ANTHROPOLOGIST, profession);

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ARTILLERY), Boolean.TRUE)
                        .put(getSkillString(profession, COMPUTER_SCIENCE), Boolean.TRUE)
                        .put(getSkillString(profession, CRAFT_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, DEMOLITIONS), Boolean.TRUE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_MACHINERY), Boolean.TRUE)
                        .put(getSkillString(profession, HEAVY_WEAPONS), Boolean.TRUE)
                        .put(getSkillString(profession, SEARCH), Boolean.TRUE)
                        .put(getSkillString(profession, SIGINT), Boolean.TRUE)
                        .put(getSkillString(profession, SWIM), Boolean.TRUE)
                        .build());

        click(getSkillString(profession, SWIM));
        click(getSkillString(profession, SEARCH));
        click(getSkillString(profession, SIGINT));

        checkAllEnabled(
                ImmutableMap.<String, Boolean>builder()
                        .put(getSkillString(profession, ARTILLERY), Boolean.FALSE)
                        .put(getSkillString(profession, COMPUTER_SCIENCE), Boolean.FALSE)
                        .put(getSkillString(profession, CRAFT_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, DEMOLITIONS), Boolean.FALSE)
                        .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.FALSE)
                        .put(getSkillString(profession, HEAVY_MACHINERY), Boolean.FALSE)
                        .put(getSkillString(profession, HEAVY_WEAPONS), Boolean.FALSE)
                        .put(getSkillString(profession, SEARCH), Boolean.TRUE)
                        .put(getSkillString(profession, SIGINT), Boolean.TRUE)
                        .put(getSkillString(profession, SWIM), Boolean.TRUE)
                        .build());

        click(profession + "Confirm");

        Map<String, String> skillMap = ImmutableMap.<String, String>builder()
                .put(ALERTNESS, "50")
                .put(ATHLETICS, "50")
                .put(BUREAUCRACY, "30")
                .put(DRIVE, "40")
                .put(FIREARMS, "40")
                .put(FIRST_AID, "40")
                .put(NAVIGATE, "40")
                .put(PERSUADE, "30")
                .put(UNARMED_COMBAT, "50")
                .put(SWIM, "60")
                .put(SEARCH, "60")
                .put(SIGINT, "40")
                .build();
        checkAllSkillValues(skillMap);
    }

    @Test
    public void testWeapons() {
        List<WebElement> selects = driver.findElements(By.name("weapon-select"));
        driver.findElement(By.id("dex-score")).sendKeys("10");
        for(WebElement selectElement: selects) {
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "unarmed"))), "Unarmed Attack", "40", "", Arrays.asList("1D4-3", "1D4-2", "1D4-1", "1D4", "1D4+1"), "N/A", "", "", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "brass_knuckles"))), "Brass knuckles, heavy flashlight, or steel-toe boots", "40", "", Arrays.asList("1D4-2", "1D4-1", "1D4", "1D4+1", "1D4+2"), "N/A", "", "", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "garotte"))), "Garotte", "40", "", "special", "N/A", "", "", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "knife"))), "Knife", "30", "", Arrays.asList("1D4-2", "1D4-1", "1D4", "1D4+1", "1D4+2"), "N/A", "", "", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "hatchet"))), "Hatchet", "30", "", Arrays.asList("1D4-2", "1D4-1", "1D4", "1D4+1", "1D4+2"), "N/A", "", "", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "combat_dagger"))), "Large knife or combat dagger", "30", "", Arrays.asList("1D6-2", "1D6-1", "1D6", "1D6+1", "1D6+2"), "3", "", "", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "club"))), "Club, nightstick, baton,  or collapsible baton", "30", "", Arrays.asList("1D6-2", "1D6-1", "1D6", "1D6+1", "1D6+2"), "N/A", "", "", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "sword"))), "Machete, tomahawk, or sword", "30", "", Arrays.asList("1D8-2", "1D8-1", "1D8", "1D8+1", "1D8+2"), "N/A", "", "", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "bat"))), "Baseball bat or rifle butt", "30", "", Arrays.asList("1D8-2", "1D8-1", "1D8", "1D8+1", "1D8+2"), "N/A", "", "", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "spear"))), "Spear or fixed bayonet", "30", "", Arrays.asList("1D8-2", "1D8-1", "1D8", "1D8+1", "1D8+2"), "3", "", "", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "axe"))), "Wood axe", "30", "", Arrays.asList("1D10-2", "1D10-1", "1D10", "1D10+1", "1D10+2"), "N/A", "", "", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "large_sword"))), "Large sword", "30", "", Arrays.asList("1D10-2", "1D10-1", "1D10", "1D10+1", "1D10+2"), "N/A", "", "", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "two_handed_sword"))), "Two-handed sword", "30", "", Arrays.asList("1D12-2", "1D12-1", "1D12", "1D12+1", "1D12+2"), "N/A", "", "", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "pepper_spray_keychain"))), "Tear Gas and Pepper Spray", "50", "1m", "-20% penalty", "", "", "", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "pepper_spray_can"))), "Tear Gas and Pepper Spray", "50", "3m", "-20% penalty", "", "", "", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "tear_gas"))), "Tear gas grenade (Thrown/Launched)", "30/0", "20m/50m", "-40% penalty", "", "", "", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "stun_grenade"))), "Stun Grenade (Thrown/Launched)", "30/0", "20m/50m", "-40% penalty", "", "", "", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "stun_gun"))), "Stun gun", "50", "1m", "-20% penalty", "", "", "", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "shock_baton"))), "Shock baton", "50", "1m", "-20% penalty", "", "", "", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "ced_pistol"))), "CED pistol", "20", "4m", "-20% penalty", "", "", "", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "light_pistol"))), "Light pistol", "20", "10m", "1D8", "N/A", "N/A", "", "7");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "medium_pistol"))), "Medium pistol", "20", "15m", "1D10", "N/A", "N/A", "", "15");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "heavy_pistol"))), "Heavy pistol", "20", "20m", "1D12", "N/A", "N/A", "", "10");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "shotgun"))), "Shotgun (slug/shot/nonlethal)", "20", "75m/50m/10m", "2D6/2D10/1D6 and stunned", "N/A", "N/A", "", "5");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "light_rifle"))), "Light Rifle or Carbine", "20", "100m", "1D12", "3", "10%", "", "10 or 30");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "smg"))), "Submachine gun (SMG)", "20", "50m", "1D10", "N/A", "10%", "", "30");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "heavy_rifle"))), "Heavy Rifle", "20", "150m", "1D12+2", "5", "10%", "", "10 or 20");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "very_heavy_rifle"))), "Very Heavy Rifle", "20", "250m", "N/A", "5", "20%", "", "10");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "hand_grenade"))), "Hand Grenade", "30", "20m", "", "N/A", "15%", "10m", "N/A");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "rpg"))), "Rocket-propelled grenade launcher (RPG)", "0", "10m", "", "20", "30%", "10m", "1");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "flamethrower"))), "Handheld flamethrower", "0", "5m", "", "N/A", "10%", "1m", "20");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "military_flamethrower"))), "Military flamethrower", "0", "10m", "", "N/A", "10%", "2m", "5");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "machine_gun"))), "General-purpose machine gun (GPMP)", "0", "300m", "", "N/A", "15%", "per burst", "100");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "grenade_launcher"))), "Grenade launcher (GL)", "0", "150m", "", "N/A", "15%", "10m", "1");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "grenade_machine_gun"))), "Grenade machine gun (GMG)", "0", "300m", "", "N/A", "15%", "10m", "30");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "heavy_machine_gun"))), "Heavy machine gun (HMG)", "0", "400m", "", "5", "20%", "per burst", "100");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "light_machine_gun"))), "Light machine gun (LMG)", "0", "200m", "", "3", "10%", "per burst", "100 or 200");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "autocannon"))), "Autocannon", "0", "400m", "", "5", "30%", "3m", "100");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "minigun"))), "Minigun", "0", "300m", "", "5", "20%", "3m (long spray only)", "4000");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "anfo_explosive"))), "ANFO explosive", "0", "", "", "N/A", "30%", "20m", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "c4"))), "C4 plastic explosive block", "0", "", "", "N/A", "30%", "2m", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "ied"))), "Improvised explosive device (IED)", "0", "", "", "N/A", "15%", "10m", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "large_ied"))), "Large IED", "0", "", "", "N/A", "60%", "75m", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "mine"))), "Explosively-formed penetrator mine", "0", "", "", "20", "25%", "10m", "");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "bomb"))), "General-purpose bomb", "0", "Air-dropped", "", "10", "70%", "100m", "N/A");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "heavy_mortar"))), "Heavy mortar", "0", "4km", "", "5", "35%", "50m", "1");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "light_mortar"))), "Light mortar", "0", "2km", "", "10", "20%", "25m", "1");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "anti_tank_missle"))), "Anti-tank guided missile (ATGM)", "0", "4km", "", "25", "35%", "50m", "N/A");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "artillery"))), "Artillery", "0", "5km", "", "10", "50%", "100m", "1");
            testWeapon(driver.findElement(By.id(selectWeapon(selectElement, "cruise_missile"))), "Cruise Missile", "0", "100km", "", "15", "80%", "150m", "N/A");
        }
    }

    @Test
    public void testRandom(){
        Map<String, Integer> professionsSelect = new HashMap<>(ImmutableMap.<String, Integer>builder()
                .put(WordUtils.capitalizeFully(ANTHROPOLOGIST.replaceAll("-"," ")), 0)
                .put(WordUtils.capitalizeFully(ENGINEER.replaceAll("-"," ")), 0)
                .put(WordUtils.capitalizeFully(FEDERAL_AGENT.replaceAll("-"," ")), 0)
                .put(WordUtils.capitalizeFully(SPECIAL_OPERATOR.replaceAll("-"," ")), 0)
                .put(WordUtils.capitalizeFully(PHYSICIAN.replaceAll("-"," ")), 0)
                .put(WordUtils.capitalizeFully(SCIENTIST.replaceAll("-"," ")), 0)
                .put(WordUtils.capitalizeFully(CRIMINAL.replaceAll("-"," ")), 0)
                .put(WordUtils.capitalizeFully(FIREFIGHTER.replaceAll("-"," ")), 0)
                .put(WordUtils.capitalizeFully(FOREIGN_SERVICE_OFFICER.replaceAll("-"," ")), 0)
                .put(WordUtils.capitalizeFully(INTELLIGENCE_ANALYST.replaceAll("-"," ")), 0)
                .put(WordUtils.capitalizeFully(INTELLIGENCE_OFFICER.replaceAll("-"," ")), 0)
                .put(WordUtils.capitalizeFully(LAWYER.replaceAll("-"," ")), 0)
                .put(WordUtils.capitalizeFully(MEDIA_SPECIALIST.replaceAll("-"," ")), 0)
                .put(WordUtils.capitalizeFully(NURSE.replaceAll("-"," ")), 0)
                .put(WordUtils.capitalizeFully(PILOT.replaceAll("-"," ")), 0)
                .put(WordUtils.capitalizeFully(POLICE_OFFICER.replaceAll("-"," ")), 0)
                .put(WordUtils.capitalizeFully(PROGRAM_MANAGER.replaceAll("-"," ")), 0)
                .put(WordUtils.capitalizeFully(SOLDIER.replaceAll("-"," ")), 0)
                .build());
        for(int i = 0; i < 200; i ++) {
            click("btnRandom");
            String profession = driver.findElement(By.id("profession")).getAttribute("value");
            System.out.println(profession);
            System.out.println( professionsSelect.get(profession));
            professionsSelect.put(profession, professionsSelect.get(profession)+1);
            List<String> skills = new ArrayList<>();
            List<WebElement> skillElements = driver.findElements(By.className("skill"));
            for (WebElement skill : skillElements) {
                if(!skill.getAttribute("base").equals(skill.getAttribute("prof-base"))) {
                    skills.add(skill.getAttribute("id"));
                }
            }
            for(int j = 0; j < driver.findElements(By.className("other-skill-name")).size(); j ++) {
                if(!driver.findElements(By.className("other-skill-name")).get(j).getAttribute("value").equals("")) {
                    skills.add(driver.findElements(By.className("other-skill-name")).get(j).getAttribute("value"));
                }
//            assertEquals(driver.findElements(By.className("other-skill")).get(position).getAttribute("value"), value);
            }


//    ["federal-agent",  'optional_skills': 1}],
//    ["special-operator",  'optional_skills': 0}],
//    ["physician", {'employer': [hospitals], 'education': ["MD"], 'stats': ["INT","POW","DEX"], 'bonds':3, 'optional_skills': 2}],
//    ["scientist", {'employer': [science], 'education': ["PHD in Chemistry", "PHD in Biology", "PHD in Physics"], 'stats': ["INT"], 'bonds':4, 'optional_skills': 3}],
//    ["firefighter", {'employer': [cities], 'education': ["High School Diploma"], 'stats': ["STR","DEX","CON"], 'bonds':3, 'optional_skills': 0}],
//    ["foreign-service-officer", {'employer': [foriegn_service], 'education': ["PHD in Foreign Affairs", "PHD in International Relations"],
//        'stats': ["INT","CHA"], 'bonds':3, 'optional_skills': 0}],
//    ["criminal", {'employer': [criminal_orgs], 'education': ["High School Diploma"], 'stats': ["STR","DEX"], 'bonds':4, 'optional_skills': 2}],
//    ["intelligence-analyst", {'employer': [intelligence_analysts], 'education': ["Masters in Political Science", "Masters in International Relations"],
//        'stats': ["INT"], 'bonds': 3, 'optional_skills': 0}],
//    ["intelligence-case-officer", {'employer': [intelligence_agencies], 'education': ["Bachelors in Political Science"], stats: ["INT","POW","CHA"], 'bonds': 2, 'optional_skills': 0}],
//    ["lawyer", {'employer': [law_firms, cities], 'education': ["JD"], 'stats': ["INT","POW","CHA"], 'bonds':2, 'optional_skills': 4}],
//    ["media-specialist", {'employer': [tv_news, newspapers, blogs, cities], 'education': ["Bachelors in Media Studies"], 'stats': ["INT","CHA"], 'bonds': 4, 'optional_skills': 5}],
//    ["nurse", {'employer': [hospitals], 'education': ["Bachelors in Nursing", "Masters in Nursing"], 'stats': ["INT","POW","CHA"], 'bonds': 4, 'optional_skills': 2}],
//    ["pilot", {'employer': [pilot], 'education': ["High School Diploma", "Bachelors in Mechanical Engineering"], 'stats': ["DEX","INT"], 'bonds': 3, 'optional_skills': 2}],
//    ["police-officer", {'employer': [cities], 'education': ["High School Diploma", "Associates in Criminal Justice"], 'stats': ["STR","CON","POW"], 'bonds': 3, 'optional_skills': 1}],
//    ["program-manager", {'employer': [top_companies], 'education': ["Masters in Business Administration"], 'stats': ["INT","CHA"], 'bonds': 4, 'optional_skills': 1}],
//    ["soldier", {'employer': [armed_forces], 'education': ["High School Diploma"], 'stats': ["STR", "CON"], 'bonds': 4, 'optional_skills': 3}],


//                    ["anthropologist", 'optional_skills': 2}],

//            ImmutableMap.<String, Boolean>builder()
//                    .put(getSkillString(profession, ARTILLERY), Boolean.TRUE)
//                    .put(getSkillString(profession, COMPUTER_SCIENCE), Boolean.TRUE)
//                    .put(getSkillString(profession, CRAFT_CHECK), Boolean.TRUE)
//                    .put(getSkillString(profession, DEMOLITIONS), Boolean.TRUE)
//                    .put(getSkillString(profession, FOREIGN_LANGUAGE_CHECK), Boolean.TRUE)
//                    .put(getSkillString(profession, HEAVY_MACHINERY), Boolean.TRUE)
//                    .put(getSkillString(profession, HEAVY_WEAPONS), Boolean.TRUE)
//                    .put(getSkillString(profession, SEARCH), Boolean.TRUE)
//                    .put(getSkillString(profession, SIGINT), Boolean.TRUE)
//                    .put(getSkillString(profession, SWIM), Boolean.TRUE)
//                    .build());
            assertThat(skills).doesNotHaveDuplicates();
            switch (profession) {
                case "Anthropologist":
                    List<String> defaultSkills = Arrays.asList(HISTORY, OCCULT, PERSUADE);
                    List<String> optionalSkills = Arrays.asList(ANTHROPOLOGY, ARCHEOLOGY, HUMINT, NAVIGATE, RIDE, SEARCH, SURVIVAL);
                    List<String> inputSkills = Collections.singletonList(WordUtils.capitalizeFully(FOREIGN_LANGUAGE.replaceAll("-", " ")) + " \\(\\w*\\)");
                    int expectedSize = 7;
                    List<String> noSkills = new ArrayList<>(ALL_SKILLS);
                    noSkills.removeAll(defaultSkills);
                    noSkills.removeAll(optionalSkills);
                    assertThat(skills).containsOnlyOnceElementsOf(defaultSkills);
                    assertThat(skills).containsAnyOf(ANTHROPOLOGY, ARCHEOLOGY);
                    assertThat(skills).doesNotContainAnyElementsOf(noSkills);
                    assertThat(skills.size()).isEqualTo(expectedSize);
                    List<String> otherSkills = new ArrayList<>(inputSkills);
                    assertThat(listContainsOtherSkillsByRegex(otherSkills, skills)).isTrue();
                    break;
                case "Engineer":
                    defaultSkills = Arrays.asList(COMPUTER_SCIENCE, SIGINT);
                    optionalSkills = Arrays.asList(ACCOUNTING, BUREAUCRACY, HEAVY_MACHINERY, LAW,
                            "Craft 30%:\n(Electrician) ", "Craft 30%:\n(Mechanic) ", "Craft 40%:\n(Microelectronics) ",
                            "Science 40%:\n(Mathematics) ");
                    expectedSize = 10;
                    noSkills = new ArrayList<>(ALL_SKILLS);
                    noSkills.removeAll(defaultSkills);
                    noSkills.removeAll(optionalSkills);
                    assertThat(skills).containsOnlyOnceElementsOf(defaultSkills);
                    assertThat(skills).doesNotContainAnyElementsOf(noSkills);
                    assertThat(skills.size()).isEqualTo(expectedSize);
                    break;
                case "Federal Agent":
                    defaultSkills = Arrays.asList(ALERTNESS, BUREAUCRACY, CRIMINOLOGY, DRIVE, FIREARMS, FORENSICS, HUMINT, LAW, PERSUADE, SEARCH, UNARMED_COMBAT);
                    optionalSkills = Arrays.asList(ACCOUNTING, COMPUTER_SCIENCE, HEAVY_WEAPONS, PHARMACY);
                    expectedSize = 12;
                    noSkills = new ArrayList<>(ALL_SKILLS);
                    noSkills.removeAll(defaultSkills);
                    noSkills.removeAll(optionalSkills);
                    assertThat(skills).containsOnlyOnceElementsOf(defaultSkills);
                    assertThat(skills).doesNotContainAnyElementsOf(noSkills);
                    assertThat(skills.size()).isEqualTo(expectedSize);
                    break;
                case "Special Operator":
                    defaultSkills = Arrays.asList(ALERTNESS, ATHLETICS, DEMOLITIONS, FIREARMS, HEAVY_WEAPONS,
                            MELEE_WEAPONS, NAVIGATE, STEALTH, SURVIVAL, SWIM, UNARMED_COMBAT, "Military Science 60%:\n(Land) ");
                    expectedSize = 12;
                    noSkills = new ArrayList<>(ALL_SKILLS);
                    noSkills.removeAll(defaultSkills);
                    assertThat(skills).containsOnlyOnceElementsOf(defaultSkills);
                    assertThat(skills).doesNotContainAnyElementsOf(noSkills);
                    assertThat(skills.size()).isEqualTo(expectedSize);
                    break;
                case "Physician":
                    defaultSkills = Arrays.asList(BUREAUCRACY, FIRST_AID, MEDICINE, PERSUADE, PHARMACY,
                            SEARCH, "Science 60%:\n(Biology) ");
                    optionalSkills = Arrays.asList(FORENSICS, PSYCHOTHERAPY, SURGERY);
                    expectedSize = 9;
                    noSkills = new ArrayList<>(ALL_SKILLS);
                    noSkills.removeAll(defaultSkills);
                    noSkills.removeAll(optionalSkills);
                    assertThat(skills).containsOnlyOnceElementsOf(defaultSkills);
                    assertThat(skills).doesNotContainAnyElementsOf(noSkills);
                    assertThat(skills.size()).isEqualTo(expectedSize);
                    break;
                case "Scientist":
                    defaultSkills = Arrays.asList(BUREAUCRACY, COMPUTER_SCIENCE);
                    optionalSkills = Arrays.asList(ACCOUNTING, FORENSICS, LAW, PHARMACY);
                    inputSkills = Arrays.asList(
                            WordUtils.capitalizeFully(SCIENCE.replaceAll("-", " ")) + " \\(\\w*\\)",
                            WordUtils.capitalizeFully(SCIENCE.replaceAll("-", " ")) + " \\(\\w*\\)",
                            WordUtils.capitalizeFully(SCIENCE.replaceAll("-", " ")) + " \\(\\w*\\)"
                    );
                    expectedSize = 8;
                    noSkills = new ArrayList<>(ALL_SKILLS);
                    noSkills.removeAll(defaultSkills);
                    noSkills.removeAll(optionalSkills);
                    System.out.println(skills);
                    assertThat(skills).containsOnlyOnceElementsOf(defaultSkills);
                    assertThat(skills).doesNotContainAnyElementsOf(noSkills);
                    assertThat(skills.size()).as(skills.toString()).isEqualTo(expectedSize);
                    otherSkills = new ArrayList<>(inputSkills);
                    assertThat(listContainsOtherSkillsByRegex(otherSkills, skills)).isTrue();
                    break;
                case "Firefighter":
                    defaultSkills = Arrays.asList(ATHLETICS, ALERTNESS, DEMOLITIONS, DRIVE, FIRST_AID,
                            FORENSICS, HEAVY_MACHINERY, NAVIGATE, SEARCH, "Craft 40%:\n(Electrician) ", "Craft 40%:\n(Mechanic) ");
                    expectedSize = 11;
                    noSkills = new ArrayList<>(ALL_SKILLS);
                    noSkills.removeAll(defaultSkills);
                    assertThat(skills).containsOnlyOnceElementsOf(defaultSkills);
                    assertThat(skills).doesNotContainAnyElementsOf(noSkills);
                    assertThat(skills.size()).isEqualTo(expectedSize);
                    break;
                case "Foreign Service Officer":
                    defaultSkills = Arrays.asList(ACCOUNTING, ANTHROPOLOGY, BUREAUCRACY, HISTORY, HUMINT,
                            LAW, PERSUADE);
                    inputSkills = Arrays.asList(
                            WordUtils.capitalizeFully(FOREIGN_LANGUAGE.replaceAll("-", " ")) + " \\(\\w*\\)",
                            WordUtils.capitalizeFully(FOREIGN_LANGUAGE.replaceAll("-", " ")) + " \\(\\w*\\)",
                            WordUtils.capitalizeFully(FOREIGN_LANGUAGE.replaceAll("-", " ")) + " \\(\\w*\\)"
                    );
//                    ccounting 40%»Anthropology 40%»Bureaucracy 60%»Foreign Language (choose one) 50%»Foreign Language (choose one) 50%»Foreign Language (choose one) 40%»
//                    History 40%»HUMINT 50%»Law 40%»Persuade 50
                    expectedSize = 10;
                    noSkills = new ArrayList<>(ALL_SKILLS);
                    noSkills.removeAll(defaultSkills);
                    System.out.println(skills);
                    assertThat(skills).containsOnlyOnceElementsOf(defaultSkills);
                    assertThat(skills).doesNotContainAnyElementsOf(noSkills);
                    assertThat(skills.size()).isEqualTo(expectedSize);
                    otherSkills = new ArrayList<>(inputSkills);
                    assertThat(listContainsOtherSkillsByRegex(otherSkills, skills)).isTrue();
                    break;
                case "Criminal":
                    defaultSkills = Arrays.asList(ALERTNESS, CRIMINOLOGY, DODGE, DRIVE,
                            FIREARMS, LAW, MELEE_WEAPONS, PERSUADE, STEALTH, UNARMED_COMBAT);
                    optionalSkills = Arrays.asList(DEMOLITIONS, DISGUISE, FORENSICS, HUMINT, NAVIGATE, OCCULT, PHARMACY);
                    expectedSize = 12;
                    noSkills = new ArrayList<>(ALL_SKILLS);
                    noSkills.removeAll(defaultSkills);
                    noSkills.removeAll(optionalSkills);
                    assertThat(skills).containsOnlyOnceElementsOf(defaultSkills);
                    assertThat(skills).doesNotContainAnyElementsOf(noSkills);
                    assertThat(skills.size()).as(skills.toString()).isEqualTo(expectedSize);
                    break;
                    /*
                    Alertness 50%»Criminology 60%»Dodge 40%»Drive 50%»Firearms 40%»Law 40%»Melee Weapons 40%»Persuade 50%»Stealth 50%»Unarmed Combat 50%C
                    hoose two from:»Craft (Locksmithing) 40%»Demolitions 40%»Disguise 50%»Foreign Language (choose one) 40%»Forensics 40%»HUMINT 50%»Navigate 50%»Occult 50%»Pharmacy 40%
                    Anthropology 40%»Bureaucracy 50%»Computer Science 40%»Criminology 40%»Foreign Language (choose one)
                    50%»Foreign Language (choose one) 50%»Foreign Language (choose one) 40%»History 40%»HUMINT 50%»SIGINT 40%
                     */
                case "Intelligence Analyst":
                    defaultSkills = Arrays.asList(ANTHROPOLOGY, BUREAUCRACY, COMPUTER_SCIENCE, CRIMINOLOGY, HUMINT, HISTORY, SIGINT
                    );
                    inputSkills = Arrays.asList(
                            WordUtils.capitalizeFully(FOREIGN_LANGUAGE.replaceAll("-", " ")) + " \\(\\w*\\)",
                            WordUtils.capitalizeFully(FOREIGN_LANGUAGE.replaceAll("-", " ")) + " \\(\\w*\\)",
                            WordUtils.capitalizeFully(FOREIGN_LANGUAGE.replaceAll("-", " ")) + " \\(\\w*\\)"
                    );

                    expectedSize = 10;
                    noSkills = new ArrayList<>(ALL_SKILLS);
                    noSkills.removeAll(defaultSkills);
                    assertThat(skills).containsOnlyOnceElementsOf(defaultSkills);
                    assertThat(skills).doesNotContainAnyElementsOf(noSkills);
                    assertThat(skills.size()).isEqualTo(expectedSize);
                    assertThat(listContainsOtherSkillsByRegex(new ArrayList<>(inputSkills), skills)).isTrue();
                    break;
                case "Intelligence Case Officer":
                    defaultSkills = Arrays.asList(ALERTNESS, BUREAUCRACY, CRIMINOLOGY, DISGUISE, DRIVE, FIREARMS,
                            HUMINT, PERSUADE, SIGINT, STEALTH, UNARMED_COMBAT
                    );
//                    ALERTNESS, BUREAUCRACY, CRIMINOLOGY, DISGUISE, DRIVE, FIREARMS, HUMINT, PERSUADE, SIGINT, STEALTH, UNARMED COMBAT
//                    intelligencecase-officer;
//                    alertness 50,bureaucracy 40,criminology 50,disguise 50,drive 40,firearms 40,foreign-language 50,foreign-language 40,humint 60,persuade 60,sigint 40,stealth 50,unarmed-combat 50;50
                    inputSkills = Arrays.asList(
                            WordUtils.capitalizeFully(FOREIGN_LANGUAGE.replaceAll("-", " ")) + " \\(\\w*\\)",
                            WordUtils.capitalizeFully(FOREIGN_LANGUAGE.replaceAll("-", " ")) + " \\(\\w*\\)"
                    );

                    expectedSize = 13;
                    noSkills = new ArrayList<>(ALL_SKILLS);
                    noSkills.removeAll(defaultSkills);
                    assertThat(skills).containsOnlyOnceElementsOf(defaultSkills);
                    assertThat(skills).doesNotContainAnyElementsOf(noSkills);
                    assertThat(skills.size()).isEqualTo(expectedSize);
                    assertThat(listContainsOtherSkillsByRegex(new ArrayList<>(inputSkills), skills)).isTrue();
                    break;

                case "Media Specialist":
                    defaultSkills = Arrays.asList(HISTORY, HUMINT, PERSUADE
                    );
                    optionalSkills = Arrays.asList(ANTHROPOLOGY, CRIMINOLOGY, OCCULT, LAW, ARCHEOLOGY, BUREAUCRACY, COMPUTER_SCIENCE);
                    inputSkills = Collections.singletonList(
                            WordUtils.capitalizeFully(ART.replaceAll("-", " ")) + " \\(.*\\)"
                    );
                    expectedSize = 9;
                    noSkills = new ArrayList<>(ALL_SKILLS);
                    noSkills.removeAll(defaultSkills);
                    noSkills.removeAll(optionalSkills);
                    assertThat(skills).containsOnlyOnceElementsOf(defaultSkills);
                    assertThat(skills).doesNotContainAnyElementsOf(noSkills);
                    assertThat(skills.size()).as(skills.toString()).isEqualTo(expectedSize);
                    otherSkills = new ArrayList<>(inputSkills);
                    assertThat(listContainsOtherSkillsByRegex(otherSkills, skills)).as(skills.toString()).isTrue();
                    break;
                case "Police Officer":
                    defaultSkills = Arrays.asList(ALERTNESS, BUREAUCRACY, CRIMINOLOGY, DRIVE, FIREARMS, FIRST_AID,
                            HUMINT, LAW, MELEE_WEAPONS, NAVIGATE, PERSUADE, SEARCH, UNARMED_COMBAT
                    );
                    optionalSkills = Arrays.asList(FORENSICS, HEAVY_MACHINERY, HEAVY_WEAPONS, RIDE);
                    expectedSize = 14;
                    noSkills = new ArrayList<>(ALL_SKILLS);
                    noSkills.removeAll(defaultSkills);
                    noSkills.removeAll(optionalSkills);
//                    but some elements were not found:
//  ["forensics", "heavy-machinery", "ride"]
                    assertThat(skills).containsOnlyOnceElementsOf(defaultSkills);
                    assertThat(skills).doesNotContainAnyElementsOf(noSkills);
                    assertThat(skills.size()).isEqualTo(expectedSize);
                    break;
                case "Program Manager":
                    defaultSkills = Arrays.asList(ACCOUNTING, BUREAUCRACY, COMPUTER_SCIENCE, CRIMINOLOGY, HISTORY,
                            LAW, PERSUADE
                            );
                    optionalSkills = Arrays.asList(ANTHROPOLOGY);
                    inputSkills = Collections.singletonList(
                            WordUtils.capitalizeFully(FOREIGN_LANGUAGE.replaceAll("-", " ")) + " \\(\\w*\\)"
                    );
                    expectedSize = 9;
                    noSkills = new ArrayList<>(ALL_SKILLS);
                    noSkills.removeAll(defaultSkills);
                    noSkills.removeAll(optionalSkills);
                    assertThat(skills).containsOnlyOnceElementsOf(defaultSkills);
                    assertThat(skills).doesNotContainAnyElementsOf(noSkills);
                    assertThat(skills.size()).isEqualTo(expectedSize);
                    assertThat(listContainsOtherSkillsByRegex(new ArrayList<>(inputSkills), skills)).isTrue();
                    break;
                case "Soldier":
                    defaultSkills = Arrays.asList(ALERTNESS, ATHLETICS, BUREAUCRACY, DRIVE, FIREARMS, FIRST_AID,
                            "Military Science 40%:\n(Land) ", NAVIGATE, PERSUADE, UNARMED_COMBAT
                    );
                    optionalSkills = Arrays.asList(ARTILLERY, COMPUTER_SCIENCE, DEMOLITIONS, HEAVY_MACHINERY,
                            HEAVY_WEAPONS, SEARCH, SIGINT, SWIM
                    );
                    expectedSize = 13;
                    noSkills = new ArrayList<>(ALL_SKILLS);
                    noSkills.removeAll(defaultSkills);
                    noSkills.removeAll(optionalSkills);
                    assertThat(skills).containsOnlyOnceElementsOf(defaultSkills);
                    assertThat(skills).doesNotContainAnyElementsOf(noSkills);
                    assertThat(skills.size()).isEqualTo(expectedSize);
                    break;

                case "Pilot":
                    defaultSkills = Arrays.asList(ALERTNESS, BUREAUCRACY, "Craft 40%:\n(Electrician) ",
                            "Craft 40%:\n(Mechanic) ", NAVIGATE, "Science 40%:\n(Meteorology) ", SWIM
                            );
                    optionalSkills = Collections.singletonList(HEAVY_WEAPONS);
                    expectedSize = 10;
                    noSkills = new ArrayList<>(ALL_SKILLS);
                    noSkills.removeAll(defaultSkills);
                    noSkills.removeAll(optionalSkills);
                    assertThat(skills).containsOnlyOnceElementsOf(defaultSkills);
                    assertThat(skills).doesNotContainAnyElementsOf(noSkills);
                    assertThat(skills.size()).as(skills.toString()).isEqualTo(expectedSize);
                    break;
                //            ALERTNESS, BUREAUCRACY, FIRST AID, HUMINT, MEDICINE, PERSUADE, PHARMACY, SCIENCE (BIOLOGY) 40%
                //            CHOOSE TWO FROM:»DRIVE, FORENSICS, NAVIGATE, PSYCHOTHERAPY, SEARCH 60%
                case "Nurse":
                    defaultSkills = Arrays.asList(ALERTNESS, BUREAUCRACY, FIRST_AID, HUMINT, MEDICINE, PERSUADE,
                            PHARMACY, "Science 40%:\n(Biology) "
                    );
                    optionalSkills = Arrays.asList(DRIVE, FORENSICS, NAVIGATE, PSYCHOTHERAPY, SEARCH);
                    expectedSize = 10;
                    noSkills = new ArrayList<>(ALL_SKILLS);
                    noSkills.removeAll(defaultSkills);
                    noSkills.removeAll(optionalSkills);
                    assertThat(skills).containsOnlyOnceElementsOf(defaultSkills);
                    assertThat(skills).doesNotContainAnyElementsOf(noSkills);
                    assertThat(skills.size()).isEqualTo(expectedSize);
                    break;
                case "Lawyer":
                    defaultSkills = Arrays.asList(ACCOUNTING, BUREAUCRACY, HUMINT, PERSUADE
                    );
                    optionalSkills = Arrays.asList(COMPUTER_SCIENCE, CRIMINOLOGY, LAW, PHARMACY);
                    expectedSize = 8;
                    noSkills = new ArrayList<>(ALL_SKILLS);
                    noSkills.removeAll(defaultSkills);
                    noSkills.removeAll(optionalSkills);
                    assertThat(skills).containsOnlyOnceElementsOf(defaultSkills);
                    assertThat(skills).doesNotContainAnyElementsOf(noSkills);
                    assertThat(skills.size()).as(skills.toString()).isEqualTo(expectedSize);
                    break;
                default:
                    System.out.println(profession);
                    fail(profession);
            }
           /*
*/
////____________art
//history
//humint
//persuade
//                break;
////            alertness
//bureaucracy
//criminology
//drive
//firearms
//first-aid
//humint
//law
//melee-weapons
//navigate
//persuade
//search
//unarmed-combat
//            case "police-officer":
//                break;
////            accounting
//bureaucracy
//computer-science
//criminology
//foreign-language
//history
//law
//persuade
//            case "program-manager":
//                break;
////            alertness
//bureaucracy
//first-aid
//humint
//medicine
//persuade
//pharmacy
//science (biology)
//            case "nurse":
//                break;
////            alertness
//bureaucracy
//craft (electrician)
//craft (mechanic)
//navigate
//pilot
//science (meteorology)
//swim
//            case "pilot":
//                break;
////            alertness
//athletics
//bureaucracy
//drive
//firearms
//first-aid
//military-science (land)
//navigate
//persuade
//unarmed-combat
//            case "soldier":
//                break;
        }
        System.out.println(professionsSelect);
    }
//    anthropologist anthropology  or archeology,foreign-language,history,occult,persuade
//anthropology,archeology,humint,navigate,ride,search,survival
//    engineer
//accounting,bureaucracy,craft,foreign-language,heavy-machinery,law,science
//    federal-agent
//accounting,computer-science,foreign-language,heavy-weapons,pharmacy
//    special-operator alertness,athletics,demolitions,firearms,heavy-weapons,melee-weapons,military-science (land),navigate,stealth,survival,swim,unarmed-combat
//
//    physician bureaucracy,first-aid,medicine,persuade,pharmacy,science (biology),search
//forensics,psychotherapy,science,surgery
//
//    scientist bureaucracy,computer-science,science,science,science
//accounting,craft,foreign-language,forensics,law,pharmacy
//
//    firefighter alertness,athletics,craft (electrician),craft (mechanic),demolitions,drive,first-aid,forensics,heavy-machinery,navigate,search
//
//    foreign-service-officer accounting,anthropology,bureaucracy,foreign-language,foreign-language,foreign-language,history,humint,law,persuade
//
//    criminal alertness,criminology,dodge,drive,firearms,law,melee-weapons,persuade,stealth,unarmed-combat
//craft (locksmithing),demolitions,disguise,foreign-language,forensics,humint,navigate,occult,pharmacy
//
//    intelligence-analyst anthropology,bureaucracy,computer-science,criminology,foreign-language,foreign-language,foreign-language,history,humint,sigint
//
//    intelligence-case-officer alertness,bureaucracy,criminology,disguise,drive,firearms,foreign-language,foreign-language,humint,persuade,sigint,stealth,unarmed-combat
//
//    lawyer accounting,bureaucracy,humint,persuade
//computer-science,criminology,foreign-language,law,pharmacy
//
//    media-specialist art,history,humint,persuade
//anthropology,archeology,art,bureaucracy,computer-science,criminology,foreign-language,law,military-science,occult,science
//
//    police-officer alertness,bureaucracy,criminology,drive,firearms,first-aid,humint,law,melee-weapons,navigate,persuade,search,unarmed-combat
//forensics,heavy-machinery,heavy-weapons,ride
//
//    program-manager accounting,bureaucracy,computer-science,criminology,foreign-language,history,law,persuade
//anthropology,art,craft,science
//
//    nurse alertness,bureaucracy,first-aid,humint,medicine,persuade,pharmacy,science (biology)
//drive,forensics,navigate,psychotherapy,search
//
//    pilot
//foreign-language,pilot,heavy-weapons,military-science
//
//    soldier
//artillery,computer-science,craft,demolitions,foreign-language,heavy-machinery,heavy-weapons,search,sigint,swim
}