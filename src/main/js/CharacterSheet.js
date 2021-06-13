// inputSkills = ["art", "craft", "military-science", "pilot", "science", "foreign-language"];
const inputSkills = new Map([
    ["art", ["Acting", "Creative Writing", "Dance", "Flute", "Forgery", "Guitar", "Painting", "Poetry", "Scriptwriting", "Sculpture", "Singing", "Violin"]],
    ["craft", ["Architect", "Carpenter", "Electrician", "Gunsmith", "Locksmith", "Mechanic", "Microelectronics", "Plumber"]],
    ["military-science", ["Land", "Air", "Sea"]],
    ["pilot", ["Airplane", "Drone", "Helicopter", "Small Boat", "Ship"]],
    ["science", ["Astronomy", "Biology", "Botany", "Chemistry", "Engineering", "Genetics", "Geology", "Mathematics",
    "Meteorology", "Physics", "Planetology", "Zoology"]],
    ["foreign-language", ["Spanish", "German", "Japanese", "Hindi", "Arabic", "Cantonese", "Mandarin", "Bengali",
    "Portuguese","Vietnamese", "Urdu", "Korean", "Turkish", "Russian", "French", "Italian"]]

    ]);
let male_names = [];
let female_names = [];
let last_names = [];
let universities = ["Harvard", "Standford", "MIT", "Brown", "Columbia", "Cornell", "Dartmouth", "University of Pennsylvania", "Princeton", "Yale", "Texas A&M"];
let history_museums = ["The Smithsonian", "The American Museum of Natural History", "The British Museum"];
let tech_companies = ["Facebook", "Google", "Apple", "IBM", "Amazon"];
let federal_agencies = ["FBI", "DEA", "ATF", "Secret Service", "US Marshals"];
let hospitals = ["Mayo Clinic", "Cleavland Clinic", "Johns Hopkins", "Massachusetts General", "Cedar Sinai"];
let science = ["National Institute of Health", "CDC", "FDA", "Los Alamos", "DARPA"];
let special_operator = ["Hostage Rescue Team", "Army Rangers", "USMC Raiders", "CIA Special Operations Group", "Navy Seals", "Delta Force"];
let criminal_orgs = ["Self Employed", "Italian Mafia", "Russian Mafia", "Small crew"];
let cities = ["New York City", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose"];
let foriegn_service = ["US State Department"];
let intelligence_analysts = ["FBI", "NSA", "CIA", "Mossad", "MI6"];
let intelligence_agencies = ["CIA", "Mossad", "MI6", "Chinese Ministry of State Security"];
let law_firms = ["Baker-Mckenzie", "Kirkland & Ellis", "Latham & Watkins", "DLA Piper", "Baker & McKenzie", "Dentons", "US Department of Justice"];
let tv_news = ["Fox", "NBC", "CNN"];
let newspapers = ["New York Times", "Washington Post", "Wall Street Journal", "Boston Globe"];
let newspaper_suffixes = ["Times", "Post", "Times Picayune", "Daily News", "Tribune", "Gazette", "News"];
let blogs = ["The Huffington Post", "Buzzfeed", "The Daily Beast", "Vice"];
let pilot = ["American Airlines", "US Airforce", "US Navy", "British Airways", "Fedex", "NetJets", "Delta Airlines"];
let top_companies = ["Walmart", "Amazon", "Apple", "CVS Health", "UnitedHealth Group", "Berkshire Hathaway",
    "McKesson", "AmerisourceBergen", "Alphabet", "0Exxon Mobil", "AT&T", "Costco Wholesale", "Cigna",
    "Cardinal Health", "Microsoft", "Walgreens Boots Alliance", "Kroger", "Home Depot", "JPMorgan Chase",
    "Verizon Communications"];
let armed_forces = ["US Marines", "US Army", "US Airforce", "US Navy"];

let profession_details = new Map([
    ["anthropologist", {'employer': [universities, history_museums], 'education': ["Masters in Anthropology", "PHD in Anthropology"], 'stats': ["INT"], 'bonds': 4, 'optional_skills': 2}],
    ["engineer", {'employer': [tech_companies, federal_agencies], 'education': ["Bachelors in Computer Science",
            "Masters in Computer Science", "PHD in Computer Science"], 'stats': ["INT"], 'bonds': 3, 'optional_skills': 4}],
    ["federal-agent", {'employer': [federal_agencies], 'education': ["Bachelors in Criminal Justice"], 'stats': ["CON","POW","CHA"], 'bonds': 3, 'optional_skills': 1}],
    ["special-operator", {'employer': [special_operator], 'education': ["High School Diploma"], 'stats': ["STR","CON","POW"], 'bonds':2, 'optional_skills': 0}],
    ["physician", {'employer': [hospitals], 'education': ["MD"], 'stats': ["INT","POW","DEX"], 'bonds':3, 'optional_skills': 2}],
    ["scientist", {'employer': [science], 'education': ["PHD in Chemistry", "PHD in Biology", "PHD in Physics"], 'stats': ["INT"], 'bonds':4, 'optional_skills': 3}],
    ["firefighter", {'employer': [cities], 'education': ["High School Diploma"], 'stats': ["STR","DEX","CON"], 'bonds':3, 'optional_skills': 0}],
    ["foreign-service-officer", {'employer': [foriegn_service], 'education': ["PHD in Foreign Affairs", "PHD in International Relations"],
        'stats': ["INT","CHA"], 'bonds':3, 'optional_skills': 0}],
    ["criminal", {'employer': [criminal_orgs], 'education': ["High School Diploma"], 'stats': ["STR","DEX"], 'bonds':4, 'optional_skills': 2}],
    ["intelligence-analyst", {'employer': [intelligence_analysts], 'education': ["Masters in Political Science", "Masters in International Relations"],
        'stats': ["INT"], 'bonds': 3, 'optional_skills': 0}],
    ["intelligence-case-officer", {'employer': [intelligence_agencies], 'education': ["Bachelors in Political Science"], stats: ["INT","POW","CHA"], 'bonds': 2, 'optional_skills': 0}],
    ["lawyer", {'employer': [law_firms, cities], 'education': ["JD"], 'stats': ["INT","POW","CHA"], 'bonds':2, 'optional_skills': 4}],
    ["media-specialist", {'employer': [tv_news, newspapers, blogs, cities], 'education': ["Bachelors in Media Studies"], 'stats': ["INT","CHA"], 'bonds': 4, 'optional_skills': 5}],
    ["nurse", {'employer': [hospitals], 'education': ["Bachelors in Nursing", "Masters in Nursing"], 'stats': ["INT","POW","CHA"], 'bonds': 4, 'optional_skills': 2}],
    ["pilot", {'employer': [pilot], 'education': ["High School Diploma", "Bachelors in Mechanical Engineering"], 'stats': ["DEX","INT"], 'bonds': 3, 'optional_skills': 2}],
    ["police-officer", {'employer': [cities], 'education': ["High School Diploma", "Associates in Criminal Justice"], 'stats': ["STR","CON","POW"], 'bonds': 3, 'optional_skills': 1}],
    ["program-manager", {'employer': [top_companies], 'education': ["Masters in Business Administration"], 'stats': ["INT","CHA"], 'bonds': 4, 'optional_skills': 1}],
    ["soldier", {'employer': [armed_forces], 'education': ["High School Diploma"], 'stats': ["STR", "CON"], 'bonds': 4, 'optional_skills': 3}],
]);

maxChecked = new Map();
String.prototype.toTitleCase = function () {
    return this.replace(/\w\S*/g, function (txt) {
        return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();
    });
};

Array.prototype.random = function () {
    return this[Math.floor((Math.random()*this.length))];
};

weapons = new Map([
    ['Hand-to-Hand Weapons', new Map([
            ['unarmed', {weapon_name: 'Unarmed Attack', skill: 'unarmed', damage: '1D4-1', armor_piercing: 'N/A', expense: "None"}],
            ['brass_knuckles', {weapon_name: 'Brass knuckles, heavy flashlight, or steel-toe boots', skill: 'unarmed', damage: '1D4', armor_piercing: 'N/A', expense: "Incidental"}],
            ['garotte', {weapon_name: 'Garotte', skill: 'unarmed', damage: 'special', armor_piercing: 'N/A', expense: "Incidental"}],
            ['knife', {weapon_name: 'Knife', skill: 'melee-weapons', damage: '1D4', armor_piercing: 'N/A', expense: "Incidental"}],
            ['hatchet', {weapon_name: 'Hatchet', skill: 'melee-weapons', damage: '1D4', armor_piercing: 'N/A', expense: "Incidental"}],
            ['combat_dagger', {weapon_name: 'Large knife or combat dagger', skill: 'melee-weapons', damage: '1D6', armor_piercing: '3', expense: "Incidental"}],
            ['club', {weapon_name: 'Club, nightstick, baton,  or collapsible baton', skill: 'melee-weapons', damage: '1D6', armor_piercing: 'N/A', expense: "Incidental"}],
            ['sword', {weapon_name: 'Machete, tomahawk, or sword', skill: 'melee-weapons', damage: '1D8', armor_piercing: 'N/A', expense: "Incidental"}],
            ['bat', {weapon_name: 'Baseball bat or rifle butt', skill: 'melee-weapons', damage: '1D8', armor_piercing: 'N/A', expense: "Incidental"}],
            ['spear', {weapon_name: 'Spear or fixed bayonet', skill: 'melee-weapons', damage: '1D8', armor_piercing: '3', expense: "Incidental"}],
            ['axe', {weapon_name: 'Wood axe', skill: 'melee-weapons', damage: '1D10', armor_piercing: 'N/A', expense: "Incidental"}],
            ['large_sword', {weapon_name: 'Large sword', skill: 'melee-weapons', damage: '1D10', armor_piercing: 'N/A', expense: "Standard"}],
            ['two_handed_sword', {weapon_name: 'Two-handed sword', skill: 'melee-weapons', damage: '1D12', armor_piercing: 'N/A', expense: "Standard"}]])
        ],
        ['Non Lethal Weapons',new Map([
            ['pepper_spray_keychain', {weapon_name: 'Tear Gas and Pepper Spray', skill: 'dex', range: '1m', uses: '1', radius: '1 target', damage: '-20% penalty', expense: "Incidental"}],
            ['pepper_spray_can', {weapon_name: 'Tear Gas and Pepper Spray', skill: 'dex', range: '3m', uses: '12', radius: '2 targets', damage: '-20% penalty', expense: "Incidental"}],
            ['tear_gas', {weapon_name: 'Tear gas grenade (Thrown/Launched)', skill: 'athletics/heavy-weapons', range: '20m/50m', uses: '1', radius: '10 m', damage: '-40% penalty', expense: "Incidental"}],
            ['stun_grenade', {weapon_name: 'Stun Grenade (Thrown/Launched)', skill: 'athletics/heavy-weapons', range: '20m/50m', uses: '1', radius: '10 m', damage: '-40% penalty', expense: "Incidental"}],
            ['stun_gun', {weapon_name: 'Stun gun', skill: 'dex', range: '1m', uses: '10', damage: '-20% penalty', expense: "Incidental"}],
            ['shock_baton', {weapon_name: 'Shock baton', skill: 'dex', range: '1m', uses: '200', damage: '-20% penalty', expense: "Incidental"}],
            ['ced_pistol', {weapon_name: 'CED pistol', skill: 'firearms', range: '4m', uses: '4', damage: '-20% penalty', expense: "Standard"}]])
        ],
        ['Firearms',new Map([
            ['light_pistol', {weapon_name: 'Light pistol', skill: 'firearms', range: '10m', damage: '1D8', lethality: 'N/A', ammo_capacity: '7', armor_piercing: 'N/A', expense: "Standard"}],
            ['medium_pistol', {weapon_name: 'Medium pistol', skill: 'firearms', range: '15m', damage: '1D10', lethality: 'N/A', ammo_capacity: '15', armor_piercing: 'N/A', expense: "Standard"}],
            ['heavy_pistol', {weapon_name: 'Heavy pistol', skill: 'firearms', range: '20m', damage: '1D12', lethality: 'N/A', ammo_capacity: '10', armor_piercing: 'N/A', expense: "Standard"}],
            ['shotgun', {weapon_name: 'Shotgun (slug/shot/nonlethal)', skill: 'firearms', range: '75m/50m/10m', damage: '2D6/2D10/1D6 and stunned', lethality: 'N/A', ammo_capacity: '5', armor_piercing: 'N/A', expense: "Standard"}],
            ['light_rifle', {weapon_name: 'Light Rifle or Carbine', skill: 'firearms', range: '100m', damage: '1D12', lethality: '10%', ammo_capacity: '10 or 30', armor_piercing: '3', expense: "Standard"}],
            ['smg', {weapon_name: 'Submachine gun (SMG)', skill: 'firearms', range: '50m', damage: '1D10', lethality: '10%', ammo_capacity: '30', armor_piercing: 'N/A', expense: "Unusual"}],
            ['heavy_rifle', {weapon_name: 'Heavy Rifle', skill: 'firearms', range: '150m', damage: '1D12+2', lethality: '10%', ammo_capacity: '10 or 20', armor_piercing: '5', expense: "Unusual"}],
            ['very_heavy_rifle', {weapon_name: 'Very Heavy Rifle', skill: 'firearms', range: '250m', damage: 'N/A', lethality: '20%', ammo_capacity: '10', armor_piercing: '5', expense: "Major"}]])
        ],
        ['Heavy Weapons',new Map([
            ['hand_grenade', {weapon_name: 'Hand Grenade', skill: 'athletics', range: '20m', lethality: '15%', kill_radius: '10m', ammo_capacity: 'N/A', armor_piercing: 'N/A', expense: "Incidental"}],
            ['rpg', {weapon_name: 'Rocket-propelled grenade launcher (RPG)', skill: 'heavy-weapons', range: '10m', lethality: '30%', kill_radius: '10m', ammo_capacity: '1', armor_piercing: '20', expense: "Standard"}],
            ['flamethrower', {weapon_name: 'Handheld flamethrower', skill: 'heavy-weapons', range: '5m', lethality: '10%', kill_radius: '1m', ammo_capacity: '20', armor_piercing: 'N/A', expense: "Unusual"}],
            ['military_flamethrower', {weapon_name: 'Military flamethrower', skill: 'heavy-weapons', range: '10m', lethality: '10%', kill_radius: '2m', ammo_capacity: '5', armor_piercing: 'N/A', expense: "Unusual"}],
            ['machine_gun', {weapon_name: 'General-purpose machine gun (GPMP)', skill: 'heavy-weapons', range: '300m', lethality: '15%', kill_radius: 'per burst', ammo_capacity: '100', armor_piercing: 'N/A', expense: "Major"}],
            ['grenade_launcher', {weapon_name: 'Grenade launcher (GL)', skill: 'heavy-weapons', range: '150m', lethality: '15%', kill_radius: '10m', ammo_capacity: '1', armor_piercing: 'N/A', expense: "Major"}],
            ['grenade_machine_gun', {weapon_name: 'Grenade machine gun (GMG)', skill: 'heavy-weapons', range: '300m', lethality: '15%', kill_radius: '10m', ammo_capacity: '30', armor_piercing: 'N/A', expense: "Major"}],
            ['heavy_machine_gun', {weapon_name: 'Heavy machine gun (HMG)', skill: 'heavy-weapons', range: '400m', lethality: '20%', kill_radius: 'per burst', ammo_capacity: '100', armor_piercing: '5', expense: "Major"}],
            ['light_machine_gun', {weapon_name: 'Light machine gun (LMG)', skill: 'heavy-weapons', range: '200m', lethality: '10%', kill_radius: 'per burst', ammo_capacity: '100 or 200', armor_piercing: '3', expense: "Major"}],
            ['autocannon', {weapon_name: 'Autocannon', skill: 'heavy-weapons', range: '400m', lethality: '30%', kill_radius: '3m', ammo_capacity: '100', armor_piercing: '5', expense: "Extreme"}],
            ['minigun', {weapon_name: 'Minigun', skill: 'heavy-weapons', range: '300m', lethality: '20%', kill_radius: '3m (long spray only)', ammo_capacity: '4000', armor_piercing: '5', expense: "Extreme"}]])
        ],
        ['Demolitions',new Map([
            ['anfo_explosive', {weapon_name: 'ANFO explosive', skill: 'demolitions', lethality: '30%', kill_radius: '20m', armor_piercing: 'N/A', expense: "Incidental"}],
            ['c4', {weapon_name: 'C4 plastic explosive block', skill: 'demolitions', lethality: '30%', kill_radius: '2m', armor_piercing: 'N/A', expense: "Incidental"}],
            ['ied', {weapon_name: 'Improvised explosive device (IED)', skill: 'demolitions', lethality: '15%', kill_radius: '10m', armor_piercing: 'N/A', expense: "Incidental"}],
            ['large_ied', {weapon_name: 'Large IED', skill: 'demolitions', lethality: '60%', kill_radius: '75m', armor_piercing: 'N/A', expense: "Standard"}],
            ['mine', {weapon_name: 'Explosively-formed penetrator mine', skill: 'demolitions', lethality: '25%', kill_radius: '10m', armor_piercing: '20', expense: "Standard"}]])
        ],
        ['Artillery', new Map([
            ['bomb', {weapon_name: 'General-purpose bomb', skill: 'artillery', range: 'Air-dropped', lethality: '70%', kill_radius: '100m', ammo_capacity: 'N/A', armor_piercing: '10', expense: "Unusual"}],
            ['heavy_mortar', {weapon_name: 'Heavy mortar', skill: 'artillery', range: '4km', lethality: '35%', kill_radius: '50m', ammo_capacity: '1', armor_piercing: '5', expense: "Major"}],
            ['light_mortar', {weapon_name: 'Light mortar', skill: 'artillery', range: '2km', lethality: '20%', kill_radius: '25m', ammo_capacity: '1', armor_piercing: '10', expense: "Major"}],
            ['anti_tank_missle', {weapon_name: 'Anti-tank guided missile (ATGM)', range: '4km', skill: 'artillery', lethality: '35%', kill_radius: '50m', ammo_capacity: 'N/A', armor_piercing: '25', expense: "Unusual"}],
            ['artillery', {weapon_name: 'Artillery', skill: 'artillery', range: '5km', lethality: '50%', kill_radius: '100m', ammo_capacity: '1', armor_piercing: '10', expense: "Extreme"}],
            ['cruise_missile', {weapon_name: 'Cruise Missile', skill: 'artillery', range: '100km', lethality: '80%', kill_radius: '150m', ammo_capacity: 'N/A', armor_piercing: '15', expense: "Extreme"}]])
    ]]);
let nationalities = ["American", "Chinese", "Irish", "Indian", "British", "Japenese", "Russian", "Turkish", "German", "Brazian",
    "Canadian",  "Arab", "Korean", "Indonesian", "Spanish", "Thai", "Australian", "French", "Mexican", "Malaysian",
    "Vietnamese", "Philippino", "Austrian", "Dutch", "Hungarian", "Columbian", "Persian", "Swiss", "South African", "Iranian",
    "Chilean", "Argentinean", "Peruvian", "Portuguese", "Greek", "Finish", "Belgian", "Egyptian", "Ethiopian", "Panamanian",
    "Norwegian", "Swedish", "Polish", "Moroccan"];

let bonds = [["Mother", "F"], ["Father", "M"], ["Coworker", "FM"], ["Friend", "FM"], ["Sister", "F"], ["Brother", "M"], ["Mentor", "FM"], ["Boyfriend", "M"], ["Girlfriend", "F"], ["Husband", "M"], ["Wife", "F"], ["Uncle", "M"], ["Aunt", "F"]];

function createWeaponSelect(){
    document.getElementsByName("weapon-select").forEach(select => {
        for (let key of weapons.keys()) {
            let optgroup = document.createElement("optgroup");
            optgroup.label = key;
            weapons.get(key).forEach((value, innerKey) => {
                let option = document.createElement("option");
                option.value = innerKey;
                option.innerText = value.weapon_name;
                optgroup.appendChild(option);
            });
            select.appendChild(optgroup)
        }
        let option = document.createElement("option");
        option.value = "other";
        option.innerText = "Other";
        select.appendChild(option);
        select.value = "other";
        select.addEventListener("change", function (event) {
            weaponSelectListener(event.target);
        });
    })
}

function weaponSelectListener(option) {
    let row = document.getElementById("weapon-row-" + option.id.split("-")[1]);
    row.getElementsByClassName("weapon-name")[0].value = "";
    row.getElementsByClassName("weapon-skill")[0].value = "";
    row.getElementsByClassName("weapon-range")[0].value = "";
    row.getElementsByClassName("weapon-damage")[0].value = "";
    row.getElementsByClassName("weapon-piercing")[0].value = "";
    row.getElementsByClassName("weapon-lethality")[0].value = "";
    row.getElementsByClassName("weapon-kill-radius")[0].value = "";
    row.getElementsByClassName("weapon-ammo")[0].value = "";
    weapons.forEach((value, key) => {
        if(value.has(option.value)) {
            let weapon = value.get(option.value);
            row.getElementsByClassName("weapon-name")[0].value = weapon.weapon_name !== undefined ? weapon.weapon_name: "";
            if(weapon.skill.includes("/")) {
                let skills = weapon.skill.split("/");
                let skill = document.getElementById(skills[0]).value;
                for(let i = 1; i < skills.length; i ++) {
                    skill += "/" + document.getElementById(skills[i]).value;
                }
                row.getElementsByClassName("weapon-skill")[0].value = skill;
            } else {
                let skill = document.getElementById(weapon.skill);
                let skillValue = skill === null ? document.getElementById(weapon.skill + "-x5").innerText : skill.value;
                row.getElementsByClassName("weapon-skill")[0].value = skillValue
            }
            row.getElementsByClassName("weapon-range")[0].value = weapon.range !== undefined ? weapon.range: "";
            row.getElementsByClassName("weapon-damage")[0].value = weapon.damage !== undefined ? weapon.damage: "";
            row.getElementsByClassName("weapon-piercing")[0].value = weapon.armor_piercing !== undefined ? weapon.armor_piercing: "";
            row.getElementsByClassName("weapon-lethality")[0].value = weapon.lethality !== undefined ? weapon.lethality: "";
            row.getElementsByClassName("weapon-kill-radius")[0].value =  weapon.kill_radius !== undefined ? weapon.kill_radius: "";
            row.getElementsByClassName("weapon-ammo")[0].value = weapon.ammo_capacity !== undefined ? weapon.ammo_capacity: "";
        }
    })
}

function createPrintButton() {
    let btn = $('#btnPrint');
    btn.text('download');
    btn.on('click', () => {
        setClassVisibility('dont-print', 'none');
        setClassVisibility('print', '');
        html2canvas(document.body).then(function (canvas) {
            const imgData = canvas.toDataURL("image/jpeg", 1);
            const pdf = new jsPDF("p", "mm", "a4");
            const pageWidth = pdf.internal.pageSize.width;
            const pageHeight = pdf.internal.pageSize.height;
            const imageWidth = canvas.width;
            const imageHeight = canvas.height;
            const ratio = imageWidth / imageHeight >= pageWidth / pageHeight ? pageWidth / imageWidth : pageHeight / imageHeight;

            pdf.addImage(imgData, 'JPEG', 0, 0, imageWidth * ratio, imageHeight * ratio);
            pdf.save("character-sheet.pdf");
        });
        setClassVisibility('dont-print', '');
        setClassVisibility('print', 'none');
    });

}

function setClassVisibility(className, visibility) {
    let elements = document.getElementsByClassName(className);
    for (i = 0; i < elements.length; i++) {
        elements[i].style.display = visibility
    }
}

function setScoreListeners() {
    setScoreListener("str");
    setScoreListener("dex");
    setScoreListener("con");
    setScoreListener("pow");
    setScoreListener("int");
    setScoreListener("cha");

}

function setScoreListener(score) {
    const input = document.querySelector("#" + score + "-score");
    const fivex = document.querySelector("#" + score + "-x5");
    input.addEventListener("change", function (event) {
        updateScore(event.target.id.split("-")[0], input.value)
    });
}

function updateScore(scoreName, score) {
    const fivex = document.querySelector("#" + scoreName + "-x5");
    fivex.innerText = parseInt(score) * 5
}

function setPowListener() {
    const pow = document.querySelector("#pow-score");
    const wp = document.querySelector("#wp-max");
    const san = document.querySelector("#san-curr");
    const bp = document.querySelector("#bp-max");
    pow.addEventListener("change", updatePow);
}

function updatePow() {
    const pow = document.querySelector("#pow-score");
    const wp = document.querySelector("#wp-max");
    const san = document.querySelector("#san-curr");
    const bp = document.querySelector("#bp-max");
    wp.innerText = pow.value;
    san.value = (pow.value * 5);
    bp.innerText = san.value - pow.value
}

function hPListener() {
    const str = document.querySelector("#str-score");
    const con = document.querySelector("#con-score");
    const hp = document.querySelector("#hp-max");

    hp.innerText = Math.ceil((parseInt(str.value) + parseInt(con.value)) / 2)
}

function setHPListener() {
    const str = document.querySelector("#str-score");
    const con = document.querySelector("#con-score");
    str.addEventListener("change", hPListener);
    con.addEventListener("change", hPListener);
}

function setSkillListeners() {
    let skills = document.getElementsByClassName("skill");
    for (i = 0; i < skills.length; i++) {
        skills[i].addEventListener("change", function () {
            updateSkillIncreaseButtons();
        })
    }
}

function setPlusListeners() {
    let pluses = document.getElementsByClassName("plus");
    for (i = 0; i < pluses.length; i++) {
        pluses[i].addEventListener("click", function (event) {
            addToSkill(event.target, 20);
            updateSkillIncreaseButtons();
        })
    }
}

function setMinusListeners() {
    let minuses = document.getElementsByClassName("minus");
    for (i = 0; i < minuses.length; i++) {
        minuses[i].addEventListener("click", function (event) {
            addToSkill(event.target, -20);
            updateSkillIncreaseButtons();
        })
    }
}

function resetSkills() {
    const skills = document.getElementsByClassName("skill");
    for (i = 0; i < skills.length; i++) {
        skills[i].value = skills[i].getAttribute("base");
        skills[i].setAttribute("prof-base", skills[i].getAttribute("base"))
    }
    resetOtherSkills()
}

function setSkill(key, value) {
    if (value.includes(" ")) {
        addOtherSkill(value.replaceAll(": ", "\n"), key)
    } else {
        const skill = document.querySelector("#" + value.toLowerCase());
        if (skill != null) {
            skill.value = key;
            skill.setAttribute("prof-base", key)
        }
    }
}

function addOtherSkill(skillName, skillValue) {
    const skillNames = document.getElementsByClassName("other-skill-name");
    const skills = document.getElementsByClassName("other-skill");
    for (i = 0; i < skillNames.length; i++) {
        if (skillNames[i].value == "") {
            skillNames[i].value = skillName.toTitleCase();
            skills[i].value = skillValue;
            skills[i].setAttribute("prof-base", skillValue);
            break;
        }
    }
}

function resetOtherSkills() {
    const skillNames = document.getElementsByClassName("other-skill-name");
    const skills = document.getElementsByClassName("other-skill");
    for (i = 0; i < skillNames.length; i++) {
        skillNames[i].value = ""
    }
    for (i = 0; i < skills.length; i++) {
        skills[i].value = ""
    }
}

function setModalListener() {
    // Get the modal
    const modal = document.getElementById("myModal");

    // Get the <span> element that closes the modal
    const span = document.getElementById("close");
    // When the user clicks on <span> (x), close the modal
    span.onclick = function () {
        modal.style.display = "none";
    };

    const confirmButtons = document.getElementsByClassName("skillModalConfirm");
    for (i = 0; i < confirmButtons.length; i++) {
        confirmButtons[i].onclick = function (event) {
            document.getElementById("professions").value = event.target.getAttribute("name");
            document.getElementById("profession").value = event.target.getAttribute("name").replaceAll("-", " ").toTitleCase();
            modal.style.display = "none";
            let skillMap = getAllModalSkills(event.srcElement.getAttribute("name"));
            skillMap.forEach(setSkill);
            updateSkillIncreaseButtons();
        }
    }
    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    };
    const professionSelect = document.getElementsByClassName("profession-select");
    for (i = 0; i < professionSelect.length; i++) {
        professionSelect[i].addEventListener("change", function (selChange) {
            setClassVisibility("skill-wrapper", "none");
            const wrapper = document.getElementById(selChange.srcElement.value + "-wrapper");
            wrapper.style.display = "block";

            const modalProfSelect = document.querySelector("#" + selChange.srcElement.value + "-professions").value = selChange.srcElement.value;

            const skillChecks = document.getElementsByClassName("skill-check");
            for (i = 0; i < skillChecks.length; i++) {
                skillChecks[i].checked = false;
            }
            disableOrEnableUnchecked(false);
            const profSelect = document.querySelector("#professions");
            profSelect.value = selChange.srcElement.value
        });
    }

    const radioButtons = document.getElementsByClassName("skill-radio");
    for (i = 0; i < radioButtons.length; i++) {
        radioButtons[i].addEventListener('click', function (event) {
            let skill = event.target.getAttribute("name")
                .replace(/\s\d{1,2}%:/, "")
                .replace(" ", "-")
                .toLowerCase();
            let profession = event.target.id.replace("-check", "")
                .replace("-" + skill, "")
                .replace(/\d/,"");
            updateSkills(profession, event.target.getAttribute("max"))
        });
    }
    document.querySelector("#professions").addEventListener('click', function () {
        resetSkills();
        modal.style.display = "block";
        const profSelect = document.querySelector("#professions");
        document.querySelector("#" + profSelect.value + "-wrapper").style = "visible"
    });

    var skillChecks = document.getElementsByClassName("skill-check");
    for (i = 0; i < skillChecks.length; i++) {
        skillChecks[i].addEventListener("change", function (event) {
            let skill = event.target.getAttribute("name")
                .replace(/\s\d{1,2}%:/, "")
                .replace(" ", "-")
                .toLowerCase();
            let profession = event.target.id.replace("-check", "")
                .replace("-" + skill, "")
                .replace(/\d/,"");
            updateSkills(profession, event.target.getAttribute("max"))
        });
    }

    let skillInputs = document.getElementsByClassName("skill-modal-input");
    for (let i = 0; i < skillInputs.length; i++) {
        skillInputs[i].addEventListener("change", function (event) {
            let skill = event.target.getAttribute("name")
                .replace(/\s\d{1,2}%:/, "")
                .replace(" ", "-")
                .toLowerCase();
            let profession = event.target.id.replace("-check", "")
                .replace("-" + skill, "")
                .replace(/\d/,"");
            updateSkills(profession, event.target.getAttribute("max"))
        });
    }
}

