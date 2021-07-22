import com.dgbirdwatching.entities.Profession;
import com.dgbirdwatching.entities.Skill;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.text.WordUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.NginxContainer;
import org.testcontainers.containers.wait.strategy.HttpWaitStrategy;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.MountableFile;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@Testcontainers
public class UITest {

    private static final String ANTHROPOLOGIST_NAME = "anthropologist";
    private static final String ENGINEER_NAME = "engineer";
    private static final String FEDERAL_AGENT_NAME = "federal-agent";
    private static final String SPECIAL_OPERATOR_NAME = "special-operator";
    private static final String PHYSICIAN_NAME = "physician";
    private static final String SCIENTIST_NAME = "scientist";
    private static final String CRIMINAL_NAME = "criminal";
    private static final String FIREFIGHTER_NAME = "firefighter";
    private static final String FOREIGN_SERVICE_OFFICER_NAME = "foreign-service-officer";
    private static final String INTELLIGENCE_ANALYST_NAME = "intelligence-analyst";
    private static final String INTELLIGENCE_OFFICER_NAME = "intelligence-case-officer";
    private static final String LAWYER_NAME = "lawyer";
    private static final String MEDIA_SPECIALIST_NAME = "media-specialist";
    private static final String NURSE_NAME = "nurse";
    private static final String PILOT_NAME = "pilot";
    private static final String POLICE_OFFICER_NAME = "police-officer";
    private static final String PROGRAM_MANAGER_NAME = "program-manager";
    private static final String SOLDIER_NAME = "soldier";

    private static final String ANTHROPOLOGIST_DESCRIPTION = "You study humanity. You’re concerned with the patterns that emerge over time, across land masses, cultures, and language groups. You might be a number cruncher, a field worker trudging through the jungle, a consultant in a war zone, or a think-tank analyst sifting myth from history in studies of the Tcho-Tcho peoples.";
    private static final String ENGINEER_DESCRIPTION = "Computers and machinery are the backbone of modern industry. You are a craftsman with data or machinery, possibly for the government and most definitely for profit. However you use your skills, the overlap between information technology and awareness of the unnatural could make this the most dangerous job on the planet.";
    private static final String FEDERAL_AGENT_DESCRIPTION = "Many Delta Green Agents are federal law enforcement officers,mostly from the FBI. Delta Green decided long ago that federal agents have the optimum balance of skills and mental stability needed to confront the unnatural.";
    private static final String SPECIAL_OPERATOR_DESCRIPTION = "As part of a force like the U.S. Army Rangers,you volunteered for a more difficult path than other soldiers. You’ve spent years in the most grueling training on the planet,and now serve on the most dangerous missions around. For other versions of this profession (U.S. Army Special Forces,SEALs,USMC Raiders,FBI Hostage Rescue Team,CIA Special Operations Group,and so on)";
    private static final String PHYSICIAN_DESCRIPTION = "Doctors are often the first to uncover signs of an unnatural incursion,and the most valuable investigators of its disastrous effects on humanity.";
    private static final String SCIENTIST_DESCRIPTION = "You expand human knowledge in a field such as biology,physics,or chemistry. When certain forms of knowledge cause insanity and death,it’s easy to conclude that some hypotheses should not be tested.";
    private static final String CRIMINAL_DESCRIPTION = "So much is illegal that there are broad economies of crime. This profile fits a hardened militant or a traditional “black collar” criminal: pimp,burglar,extortionist,or thug. If you want a white-collar criminal,choose Computer Scientist or Business Executive and make very risky decisions.";
    private static final String FIREFIGHTER_DESCRIPTION = "Your job oscillates between the tedium of maintaining your gear,exhilaration when the alarm finally comes,and the work of investigating a scene after the smoke has cleared. If you’re involved with Delta Green,you clearly stumbled into something worse than a house fire.";
    private static final String FOREIGN_SERVICE_OFFICER_DESCRIPTION = "You travel to strange lands,meet interesting people,and try to get along with them. Odds are you work for the State Department,though USAID,the Commercial Service and the Foreign Agriculture Service also have FSOs. Either way,you’ve had every opportunity to learn exotic and deadly things,the kinds of things that qualify you for Delta Green clearance.";
    private static final String INTELLIGENCE_ANALYST_DESCRIPTION = "In the FBI, NSA and CIA, there are those who gather information and those who decide what it means. You take information from disparate sources—newspapers,websites,informants,ELINT,and the assets developed by Case Officers—and figure out what it means. In short,your job is the piecing together of unrelated knowledge,a dangerous endeavor in the world of Delta Green.";
    private static final String INTELLIGENCE_OFFICER_DESCRIPTION = "You recruit people to spy on their own countries for your agency,probably the CIA. Your job is to develop foreign intelligence sources (‘assets’),communicate with them,and keep them under control,productive,and alive. It’s a hard business because you must view everyone as a potential threat,liar,or tool to further your agenda. If your name came to the attention of Delta Green,congratulations, you are now someone else’s asset.";
    private static final String LAWYER_DESCRIPTION = "Your tools are a computer and smartphone. You might be moving millions of dollars,or bits of data,or both. Or you might be a prosecutor,a defense attorney,or judge.";
    private static final String MEDIA_SPECIALIST_DESCRIPTION = "You might be an author,an editor,a researcher for a company or any branch of the government,a blogger,a TV reporter,or a scholar of rare texts. With the unnatural,you’ve uncovered the story of a lifetime.";
    private static final String NURSE_DESCRIPTION = "Medical professionals are on the front line when awful things happen. Is that what brought you to the group’s attention?";
    private static final String PILOT_DESCRIPTION = "Air or sea,commercial or military,your duty is to keep your passengers alive and craft intact. This can lead to hard choices when your passengers put the vehicle in danger. Or are you a drone operator,flying a Predator from a thousand miles away? Either way,what op brought you to the attention of Delta Green?";
    private static final String POLICE_OFFICER_DESCRIPTION = "You serve and protect. Police officers walk the beat in uniform. Deputy sheriffs answer to an elected law enforcer and have jurisdiction over an entire county. Detectives come in after the fact and put the pieces together.";
    private static final String PROGRAM_MANAGER_DESCRIPTION = "You run an organization. Someone has to secure funding,move resources,and make connections—and that’s you.   You control a budget and are responsible for how your program is maintained and where the money goes. Organizations discover the most startling things in their pursuit of profit or the public good.";
    private static final String SOLDIER_DESCRIPTION = "Governments will always need boots on the ground and steady hands holding rifles. When war begins,civilization gets out of the way. With the social contract void,unnatural things creep in at the edges. There’s a reason Delta Green began in the military.";

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

    private static final int ACCOUNTING_BASE_VALUE = 0;
    private static final int HISTORY_BASE_VALUE = 0;
    private static final int UNNATURAL_BASE_VALUE = 0;
    private static final int ALERTNESS_BASE_VALUE = 0;
    private static final int HUMINT_BASE_VALUE = 0;
    private static final int ANTHROPOLOGY_BASE_VALUE = 0;
    private static final int LAW_BASE_VALUE = 0;
    private static final int ARCHEOLOGY_BASE_VALUE = 0;
    private static final int MEDICINE_BASE_VALUE = 0;
    private static final int ARTILLERY_BASE_VALUE = 0;
    private static final int MELEE_WEAPONS_BASE_VALUE = 0;
    private static final int ATHLETICS_BASE_VALUE = 0;
    private static final int NAVIGATE_BASE_VALUE = 0;
    private static final int BUREAUCRACY_BASE_VALUE = 0;
    private static final int OCCULT_BASE_VALUE = 0;
    private static final int COMPUTER_SCIENCE_BASE_VALUE = 0;
    private static final int PERSUADE_BASE_VALUE = 0;
    private static final int CRIMINOLOGY_BASE_VALUE = 0;
    private static final int PHARMACY_BASE_VALUE = 0;
    private static final int DEMOLITIONS_BASE_VALUE = 0;
    private static final int PSYCHOTHERAPY_BASE_VALUE = 0;
    private static final int DISGUISE_BASE_VALUE = 0;
    private static final int RIDE_BASE_VALUE = 0;
    private static final int DODGE_BASE_VALUE = 0;
    private static final int SEARCH_BASE_VALUE = 0;
    private static final int DRIVE_BASE_VALUE = 0;
    private static final int SIGINT_BASE_VALUE = 0;
    private static final int FIREARMS_BASE_VALUE = 0;
    private static final int STEALTH_BASE_VALUE = 0;
    private static final int FIRST_AID_BASE_VALUE = 0;
    private static final int SURGERY_BASE_VALUE = 0;
    private static final int FORENSICS_BASE_VALUE = 0;
    private static final int SURVIVAL_BASE_VALUE = 0;
    private static final int HEAVY_MACHINERY_BASE_VALUE = 0;
    private static final int SWIM_BASE_VALUE = 0;
    private static final int HEAVY_WEAPONS_BASE_VALUE = 0;
    private static final int UNARMED_COMBAT_BASE_VALUE = 0;

    private static final int CRAFT_BASE_VALUE = 0;
    private static final int SCIENCE_BASE_VALUE = 0;
    private static final int MILITARY_SCIENCE_BASE_VALUE = 0;
    private static final int ART_BASE_VALUE = 0;
    private static final int PILOT_SKILL_BASE_VALUE = 0;
    private static final int FOREIGN_LANGUAGE_BASE_VALUE = 0;