function readFile(path) {
    const request = new XMLHttpRequest();
    request.open("GET", path, false);
    request.send(null);
    return request.responseText;
}

function updateSkills(profession) {
    let confirmButtons = document.getElementsByClassName("skillModalConfirm");
    for (let i = 0; i < confirmButtons.length; i++) {
        confirmButtons[i].disabled = false;
    }
    let skills = getAllDefaultSkills(profession);
    const skillCheckDivs = document.getElementsByClassName("skill-check-div");
    let skillsToDisable = [];
    for (let i = 0; i < skillCheckDivs.length; i++) {
        let skillCheck = skillCheckDivs[i].getElementsByClassName("skill-check")[0];
        let skillInput = skillCheckDivs[i].getElementsByClassName("skill-modal-input-opt")[0];
        let skillName = skillCheck.name;
        if (skillInput !== undefined) {
            if (skills.has((skillName + " (" + skillInput.value + ")").toLowerCase())) {
                skillCheckDivs[i].className += " red";
                skillInput.className += " red";
                for (let i = 0; i < confirmButtons.length; i++) {
                    confirmButtons[i].disabled = true;
                }
            } else {
                skillCheckDivs[i].className = skillCheckDivs[i].className.replace(" red", "");
                skillInput.className = skillInput.className.replace(" red", "");
            }
        }
        if (skills.has(skillName)) {
            skillCheck.checked = false;
            skillsToDisable.push(skillCheck);
        }
        else {
            skillCheck.disabled = false;
        }
    }
    checkForDisableOrEnableUnchecked(maxChecked.get(profession));
    for (let i = 0; i < skillsToDisable.length; i++) {
        skillsToDisable[i].disabled = true;
    }
}

function countChecked() {
    const skillChecks = document.getElementsByClassName("skill-check");
    let checkedCount = 0;
    for (let i = 0; i < skillChecks.length; i++) {
        if (skillChecks[i].checked) {
            checkedCount = checkedCount + 1;
        }
    }
    return checkedCount;
}

function checkForDisableOrEnableUnchecked(maxCheckedCount) {
    const checkedCount = countChecked();
    let disable = checkedCount >= maxCheckedCount;
    disableOrEnableUnchecked(disable);
}

function disableOrEnableUnchecked(disable) {
    const skillChecks = document.getElementsByClassName("skill-check");
    for (i = 0; i < skillChecks.length; i++) {
        //Change the status if it's not checked and also doesn't have an exclusive that's checked
        if (!skillChecks[i].checked && (skillChecks[i].getAttribute("exclusive") == null || !document.querySelector("#" + skillChecks[i].getAttribute("exclusive")).checked)) {
            skillChecks[i].disabled = disable;
        }
    }
}

function getAllModalSkills(profession) {
    const skillMap = new Map();
    getAllDefaultSkills(profession).forEach((value, key) => {
        skillMap.set(key, value);
    });

    let skillCheckDivs = (document.getElementsByClassName(profession + " skill-check-div"));
    for (let i = 0; i < skillCheckDivs.length; i++) {
        let skillChecks = skillCheckDivs[i].getElementsByClassName(profession + " skill-check");
        if (skillChecks[0].checked) {
            let modalInputs = skillCheckDivs[i].getElementsByClassName("skill-modal-input-opt");
            if(modalInputs.length === 0) {
                skillMap.set(skillChecks[0].name, skillChecks[0].getAttribute("base"))
            } else {
                let skillName = skillChecks[0].value.replace("-", " ").toTitleCase();
                let base = skillChecks[0].getAttribute("base");
                skillMap.set(skillName + " " + base + "%:\n(" + modalInputs[0].value.toTitleCase() + ") ", base)
            }
        }
    }
    return skillMap;
}