    private static final TestProfession ANTHROPOLOGIST = new TestProfession(ANTHROPOLOGIST_NAME,
            ANTHROPOLOGIST_DESCRIPTION, 2, 4,
            Map.of(
                    BUREAUCRACY, new Skill(BUREAUCRACY, BUREAUCRACY_BASE_VALUE,40),
                    HISTORY, new Skill(HISTORY, HISTORY_BASE_VALUE,60),
                    OCCULT, new Skill(OCCULT, OCCULT_BASE_VALUE,40),
                    PERSUADE, new Skill(PERSUADE, PERSUADE_BASE_VALUE,40),
                    formatSkillKey(FOREIGN_LANGUAGE, "50"), new Skill(FOREIGN_LANGUAGE, Collections.emptyList(), FOREIGN_LANGUAGE_BASE_VALUE, 50, null, ""),
                    formatSkillKey(FOREIGN_LANGUAGE, "40"), new Skill(FOREIGN_LANGUAGE, Collections.emptyList(), FOREIGN_LANGUAGE_BASE_VALUE, 40, null, "")
            ),
            Map.of(
                    ANTHROPOLOGY, new Skill(ANTHROPOLOGY, Collections.emptyList(), ANTHROPOLOGY_BASE_VALUE, 50,
                            new Skill(ARCHEOLOGY, ARCHEOLOGY_BASE_VALUE, 50), null)
            ),
            Map.of(
                    ANTHROPOLOGY, new Skill(ANTHROPOLOGY, Collections.emptyList(), ANTHROPOLOGY_BASE_VALUE, 50,
                            new Skill(ARCHEOLOGY, ARCHEOLOGY_BASE_VALUE, 50), null),
                    ARCHEOLOGY, new Skill(ARCHEOLOGY, ARCHEOLOGY_BASE_VALUE, 50),
                    HUMINT, new Skill(HUMINT, HUMINT_BASE_VALUE,50),
                    NAVIGATE, new Skill(NAVIGATE, NAVIGATE_BASE_VALUE,50),
                    RIDE, new Skill(RIDE, RIDE_BASE_VALUE,50),
                    SEARCH, new Skill(SEARCH, SEARCH_BASE_VALUE,60),
                    SURVIVAL, new Skill(SURVIVAL, SURVIVAL_BASE_VALUE,50)
            ));
    private static final TestProfession ENGINEER = new TestProfession(ENGINEER_NAME,
            ENGINEER_DESCRIPTION, 4, 3,
            Map.of(
                    COMPUTER_SCIENCE, new Skill(COMPUTER_SCIENCE, COMPUTER_SCIENCE_BASE_VALUE, 60),
                    formatSkillKey(CRAFT, "30" , "electrician"), new Skill(CRAFT, Collections.emptyList(), CRAFT_BASE_VALUE, 30, null, "Electrician"),
                    formatSkillKey(CRAFT, "30" , "mechanic"), new Skill(CRAFT, Collections.emptyList(), CRAFT_BASE_VALUE, 30, null, "Mechanic"),
                    formatSkillKey(CRAFT, "40" , "microelectronics"), new Skill(CRAFT, Collections.emptyList(), CRAFT_BASE_VALUE, 40, null, "Microelectronics"),
                    formatSkillKey(SCIENCE, "40" , "mathematics"), new Skill(SCIENCE, Collections.emptyList(), SCIENCE_BASE_VALUE, 40, null, "Mathematics"),
                    SIGINT, new Skill(SIGINT, SIGINT_BASE_VALUE,40)
            ),
            Map.of(
                    ACCOUNTING, new Skill(ACCOUNTING, ACCOUNTING_BASE_VALUE,50),
                    BUREAUCRACY, new Skill(BUREAUCRACY, BUREAUCRACY_BASE_VALUE,50),
                    HEAVY_MACHINERY, new Skill(HEAVY_MACHINERY, HEAVY_MACHINERY_BASE_VALUE,50),
                    LAW, new Skill(LAW, LAW_BASE_VALUE,40),
                    formatSkillKey(CRAFT, "40"), new Skill(CRAFT, Collections.emptyList(), CRAFT_BASE_VALUE,40, null, ""),
                    formatSkillKey(FOREIGN_LANGUAGE, "40"), new Skill(FOREIGN_LANGUAGE, Collections.emptyList(), FOREIGN_LANGUAGE_BASE_VALUE,40, null, ""),
                    formatSkillKey(SCIENCE, "40"), new Skill(SCIENCE, Collections.emptyList(), SCIENCE_BASE_VALUE,40, null, "")
            ));