function getAllDefaultSkills(profession) {
    let skillMap = new Map();
    const skillsDefault = document.getElementsByClassName("skill-default");
    for (let i = 0; i < skillsDefault.length; i++) {
        if (skillsDefault[i].className.includes(profession)) {
            skillMap.set(skillsDefault[i].getAttribute("name"), skillsDefault[i].getAttribute("base"))
        }
    }
    const skillsRadio = document.getElementsByClassName("skill-radio");
    for (i = 0; i < skillsRadio.length; i++) {
        if (skillsRadio[i].checked) {
            if (skillsRadio[i].className.includes(profession)) {
                skillMap.set(skillsRadio[i].value, skillsRadio[i].getAttribute("base"))
            }
        }
    }
    const skillsInput = document.getElementsByClassName("skill-modal-input");
    for (i = 0; i < skillsInput.length; i++) {
        if (skillsInput[i].className.includes(profession)) {
            skillMap.set((skillsInput[i].name + " (" + skillsInput[i].value + ")"), skillsInput[i].getAttribute("base"))
        }
    }
    return skillMap;
}

function createOption(value, text) {
    const opt = document.createElement("option");
    opt.value = value;
    opt.innerText = text;
    return opt;
}


function populateProfessionSelect(profSelect) {

    const typical = document.createElement("optgroup");
    typical.label = "Typical Professions";
    typical.appendChild(createOption("anthropologist", "Anthropologist or Historian"));
    typical.appendChild(createOption("engineer", "Computer Scientist or Engineer"));
    typical.appendChild(createOption("federal-agent", "Federal Agent"));
    typical.appendChild(createOption("special-operator", "Special Operator"));
    typical.appendChild(createOption("physician", "Physician"));
    typical.appendChild(createOption("scientist", "Scientist"));

    const atypical = document.createElement("optgroup");
    atypical.label = "Less Typical Professions";
    atypical.appendChild(createOption("criminal", "Criminal"));
    atypical.appendChild(createOption("firefighter", "Firefighter"));
    atypical.appendChild(createOption("foreign-service-officer", "Foreign Service Officer"));
    atypical.appendChild(createOption("intelligence-analyst", "Intelligence Analyst"));
    atypical.appendChild(createOption("intelligence-case-officer", "Intelligence Case Officer"));
    atypical.appendChild(createOption("lawyer", "Lawyer or Business Executive"));
    atypical.appendChild(createOption("media-specialist", "Media Specialist"));
    atypical.appendChild(createOption("nurse", "Nurse or Paramedic"));
    atypical.appendChild(createOption("pilot", "Pilot or Sailor"));
    atypical.appendChild(createOption("police-officer", "Police Officer"));
    atypical.appendChild(createOption("program-manager", "Program Manager"));
    atypical.appendChild(createOption("soldier", "Soldier or Marine"));

    profSelect.appendChild(typical);
    profSelect.appendChild(atypical)
}