    private static final TestProfession FEDERAL_AGENT = new TestProfession(FEDERAL_AGENT_NAME,
            FEDERAL_AGENT_DESCRIPTION, 1, 3,
            ImmutableMap.<String, Skill>builder()
                    .put(ALERTNESS, new Skill(ALERTNESS, ALERTNESS_BASE_VALUE, 50))
                    .put(BUREAUCRACY, new Skill(BUREAUCRACY, BUREAUCRACY_BASE_VALUE, 40))
                    .put(CRIMINOLOGY, new Skill(CRIMINOLOGY, CRIMINOLOGY_BASE_VALUE, 50))
                    .put(DRIVE, new Skill(DRIVE, DRIVE_BASE_VALUE, 50))
                    .put(FIREARMS, new Skill(FIREARMS, FIREARMS_BASE_VALUE, 50))
                    .put(FORENSICS, new Skill(FORENSICS, FORENSICS_BASE_VALUE, 30))
                    .put(HUMINT, new Skill(HUMINT, HUMINT_BASE_VALUE, 60))
                    .put(LAW, new Skill(LAW, LAW_BASE_VALUE, 30))
                    .put(PERSUADE, new Skill(PERSUADE, PERSUADE_BASE_VALUE, 50))
                    .put(SEARCH, new Skill(SEARCH, SEARCH_BASE_VALUE, 50))
                    .put(UNARMED_COMBAT, new Skill(UNARMED_COMBAT, UNARMED_COMBAT_BASE_VALUE,60))
                    .build(),
            Map.of(
                    ACCOUNTING, new Skill(ACCOUNTING, ACCOUNTING_BASE_VALUE,60),
                    COMPUTER_SCIENCE, new Skill(COMPUTER_SCIENCE, COMPUTER_SCIENCE_BASE_VALUE,50),
                    formatSkillKey(FOREIGN_LANGUAGE, "50"), new Skill(FOREIGN_LANGUAGE, Collections.emptyList(), FOREIGN_LANGUAGE_BASE_VALUE,50, null, ""),
                    HEAVY_WEAPONS, new Skill(HEAVY_WEAPONS, HEAVY_WEAPONS_BASE_VALUE,50),
                    PHARMACY, new Skill(PHARMACY, PHARMACY_BASE_VALUE,50)
            ));
    private static final TestProfession SPECIAL_OPERATOR = new TestProfession(SPECIAL_OPERATOR_NAME,
            SPECIAL_OPERATOR_DESCRIPTION, 0, 2,
            ImmutableMap.<String, Skill>builder()
                    .put(ALERTNESS, new Skill(ALERTNESS, ALERTNESS_BASE_VALUE, 60))
                    .put(ATHLETICS, new Skill(ATHLETICS, ATHLETICS_BASE_VALUE, 60))
                    .put(DEMOLITIONS, new Skill(DEMOLITIONS, DEMOLITIONS_BASE_VALUE, 40))
                    .put(FIREARMS, new Skill(FIREARMS, FIREARMS_BASE_VALUE, 60))
                    .put(HEAVY_WEAPONS, new Skill(HEAVY_WEAPONS, HEAVY_WEAPONS_BASE_VALUE, 50))
                    .put(MELEE_WEAPONS, new Skill(MELEE_WEAPONS, MELEE_WEAPONS_BASE_VALUE, 50))
                    .put(formatSkillKey(MILITARY_SCIENCE, "60", "land"), new Skill(MILITARY_SCIENCE, Collections.emptyList(), MILITARY_SCIENCE_BASE_VALUE, 60, null, "Land"))
                    .put(NAVIGATE, new Skill(NAVIGATE, NAVIGATE_BASE_VALUE, 50))
                    .put(STEALTH, new Skill(STEALTH, STEALTH_BASE_VALUE, 50))
                    .put(SURVIVAL, new Skill(SURVIVAL, SURVIVAL_BASE_VALUE, 50))
                    .put(SWIM, new Skill(SWIM, SWIM_BASE_VALUE, 50))
                    .put(UNARMED_COMBAT, new Skill(UNARMED_COMBAT, UNARMED_COMBAT_BASE_VALUE,60))
                    .build(),
            Collections.emptyMap());
    private static final TestProfession PHYSICIAN = new TestProfession(PHYSICIAN_NAME,
            PHYSICIAN_DESCRIPTION, 2, 3,
            ImmutableMap.<String, Skill>builder()
                    .put(BUREAUCRACY, new Skill(BUREAUCRACY, BUREAUCRACY_BASE_VALUE, 50))
                    .put(FIRST_AID, new Skill(FIRST_AID, FIRST_AID_BASE_VALUE, 60))
                    .put(MEDICINE, new Skill(MEDICINE, MEDICINE_BASE_VALUE, 60))
                    .put(PERSUADE, new Skill(PERSUADE, PERSUADE_BASE_VALUE, 40))
                    .put(PHARMACY, new Skill(PHARMACY, PHARMACY_BASE_VALUE, 50))
                    .put(formatSkillKey(SCIENCE, "60", "biology"), new Skill(SCIENCE, Collections.emptyList(), SCIENCE_BASE_VALUE, 60, null, "Biology"))
                    .put(SEARCH, new Skill(SEARCH, SEARCH_BASE_VALUE, 40))
                    .build(),
            ImmutableMap.<String, Skill>builder()
                    .put(FORENSICS, new Skill(FORENSICS, FORENSICS_BASE_VALUE, 50))
                    .put(PSYCHOTHERAPY, new Skill(PSYCHOTHERAPY, PSYCHOTHERAPY_BASE_VALUE, 60))
                    .put(formatSkillKey(SCIENCE, "50"), new Skill(SCIENCE, Collections.emptyList(), SCIENCE_BASE_VALUE, 50, null, ""))
                    .put(SURGERY, new Skill(SURGERY, SURGERY_BASE_VALUE, 50))
                    .build());
    private static final TestProfession SCIENTIST = new TestProfession(SCIENTIST_NAME,
            SCIENTIST_DESCRIPTION, 3, 4,
            ImmutableMap.<String, Skill>builder()
                    .put(BUREAUCRACY, new Skill(BUREAUCRACY, BUREAUCRACY_BASE_VALUE, 40))
                    .put(COMPUTER_SCIENCE, new Skill(COMPUTER_SCIENCE, COMPUTER_SCIENCE_BASE_VALUE, 40))
                    .put(formatSkillKey(SCIENCE, "60"), new Skill(SCIENCE, Collections.emptyList(), SCIENCE_BASE_VALUE, 60, null, ""))
                    .put(formatSkillKey(SCIENCE, "50"), new Skill(SCIENCE, Collections.emptyList(), SCIENCE_BASE_VALUE, 50, null, ""))
                    .put(formatSkillKey(SCIENCE, "50")+"_1", new Skill(SCIENCE, Collections.emptyList(), SCIENCE_BASE_VALUE, 50, null, ""))
                    .build(),
            ImmutableMap.<String, Skill>builder()
                    .put(ACCOUNTING, new Skill(ACCOUNTING, ACCOUNTING_BASE_VALUE, 50))
                    .put(CRAFT, new Skill(CRAFT, Collections.emptyList(), CRAFT_BASE_VALUE,40, null, ""))
                    .put(FOREIGN_LANGUAGE, new Skill(FOREIGN_LANGUAGE, Collections.emptyList(), FOREIGN_LANGUAGE_BASE_VALUE, 40, null, ""))
                    .put(FORENSICS, new Skill(FORENSICS, FORENSICS_BASE_VALUE, 40))
                    .put(LAW, new Skill(LAW, LAW_BASE_VALUE, 40))
                    .put(PHARMACY, new Skill(PHARMACY, PHARMACY_BASE_VALUE, 40))
                    .build());
    private static final TestProfession CRIMINAL = new TestProfession(CRIMINAL_NAME,
            CRIMINAL_DESCRIPTION, 2, 4,
            ImmutableMap.<String, Skill>builder()
                    .put(ALERTNESS, new Skill(ALERTNESS, ALERTNESS_BASE_VALUE, 50))
                    .put(ATHLETICS, new Skill(ATHLETICS, ATHLETICS_BASE_VALUE, 50))
                    .put(CRIMINOLOGY, new Skill(CRIMINOLOGY, CRIMINOLOGY_BASE_VALUE, 60))
                    .put(DODGE, new Skill(DODGE, DODGE_BASE_VALUE, 40))
                    .put(DRIVE, new Skill(DRIVE, DRIVE_BASE_VALUE, 50))
                    .put(FIREARMS, new Skill(FIREARMS, FIREARMS_BASE_VALUE, 40))
                    .put(LAW, new Skill(LAW, LAW_BASE_VALUE, 20))
                    .put(MELEE_WEAPONS, new Skill(MELEE_WEAPONS, MELEE_WEAPONS_BASE_VALUE, 40))
                    .put(PERSUADE, new Skill(PERSUADE, PERSUADE_BASE_VALUE, 50))
                    .put(STEALTH, new Skill(STEALTH, STEALTH_BASE_VALUE, 50))
                    .put(UNARMED_COMBAT, new Skill(UNARMED_COMBAT, UNARMED_COMBAT_BASE_VALUE, 50))
                    .build(),
            ImmutableMap.<String, Skill>builder()
                    .put(formatSkillKey(CRAFT,"40","locksmithing"), new Skill(CRAFT, Collections.emptyList(), CRAFT_BASE_VALUE,40, null, "Locksmithing"))
                    .put(DEMOLITIONS, new Skill(DEMOLITIONS, DEMOLITIONS_BASE_VALUE, 40))
                    .put(DISGUISE, new Skill(DISGUISE, DISGUISE_BASE_VALUE, 50))
                    .put(FOREIGN_LANGUAGE, new Skill(FOREIGN_LANGUAGE, Collections.emptyList(), FOREIGN_LANGUAGE_BASE_VALUE, 40, null, ""))
                    .put(FORENSICS, new Skill(FORENSICS, FORENSICS_BASE_VALUE, 40))
                    .put(HUMINT, new Skill(HUMINT, HUMINT_BASE_VALUE, 50))
                    .put(NAVIGATE, new Skill(NAVIGATE, NAVIGATE_BASE_VALUE, 50))
                    .put(OCCULT, new Skill(OCCULT, OCCULT_BASE_VALUE, 50))
                    .put(PHARMACY, new Skill(PHARMACY,PHARMACY_BASE_VALUE, 40))
                    .build());
    private static final TestProfession FIREFIGHTER = new TestProfession(FIREFIGHTER_NAME,
            FIREFIGHTER_DESCRIPTION, 0, 3,
            ImmutableMap.<String, Skill>builder()
                    .put(ALERTNESS, new Skill(ALERTNESS, ALERTNESS_BASE_VALUE, 50))
                    .put(ATHLETICS, new Skill(ATHLETICS, ATHLETICS_BASE_VALUE, 60))
                    .put(formatSkillKey(CRAFT, "40", "electrician"), new Skill(CRAFT, Collections.emptyList(), CRAFT_BASE_VALUE,40, null, "Electrician"))
                    .put(formatSkillKey(CRAFT, "40", "mechanic"), new Skill(CRAFT, Collections.emptyList(), CRAFT_BASE_VALUE,40, null, "Mechanic"))
                    .put(DEMOLITIONS, new Skill(DEMOLITIONS, DEMOLITIONS_BASE_VALUE, 50))
                    .put(DRIVE, new Skill(DRIVE, DRIVE_BASE_VALUE, 50))
                    .put(FIRST_AID, new Skill(FIRST_AID, FIRST_AID_BASE_VALUE, 50))
                    .put(FORENSICS, new Skill(FORENSICS, FORENSICS_BASE_VALUE, 40))
                    .put(HEAVY_MACHINERY, new Skill(HEAVY_MACHINERY, HEAVY_MACHINERY_BASE_VALUE, 50))
                    .put(NAVIGATE, new Skill(NAVIGATE, NAVIGATE_BASE_VALUE, 50))
                    .put(SEARCH, new Skill(SEARCH, SEARCH_BASE_VALUE, 40))
                    .build(),
            Collections.emptyMap());
    private static final TestProfession FOREIGN_SERVICE_OFFICER = new TestProfession(FOREIGN_SERVICE_OFFICER_NAME,
            FOREIGN_SERVICE_OFFICER_DESCRIPTION, 0, 3,
            ImmutableMap.<String, Skill>builder()
                    .put(ACCOUNTING, new Skill(ACCOUNTING, ACCOUNTING_BASE_VALUE, 40))
                    .put(ANTHROPOLOGY, new Skill(ANTHROPOLOGY, ANTHROPOLOGY_BASE_VALUE, 40))
                    .put(BUREAUCRACY, new Skill(BUREAUCRACY, BUREAUCRACY_BASE_VALUE, 60))
                    .put(formatSkillKey(FOREIGN_LANGUAGE, "50"), new Skill(FOREIGN_LANGUAGE, Collections.emptyList(), FOREIGN_LANGUAGE_BASE_VALUE, 50, null, ""))
                    .put(formatSkillKey(FOREIGN_LANGUAGE, "50")+"_1", new Skill(FOREIGN_LANGUAGE, Collections.emptyList(), FOREIGN_LANGUAGE_BASE_VALUE, 50, null, ""))
                    .put(formatSkillKey(FOREIGN_LANGUAGE, "40"), new Skill(FOREIGN_LANGUAGE, Collections.emptyList(), FOREIGN_LANGUAGE_BASE_VALUE, 40, null, ""))
                    .put(HISTORY, new Skill(HISTORY, HISTORY_BASE_VALUE, 40))
                    .put(HUMINT, new Skill(HUMINT, HUMINT_BASE_VALUE, 50))
                    .put(LAW, new Skill(LAW, LAW_BASE_VALUE, 40))
                    .put(PERSUADE, new Skill(PERSUADE, PERSUADE_BASE_VALUE, 50))
                    .build(),
            Collections.emptyMap());
    private static final TestProfession INTELLIGENCE_ANALYST = new TestProfession(INTELLIGENCE_ANALYST_NAME,
            INTELLIGENCE_ANALYST_DESCRIPTION, 0, 3,
            ImmutableMap.<String, Skill>builder()
                    .put(ANTHROPOLOGY, new Skill(ANTHROPOLOGY, ANTHROPOLOGY_BASE_VALUE, 40))
                    .put(BUREAUCRACY, new Skill(BUREAUCRACY, BUREAUCRACY_BASE_VALUE, 50))
                    .put(COMPUTER_SCIENCE, new Skill(COMPUTER_SCIENCE, COMPUTER_SCIENCE_BASE_VALUE, 40))
                    .put(CRIMINOLOGY, new Skill(CRIMINOLOGY, CRIMINOLOGY_BASE_VALUE, 40))
                    .put(formatSkillKey(FOREIGN_LANGUAGE, "50"), new Skill(FOREIGN_LANGUAGE, Collections.emptyList(), FOREIGN_LANGUAGE_BASE_VALUE, 50, null, ""))
                    .put(formatSkillKey(FOREIGN_LANGUAGE, "50")+"_1", new Skill(FOREIGN_LANGUAGE, Collections.emptyList(), FOREIGN_LANGUAGE_BASE_VALUE, 50, null, ""))
                    .put(formatSkillKey(FOREIGN_LANGUAGE, "40"), new Skill(FOREIGN_LANGUAGE, Collections.emptyList(), FOREIGN_LANGUAGE_BASE_VALUE, 40, null, ""))
                    .put(HISTORY, new Skill(HISTORY, HISTORY_BASE_VALUE, 40))
                    .put(HUMINT, new Skill(HUMINT, HUMINT_BASE_VALUE, 50))
                    .put(SIGINT, new Skill(SIGINT, SIGINT_BASE_VALUE, 40))
                    .build(),
            Collections.emptyMap());
    private static final TestProfession INTELLIGENCE_OFFICER = new TestProfession(INTELLIGENCE_OFFICER_NAME,
            INTELLIGENCE_OFFICER_DESCRIPTION, 0, 2,
            ImmutableMap.<String, Skill>builder()
                    .put(ALERTNESS, new Skill(ALERTNESS, ALERTNESS_BASE_VALUE, 50))
                    .put(BUREAUCRACY, new Skill(BUREAUCRACY, BUREAUCRACY_BASE_VALUE, 40))
                    .put(CRIMINOLOGY, new Skill(CRIMINOLOGY, CRIMINOLOGY_BASE_VALUE, 50))
                    .put(DISGUISE, new Skill(DISGUISE, DISGUISE_BASE_VALUE, 50))
                    .put(DRIVE, new Skill(DRIVE, DRIVE_BASE_VALUE, 40))
                    .put(FIREARMS, new Skill(FIREARMS, FIREARMS_BASE_VALUE, 40))
                    .put(formatSkillKey(FOREIGN_LANGUAGE, "50"), new Skill(FOREIGN_LANGUAGE, Collections.emptyList(), FOREIGN_LANGUAGE_BASE_VALUE, 50, null, ""))
                    .put(formatSkillKey(FOREIGN_LANGUAGE, "40"), new Skill(FOREIGN_LANGUAGE, Collections.emptyList(), FOREIGN_LANGUAGE_BASE_VALUE, 40, null, ""))
                    .put(HUMINT, new Skill(HUMINT, HUMINT_BASE_VALUE, 60))
                    .put(PERSUADE, new Skill(PERSUADE, PERSUADE_BASE_VALUE, 60))
                    .put(SIGINT, new Skill(SIGINT, SIGINT_BASE_VALUE, 40))
                    .put(STEALTH, new Skill(STEALTH, STEALTH_BASE_VALUE, 50))
                    .put(UNARMED_COMBAT, new Skill(UNARMED_COMBAT, UNARMED_COMBAT_BASE_VALUE, 50))
                    .build(),
            Collections.emptyMap());
    private static final TestProfession LAWYER = new TestProfession(LAWYER_NAME,
            LAWYER_DESCRIPTION, 4, 4,
            ImmutableMap.<String, Skill>builder()
                    .put(ACCOUNTING, new Skill(ACCOUNTING, ACCOUNTING_BASE_VALUE, 50))
                    .put(BUREAUCRACY, new Skill(BUREAUCRACY, BUREAUCRACY_BASE_VALUE, 50))
                    .put(HUMINT, new Skill(HUMINT,HUMINT_BASE_VALUE, 40))
                    .put(PERSUADE, new Skill(PERSUADE, PERSUADE_BASE_VALUE, 60))
                    .build(),
            ImmutableMap.<String, Skill>builder()
                    .put(COMPUTER_SCIENCE, new Skill(COMPUTER_SCIENCE, COMPUTER_SCIENCE_BASE_VALUE, 50))
                    .put(CRIMINOLOGY, new Skill(CRIMINOLOGY, CRIMINOLOGY_BASE_VALUE, 60))
                    .put(FOREIGN_LANGUAGE, new Skill(FOREIGN_LANGUAGE, Collections.emptyList(), FOREIGN_LANGUAGE_BASE_VALUE, 50, null, ""))
                    .put(LAW, new Skill(LAW, LAW_BASE_VALUE, 50))
                    .put(PHARMACY, new Skill(PHARMACY, PHARMACY_BASE_VALUE, 50))
                    .build());
    private static final TestProfession MEDIA_SPECIALIST = new TestProfession(MEDIA_SPECIALIST_NAME,
            MEDIA_SPECIALIST_DESCRIPTION, 5, 4,
            ImmutableMap.<String, Skill>builder()
                    .put(formatSkillKey(ART, "60"), new Skill(ART, Collections.emptyList(), ART_BASE_VALUE, 60, null, ""))
                    .put(HISTORY, new Skill(HISTORY, HISTORY_BASE_VALUE, 40))
                    .put(HUMINT, new Skill(HUMINT, HUMINT_BASE_VALUE, 40))
                    .put(PERSUADE, new Skill(PERSUADE, PERSUADE_BASE_VALUE, 50))
                    .build(),
            ImmutableMap.<String, Skill>builder()
                    .put(ANTHROPOLOGY, new Skill(ANTHROPOLOGY, ANTHROPOLOGY_BASE_VALUE, 40))
                    .put(ARCHEOLOGY, new Skill(ARCHEOLOGY, ARCHEOLOGY_BASE_VALUE, 40))
                    .put(ART, new Skill(ART, Collections.emptyList(), ART_BASE_VALUE, 40, null, ""))
                    .put(BUREAUCRACY, new Skill(BUREAUCRACY, BUREAUCRACY_BASE_VALUE, 50))
                    .put(COMPUTER_SCIENCE, new Skill(COMPUTER_SCIENCE, COMPUTER_SCIENCE_BASE_VALUE, 40))
                    .put(CRIMINOLOGY, new Skill(CRIMINOLOGY, CRIMINOLOGY_BASE_VALUE, 50))
                    .put(FOREIGN_LANGUAGE, new Skill(FOREIGN_LANGUAGE, Collections.emptyList(), FOREIGN_LANGUAGE_BASE_VALUE, 40, null, ""))
                    .put(LAW, new Skill(LAW, LAW_BASE_VALUE, 40))
                    .put(MILITARY_SCIENCE, new Skill(MILITARY_SCIENCE, Collections.emptyList(), MILITARY_SCIENCE_BASE_VALUE, 40, null, ""))
                    .put(OCCULT, new Skill(OCCULT, OCCULT_BASE_VALUE, 50))
                    .put(SCIENCE, new Skill(SCIENCE, Collections.emptyList(), SCIENCE_BASE_VALUE, 40, null, ""))
                    .build());
    private static final TestProfession NURSE = new TestProfession(NURSE_NAME,
            NURSE_DESCRIPTION, 0, 4,
            ImmutableMap.<String, Skill>builder()
                    .put(ALERTNESS, new Skill(ALERTNESS, ALERTNESS_BASE_VALUE, 40))
                    .put(BUREAUCRACY, new Skill(BUREAUCRACY, BUREAUCRACY_BASE_VALUE, 40))
                    .put(FIRST_AID, new Skill(FIRST_AID, FIRST_AID_BASE_VALUE, 60))
                    .put(HUMINT, new Skill(HUMINT, HUMINT_BASE_VALUE, 40))
                    .put(MEDICINE, new Skill(MEDICINE, MEDICINE_BASE_VALUE, 40))
                    .put(PERSUADE, new Skill(PERSUADE, PERSUADE_BASE_VALUE, 40))
                    .put(PHARMACY, new Skill(PHARMACY, PHARMACY_BASE_VALUE, 40))
                    .put(formatSkillKey(SCIENCE,"40","biology"), new Skill(SCIENCE, Collections.emptyList(), SCIENCE_BASE_VALUE, 40, null, "Biology"))
                    .build(),
            ImmutableMap.<String, Skill>builder()
                    .put(DRIVE, new Skill(DRIVE, DRIVE_BASE_VALUE, 60))
                    .put(FORENSICS, new Skill(FORENSICS, FORENSICS_BASE_VALUE, 40))
                    .put(NAVIGATE, new Skill(NAVIGATE, NAVIGATE_BASE_VALUE, 50))
                    .put(PSYCHOTHERAPY, new Skill(PSYCHOTHERAPY, PSYCHOTHERAPY_BASE_VALUE, 50))
                    .put(SEARCH, new Skill(SEARCH, SEARCH_BASE_VALUE, 60))
                    .build());

    private static final TestProfession PILOT = new TestProfession(PILOT_NAME,
            PILOT_DESCRIPTION, 2, 3,
            ImmutableMap.<String, Skill>builder()
                    .put(ALERTNESS, new Skill(ALERTNESS, ALERTNESS_BASE_VALUE, 60))
                    .put(BUREAUCRACY, new Skill(BUREAUCRACY, BUREAUCRACY_BASE_VALUE, 30))
                    .put(formatSkillKey(CRAFT, "40", "electrician"), new Skill(CRAFT, Collections.emptyList(), CRAFT_BASE_VALUE,40, null, "Electrician"))
                    .put(formatSkillKey(CRAFT, "40", "mechanic"), new Skill(CRAFT, Collections.emptyList(), CRAFT_BASE_VALUE,40, null, "Mechanic"))
                    .put(NAVIGATE, new Skill(NAVIGATE, NAVIGATE_BASE_VALUE, 50))
                    .put(formatSkillKey(PILOT_SKILL, "60"), new Skill(PILOT_SKILL, Collections.emptyList(), PILOT_SKILL_BASE_VALUE, 60, null, ""))
                    .put(formatSkillKey(SCIENCE, "40", "meteorology"), new Skill(SCIENCE, Collections.emptyList(), SCIENCE_BASE_VALUE, 40, null, "Meteorology"))
                    .put(SWIM, new Skill(SWIM, SWIM_BASE_VALUE, 40))
                    .build(),
            ImmutableMap.<String, Skill>builder()
                    .put(formatSkillKey(FOREIGN_LANGUAGE, "50"), new Skill(FOREIGN_LANGUAGE, Collections.emptyList(), FOREIGN_LANGUAGE_BASE_VALUE, 50, null, ""))
                    .put(formatSkillKey(PILOT_SKILL, "50"), new Skill(PILOT_SKILL, Collections.emptyList(), PILOT_SKILL_BASE_VALUE, 50, null, ""))
                    .put(HEAVY_WEAPONS, new Skill(HEAVY_WEAPONS, HEAVY_WEAPONS_BASE_VALUE, 50))
                    .put(formatSkillKey(MILITARY_SCIENCE, "50"), new Skill(MILITARY_SCIENCE, Collections.emptyList(), MILITARY_SCIENCE_BASE_VALUE, 50, null, ""))
                    .build());
    private static final TestProfession POLICE_OFFICER = new TestProfession(POLICE_OFFICER_NAME,
            POLICE_OFFICER_DESCRIPTION, 1, 3,
            ImmutableMap.<String, Skill>builder()
                    .put(ALERTNESS, new Skill(ALERTNESS, ALERTNESS_BASE_VALUE, 60))
                    .put(BUREAUCRACY, new Skill(BUREAUCRACY, BUREAUCRACY_BASE_VALUE, 40))
                    .put(CRIMINOLOGY, new Skill(CRIMINOLOGY, CRIMINOLOGY_BASE_VALUE, 40))
                    .put(DRIVE, new Skill(DRIVE, DRIVE_BASE_VALUE, 50))
                    .put(FIREARMS, new Skill(FIREARMS, FIREARMS_BASE_VALUE, 40))
                    .put(FIRST_AID, new Skill(FIRST_AID, FIRST_AID_BASE_VALUE, 30))
                    .put(HUMINT, new Skill(HUMINT, HUMINT_BASE_VALUE, 50))
                    .put(LAW, new Skill(LAW, LAW_BASE_VALUE, 30))
                    .put(MELEE_WEAPONS, new Skill(MELEE_WEAPONS, MELEE_WEAPONS_BASE_VALUE, 50))
                    .put(NAVIGATE, new Skill(NAVIGATE, NAVIGATE_BASE_VALUE, 40))
                    .put(PERSUADE, new Skill(PERSUADE, PERSUADE_BASE_VALUE, 40))
                    .put(SEARCH, new Skill(SEARCH, SEARCH_BASE_VALUE, 40))
                    .put(UNARMED_COMBAT, new Skill(UNARMED_COMBAT, UNARMED_COMBAT_BASE_VALUE, 60))
                    .build(),
            ImmutableMap.<String, Skill>builder()
                    .put(FORENSICS, new Skill(FORENSICS, FORENSICS_BASE_VALUE, 50))
                    .put(HEAVY_MACHINERY, new Skill(HEAVY_MACHINERY, HEAVY_MACHINERY_BASE_VALUE, 60))
                    .put(HEAVY_WEAPONS, new Skill(HEAVY_WEAPONS, HEAVY_WEAPONS_BASE_VALUE, 50))
                    .put(RIDE, new Skill(RIDE, RIDE_BASE_VALUE, 60))
                    .build());
    private static final TestProfession PROGRAM_MANAGER = new TestProfession(PROGRAM_MANAGER_NAME,
            PROGRAM_MANAGER_DESCRIPTION, 1, 4,
            ImmutableMap.<String, Skill>builder()
                    .put(ACCOUNTING, new Skill(ACCOUNTING, ACCOUNTING_BASE_VALUE, 60))
                    .put(BUREAUCRACY, new Skill(BUREAUCRACY, BUREAUCRACY_BASE_VALUE, 60))
                    .put(COMPUTER_SCIENCE, new Skill(COMPUTER_SCIENCE, COMPUTER_SCIENCE_BASE_VALUE, 50))
                    .put(CRIMINOLOGY, new Skill(CRIMINOLOGY, CRIMINOLOGY_BASE_VALUE, 30))
                    .put(formatSkillKey(FOREIGN_LANGUAGE, "50"), new Skill(FOREIGN_LANGUAGE, Collections.emptyList(), FOREIGN_LANGUAGE_BASE_VALUE, 50, null, ""))
                    .put(HISTORY, new Skill(HISTORY, HISTORY_BASE_VALUE, 40))
                    .put(LAW, new Skill(LAW, LAW_BASE_VALUE, 40))
                    .put(PERSUADE, new Skill(PERSUADE, PERSUADE_BASE_VALUE, 50))
                    .build(),
            ImmutableMap.<String, Skill>builder()
                    .put(ANTHROPOLOGY, new Skill(ANTHROPOLOGY, ANTHROPOLOGY_BASE_VALUE, 30))
                    .put(formatSkillKey(ART, "30"), new Skill(ART, Collections.emptyList(), ART_BASE_VALUE, 30, null, ""))
                    .put(formatSkillKey(CRAFT, "30"), new Skill(CRAFT, Collections.emptyList(), CRAFT_BASE_VALUE,30, null, ""))
                    .put(formatSkillKey(SCIENCE, "30"), new Skill(SCIENCE, Collections.emptyList(), SCIENCE_BASE_VALUE, 30, null, ""))
                    .build());
    private static final TestProfession SOLDIER = new TestProfession(SOLDIER_NAME,
            SOLDIER_DESCRIPTION, 3, 4,
            ImmutableMap.<String, Skill>builder()
                    .put(ALERTNESS, new Skill(ALERTNESS, ALERTNESS_BASE_VALUE, 50))
                    .put(ATHLETICS, new Skill(ATHLETICS, ATHLETICS_BASE_VALUE, 50))
                    .put(BUREAUCRACY, new Skill(BUREAUCRACY, BUREAUCRACY_BASE_VALUE, 30))
                    .put(DRIVE, new Skill(DRIVE, DRIVE_BASE_VALUE, 40))
                    .put(FIREARMS, new Skill(FIREARMS, FIREARMS_BASE_VALUE, 40))
                    .put(FIRST_AID, new Skill(FIRST_AID, FIRST_AID_BASE_VALUE, 40))
                    .put(formatSkillKey(MILITARY_SCIENCE, "40", "land"), new Skill(MILITARY_SCIENCE, Collections.emptyList(), MILITARY_SCIENCE_BASE_VALUE, 40, null, "Land"))
                    .put(NAVIGATE, new Skill(NAVIGATE, NAVIGATE_BASE_VALUE, 40))
                    .put(PERSUADE, new Skill(PERSUADE, PERSUADE_BASE_VALUE, 30))
                    .put(UNARMED_COMBAT, new Skill(UNARMED_COMBAT, UNARMED_COMBAT_BASE_VALUE, 50))
                    .build(),
            ImmutableMap.<String, Skill>builder()
                    .put(ARTILLERY, new Skill(ARTILLERY, ARTILLERY_BASE_VALUE, 40))
                    .put(COMPUTER_SCIENCE, new Skill(COMPUTER_SCIENCE, COMPUTER_SCIENCE_BASE_VALUE, 40))
                    .put(CRAFT, new Skill(CRAFT, Collections.emptyList(), CRAFT_BASE_VALUE,40, null, ""))
                    .put(DEMOLITIONS, new Skill(DEMOLITIONS, DEMOLITIONS_BASE_VALUE, 40))
                    .put(FOREIGN_LANGUAGE, new Skill(FOREIGN_LANGUAGE, Collections.emptyList(), FOREIGN_LANGUAGE_BASE_VALUE, 40, null, ""))
                    .put(HEAVY_MACHINERY, new Skill(HEAVY_MACHINERY, HEAVY_MACHINERY_BASE_VALUE, 50))
                    .put(HEAVY_WEAPONS, new Skill(HEAVY_WEAPONS, HEAVY_WEAPONS_BASE_VALUE, 40))
                    .put(SEARCH, new Skill(SEARCH, SEARCH_BASE_VALUE, 60))
                    .put(SIGINT, new Skill(SIGINT, SIGINT_BASE_VALUE, 40))
                    .put(SWIM, new Skill(SWIM, SWIM_BASE_VALUE, 60))
                    .build());