function createProfessionWrappers() {
    const modal = document.querySelector("#modal-content");
    const allProfs = parseProfessions();
    for (z = 0; z < allProfs.length; z++) {
        modal.appendChild(allProfs[z])
    }
}

function parseMaleNames() {
    const wrappers = [];
    const data = readFile("resources/male-names.txt");
    male_names = data.split(",");
}

function parseFemaleNames() {
    const wrappers = [];
    const data = readFile("resources/female-names.txt");
    female_names = data.split(",");
}

function parseLastNames() {
    const wrappers = [];
    const data = readFile("resources/last-names.txt");
    last_names = data.split(",");
}

function parseProfessions() {
    const wrappers = [];
    const data = readFile("resources/professions.txt");
    let allProfsArr = (data.split("\n"));
    for (let y = 0; y < allProfsArr.length; y++) {
        if(allProfsArr[y] !== "") {
            const profArr = allProfsArr[y].split(";");
            const name = profArr[0];
            const description = profArr[1];
            const optSkillText = profArr[2];
            const maxCheckedNum = profArr[3];
            const stats = profArr[4];
            const bonds = profArr[5];
            const wrapper = createProfessionWrapper(name, optSkillText, description, stats, bonds, maxCheckedNum);
            const skillList = profArr[6].split(",");
            let optSkillList = [];
            if (profArr.length > 7) {
                optSkillList = profArr[7].split(",");
            }
            const defaultSkills = wrapper.getElementsByClassName("default-skills")[0];
            for (let k = 0; k < skillList.length; k++) {
                let skillChild = getSkillChild(skillList[k], false, name, wrapper);
                defaultSkills.appendChild(skillChild)
            }
            const optionalSkills = wrapper.getElementsByClassName("optional-skills")[0];
            for (let n = 0; n < optSkillList.length; n++) {
                if(optSkillList[n] != "") {
                    optionalSkills.appendChild(getSkillChild(optSkillList[n], true, name, wrapper))
                }
            }
            wrappers.push(wrapper);
            maxChecked.set(name, maxCheckedNum);
        }
    }
    return wrappers
}

function getSkillChild(skillString, opt, profName, wrapper) {
    if (skillString.includes(" or ")) {
        const exclusiveSkills = (skillString.split(" or "));
        const exclusiveSkillNames = [];
        const exclusiveSkillValues = [];
        const exclusiveSkillFriendlyNames = [];
        let combinedName = profName;
        for (j = 0; j < exclusiveSkills.length; j++) {
            let skill = exclusiveSkills[j].split(" ");
            combinedName = combinedName + "-" + skill[0];
            exclusiveSkillNames.push(skill[0]);
            exclusiveSkillValues.push(skill[1]);
            exclusiveSkillFriendlyNames.push(skill[0].replace("-", " ").toTitleCase() + " " + skill[1] + "%")
        }
        return createRadioSkills(profName, combinedName, exclusiveSkillNames, exclusiveSkillValues, exclusiveSkillFriendlyNames)
    }
    else if(skillString.includes("(")) {
        let skill = skillString.split(") ");
        let friendlyName = (skill[0]+")").replace("-", " ").toTitleCase();
        if (opt) {
            return createOptionalSkill(profName, skill[0].replace(/\s\(.*/, ""), skill[1], friendlyName, " " + skill[1] + "%")
        }
        else {
            return createDefaultSkill(profName, skill[0], skill[1], skill[0].replace("-", " ").toTitleCase() + ") " + skill[1] + "%")
        }
    }

    let skill = skillString.split(" ");
    if (inputSkills.has(skill[0])) {
        if (opt) {
            return createOptionalSkillInput(profName, skill[0], skill[1], skill[0].replace("-", " ").toTitleCase(), " " + skill[1] + "%:")
        } else {
            return createSkillInput(profName, skill[0], skill[1], skill[0].replace("-", " ").toTitleCase() + " " + skill[1] + "%:", wrapper)
        }
    } else {
        if (opt) {
            return createOptionalSkill(profName, skill[0], skill[1], skill[0].replace("-", " ").toTitleCase(), " " + skill[1] + "%")
        } else {
            return createDefaultSkill(profName, skill[0], skill[1], skill[0].replace("-", " ").toTitleCase() + " " + skill[1] + "%")
        }
    }
}

function createOptionalSkillInput(professionName, skillName, baseValue, friendlyName) {
    const skillDiv = document.createElement("div");
    skillDiv.className = professionName + " prof-modal skill-check-div";

    let input = document.createElement("input");
    input.type = "checkbox";
    input.className = professionName + " skill-check";
    input.id = professionName + "-" + skillName + "-check";
    input.value = skillName;
    input.name = skillName;
    input.setAttribute("base", baseValue);
    skillDiv.appendChild(input);

    const label = document.createElement("label");
    label.setAttribute("for", professionName + "-" + skillName);
    label.innerText = friendlyName;
    skillDiv.appendChild(label);

    input = document.createElement("input");
    input.type = "text";
    input.className = professionName + " fill skill-modal-input-opt";
    input.id = professionName + "-" + skillName;
    input.value = "(choose one)";
    input.name = friendlyName;
    input.setAttribute("base", baseValue);
    input.setAttribute("base", baseValue);
    skillDiv.appendChild(input);

    return skillDiv
}

function createOptionalSkill(professionName, skillName, baseValue, friendlyName, friendlyValue) {
    const skillDiv = document.createElement("div");
    skillDiv.className = professionName + " prof-modal skill-check-div";

    const input = document.createElement("input");
    input.type = "checkbox";
    input.className = professionName + " skill-check";
    input.id = professionName + "-" + skillName;
    input.value = skillName;
    if(inputSkills.has(skillName)) {
        input.name = (skillName + friendlyValue + "\n" + friendlyName.substring(friendlyName.indexOf("(") - 1));
    }
    else {
        input.name = skillName;
    }
    input.setAttribute("base", baseValue);
    skillDiv.appendChild(input);

    const label = document.createElement("label");
    label.setAttribute("for", professionName + "-" + skillName);
    label.innerText = friendlyName;
    skillDiv.appendChild(label);

    const span = document.createElement("span");
    span.innerText = friendlyValue;
    skillDiv.appendChild(span);

    return skillDiv
}

function createSkillInput(professionName, skillName, baseValue, friendlyName, wrapper) {
    const skillDiv = document.createElement("div");
    skillDiv.className = professionName + " prof-modal " + skillName;

    const label = document.createElement("label");
    label.setAttribute("for", professionName + "-" + skillName);
    label.innerText = friendlyName;
    skillDiv.appendChild(label);

    const input = document.createElement("input");
    input.className = professionName + " fill skill-modal-input";
    input.type = "text";
    let otherElements = wrapper.getElementsByClassName(professionName + " prof-modal " + skillName);

    input.id = professionName + "-" + skillName + (otherElements.length+1);
    input.name = friendlyName;
    input.value = "(choose one)";
    input.setAttribute("base", baseValue);
    skillDiv.appendChild(input);

    return skillDiv;

}

function createRadioSkills(professionName, combinedSkillName, skillNames, baseValues, friendlyNames) {
    const div = document.createElement("div");

    for (i = 0; i < skillNames.length; i++) {
        const radioInput = document.createElement("input");
        radioInput.type = "radio";
        radioInput.className = professionName + " prof-modal skill-radio";
        radioInput.id = professionName + "-" + skillNames[i] + "Opt";
        radioInput.name = combinedSkillName;
        radioInput.value = skillNames[i];
        radioInput.setAttribute("base", baseValues[i]);

        const label = document.createElement("label");
        label.setAttribute("for", professionName + "-" + skillNames[i]);
        label.innerText = friendlyNames[i];

        div.appendChild(radioInput);
        div.appendChild(label);

        if (i < (skillNames.length - 1)) {
            const span = document.createElement("span");
            span.innerText = " or ";
            div.appendChild(span)
        }
    }

    return div
}

function createDefaultSkill(professionName, skillName, baseValue, friendlyName) {
    const skillDiv = document.createElement("div");
    skillDiv.className = professionName + " prof-modal skill-default";
    skillDiv.setAttribute("base", baseValue);
    if(friendlyName.includes("(")) {
        friendlyName = friendlyName.substring(0, friendlyName.indexOf("(")-1) + " "
            + baseValue + "%:\n" + friendlyName.substring(friendlyName.indexOf("("), friendlyName.length-3);
        skillDiv.setAttribute("name", friendlyName);
    }
    else {
        skillDiv.setAttribute("name", skillName);
    }
    skillDiv.innerText = friendlyName;
    return skillDiv
}

function createProfessionWrapper(professionName, skillLabelText, descriptionText, statText, bondText, maxCheckedCount) {
    const wrapper = document.createElement("table");
    wrapper.className = "fill skill-wrapper";
    wrapper.id = professionName + "-wrapper";
    wrapper.style = "display: none;";

    const tbody = document.createElement("tbody");
    wrapper.appendChild(tbody);
    const rowOne = document.createElement("tr");
    tbody.appendChild(rowOne);
    const professionSelectCell = document.createElement("td");
    rowOne.appendChild(professionSelectCell);

    const professionSpan = document.createElement("span");
    professionSpan.className = "fill";
    professionSelectCell.appendChild(professionSpan);

    const professionSelect = document.createElement("select");
    professionSelect.id = professionName + "-professions";
    professionSelect.className = "profession-select";
    populateProfessionSelect(professionSelect);
    professionSpan.appendChild(professionSelect);

    if(maxCheckedCount !== "0") {
        const blankTd = document.createElement("td");
        rowOne.appendChild(blankTd);
    }

    const rowTwo = document.createElement("tr");
    rowTwo.className = "skill-modal";
    tbody.appendChild(rowTwo);

    const profDescriptionCell = document.createElement("td");
    profDescriptionCell.className = professionName + " prof-modal third pad-right align-top";
    rowTwo.appendChild(profDescriptionCell);

    const profDescription = document.createElement("div");
    profDescription.innerText = descriptionText + "\n\n" + statText + "\n" + bondText;
    profDescriptionCell.appendChild(profDescription);

    const defaultSkills = document.createElement("td");
    defaultSkills.className = "default-skills align-top";
    rowTwo.appendChild(defaultSkills);

    const skillDiv = document.createElement("div");
    skillDiv.innerText = "SKILLS";
    defaultSkills.appendChild(skillDiv);

    if (skillLabelText != null && skillLabelText !== "") {
        const optionalSkills = document.createElement("td");
        if (skillLabelText == null) {
            skillLabel.style = "display: none;"
        } else {
            const skillLabelDiv = document.createElement("div");
            skillLabelDiv.innerText = skillLabelText;
            optionalSkills.appendChild(skillLabelDiv)
        }
        optionalSkills.className = "optional-skills align-top";
        rowTwo.appendChild(optionalSkills)
    }

    const confirmTd = document.createElement("td");

    const rowThree = document.createElement("tr");
    rowThree.className = professionName + " prof-modal skill-modal align-top";
    tbody.appendChild(rowThree);

    const statAndBondsCell = document.createElement("td");
    rowThree.appendChild(statAndBondsCell);

    if(maxCheckedCount !== "0") {
        const blankTdTwo = document.createElement("td");
        rowThree.appendChild(blankTdTwo);
    }

    rowThree.appendChild(confirmTd);

    const confirmInput = document.createElement("input");
    confirmInput.type = "button";
    confirmInput.name = professionName;
    confirmInput.value = "Confirm";
    confirmInput.className = "skillModalConfirm";
    confirmInput.id = professionName + "Confirm";
    confirmTd.appendChild(confirmInput);

    return wrapper;
}

function updateSkillIncreaseButtons() {
    let skillTrs = document.getElementsByClassName("skill-tr");
    let numIncreases = 0;
    for(let i =0; i < skillTrs.length; i ++) {
        let skills = skillTrs[i].getElementsByClassName("skill");
        let skill;
        if(skills.length === 0) {
            skill = skillTrs[i].getElementsByClassName("other-skill")[0];
        }
        else {
            skill = skills[0]
        }
        let minus = skillTrs[i].getElementsByClassName("minus")[0];
        let plus = skillTrs[i].getElementsByClassName("plus")[0];
        let value = parseInt(skill.value);
        let base = parseInt(skill.getAttribute("prof-base"));

        if(skill.value === "") {
            minus.style = "display: none;";
            plus.style = "display: none;";
            continue;
        }
        if(value === base) {
            minus.style = "display: none;"
        }
        else  {
            minus.style = "";
            numIncreases += ((value-base)/20);
        }
        //No skill can be greater than 80 so disable the 'add 20 points' button if it's above 60
        if(value > 60) {
            plus.style = "display: none;"
        }
        else {
            plus.style = "";
        }
    }
    if(numIncreases >= 8) {
        let pluses = document.getElementsByClassName("plus");
        for(let i =0; i < pluses.length; i ++) {
            pluses[i].style = "display: none;"
        }
    }
    document.getElementById("numIncrease").innerText = (8-numIncreases) + "";
}

function setPlusAndMinusButtons(skillTr) {
    let skill = skillTr.getElementsByClassName("skill")[0];
    let minus = skillTr.getElementsByClassName("minus")[0];
    let plus = skillTr.getElementsByClassName("plus")[0];
    let value = parseInt(skill.value);
    let base = parseInt(skill.getAttribute("prof-base"));

    if(value === base) {
        minus.style = "display: none;"
    }
    else  {
        minus.style = "";
        return ((value-base)/20);
    }
    //No skill can be greater than 80 so disable the 'add 20 points' button if it's above 60
    if(value > 60) {
        plus.style = "display: none;"
    }
    else {
        plus.style = "";
    }
    return 0;
}

function addToSkill(skill, change) {
    let parent = skill.parentElement.parentElement;
    let skillInputs = parent.getElementsByClassName("skill");
    let skillInput;
    if(skillInputs.length > 0) {
        skillInput = skillInputs[0]
    }
    else {
        skillInput = parent.getElementsByClassName("other-skill")[0]
    }
    skillInput.value = parseInt(skillInput.value) + change;
}

function createNameListener() {
    document.getElementById("random-name").addEventListener("click", event => {
        randomName();
    })
}

function randomName() {
    let genderRand = Math.floor(Math.random()*10);
    let name;
    if((genderRand % 2) === 0) {
        document.getElementById("sex2").checked = true;
        document.getElementById("sex1").checked = false;
        name = male_names.random() + " " + last_names.random()
    }
    else {
        document.getElementById("sex1").checked = true;
        document.getElementById("sex2").checked = false;
        name = female_names.random() + " " + last_names.random()
    }
    document.getElementById("name").value = name;
}


function setRandomListener() {
    document.getElementById("btnRandom").addEventListener("click", random);
}
function random() {
    randomProfession();
    randomName();
    randomEmployer();
    randomNationality();
    randomAge();
    randomEducation();
    randomStats();
    randomBonds();
    randomSkills();
}

function randomEmployer() {
    let profession = document.getElementById("professions").value;
    let employer = (profession_details.get(profession).employer.random().random());
    if(cities.includes(employer)) {
        if(profession === "firefighter") {
            employer += " FD";
        }
        else if(profession === "lawyer") {
            employer += " DA's Office"
        }
        else if(profession === "police-officer") {
            employer += " PD";
        }
        else if(profession === "media-specialist") {
            employer += " " + newspaper_suffixes.random();
        }
    }
    document.getElementById("employer").value = employer;
}

function randomNationality() {
    let nationality = nationalities.random();
    let addAmerican = Math.floor((Math.random()*2));
    if(nationality !== "American" && addAmerican !== 1) {
        nationality += "-American";
    }
    document.getElementById("nationality").value = nationality;
}

function randomAge() {
    let twentyFiveYearsAgo = new Date().getTime()-802915614000;
    let fiftyFiveYearsAgo = new Date().getTime()-2065220189359;
    let birthday = moment(new Date(Math.random() * (fiftyFiveYearsAgo - twentyFiveYearsAgo) + twentyFiveYearsAgo));
    let age = (parseInt(moment(new Date()).format('YYYY'))-
        parseInt(birthday.format('YYYY')));
    document.getElementById("age").value = age + " " + birthday.format('MM/DD/YYYY')
}

function randomProfession() {
    let profList = [];
    let professions = document.getElementById("professions");
    let options = professions.getElementsByTagName("option");
    for(let i = 0; i < options.length; i ++) {
        profList.push(options[i].value)
    }
    professions.value = profList.random();
    document.getElementById("profession").value = professions.value.replaceAll("-", " ").toTitleCase();
}

function randomEducation() {
    let profession = document.getElementById("professions").value;
    let education = profession_details.get(profession).education.random();
    if(education !== 'High School Diploma') {
        education += " from " + universities.random();
    }
    document.getElementById("education").value = education;
}

function randomStats() {
    let profession = document.getElementById("professions").value;
    let stats = [...profession_details.get(profession).stats];
    let stat_names = ["STR", "DEX", "CON", "INT", "POW", "CHA"];
    let focuses = [["14", "12", "10", "10", "9", "17"], ["12", "12", "11", "11", "13", "13"], ["11", "10", "10", "12", "14", "15"]];
    let focus = focuses[stats.length-1];
    while(stats.length > 0) {
        let stat = stats.pop();
        stat_names.splice(stat_names.indexOf(stat), 1)[0].toLowerCase() + "-score";
        stat = stat.toLowerCase() + "-score";
        document.getElementById(stat).value = focus.pop();
    }

    while(stat_names.length > 0) {
        let stat = (stat_names.splice(stat_names.indexOf(stat_names.random()), 1))[0].toLowerCase() + "-score";
        document.getElementById(stat).value = focus.pop();
    }
    updateScore("str", document.querySelector("#str-score"));
    updateScore("dex", document.querySelector("#dex-score"));
    updateScore("con", document.querySelector("#con-score"));
    updateScore("int", document.querySelector("#int-score"));
    updateScore("pow", document.querySelector("#pow-score"));
    updateScore("cha", document.querySelector("#cha-score"));
    hPListener();
    updatePow();
}

function randomBonds() {
    let bondNames = document.getElementsByClassName("bond");
    let bondScores = document.getElementsByClassName("bond-score");
    let profession = profession_details.get(document.getElementById("professions").value);
    let chaScore = document.getElementById("cha-score").value;
    let chosenBonds = [];
    for(let i = 0; i < bondNames.length; i ++) {
        bondNames[i].value = "";
        bondScores[i].value = "";
    }
    for(let i = 0; i < profession.bonds; i ++) {
        let bond = bonds.random();
        while(chosenBonds.includes(bond)) {
            bond = bonds.random();
        }
        chosenBonds.push(bond[0]);
        let name;
        let genderRand = Math.floor(Math.random()*10);
        if(bond[1] === "M" || (bond[1] === "FM" && (genderRand % 2) === 0)) {
            name = male_names.random() + " " + last_names.random()
        }
        if(bond[1] === "F" || (bond[1] === "FM" && (genderRand % 2) !== 0)) {
            name = female_names.random() + " " + last_names.random()
        }
        bondNames[i].value = name + " (" + bond[0] + ")";
        bondScores[i].value = chaScore;
    }
}

function pickRandomInput(skillName) {

    return inputSkills.get(skillName).random();
}

function randomSkills() {
    resetSkills();
    resetOtherSkills();
    let profession = document.getElementById("professions").value;
    let default_skills = document.getElementsByClassName(profession + " skill-default");
    let default_input_skills = document.getElementsByClassName(profession + " skill-modal-input");
    let skill_checks =  [].slice.call(document.getElementsByClassName(profession + " skill-check"));
    let radio_skills = [].slice.call(document.getElementsByClassName(profession + " skill-radio"));
    let skills = new Map();
    console.log(profession);
    if(radio_skills.length > 0) {
        let radio = radio_skills.random();
        skills.set(radio.getAttribute("value"), radio.getAttribute("base"));
    }
    for(let i = 0; i < default_skills.length; i++) {
        skills.set(default_skills[i].getAttribute("name"), default_skills[i].getAttribute("base"))
    }
    for(let i = 0; i < default_input_skills.length; i++) {
        let skillName = default_input_skills[i].getAttribute("name")
            .replace(/\s\d{1,2}%:/, "").toLowerCase().replace(" ", "-");
        if(inputSkills.has(skillName)) {
            skillName = skillName.replaceAll("-", " ").toTitleCase() + " (" + pickRandomInput(skillName) +")";
            skills.set(skillName, default_input_skills[i].getAttribute("base"));
        }
    }
    console.log((default_skills.length + default_input_skills.length + (radio_skills.length)-1) + " default skills");
    console.log((profession_details.get(profession).optional_skills) + " optional skills");
    console.log("Radio skills");
    for(let i = 0; i < radio_skills.length; i ++) {
        console.log(radio_skills[i].getAttribute("value"))
    }
    console.log("Default skills Without radio");
    for(let i = 0; i < default_skills.length; i ++) {
        console.log(default_skills[i].getAttribute("name"))
    }
    console.log("Default skills");
        skills.forEach((value, key) => {
            console.log(key)
        });
    for(let i = 0; i < profession_details.get(profession).optional_skills; i++) {
        let rand = Math.floor(Math.random()*skill_checks.length)
        console.log(rand)
        console.log(skill_checks[rand])
        let skill = skill_checks.splice(rand, 1)[0];
        let skillName = skill.getAttribute("name");
        while(skills.has(skillName)) {
            console.log("Skills has " + skillName)
            skill = skill_checks.splice((Math.floor(Math.random()*skill_checks.length)), 1)[0];
            skillName = skill.getAttribute("name");
        }
        console.log("Skill name: " + skillName)
        if(inputSkills.has(skillName)) {
            console.log("Input skill before: " + skillName)
            skillName = skillName.replaceAll("-", " ").toTitleCase() + " (" + pickRandomInput(skillName) +")";
            console.log("Input skill after: " + skillName)
        }
        skills.set(skillName, skill.getAttribute("base"));

    }

    console.log(skills.size + " skills");
    skills.forEach((value, key) => {
        setSkill(value, key)
    })
}