    private static final List<String> ALL_SKILLS = Arrays.asList(ACCOUNTING, HISTORY, UNNATURAL, ALERTNESS, HUMINT,
            ANTHROPOLOGY, LAW, ARCHEOLOGY, MEDICINE, ARTILLERY, MELEE_WEAPONS, ATHLETICS, NAVIGATE, BUREAUCRACY,
            OCCULT, COMPUTER_SCIENCE, PERSUADE, CRIMINOLOGY, PHARMACY, DEMOLITIONS, PSYCHOTHERAPY, DISGUISE, RIDE,
            DODGE, SEARCH, DRIVE, SIGINT, FIREARMS, STEALTH, FIRST_AID, SURGERY, FORENSICS, SURVIVAL, HEAVY_MACHINERY,
            SWIM, HEAVY_WEAPONS, UNARMED_COMBAT, CRAFT, SCIENCE, MILITARY_SCIENCE, ART, PILOT_SKILL, FOREIGN_LANGUAGE);

    private static final List<String> INPUT_SKILLS = Arrays.asList(CRAFT, SCIENCE, MILITARY_SCIENCE,
            ART, PILOT_SKILL, FOREIGN_LANGUAGE);

    private static final Map<String, TestProfession> professions =
            ImmutableMap.<String, TestProfession>builder()
                    .put(ANTHROPOLOGIST_NAME, ANTHROPOLOGIST)
                    .put(ENGINEER_NAME, ENGINEER)
                    .put(FEDERAL_AGENT_NAME, FEDERAL_AGENT)
                    .put(SPECIAL_OPERATOR_NAME, SPECIAL_OPERATOR)
                    .put(PHYSICIAN_NAME, PHYSICIAN)
                    .put(SCIENTIST_NAME, SCIENTIST)
                    .put(CRIMINAL_NAME, CRIMINAL)
                    .put(FIREFIGHTER_NAME, FIREFIGHTER)
                    .put(FOREIGN_SERVICE_OFFICER_NAME, FOREIGN_SERVICE_OFFICER)
                    .put(INTELLIGENCE_ANALYST_NAME, INTELLIGENCE_ANALYST)
                    .put(INTELLIGENCE_OFFICER_NAME, INTELLIGENCE_OFFICER)
                    .put(LAWYER_NAME, LAWYER)
                    .put(MEDIA_SPECIALIST_NAME, MEDIA_SPECIALIST)
                    .put(NURSE_NAME, NURSE)
                    .put(PILOT_NAME, PILOT)
                    .put(POLICE_OFFICER_NAME, POLICE_OFFICER)
                    .put(PROGRAM_MANAGER_NAME, PROGRAM_MANAGER)
                    .put(SOLDIER_NAME, SOLDIER)
                    .build();

    private static final List<String> CRAFT_INPUTS = Arrays.asList("Architect", "Carpenter", "Electrician", "Gunsmith");
    private static final List<String> SCIENCE_INPUTS = Arrays.asList("Astronomy", "Biology", "Botany", "Chemistry");
    private static final List<String> MILITARY_SCIENCE_INPUTS = Arrays.asList("Land", "Air", "Sea", "Space");
    private static final List<String> ART_INPUTS = Arrays.asList("Acting", "Creative Writing", "Dance", "Flute");
    private static final List<String> PILOT_INPUTS = Arrays.asList("Airplane", "Drone", "Helicopter", "Small Boat");
    private static final List<String> FOREIGN_LANGUAGE_INPUTS = Arrays.asList("Spanish", "French", "Chinese", "Germamn");

    private static final Map<String, List<List<String>>> INPUT_MAP = Map.of(
            CRAFT, Arrays.asList(new ArrayList<>(CRAFT_INPUTS), new ArrayList<>()),
            ART, Arrays.asList(new ArrayList<>(ART_INPUTS), new ArrayList<>()),
            FOREIGN_LANGUAGE, Arrays.asList(new ArrayList<>(FOREIGN_LANGUAGE_INPUTS), new ArrayList<>()),
            SCIENCE, Arrays.asList(new ArrayList<>(SCIENCE_INPUTS), new ArrayList<>()),
            MILITARY_SCIENCE, Arrays.asList(new ArrayList<>(MILITARY_SCIENCE_INPUTS), new ArrayList<>()),
            PILOT_SKILL, Arrays.asList(new ArrayList<>(PILOT_INPUTS), new ArrayList<>()));

    @Container
    public NginxContainer<?> nginx = new NginxContainer<>("nginx:latest")
            .withFileSystemBind("/Users/pthompson/repos/deltagreen/charactercreator/src/main/nginx/", "/etc/nginx", BindMode.READ_ONLY)
            .withCopyFileToContainer(MountableFile.forHostPath("/Users/pthompson/repos/deltagreen/charactercreator/src/main/", MountableFile.DEFAULT_DIR_MODE), "/usr/share/nginx/html/")
            .withExposedPorts(80)
            .waitingFor(new HttpWaitStrategy().withStartupTimeout(Duration.ofMinutes(3L)));

    private WebDriver getDriver() {
        WebDriver driver = new ChromeDriver();
        URL baseUrl = null;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {
        }
        try {
            baseUrl = nginx.getBaseUrl("http", 80);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get(baseUrl.toString() + "/CharacterSheet.html");
        return driver;
    }

    private void click(WebDriver driver, String id) {
        WebElement element = driver.findElement(By.id(id));
        element.click();
    }

    private void inputText(WebDriver driver, String id, String text) {
        WebElement language = driver.findElement(By.id(id));
        language.clear();
        language.sendKeys(text);
    }

    private String getSkillString(String profession, String skill) {
        return profession + "-" + skill;
    }

    private String getValue(WebDriver driver, String id) {
        WebElement element = driver.findElement(By.id(id));
        return element.getAttribute("value");
    }

    private void checkAllSkillValues(WebDriver driver, Map<String, String> skillMap) {
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

    private List<WebElement> getElementsByClass(WebDriver driver, String className) {
        return driver.findElements(By.className(className));
    }

    private void checkAllEnabled(WebDriver driver, List<String> enabled) {
        checkAllEnabled(driver, enabled, Collections.emptyList());
    }

    private void checkAllEnabled(WebDriver driver, List<String> enabled, List<String> disabled) {
        for (String id : enabled) {
            WebElement element = driver.findElement(By.id(id));
            assertThat(element.isEnabled()).as(id + " enabled").isTrue();
        }

        for (String id : disabled) {
            WebElement element = driver.findElement(By.id(id));
            assertThat(element.isEnabled()).as(id + " enabled").isFalse();
        }

    }

    private void checkAllEnabled(WebDriver driver, Map<String, Boolean> skills) {
        for (Map.Entry<String, Boolean> skillEntry : skills.entrySet()) {
            WebElement element = driver.findElement(By.id(skillEntry.getKey()));
            assertThat(element.isEnabled()).as(skillEntry.getKey() + " enabled").isEqualTo(skillEntry.getValue());
        }
    }

    private void assertOtherSkill(WebDriver driver, int position, String text, String value) {
        assertEquals(driver.findElements(By.className("other-skill-name")).get(position).getAttribute("value"), text);
        assertEquals(driver.findElements(By.className("other-skill")).get(position).getAttribute("value"), value);
    }

    private void openProfessionModal(WebDriver driver) {
        click(driver, "professions");
    }

    private void selectProfession(WebDriver driver, String currentProfession, String newProfession) {
        select(driver, currentProfession + "-professions", newProfession);
    }

    private void select(WebDriver driver, String id, String value) {
        Select select = new Select(driver.findElement(By.id(id)));
        select.selectByValue(value);
    }

    private String getChildElementValue(WebElement parent, String className) {
        return parent.findElement(By.className(className)).getAttribute("value");
    }

    private List<WebElement> getChildElementsByTag(WebElement parent, String tag) {
        return parent.findElements(By.tagName(tag));
    }

    private void testWeapon(WebDriver driver, WebElement parent, String weaponName, String skill, String range, String damage, String piercing, String lethality, String killRadius, String ammo) {
        testWeapon(driver, parent, weaponName, skill, range, Collections.singletonList(damage), piercing, lethality, killRadius, ammo);
    }

    private void testWeapon(WebDriver driver, WebElement parent, String weaponName, String skill, String range, List<String> damage, String piercing, String lethality, String killRadius, String ammo) {
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

    private List<WebElement> findElementsByMultipleClasses(WebDriver driver, String... classes) {
        String classString = Arrays.stream(classes).collect(Collectors
                .joining("') and contains(@class, '", "//*[contains(@class, '", "')]"));
        return driver.findElements(By.xpath(classString));
    }

    private List<WebElement> findElementsByMultipleClassesAndTag(WebDriver driver, String tag, String... classes) {
        String classString = Arrays.stream(classes).collect(Collectors
                .joining("') and contains(@class, '", "//" + tag + "[contains(@class, '", "')]"));
        return driver.findElements(By.xpath(classString));
    }

    private static Stream<Arguments> provideArguments() {
        Stream.Builder argumentsStream = Stream.<Arguments>builder();
        argumentsStream.add(Arguments.of(ANTHROPOLOGIST_NAME, Arrays.asList(ARCHEOLOGY, HUMINT)));
        argumentsStream.add(Arguments.of(ANTHROPOLOGIST_NAME, Arrays.asList(NAVIGATE, RIDE)));
        argumentsStream.add(Arguments.of(ANTHROPOLOGIST_NAME, Arrays.asList(SEARCH, SURVIVAL)));
        argumentsStream.add(Arguments.of(ENGINEER_NAME, Arrays.asList(ACCOUNTING, BUREAUCRACY, CRAFT, FOREIGN_LANGUAGE)));
        argumentsStream.add(Arguments.of(ENGINEER_NAME, Arrays.asList(FOREIGN_LANGUAGE, HEAVY_MACHINERY, LAW, SCIENCE)));
        argumentsStream.add(Arguments.of(FEDERAL_AGENT_NAME, Collections.singletonList(ACCOUNTING)));
        argumentsStream.add(Arguments.of(FEDERAL_AGENT_NAME, Collections.singletonList(COMPUTER_SCIENCE)));
        argumentsStream.add(Arguments.of(FEDERAL_AGENT_NAME, Collections.singletonList(FOREIGN_LANGUAGE)));
        argumentsStream.add(Arguments.of(FEDERAL_AGENT_NAME, Collections.singletonList(HEAVY_WEAPONS)));
        argumentsStream.add(Arguments.of(FEDERAL_AGENT_NAME, Collections.singletonList(PHARMACY)));
        argumentsStream.add(Arguments.of(PHYSICIAN_NAME, Arrays.asList(FORENSICS, PSYCHOTHERAPY)));
        argumentsStream.add(Arguments.of(PHYSICIAN_NAME, Arrays.asList(SCIENCE, SURGERY)));
        argumentsStream.add(Arguments.of(SCIENTIST_NAME, Arrays.asList(ACCOUNTING, CRAFT, FOREIGN_LANGUAGE)));
        argumentsStream.add(Arguments.of(SCIENTIST_NAME, Arrays.asList(FORENSICS, LAW, PHARMACY)));
        argumentsStream.add(Arguments.of(SPECIAL_OPERATOR_NAME, Collections.emptyList()));
        argumentsStream.add(Arguments.of(CRIMINAL_NAME, Arrays.asList(CRAFT, DEMOLITIONS)));
        argumentsStream.add(Arguments.of(CRIMINAL_NAME, Arrays.asList(DISGUISE, FOREIGN_LANGUAGE)));
        argumentsStream.add(Arguments.of(CRIMINAL_NAME, Arrays.asList(FORENSICS, HUMINT)));
        argumentsStream.add(Arguments.of(CRIMINAL_NAME, Arrays.asList(NAVIGATE, OCCULT)));
        argumentsStream.add(Arguments.of(CRIMINAL_NAME, Arrays.asList(OCCULT, PHARMACY)));
        argumentsStream.add(Arguments.of(FIREFIGHTER_NAME, Collections.emptyList()));
        argumentsStream.add(Arguments.of(FOREIGN_SERVICE_OFFICER_NAME, Collections.emptyList()));
        argumentsStream.add(Arguments.of(INTELLIGENCE_OFFICER_NAME, Collections.emptyList()));
        argumentsStream.add(Arguments.of(INTELLIGENCE_ANALYST_NAME, Collections.emptyList()));
        argumentsStream.add(Arguments.of(LAWYER_NAME, Arrays.asList(COMPUTER_SCIENCE, CRIMINOLOGY, FOREIGN_LANGUAGE, LAW)));
        argumentsStream.add(Arguments.of(LAWYER_NAME, Arrays.asList(CRIMINOLOGY, FOREIGN_LANGUAGE, LAW, PHARMACY)));
        argumentsStream.add(Arguments.of(MEDIA_SPECIALIST_NAME, Collections.emptyList()));
        argumentsStream.add(Arguments.of(NURSE_NAME, Arrays.asList(DRIVE, FORENSICS)));
        argumentsStream.add(Arguments.of(NURSE_NAME, Arrays.asList(NAVIGATE, PSYCHOTHERAPY)));
        argumentsStream.add(Arguments.of(NURSE_NAME, Arrays.asList(PSYCHOTHERAPY, SEARCH)));
        argumentsStream.add(Arguments.of(PILOT_NAME, Arrays.asList(FOREIGN_LANGUAGE, PILOT_NAME)));
        argumentsStream.add(Arguments.of(PILOT_NAME, Arrays.asList(HEAVY_WEAPONS, MILITARY_SCIENCE)));
        argumentsStream.add(Arguments.of(POLICE_OFFICER_NAME, Collections.singletonList(FORENSICS)));
        argumentsStream.add(Arguments.of(POLICE_OFFICER_NAME, Collections.singletonList(HEAVY_MACHINERY)));
        argumentsStream.add(Arguments.of(POLICE_OFFICER_NAME, Collections.singletonList(HEAVY_WEAPONS)));
        argumentsStream.add(Arguments.of(POLICE_OFFICER_NAME, Collections.singletonList(RIDE)));
        argumentsStream.add(Arguments.of(PROGRAM_MANAGER_NAME, Collections.singletonList(ANTHROPOLOGY)));
        argumentsStream.add(Arguments.of(PROGRAM_MANAGER_NAME, Collections.singletonList(ART)));
        argumentsStream.add(Arguments.of(PROGRAM_MANAGER_NAME, Collections.singletonList(CRAFT)));
        argumentsStream.add(Arguments.of(PROGRAM_MANAGER_NAME, Collections.singletonList(SCIENCE)));
        argumentsStream.add(Arguments.of(SOLDIER_NAME, Arrays.asList(ARTILLERY, COMPUTER_SCIENCE, CRAFT)));
        argumentsStream.add(Arguments.of(SOLDIER_NAME, Arrays.asList(DEMOLITIONS, FOREIGN_LANGUAGE, HEAVY_MACHINERY)));
        argumentsStream.add(Arguments.of(SOLDIER_NAME, Arrays.asList(HEAVY_WEAPONS, SEARCH, SIGINT)));
        argumentsStream.add(Arguments.of(SOLDIER_NAME, Arrays.asList(SEARCH, SIGINT, SWIM)));
        return argumentsStream.build();

    }

    private static String formatSkillKey(String name, String value) {
        return name.replace("-", " ") + " " + value + "%:";
    }

    private static String formatSkillKey(String name, String value, String input) {
        return name.replace("-", " ") + " " + value + "%:\n(" + input + ")";
    }

    private List<WebElement> getDefaultSkillElements(WebDriver driver, String professionName) {
        return driver.findElements((By.xpath("//div[@class='"
                + professionName + " prof-modal skill-default']")));
    }

    private void verifyTextOnSkillElement(WebElement skillElement, TestProfession profession) {
        String key = skillElement.getText().toLowerCase();
        if(!key.contains("(")) {
            key = parseSkillName(key);
        }

        Skill skill = profession.getDefaultSkills().get(key);
        assertThat(skill).as(key).isNotNull();
        assertThat(skill.getSkillDisplayText()).isEqualTo(skillElement.getText().toLowerCase());
    }

    private Skill addExclusiveSkill(WebElement skillElement, WebDriver driver, TestProfession profession) {
        String key = (skillElement.getText().substring(0, skillElement.getText().indexOf(" "))).toLowerCase();
        Skill skill = profession.getExclusiveSkills().get(key);

        String exclusiveString = skill.getName() + " " +
                skill.getProfessionBase() + "% or " +
                skill.getExclusive().getName() + " " +
                skill.getExclusive().getProfessionBase() + "%";
        assertThat(skillElement.getText().toLowerCase())
                .isEqualTo(exclusiveString);

        click(driver, profession.getName() + "-" + skill.getName() + "Opt");
        return skill;
    }

    private List<WebElement> getExclusiveSkillElements(WebDriver driver) {
        return getElementsByClass(driver, "skill-radio-div");
    }

    private List<WebElement> getDefaultInputSkillElements(WebDriver driver, String professionName) {
        return findElementsByMultipleClasses(driver, professionName,
                "default-skill-input", "prof-modal");
    }

    private String parseSkillName(String text) {
        return text.substring(0, text.lastIndexOf(" "))
                .replace(" ", "-").toLowerCase();
    }

    private String setInputForSkillChild(TestProfession profession, WebElement webElement, Map<String, List<List<String>>> inputs) {
        Skill skill = profession.getDefaultSkills().get(webElement.getText().toLowerCase());
        assertThat(skill).as(webElement.getText() + " not contained in " + profession.getDefaultSkills()).isNotNull();
        //Set input
        List<WebElement> inputFields = getChildElementsByTag(webElement, "input");
        assertThat(inputFields.size()).isEqualTo(1);

        return setInputForSkill(inputs, skill, inputFields.get(0));
    }

    private String setInputForSkill(Map<String, List<List<String>>> inputs, Skill skill, WebElement inputField) {
        String input = inputs.get(skill.getName()).get(0).remove(0);
        inputs.get(skill.getName()).get(1).add(input);
        inputField.clear();
        inputField.sendKeys(input);
        return input;
    }

    private List<WebElement> getOptionalSkillElements(WebDriver driver, String professionName) {
        return findElementsByMultipleClassesAndTag(driver, "div",
                professionName, "skill-check");
    }

    private List<WebElement> getSkillCheckboxes(WebDriver driver, String professionName) {
        return driver.findElements(By.xpath("//input[@class='" + professionName + " skill-check']"));
    }

    private Map<String, List<List<String>>> getInputMap() {
        return Map.of(
                CRAFT, Arrays.asList(new ArrayList<>(CRAFT_INPUTS), new ArrayList<>()),
                ART, Arrays.asList(new ArrayList<>(ART_INPUTS), new ArrayList<>()),
                FOREIGN_LANGUAGE, Arrays.asList(new ArrayList<>(FOREIGN_LANGUAGE_INPUTS), new ArrayList<>()),
                SCIENCE, Arrays.asList(new ArrayList<>(SCIENCE_INPUTS), new ArrayList<>()),
                MILITARY_SCIENCE, Arrays.asList(new ArrayList<>(MILITARY_SCIENCE_INPUTS), new ArrayList<>()),
                PILOT_SKILL, Arrays.asList(new ArrayList<>(PILOT_INPUTS), new ArrayList<>()));
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void testProfession(String professionName, List<String> chosenOptionalSkills) {
        TestProfession profession = professions.get(professionName);
        WebDriver driver = getDriver();
        try {
            Map<String, List<List<String>>> inputs = getInputMap();

            openProfessionModal(driver);
            selectProfession(driver, ANTHROPOLOGIST_NAME, profession.getName());

            //Make a list of all default skills
            Map<String, Skill> chosenSkills = new HashMap<>(profession.getDefaultSkills());

            //Add an exclusive skill
            if(!profession.getExclusiveSkills().isEmpty()) {
                getExclusiveSkillElements(driver).forEach(webElement -> {
                    Skill skill = addExclusiveSkill(webElement, driver, profession);
                    chosenSkills.put(skill.getName(), skill);
                });
            }

            //Find all the default skill elements and make sure they match the expected number
            List<WebElement> defaultSkillElements = getDefaultSkillElements(driver, profession.getName());

//            assertThat(profession.getDefaultSkills().size()).isEqualTo(defaultSkillElements.size());

            //Check the text on each default skill
            defaultSkillElements.forEach(skillElement -> {
                verifyTextOnSkillElement(skillElement, profession);
            });

            //Set the input on and input skills in the default list
            getDefaultInputSkillElements(driver, profession.getName()).forEach(webElement -> {
                String input = setInputForSkillChild(profession, webElement, inputs);
                String key = webElement.getText().toLowerCase();
                System.out.println(chosenSkills.get(key).getInput());
                if(!chosenSkills.get(key).getInput().isBlank() && chosenSkills.containsKey(key+"_1")) {
                    key += "_1";
                }
                assertThat(chosenSkills).as(key + " not contained in " + chosenSkills.keySet()).containsKey(key);
                chosenSkills.get(key)
                        .setInput(input);
            });

            List<WebElement> chosenCheckBoxes = new ArrayList<>();

            Map<String, Skill> allOptionalSkills = new HashMap<>(profession.getOptionalSkills());

            getOptionalSkillElements(driver, profession.getName()).forEach(webElement -> {

                String webElementText = webElement.getText().toLowerCase();
                String skillName = parseSkillName(webElementText);

                Skill skill = allOptionalSkills.containsKey(skillName) ?
                        allOptionalSkills.get(skillName): allOptionalSkills.get(webElementText);
                assertThat(skill).as(skillName).isNotNull();

                List<WebElement> childInputs = getChildElementsByTag(webElement, "input");
                assertThat(childInputs.size()).isBetween(1,2);
                WebElement checkInput = childInputs.get(0);

                //If skill has already been chosen it should be disabled
                assertThat(chosenSkills.containsKey(skillName)).isEqualTo(!checkInput.isEnabled());

                //If this is the skill we want save the checkbox for later and set the input if needed
                if(chosenOptionalSkills.contains(skillName)) {
                    chosenCheckBoxes.add(checkInput);
                    if (childInputs.size() > 1) {
                        String input = setInputForSkill(inputs, skill, childInputs.get(1));
                        skill.setInput(input);
                    }
                    chosenSkills.put(skillName, skill);
                }
            });

            assertThat(chosenCheckBoxes.size()).isEqualTo(chosenOptionalSkills.size());

            //Now click every check box we saved
            chosenCheckBoxes.forEach(WebElement::click);

            //Every checkbox should either be checked or disabled
            getSkillCheckboxes(driver, profession.getName()).forEach(webElement ->
                    assertThat(webElement).as(webElement.getText()).satisfiesAnyOf(
                            element -> assertThat(element.isSelected()).isTrue(),
                            element -> assertThat(element.isEnabled()).isFalse()
                    ));

            click(driver, profession.getName() + "Confirm");

            //Find every chosen skill that doesn't have an input
            Map<String, String> skillMap = chosenSkills.entrySet().stream()
                    .filter(stringSkillEntry -> stringSkillEntry.getValue().getInput() == null)
                    .collect(Collectors.toMap(Map.Entry::getKey, s -> s.getValue().getProfessionBase() + ""));

            checkAllSkillValues(driver, skillMap);

            //Find all the chosen skills not in that previous list
            List<String> chosenInputSkills = chosenSkills.entrySet().stream().filter(stringSkillEntry ->
                    !skillMap.containsKey(stringSkillEntry.getKey()))
                    .map(stringSkillEntry -> stringSkillEntry.getValue().getSkillDisplayText().replace("_1", ""))
                    .collect(Collectors.toList());

            //Iterate through every container div in the 'other skills' section
            List<WebElement> otherSkillDivs = driver.findElements(By.className("other-skill-container"));
            otherSkillDivs.forEach(div -> {
                String skillName = getChildElementValue(div, "other-skill-name").toLowerCase();

                //If this was in our chosen skill list remove it
                if(chosenInputSkills.remove(skillName)) {
                    //String everything but the numbers from the skill name and verify it matches the value
                    String value = (skillName.replaceAll("\\D", ""));
                    String skillValue = getChildElementValue(div, "other-skill").toLowerCase();
                    assertThat(skillValue).isEqualTo(value);
                }
                //If it wasn't chosen it should be blank
                else {
                    assertThat(skillName).isBlank();
                    assertThat(getChildElementValue(div, "other-skill")).isBlank();
                }
            });
            //Make sure we found all our input skills
            assertThat(chosenInputSkills).isEmpty();

        }
        finally {
            driver.close();
        }
    }

    private String selectWeapon(WebElement selectElement, String value) {
        Select select = new Select(selectElement);
        select.selectByValue(value);
        String id = (selectElement.getAttribute("id"));
        String[] idSplit = id.split("-");
        return idSplit[0] + "-row-" + idSplit[1];
    }

    @org.junit.jupiter.api.Test
    public void testWeapons() {
        WebDriver driver = getDriver();
        try {
            List<WebElement> selects = driver.findElements(By.name("weapon-select"));
            driver.findElement(By.id("dex-score")).sendKeys("10");
            for (WebElement selectElement : selects) {
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "unarmed"))), "Unarmed Attack", "40", "", Arrays.asList("1D4-3", "1D4-2", "1D4-1", "1D4", "1D4+1"), "N/A", "", "", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "brass_knuckles"))), "Brass knuckles, heavy flashlight, or steel-toe boots", "40", "", Arrays.asList("1D4-2", "1D4-1", "1D4", "1D4+1", "1D4+2"), "N/A", "", "", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "garotte"))), "Garotte", "40", "", "special", "N/A", "", "", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "knife"))), "Knife", "30", "", Arrays.asList("1D4-2", "1D4-1", "1D4", "1D4+1", "1D4+2"), "N/A", "", "", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "hatchet"))), "Hatchet", "30", "", Arrays.asList("1D4-2", "1D4-1", "1D4", "1D4+1", "1D4+2"), "N/A", "", "", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "combat_dagger"))), "Large knife or combat dagger", "30", "", Arrays.asList("1D6-2", "1D6-1", "1D6", "1D6+1", "1D6+2"), "3", "", "", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "club"))), "Club, nightstick, baton,  or collapsible baton", "30", "", Arrays.asList("1D6-2", "1D6-1", "1D6", "1D6+1", "1D6+2"), "N/A", "", "", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "sword"))), "Machete, tomahawk, or sword", "30", "", Arrays.asList("1D8-2", "1D8-1", "1D8", "1D8+1", "1D8+2"), "N/A", "", "", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "bat"))), "Baseball bat or rifle butt", "30", "", Arrays.asList("1D8-2", "1D8-1", "1D8", "1D8+1", "1D8+2"), "N/A", "", "", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "spear"))), "Spear or fixed bayonet", "30", "", Arrays.asList("1D8-2", "1D8-1", "1D8", "1D8+1", "1D8+2"), "3", "", "", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "axe"))), "Wood axe", "30", "", Arrays.asList("1D10-2", "1D10-1", "1D10", "1D10+1", "1D10+2"), "N/A", "", "", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "large_sword"))), "Large sword", "30", "", Arrays.asList("1D10-2", "1D10-1", "1D10", "1D10+1", "1D10+2"), "N/A", "", "", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "two_handed_sword"))), "Two-handed sword", "30", "", Arrays.asList("1D12-2", "1D12-1", "1D12", "1D12+1", "1D12+2"), "N/A", "", "", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "pepper_spray_keychain"))), "Tear Gas and Pepper Spray", "50", "1m", "-20% penalty", "", "", "", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "pepper_spray_can"))), "Tear Gas and Pepper Spray", "50", "3m", "-20% penalty", "", "", "", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "tear_gas"))), "Tear gas grenade (Thrown/Launched)", "30/0", "20m/50m", "-40% penalty", "", "", "", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "stun_grenade"))), "Stun Grenade (Thrown/Launched)", "30/0", "20m/50m", "-40% penalty", "", "", "", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "stun_gun"))), "Stun gun", "50", "1m", "-20% penalty", "", "", "", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "shock_baton"))), "Shock baton", "50", "1m", "-20% penalty", "", "", "", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "ced_pistol"))), "CED pistol", "20", "4m", "-20% penalty", "", "", "", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "light_pistol"))), "Light pistol", "20", "10m", "1D8", "N/A", "N/A", "", "7");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "medium_pistol"))), "Medium pistol", "20", "15m", "1D10", "N/A", "N/A", "", "15");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "heavy_pistol"))), "Heavy pistol", "20", "20m", "1D12", "N/A", "N/A", "", "10");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "shotgun"))), "Shotgun (slug/shot/nonlethal)", "20", "75m/50m/10m", "2D6/2D10/1D6 and stunned", "N/A", "N/A", "", "5");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "light_rifle"))), "Light Rifle or Carbine", "20", "100m", "1D12", "3", "10%", "", "10 or 30");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "smg"))), "Submachine gun (SMG)", "20", "50m", "1D10", "N/A", "10%", "", "30");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "heavy_rifle"))), "Heavy Rifle", "20", "150m", "1D12+2", "5", "10%", "", "10 or 20");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "very_heavy_rifle"))), "Very Heavy Rifle", "20", "250m", "N/A", "5", "20%", "", "10");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "hand_grenade"))), "Hand Grenade", "30", "20m", "", "N/A", "15%", "10m", "N/A");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "rpg"))), "Rocket-propelled grenade launcher (RPG)", "0", "10m", "", "20", "30%", "10m", "1");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "flamethrower"))), "Handheld flamethrower", "0", "5m", "", "N/A", "10%", "1m", "20");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "military_flamethrower"))), "Military flamethrower", "0", "10m", "", "N/A", "10%", "2m", "5");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "machine_gun"))), "General-purpose machine gun (GPMP)", "0", "300m", "", "N/A", "15%", "per burst", "100");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "grenade_launcher"))), "Grenade launcher (GL)", "0", "150m", "", "N/A", "15%", "10m", "1");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "grenade_machine_gun"))), "Grenade machine gun (GMG)", "0", "300m", "", "N/A", "15%", "10m", "30");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "heavy_machine_gun"))), "Heavy machine gun (HMG)", "0", "400m", "", "5", "20%", "per burst", "100");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "light_machine_gun"))), "Light machine gun (LMG)", "0", "200m", "", "3", "10%", "per burst", "100 or 200");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "autocannon"))), "Autocannon", "0", "400m", "", "5", "30%", "3m", "100");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "minigun"))), "Minigun", "0", "300m", "", "5", "20%", "3m (long spray only)", "4000");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "anfo_explosive"))), "ANFO explosive", "0", "", "", "N/A", "30%", "20m", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "c4"))), "C4 plastic explosive block", "0", "", "", "N/A", "30%", "2m", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "ied"))), "Improvised explosive device (IED)", "0", "", "", "N/A", "15%", "10m", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "large_ied"))), "Large IED", "0", "", "", "N/A", "60%", "75m", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "mine"))), "Explosively-formed penetrator mine", "0", "", "", "20", "25%", "10m", "");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "bomb"))), "General-purpose bomb", "0", "Air-dropped", "", "10", "70%", "100m", "N/A");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "heavy_mortar"))), "Heavy mortar", "0", "4km", "", "5", "35%", "50m", "1");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "light_mortar"))), "Light mortar", "0", "2km", "", "10", "20%", "25m", "1");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "anti_tank_missle"))), "Anti-tank guided missile (ATGM)", "0", "4km", "", "25", "35%", "50m", "N/A");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "artillery"))), "Artillery", "0", "5km", "", "10", "50%", "100m", "1");
                testWeapon(driver, driver.findElement(By.id(selectWeapon(selectElement, "cruise_missile"))), "Cruise Missile", "0", "100km", "", "15", "80%", "150m", "N/A");
            }
        } finally {
            driver.close();
        }
    }

    @org.junit.jupiter.api.Test
    public void testRandom() {
        WebDriver driver = getDriver();
        try {
            Map<String, Integer> professionsSelect = new HashMap<>(ImmutableMap.<String, Integer>builder()
                    .put(WordUtils.capitalizeFully(ANTHROPOLOGIST_NAME.replaceAll("-", " ")), 0)
                    .put(WordUtils.capitalizeFully(ENGINEER_NAME.replaceAll("-", " ")), 0)
                    .put(WordUtils.capitalizeFully(FEDERAL_AGENT_NAME.replaceAll("-", " ")), 0)
                    .put(WordUtils.capitalizeFully(SPECIAL_OPERATOR_NAME.replaceAll("-", " ")), 0)
                    .put(WordUtils.capitalizeFully(PHYSICIAN_NAME.replaceAll("-", " ")), 0)
                    .put(WordUtils.capitalizeFully(SCIENTIST_NAME.replaceAll("-", " ")), 0)
                    .put(WordUtils.capitalizeFully(CRIMINAL_NAME.replaceAll("-", " ")), 0)
                    .put(WordUtils.capitalizeFully(FIREFIGHTER_NAME.replaceAll("-", " ")), 0)
                    .put(WordUtils.capitalizeFully(FOREIGN_SERVICE_OFFICER_NAME.replaceAll("-", " ")), 0)
                    .put(WordUtils.capitalizeFully(INTELLIGENCE_ANALYST_NAME.replaceAll("-", " ")), 0)
                    .put(WordUtils.capitalizeFully(INTELLIGENCE_OFFICER_NAME.replaceAll("-", " ")), 0)
                    .put(WordUtils.capitalizeFully(LAWYER_NAME.replaceAll("-", " ")), 0)
                    .put(WordUtils.capitalizeFully(MEDIA_SPECIALIST_NAME.replaceAll("-", " ")), 0)
                    .put(WordUtils.capitalizeFully(NURSE_NAME.replaceAll("-", " ")), 0)
                    .put(WordUtils.capitalizeFully(PILOT_NAME.replaceAll("-", " ")), 0)
                    .put(WordUtils.capitalizeFully(POLICE_OFFICER_NAME.replaceAll("-", " ")), 0)
                    .put(WordUtils.capitalizeFully(PROGRAM_MANAGER_NAME.replaceAll("-", " ")), 0)
                    .put(WordUtils.capitalizeFully(SOLDIER_NAME.replaceAll("-", " ")), 0)
                    .build());
            for (int i = 0; i < 200; i++) {
                click(driver, "btnRandom");
                String profession = driver.findElement(By.id("profession")).getAttribute("value");
                System.out.println(profession);
                System.out.println(professionsSelect.get(profession));
                professionsSelect.put(profession, professionsSelect.get(profession) + 1);
                List<String> skills = new ArrayList<>();
                List<WebElement> skillElements = driver.findElements(By.className("skill"));
                for (WebElement skill : skillElements) {
                    if (!skill.getAttribute("base").equals(skill.getAttribute("prof-base"))) {
                        skills.add(skill.getAttribute("id"));
                    }
                }
                for (int j = 0; j < driver.findElements(By.className("other-skill-name")).size(); j++) {
                    if (!driver.findElements(By.className("other-skill-name")).get(j).getAttribute("value").equals("")) {
                        skills.add(driver.findElements(By.className("other-skill-name")).get(j).getAttribute("value"));
                    }
                }
                assertThat(skills).doesNotHaveDuplicates();
                switch (profession) {
                    case "Anthropologist":
                        List<String> defaultSkills = Arrays.asList(BUREAUCRACY, HISTORY, OCCULT, PERSUADE);
                        List<String> optionalSkills = Arrays.asList(ANTHROPOLOGY, ARCHEOLOGY, HUMINT, NAVIGATE, RIDE, SEARCH, SURVIVAL);
                        String foreignLanguage = WordUtils.capitalizeFully(FOREIGN_LANGUAGE.replaceAll("-", " ")) + " \\(\\w*\\)";
                        List<String> inputSkills = Arrays.asList(foreignLanguage, foreignLanguage);
                        int expectedSize = 9;
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
                                "Craft 30%:\n(Electrician)", "Craft 30%:\n(Mechanic)", "Craft 40%:\n(Microelectronics)",
                                "Science 40%:\n(Mathematics)");
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
                                MELEE_WEAPONS, NAVIGATE, STEALTH, SURVIVAL, SWIM, UNARMED_COMBAT, "Military Science 60%:\n(Land)");
                        expectedSize = 12;
                        noSkills = new ArrayList<>(ALL_SKILLS);
                        noSkills.removeAll(defaultSkills);
                        assertThat(skills).containsOnlyOnceElementsOf(defaultSkills);
                        assertThat(skills).doesNotContainAnyElementsOf(noSkills);
                        assertThat(skills.size()).isEqualTo(expectedSize);
                        break;
                    case "Physician":
                        defaultSkills = Arrays.asList(BUREAUCRACY, FIRST_AID, MEDICINE, PERSUADE, PHARMACY,
                                SEARCH, "Science 60%:\n(Biology)");
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
                                FORENSICS, HEAVY_MACHINERY, NAVIGATE, SEARCH, "Craft 40%:\n(Electrician)", "Craft 40%:\n(Mechanic)");
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
                        defaultSkills = Arrays.asList(ALERTNESS, ATHLETICS, CRIMINOLOGY, DODGE, DRIVE,
                                FIREARMS, LAW, MELEE_WEAPONS, PERSUADE, STEALTH, UNARMED_COMBAT);
                        optionalSkills = Arrays.asList(DEMOLITIONS, DISGUISE, FORENSICS, HUMINT, NAVIGATE, OCCULT, PHARMACY);
                        expectedSize = 13;
                        noSkills = new ArrayList<>(ALL_SKILLS);
                        noSkills.removeAll(defaultSkills);
                        noSkills.removeAll(optionalSkills);
                        assertThat(skills).containsOnlyOnceElementsOf(defaultSkills);
                        assertThat(skills).doesNotContainAnyElementsOf(noSkills);
                        assertThat(skills.size()).as(skills.toString()).isEqualTo(expectedSize);
                        break;
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
                                "Military Science 40%:\n(Land)", NAVIGATE, PERSUADE, UNARMED_COMBAT
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
                        defaultSkills = Arrays.asList(ALERTNESS, BUREAUCRACY, "Craft 40%:\n(Electrician)",
                                "Craft 40%:\n(Mechanic)", NAVIGATE, "Science 40%:\n(Meteorology)", SWIM
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
                                PHARMACY, "Science 40%:\n(Biology)"
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
            }
        }
        finally {
            driver.close();
        }
    }
}