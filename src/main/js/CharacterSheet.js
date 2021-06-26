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
let skills;
let employers;
let names = new Map();
let code_names = [];
let universities = [["Harvard", "at"], ["Standford", "at"], ["MIT", "at"], ["Brown", "at"], ["Columbia", "at"],
   ["Cornell", "at"], ["Dartmouth", "at"], ["The University of Pennsylvania", "at"], ["Princeton", "at"], ["Yale", "at"],
   ["Texas A&M", "at"]];
let history_museums = [["The Smithsonian", "at"], ["The American Museum of Natural History", "at"], ["The British Museum", "at"]];
let tech_companies = [["Facebook", "at"], ["Google", "at"], ["Apple", "at"], ["IBM", "at"], ["Amazon", "at"]];
let federal_agencies = [["FBI", "in the"], ["DEA", "in the"], ["ATF", "in the"], ["Secret Service", "in the"],
   ["US Marshals", "in the"]];
let hospitals = [["The Mayo Clinic", "at"], ["The Cleavland Clinic", "at"], ["Johns Hopkins", "at"], ["Massachusetts General", "at"],
   ["Cedar Sinai", "at"]];
let science = [["The National Institute of Health", "at"], ["CDC", "at the"], ["FDA", "at the"], ["Los Alamos National Laboratory", "at"],
   ["DARPA", "at"]];
let special_operator = [["Hostage Rescue Team", "in the"], ["Army Rangers", "in the"], ["USMC Raiders", "in the"],
   ["CIA Special Operations Group", "in the"], ["Navy Seals", "in the"], ["Delta Force", "in the"]];
let criminal_orgs = [["self employed", "who is"], ["Italian Mafia", "in the"], ["Russian Mafia", "in the"], ["small crew", "with a"]];
let cities = ["New York City", "Los Angeles", "Chicago", "Houston",
   "Phoenix", "Philadelphia", "San Antonio", "San Diego",
   "Dallas", "San Jose"];
let foreign_service = [["US State Department", "at the"]];
let intelligence_analysts = [["FBI", "in the"], ["NSA", "in the"], ["CIA", "in the"], ["Mossad", "at"], ["MI6", "in"]];
let intelligence_agencies = [["CIA", "in the"], ["Mossad", "at"], ["MI6", "in"], ["Chinese Ministry of State Security", "in the"]];
let law_firms = [["Baker-Mckenzie", "at"], ["Kirkland & Ellis", "at"], ["Latham & Watkins", "at"],
   ["DLA Piper", "at"], ["Baker & McKenzie", "at"], ["Dentons", "at"], ["US Department of Justice", "in the"]];
let tv_news = [["Fox News", "at"], ["NBC News", "at"], ["CNN News", "at"]];
let newspapers = [["The New York Times", "at"], ["The Washington Post", "at"], ["The Wall Street Journal", "at"],
   ["The Boston Globe", "at"]];
let newspaper_suffixes = [["Times", "at the"], ["Post", "at the"], ["Times-Picayune", "at the"],
   ["Daily News", "at the"], ["Tribune", "at the"], ["Gazette", "at the"], ["News", "at the"]];
let blogs = [["The Huffington Post", "at"], ["Buzzfeed", "at"], ["The Daily Beast", "at"], ["Vice", "at"]];
let pilot = [["American Airlines", "at"], ["US Airforce", "in the"], ["US Navy", "in the"], ["British Airways", "at"],
   ["Fedex", "at"], ["NetJets", "at"], ["Delta Airlines", "at"]];
let top_companies = [["Walmart", "at"], ["Amazon", "at"], ["Apple", "at"], ["CVS Health", "at"],
   ["UnitedHealth Group", "at"], ["Berkshire Hathaway", "at"],
   ["McKesson", "at"], ["AmerisourceBergen", "at"], ["Alphabet", "at"], ["Exxon Mobil", "at"], ["AT&T", "at"],
   ["Costco Wholesale", "at"], ["Cigna", "at"],
   ["Cardinal Health", "at"], ["Microsoft", "at"], ["Walgreens Boots Alliance"], ["Kroger", "at"], ["Home Depot", "at"],
   ["JPMorgan Chase", "at"], ["Verizon Communications", "at"]];
let armed_forces = [["The US Marines", "in"], ["The US Army", "in"], ["The US Airforce", "in"], ["The US Navy", "in"]];

let profession_details = new Map([
   ["anthropologist", {'employer': [universities, history_museums],
       'education': ["Masters in Anthropology", "PHD in Anthropology"], 'stats': ["INT"], 'bonds': 4,
       'optional_skills': 2, 'weapons': [["pepper_spray_can", "Pepper Spray Can"]], 'other_gear': ['Smartphone', 'Laptop']}],
   ["engineer", {'employer': [tech_companies, federal_agencies], 'education': ["Bachelors in Computer Science",
           "Masters in Computer Science", "PHD in Computer Science"], 'stats': ["INT"], 'bonds': 3,
       'optional_skills': 4, 'weapons': [["stun_gun", "Taser"]], 'other_gear': ['Smartphone', 'Laptop']}],
   ["federal-agent", {'employer': [federal_agencies], 'education': ["Bachelors in Criminal Justice"],
       'stats': ["CON","POW","CHA"], 'bonds': 3, 'optional_skills': 1,
       'weapons': [["medium_pistol", "Glock 17"]], 'other_gear': ['Ear piece communicator', 'Smartphone', 'Laptop',
           'Flexible Cuffs', "Tactical Light"]}],
   ["special-operator", {'employer': [special_operator], 'education': ["High School Diploma"],
       'stats': ["STR","CON","POW"], 'bonds':2, 'optional_skills': 0,
       'weapons': [["medium_pistol", "Colt M1911"], ["combat_dagger", "KBAR Knife"]], 'other_gear': ['Smartphone', 'Ear piece communicator',
           "Tactical Light", "Night Vision Goggles (Civilian)", "Sound Suppressor"]}],
   ["physician", {'employer': [hospitals], 'education': ["MD"], 'stats': ["INT","POW","DEX"], 'bonds':3,
       'optional_skills': 2, 'weapons': [["pepper_spray_can", "Pepper Spray Can"]], 'other_gear': ['Smartphone', 'First Aid Kit']}],
   ["scientist", {'employer': [science], 'education': ["PHD in Chemistry", "PHD in Biology", "PHD in Physics"],
       'stats': ["INT"], 'bonds':4, 'optional_skills': 3, 'weapons': [["stun_gun", "Taser"]], 'other_gear': ['Smartphone', 'Laptop']}],
   ["firefighter", {'employer': [cities], 'education': ["High School Diploma"], 'stats': ["STR","DEX","CON"],
       'bonds':3, 'optional_skills': 0, 'weapons': [["knife", "Knife"]], 'other_gear': ['Smartphone',
           'First Responder Medical Kit', "Large Flashlight"]}],
   ["foreign-service-officer", {'employer': [foreign_service], 'education': ["PHD in Foreign Affairs", "PHD in International Relations"],
       'stats': ["INT","CHA"], 'bonds':3, 'optional_skills': 0,
       'weapons': [["pepper_spray_can", "Pepper Spray Can"]], 'other_gear': ['Smartphone', 'Laptop']}],
   ["criminal", {'employer': [criminal_orgs], 'education': ["High School Diploma"], 'stats': ["STR","DEX"],
       'bonds':4, 'optional_skills': 2, 'weapons': [["light_pistol", ".38 Special"], ["knife", "Knife"]], 'other_gear': ['Burner Phone', 'Lockpick Kit']}],
   ["intelligence-analyst", {'employer': [intelligence_analysts], 'education': ["Masters in Political Science", "Masters in International Relations"],
       'stats': ["INT"], 'bonds': 3, 'optional_skills': 0, 'weapons': [["stun_gun", "Taser"]], 'other_gear': ['Smartphone', 'Laptop']}],
   ["intelligence-case-officer", {'employer': [intelligence_agencies],
       'education': ["Bachelors in Political Science"], stats: ["INT","POW","CHA"],
       'bonds': 2, 'optional_skills': 0, 'weapons': [["medium_pistol", "Glock 17"]], 'other_gear': ['Smartphone', 'Laptop', 'Ear piece communicator']}],
   ["lawyer", {'employer': [law_firms, cities], 'education': ["JD"], 'stats': ["INT","POW","CHA"],
       'bonds':2, 'optional_skills': 4, 'weapons': [["stun_gun", "Taser"]], 'other_gear': ['Smartphone', 'Laptop']}],
   ["media-specialist", {'employer': [tv_news, newspapers, blogs, cities],
       'education': ["Bachelors in Media Studies"], 'stats': ["INT","CHA"],
       'bonds': 4, 'optional_skills': 5,  'weapons': [["stun_gun", "Taser"]], 'other_gear': ['Smartphone', 'Laptop', 'Voice-activated recorder']}],
   ["nurse", {'employer': [hospitals], 'education': ["Bachelors in Nursing", "Masters in Nursing"],
       'stats': ["INT","POW","CHA"], 'bonds': 4, 'optional_skills': 2,
       'weapons': [["pepper_spray", "Pepper Spray Can"]], 'other_gear': ['Smartphone', 'First Aid Kit']}],
   ["pilot", {'employer': [pilot], 'education': ["High School Diploma", "Bachelors in Mechanical Engineering"],
       'stats': ["DEX","INT"], 'bonds': 3, 'optional_skills': 2,
       'weapons': [["pepper_spray", "Pepper Spray Can"]], 'other_gear': ['Smartphone', 'Laptop']}],
   ["police-officer", {'employer': [cities], 'education': ["High School Diploma", "Associates in Criminal Justice"],
       'stats': ["STR","CON","POW"], 'bonds': 3, 'optional_skills': 1,
        'weapons': [["heavy_pistol", ".44 Magnum"]], 'other_gear': ['Smartphone', 'Laptop', "Handcuffs", "Large Flashlight"]}],
   ["program-manager", {'employer': [top_companies], 'education': ["Masters in Business Administration"],
       'stats': ["INT","CHA"], 'bonds': 4, 'optional_skills': 1, 'weapons': [["pepper_spray", "Pepper Spray Can"]],
       'other_gear': ['Smartphone', 'Laptop']}],
   ["soldier", {'employer': [armed_forces], 'education': ["High School Diploma"], 'stats': ["STR", "CON"], 'bonds': 4, 'optional_skills': 3,
       'weapons': [["medium_pistol", "Beretta M9"], ["combat_dagger", "KBAR Knife"]], 'other_gear': ['Smartphone', "Tactical Light"]}]
]);

let maxChecked = new Map();

String.prototype.toTitleCase = function () {
    let s = this.replace(/\w\S*/g, function (txt) {
        return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();
    });
    return s.replace(/-\w/g, function (txt) {
        return "-" + txt.charAt(1).toUpperCase() + txt.substr(2);
    });
};

Array.prototype.random = function () {
    return this[Math.floor((Math.random()*this.length))];
};

let nationalities = ["albanian", "albanian-american", "algerian", "algerian-american", "american", "iraqi",
   "iraqi-american", "argentinian", "argentinian-american", "armenian", "armenian-american",
   "australian", "australian-american", "austrian", "austrian-american", "belarusian",
   "belarusian-american", "belgian", "belgian-american", "brazilian", "brazilian-american",
   "british", "british-american", "bulgarian", "bulgarian-american", "cameroonian", "cameroonian-american",
   "canadian", "canadian-american", "chinese", "chinese-american", "croatian", "croatian-american",
   "cypriot", "cypriot-american", "czech", "czech-american", "danish", "danish-american", "dutch",
   "dutch-american", "egyptian", "egyptian-american", "estonian", "estonian-american", "ethiopian",
   "ethiopian-american", "filipino", "filipino-american", "finnish", "finnish-american", "french",
   "french-american", "german", "german-american", "greek", "greek-american", "haitian", "haitian-american",
   "hungarian", "hungarian-american", "icelandic", "icelandic-american", "indian", "indian-american",
   "iranian", "iranian-american", "irish", "irish-american", "italian", "italian-american", "jamaican",
   "jamaican-american", "japanese", "japanese-american", "korean", "korean-american", "laotian",
   "laotian-american", "latvian", "latvian-american", "lithuanian", "lithuanian-american", "malaysian",
   "malaysian-american", "moldovan", "moldovan-american", "moroccan", "moroccan-american", "nepalese",
   "nepalese-american", "norwegian", "norwegian-american", "pakistani", "pakistani-american", "polish",
   "polish-american", "portuguese", "portuguese-american", "romanian", "romanian-american", "russian",
   "russian-american", "samoan", "samoan-american", "scottish", "scottish-american", "serbian", "serbian-american",
   "slovenian", "slovenian-american", "spanish", "spanish-american", "swedish", "swedish-american", "swiss",
   "swiss-american", "thai", "thai-american", "turkish", "turkish-american", "ukrainian", "ukrainian-american",
   "uzbek", "uzbek-american", "vietnamese", "vietnamese-american", "welsh", "welsh-american"];

let bonds = [["Mother", "F", "Family", "Older"], ["Father", "M", "Family", "Older"], ["Coworker", "FM", "Non-family"],
   ["Friend", "FM", "Non-family"], ["Sister", "F", "Family", "Same"], ["Brother", "M", "Family", "Same"],
   ["Mentor", "FM", "Non-family"], ["Boyfriend", "M", "Non-family"], ["Girlfriend", "F", "Non-family"],
   ["Husband", "M", "Family", "Same"], ["Wife", "F", "Family", "Same"], ["Uncle", "M", "Family", "Older"],
   ["Aunt", "F", "Family", "Older"], ["Grandmother", "F", "Family", "Older"], ["Grandfather", "M", "Family", "Older"],
   ["Ex-wife", "F", "Non-family", "Same"], ["Ex-husband", "M", "Non-family", "Same"],
   ["Daughter", "F", "Family", "Younger"], ["Son", "M", "Family", "Younger"],
   ["Ex-boyfriend", "M", "Non-family", "Same"], ["Ex-girlfriend", "F", "Non-family", "Same"]];

const description = {
   eye_description: ["exquisite", "iridescent", "luminous", "magnetic", "radiant", "angry", "anxious",
       "appealing", "blank", "brooding", "candid", "cold", "commanding", "compassionate", "confused", "cruel",
       "curious", "dazed", "dead", "discerning", "disdainful", "dull", "emotionless", "fearful", "fiery",
       "genuine", "grave", "hollow", "honest", "hopeful", "imploring", "innocent", "intelligent", "intense",
       "irritated", "jovial", "judgmental", "keen", "knowing", "melancholy", "mischievous", "mocking", "playful",
       "reflective","restless", "resigned", "resolute", "sad", "sorrowful", "stern", "sympathetic", "thoughtful",
       "trusting", "unreadable", "weary"],
   eye_color: ["green", "blue", "brown", "grey", "black"],
   hair_texture: ["frizzy", "balding", "thin", "thick", "long", "short", "messy", "straight", "curly", "greasy",
       "slick", "fluffy", "luxurious", "silky", "wavy", "lush", "stringy", "flowing", "close cropped"],
   hair_color: ["blond", "black", "grey", "white", "red", "brown"],
   skin: ['dark brown', 'brown', 'light brown', 'tan', 'pale white'],
   beards: ["bristly beard", "bristly moustache", "bushy beard", "bushy moustache", "clean-shaven", "close-trimmed beard",
       "coarse beard", "curly moustache", "full beard", "scraggly beard", "scratchy beard", "short beard", "long beard",
       "neat beard", "neatly trimmed beard", "pencil-thin moustache", "stubbly beard", "stylish beard", "thick beard",
       "thick moustache", "thin beard", "thin moustache", "unkempt beard", "well-groomed beard", "wild beard"],
   glasses: ["old-fashioned looking", "rectangular", "rimless", "oversized", "horn-rimmed", "big rimmed", "thick", "trendy", "thin"],
   clothing: ["expensive looking", "casual looking", "stiff looking", "colorful", "ragged", "neat looking", "cheap looking",
       "tattered looking", "gaudy looking", "rumpled", "dowdy looking", "loose", "ill-fitting"],
   speech: ["articulate", "chatty", "conversational", "crisp", "eloquent", "flowery", "formal", "inarticulate",
       "incoherent", "informal", "lyrical", "ponderous", "rambling", "succinct", "verbose", "wordy"],
   demeanor: ["cool", "grave", "modest", "courteous", "mild-mannered", "quiet", "serious", "dainty", "icy", "lofty",
       "somber", "indifferent", "solemn", "frantic", "furtive", "businesslike", "stern", "reckless", "courteous", "calm",
       "intense", "casual", "frigid", "polite", "modest", "affable", "unpolished", "passive", "joyous", "humble", "severe",
       "fierce", "professional", "uptight", "aloof"]
};

let weapons = new Map();
let dataLoaded = false;
let professionsFinished = false;

function setup() {
    waitForDataLoad();
    let timeoutms = 2000;
    new Promise((r, j)=>{
        var check = () => {
            console.warn('checking');
            if(dataLoaded)
                r();
            else if((timeoutms -= 100) < 0)
                j('timed out!');
            else
                setTimeout(check, 100)
        };
        setTimeout(check, 100)
    }).then(value => {
        createWeaponSelect(weapons);
        console.log("createProfessionWrappers")
        createProfessionWrappers();
        new Promise((ra, ja)=>{
            var check = () => {
                console.warn('checking');
                if(professionsFinished) {
                    ra();
                }
                else if((timeoutms -= 100) < 0) {
                    ja('timed out!');
                }
                else
                    setTimeout(check, 100)
            };
            setTimeout(check, 100)
        }).then( value1 => {
            setScoreListeners();
            setHPListener();
            setPowListener();
            setAdaptedListeners();
            createPrintButton();
            console.log("setModalListener")
            setModalListener();
            updateSkillIncreaseButtons();
            setSkillListeners();
            setPlusListeners();
            setMinusListeners();
            createNameListener();
            parseNames();
            setRandomListener();
        });
    });
}

function waitForDataLoad() {
    $.getScript('js/DataParser.js', function () {
        // skills = parseSkills();
        weapons = getWeapons();
        dataLoaded = true;
    });
}

function createWeaponSelect(weapons){
    console.log(weapons['Hand-to-Hand Weapons']);
    document.getElementsByName("weapon-select").forEach(select => {

        Object.keys(weapons).forEach(weaponType => {
            let optgroup = document.createElement("optgroup");
            optgroup.label = weaponType;

            Object.keys(weapons[weaponType]).forEach((weaponKey) => {
                let weapon = weapons[weaponType][weaponKey];
                let option = document.createElement("option");
                option.value = weaponKey;
                option.innerText = weapon['friendlyName'];
                optgroup.appendChild(option);
                select.appendChild(optgroup);
            });
        });

        let option = document.createElement("option");
        option.value = "other";
        option.innerText = "Other";
        select.appendChild(option);
        select.value = "other";
        select.addEventListener("change", function (event) {
            weaponSelectListener(event.target);
        });
    });
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
    Object.keys(weapons).forEach((weaponType) => {
        let weaponList = weapons[weaponType];
        console.log(weaponList[option.value]);
        if(weaponList[option.value] !== undefined) {
            let weapon = weapons[weaponType][(option.value)];
            row.getElementsByClassName("weapon-name")[0].value = weapon.friendlyName !== undefined ? weapon.friendlyName: "";
            if(weapon.skill.includes("/")) {
                let skills = weapon.skill.split("/");
                let skill = document.getElementById(skills[0]).value;
                for(let i = 1; i < skills.length; i ++) {
                    skill += "/" + document.getElementById(skills[i]).value;
                }
                row.getElementsByClassName("weapon-skill")[0].value = skill;
            } else {
                let skill = document.getElementById(weapon.skill);
                console.log(weapon.skill);
                console.log(skill);
                row.getElementsByClassName("weapon-skill")[0].value = skill === null
                    ? document.getElementById(weapon.skill + "-x5").innerText : skill.value
            }
            row.getElementsByClassName("weapon-range")[0].value = weapon.range !== undefined ? weapon.range: "";
            let baseDamage = weapon.damage;
            if((weapon.skill === "unarmed-combat" || weapon.skill === 'melee-weapons') && weapon.damage.match(/\d*D\d*.\d{0,3}/)) {
                let damageBonus = 0;
                let strBonus = getStrBonusDamage();
                if(baseDamage.includes("-")) {
                    let baseDamageParts = baseDamage.split("-");
                    baseDamage = baseDamageParts[0];
                    console.log(parseInt(baseDamageParts[1]));
                    console.log(parseInt(baseDamageParts[1]) * -1);
                    damageBonus = ((parseInt(baseDamageParts[1])) * -1)+strBonus;
                    console.log("damageBonus " + damageBonus)

                }
                else if(baseDamage.includes("+")) {
                    let baseDamageParts = baseDamage.split("+");
                    baseDamage = baseDamageParts[0];
                    damageBonus = parseInt(baseDamageParts[1])+strBonus;
                    console.log("damageBonus " + damageBonus)
                }
                else {
                    damageBonus = strBonus
                }

                if(damageBonus > 0) {
                    damageBonus = "+" + damageBonus;
                }
                else if(damageBonus === 0) {
                    damageBonus = "";
                }
                baseDamage += damageBonus;
                console.log(damageBonus);
                console.log(strBonus);
                console.log(baseDamage);
            }
            row.getElementsByClassName("weapon-damage")[0].value = baseDamage !== undefined ? baseDamage: "";
            row.getElementsByClassName("weapon-piercing")[0].value = weapon.armorPiercing !== undefined ? weapon.armorPiercing: "";
            row.getElementsByClassName("weapon-lethality")[0].value = weapon.lethality !== undefined ? weapon.lethality: "";
            row.getElementsByClassName("weapon-kill-radius")[0].value =  weapon.killRadius !== undefined ? weapon.killRadius: "";
            row.getElementsByClassName("weapon-ammo")[0].value = weapon.ammoCapacity !== undefined ? weapon.ammoCapacity: "";
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
    for (let i = 0; i < elements.length; i++) {
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
    input.addEventListener("change", function (event) {
        updateScore(event.target.id.split("-")[0], input.value)
    });
}

function updateScore(scoreName, score) {
    console.log("scoreName " + scoreName);
    console.log("score " + score);
    const fivex = document.querySelector("#" + scoreName + "-x5");
    fivex.innerText = parseInt(score) * 5
}

function setPowListener() {
    const pow = document.querySelector("#pow-score");
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
    str.addEventListener("change", recalculateWeapons);
    con.addEventListener("change", hPListener);
}

function setSkillListeners() {
    let skills = document.getElementsByClassName("skill");
    for (let i = 0; i < skills.length; i++) {
        skills[i].addEventListener("change", function () {
            updateSkillIncreaseButtons();
        })
    }
}

function setPlusListeners() {
    let pluses = document.getElementsByClassName("plus");
    for (let i = 0; i < pluses.length; i++) {
        pluses[i].addEventListener("click", function (event) {
            addToSkill(event.target, 20);
            updateSkillIncreaseButtons();
        })
    }
}

function setAdaptedListeners() {
    let violenceChecks = document.getElementsByClassName("violence-check");
    for(let i = 0; i < violenceChecks.length; i ++) {
        violenceChecks[i].addEventListener('click', function() {
            adaptedListener("violence")
        });
    }
    let helplessnessChecks = document.getElementsByClassName("helplessness-check");
    for(let i = 0; i < helplessnessChecks.length; i ++) {
        helplessnessChecks[i].addEventListener('click', function() {
            adaptedListener("helplessness")
        });
    }
}

function adaptedListener(checkType) {
    let checks = document.getElementsByClassName(checkType + "-check");
    let allChecked = true;
    for(let j = 0; j < checks.length; j ++) {
        allChecked = allChecked && checks[j].checked;
    }
    let adapted = document.getElementById(checkType + "-adapted");
    if(allChecked) {
        adapted.style.visibility = "";
    }
    else {
        adapted.style.visibility = "hidden";
    }
}

function setMinusListeners() {
    let minuses = document.getElementsByClassName("minus");
    for (let i = 0; i < minuses.length; i++) {
        minuses[i].addEventListener("click", function (event) {
            addToSkill(event.target, -20);
            updateSkillIncreaseButtons();
        })
    }
}

function resetSkills() {
    const skills = document.getElementsByClassName("skill");
    for (let i = 0; i < skills.length; i++) {
        skills[i].value = skills[i].getAttribute("base");
        skills[i].setAttribute("prof-base", skills[i].getAttribute("base"))
    }
    resetOtherSkills()
}

function setSkill(key, value) {
    console.log(value + ": " + key);
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
    for (let i = 0; i < skillNames.length; i++) {
        if (skillNames[i].value === "") {
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
    for (let i = 0; i < skillNames.length; i++) {
        skillNames[i].value = ""
    }
    for (let i = 0; i < skills.length; i++) {
        skills[i].value = ""
    }
}

function setModalListener() {
    console.log("setModalListener")
    // Get the modal
    const modal = document.getElementById("myModal");

    // Get the <span> element that closes the modal
    const span = document.getElementById("close");
    // When the user clicks on <span> (x), close the modal
    span.onclick = function () {
        modal.style.display = "none";
    };

    const confirmButtons = document.getElementsByClassName("skillModalConfirm");
    for (let i = 0; i < confirmButtons.length; i++) {
        confirmButtons[i].onclick = function (event) {
            document.getElementById("professions").setAttribute("name", event.target.getAttribute("name"));
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
    console.log(professionSelect.length);
    for (let i = 0; i < professionSelect.length; i++) {
        professionSelect[i].addEventListener("change", function (selChange) {
            setClassVisibility("skill-wrapper", "none");
            const wrapper = document.getElementById(selChange.target.value + "-wrapper");
            wrapper.style.display = "block";

            const skillChecks = document.getElementsByClassName("skill-check");
            console.log(skillChecks)
            console.log(skillChecks.length)
            for (let i = 0; i < skillChecks.length; i++) {
                skillChecks[i].checked = false;
            }
            disableOrEnableUnchecked(false);
            const profSelect = document.querySelector("#professions");
            profSelect.setAttribute("name" ,selChange.target.value);
            let professionSelects = document.getElementsByClassName("profession-select");
            for(let i = 0; i < professionSelects.length; i ++) {
                professionSelects[i].value = selChange.target.value;
            }
        });
    }

    const radioButtons = document.getElementsByClassName("skill-radio");
    for (let i = 0; i < radioButtons.length; i++) {
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
        document.querySelector("#" + profSelect.getAttribute("name") + "-wrapper").style = "visible"
    });

    let skillChecks = document.getElementsByClassName("skill-check");
    // anthropologist skill-check
    console.log(skillChecks.length + " SKILL CHECKS")
    console.log(skillChecks)
    for (let i = 0; i < skillChecks.length; i++) {
        skillChecks[i].addEventListener("change", function (event) {
            let skill = event.target.getAttribute("name")
                .replace(/\s\d{1,2}%:/, "")
                .replace(" ", "-")
                .toLowerCase();
            let profession = event.target.id.replace("-check", "")
                .replace("-" + skill, "")
                .replace(/\d/,"");
            console.log("CLICKED CHECK MARK");
            updateSkills(profession, event.target.getAttribute("max"))
        });
    }

    let skillInputs = document.getElementsByClassName("skill-modal-input");
    console.log(skillInputs.length)
    for (let i = 0; i < skillInputs.length; i++) {
        console.log(skillInputs[i])
        skillInputs[i].addEventListener("change", function (event) {
            let skill = event.target.getAttribute("name")
                .replace(/\s\d{1,2}%:/, "")
                .replace(" ", "-")
                .toLowerCase();
            let profession = event.target.id.replace("-check", "")
                .replace("-" + skill, "")
                .replace(/\d/,"");
            console.log("CLICKED " + event.target);
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
    for (let i = 0; i < skillChecks.length; i++) {
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
    for (let i = 0; i < skillsRadio.length; i++) {
        if (skillsRadio[i].checked) {
            if (skillsRadio[i].className.includes(profession)) {
                skillMap.set(skillsRadio[i].value, skillsRadio[i].getAttribute("base"))
            }
        }
    }
    const skillsInput = document.getElementsByClassName("skill-modal-input");
    for (let i = 0; i < skillsInput.length; i++) {
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
    atypical.appendChild(createOption("custom", "Custom"));

    profSelect.appendChild(typical);
    profSelect.appendChild(atypical)
}

function createProfessionWrappers() {
    const modal = document.querySelector("#modal-content");
    let allProfs;
    new Promise((r, j)=>{
        var check = () => {
            $.getScript('js/ProfessionWrapper.js', function () {
                allProfs = parseProfessions();
                r();
            });
        };
        setTimeout(check, 100)
    }).then(value => {
        for (let z = 0; z < allProfs.length; z++) {
            modal.appendChild(allProfs[z])
        }
        console.log("FINISHED createProfessionWrappers");
        professionsFinished = true;
        // modal.appendChild(createOtherProfModal());
    });
}

function createOtherProfModal() {
    const wrapper = document.createElement("table");
    wrapper.className = "fill skill-wrapper";
    wrapper.id = "custom-wrapper";
    wrapper.style = "display: none;";

    const tbody = document.createElement("tbody");
    wrapper.appendChild(tbody);

    const rowOne = document.createElement("tr");
    tbody.appendChild(rowOne);
    const professionSelectCell = document.createElement("td");
    professionSelectCell.className = "align-top";
    rowOne.appendChild(professionSelectCell);

    let skillTd = document.createElement("td");
    skillTd.className = "center";
    let skillTable = document.createElement("table");
    let skillBody  = document.createElement("tbody");
    skillTable.appendChild(skillBody);
    skillBody.appendChild(createSkillRow("Accounting", 10));
    skillBody.appendChild(createSkillRow("Alertness", 20));
    skillBody.appendChild(createSkillRow("Anthropology", 0));
    skillBody.appendChild(createSkillRow("Archeology", 0));
    skillBody.appendChild(createSkillRow("Artillery", 0));
    skillBody.appendChild(createSkillRow("Athletics", 30));
    skillBody.appendChild(createSkillRow("Bureaucracy", 10));
    skillBody.appendChild(createSkillRow("Computer Science", 0));
    skillBody.appendChild(createSkillRow("Criminology", 10));
    skillBody.appendChild(createSkillRow("Demolitions", 0));
    skillBody.appendChild(createSkillRow("Disguise", 10));
    skillBody.appendChild(createSkillRow("Dodge", 30));
    skillBody.appendChild(createSkillRow("Drive", 10));
    skillBody.appendChild(createSkillRow("Firearms", 20));
    skillBody.appendChild(createSkillRow("First Aid", 10));
    skillBody.appendChild(createSkillRow("Forensics", 0));
    skillBody.appendChild(createSkillRow("Heavy Machinery", 10));
    skillBody.appendChild(createSkillRow("Heavy Weapons", 0));
    skillTd.appendChild(skillTable);
    rowOne.appendChild(skillTd);

    let skillTwoTd = document.createElement("td");
    skillTwoTd.className = "center";
    let skillTwoTable = document.createElement("table");
    let skillTwoBody  = document.createElement("tbody");
    skillTwoTd.appendChild(skillTwoTable);
    skillTwoTable.appendChild(skillTwoBody);
    skillTwoBody.appendChild(createSkillRow("Accounting", 10));
    skillTwoBody.appendChild(createSkillRow("History", 10));
    skillTwoBody.appendChild(createSkillRow("HUMINT", 10));
    skillTwoBody.appendChild(createSkillRow("Law", 0));
    skillTwoBody.appendChild(createSkillRow("Medicine", 0));
    skillTwoBody.appendChild(createSkillRow("Melee Weapons", 30));
    skillTwoBody.appendChild(createSkillRow("Navigate", 10));
    skillTwoBody.appendChild(createSkillRow("Occult", 10));
    skillTwoBody.appendChild(createSkillRow("Persuade", 20));
    skillTwoBody.appendChild(createSkillRow("Pharmacy", 0));
    skillTwoBody.appendChild(createSkillRow("Psychotherapy", 10));
    skillTwoBody.appendChild(createSkillRow("Ride", 10));
    skillTwoBody.appendChild(createSkillRow("Search", 20));
    skillTwoBody.appendChild(createSkillRow("SIGINT", 0));
    skillTwoBody.appendChild(createSkillRow("Stealth", 10));
    skillTwoBody.appendChild(createSkillRow("Surgery", 0));
    skillTwoBody.appendChild(createSkillRow("Survival", 10));
    skillTwoBody.appendChild(createSkillRow("Swim", 20));
    skillTwoBody.appendChild(createSkillRow("Unarmed Combat", 40));
    rowOne.appendChild(skillTwoTd);


    const professionSpan = document.createElement("span");
    professionSpan.className = "fill";
    professionSelectCell.appendChild(professionSpan);

    const professionSelect = document.createElement("select");
    professionSelect.id = "custom-professions";
    professionSelect.className = "profession-select";
    populateProfessionSelect(professionSelect);
    professionSpan.appendChild(professionSelect);

    const rowTwo = document.createElement("tr");
    rowTwo.className = "skill-modal";

    let nameTd = document.createElement("td");
    rowTwo.appendChild(nameTd);

    let explanationTextTd = document.createElement("td");
    rowTwo.appendChild(explanationTextTd);


    tbody.appendChild(rowTwo);

    const confirmTd = document.createElement("td");
    rowTwo.appendChild(confirmTd);

    // const rowThree = document.createElement("tr");
    // rowThree.className = "custom prof-modal skill-modal align-top";
    // tbody.appendChild(rowThree);
    //
    // rowThree.appendChild(confirmTd);

    const confirmInput = document.createElement("input");
    confirmInput.type = "button";
    confirmInput.name = "custom";
    confirmInput.value = "Confirm";
    confirmInput.className = "skillModalConfirm";
    confirmInput.id = "customConfirm";
    confirmTd.appendChild(confirmInput);
    return wrapper;
}

function createSkillRow(skillName, baseValue) {
    let row = document.createElement("tr");
    row.className = "center";
    let checkTd = document.createElement("td");
    row.appendChild(checkTd);
    let check = document.createElement("input");
    check.type = "checkbox";
    check.id = skillName + "-check";
    check.className = skillName + " custom-checkbox";
    checkTd.appendChild(check);

    let nameTd = document.createElement("td");
    nameTd.className = "pad";
    row.appendChild(nameTd);
    let span = document.createElement("span");
    span.innerText = skillName;
    nameTd.appendChild(span);

    let inputTd = document.createElement("td");
    row.appendChild(inputTd);
    let input = document.createElement("input");
    input.id = "custom-" + skillName;
    input.setAttribute("base", baseValue);
    inputTd.className = skillName + " custom-skill-input";
    input.value = baseValue;
    inputTd.appendChild(input);
    return row;
}

function parseNames() {
    let data = readFile("resources/names/code-names.txt");
    code_names = data.split(",");
    parseNamesForNationality('american');
    nationalities.forEach(nationality => {
        parseNamesForNationality(nationality)
    })
}

function parseNamesForNationality(nationality) {
    let male_names;
    let female_names;
    let last_names;
    if(nationality.includes("-american")) {
        let data = readFile("resources/names/" + nationality.replace("-american", "") + ".txt");
        let all_names = data.split("\n");
        male_names = names.get("American").male;
        female_names = names.get("American").female;
        last_names = all_names[2].split(",");
    }
    else {
        let data = readFile("resources/names/" + nationality + ".txt");
        let all_names = data.split("\n");
        male_names = all_names[0].split(",");
        female_names = all_names[1].split(",");
        last_names = all_names[2].split(",");
    }
    names.set(nationality.toTitleCase(), {male: male_names, female: female_names, last: last_names});

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
    console.log("Add to skill " + skill);
    let parent = skill.parentElement.parentElement;
    let skillInputs = parent.getElementsByClassName("skill");
    console.log(parent);
    console.log(skillInputs);
    let skillInput;
    if(skillInputs.length > 0) {
        skillInput = skillInputs[0]
    }
    else {
        skillInput = parent.getElementsByClassName("other-skill")[0]
    }
    console.log(skillInput);
    skillInput.value = parseInt(skillInput.value) + change;
}

function createNameListener() {
    document.getElementById("random-name").addEventListener("click", function() {
        randomName();
    })
}

function setNames(nationality) {
    if(names.has(nationality)) {
        return names.get(nationality)
    }
    else {
        console.log(nationality + " NOT FOUND. USING AMERICAN");
        return names.get("American");
    }
}

function randomGender() {
    let gender = generateRandomGender();
    if(gender === "M") {
        document.getElementById("sex2").checked = true;
        document.getElementById("sex1").checked = false;
    }
    else {
        document.getElementById("sex1").checked = true;
        document.getElementById("sex2").checked = false;
    }
    return gender;
}

function generateRandomGender() {
    let genderRand = Math.floor(Math.random()*10);
    if((genderRand % 2) === 0) {
        return  "M";
    }
    else {
        return  "F";
    }
}

function randomName(gender) {
    let nationality = document.getElementById("nationality").value;
    document.getElementById("name").value = generateRandomName(nationality, gender);
}

function generateRandomName(nationality, gender) {
    console.log(nationality);
    console.log(gender);
    let national_names = setNames(nationality.toTitleCase());
    console.log(national_names);
    let name;
    if(gender === "M") {
        name = national_names.last.random() + ", " + national_names.female.random()
    }
    else {
        name = national_names.last.random() + ", " + national_names.female.random()
    }
    name += " (" + code_names.random() + ")";
    return name;
}


function setRandomListener() {
    document.getElementById("btnRandom").addEventListener("click", random);
}
function random() {
    randomProfession();
    randomEmployer();
    randomNationality();
    let gender = randomGender();
    randomName(gender);
    randomAge();
    randomEducation();
    randomStats();
    randomBonds();
    randomSkills();
    randomDescription(gender);
    randomSkillImprovements();
    randomGear();
    randomWeapons();
}

function randomEmployer() {
    let profession = document.getElementById("professions").getAttribute("name");
    document.getElementById("employer").value = generateRandomEmployer(profession)[0];
}

function generateRandomEmployer(profession) {
    let raw_employer = (profession_details.get(profession).employer.random().random());
    let prefix = raw_employer[1];
    let employer = raw_employer[0];
    if(cities.includes(raw_employer)) {
        employer = raw_employer;
        if(profession === "firefighter") {
            employer += " Fire Department";
            prefix = "in the";
        }
        else if(profession === "lawyer") {
            employer += " DA's Office";
            prefix = "in the";
        }
        else if(profession === "police-officer") {
            employer += " Police Department";
            prefix = "in the";
        }
        else if(profession === "media-specialist") {
            employer += " " + newspaper_suffixes.random()[0];
            prefix = "at the";
        }
    }
    return [employer, prefix];
}

function randomNationality() {
    document.getElementById("nationality").value = nationalities.random().toTitleCase();
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
    let profession = generateRandomProfession();
    professions.setAttribute("name", profession);
    document.getElementById("profession").value = profession.replaceAll("-", " ").toTitleCase();
}

function generateRandomProfession() {
    let profList = [];
    // let options = document.getElementsByClassName("profession-select")[0].getElementsByTagName("option");
    // for(let i = 0; i < options.length; i ++) {
    //     profList.push(options[i].value)
    // }
    profession_details.forEach((value, key) => {
        profList.push(key);
    });
    console.log(profList);
    return profList.random();
}

function randomEducation() {
    let profession = document.getElementById("professions").getAttribute("name");
    let education = profession_details.get(profession).education.random();
    if(education !== 'High School Diploma') {
        education += " from " + universities.random()[0];
    }
    document.getElementById("education").value = education;
}

function randomStats() {
    let profession = document.getElementById("professions").getAttribute("name");
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
    updateScore("str", document.querySelector("#str-score").value);
    updateScore("dex", document.querySelector("#dex-score").value);
    updateScore("con", document.querySelector("#con-score").value);
    updateScore("int", document.querySelector("#int-score").value);
    updateScore("pow", document.querySelector("#pow-score").value);
    updateScore("cha", document.querySelector("#cha-score").value);
    hPListener();
    updatePow();
}

function randomBonds() {
    let bondNames = document.getElementsByClassName("bond");
    let bondScores = document.getElementsByClassName("bond-score");
    let profession = profession_details.get(document.getElementById("professions").getAttribute("name"));
    let chaScore = document.getElementById("cha-score").value;
    let nationality = document.getElementById("nationality").value;

    let lastName = document.getElementById("name").value.split(",")[0];
    for(let i = 0; i < bondNames.length; i ++) {
        bondNames[i].value = "";
        bondScores[i].value = "";
    }
    let bonds = generateRandomBonds(profession.bonds, lastName, nationality);
    for(let i = 0; i < bonds.length; i ++) {
        bondNames[i].value = bonds[i][0] + " (" + bonds[i][1] + ")";
        bondScores[i].value = chaScore;
    }
}

function generateRandomBonds(numBonds, lastName, nationality) {
    console.log("numBonds: " + numBonds);
    let chosenBonds = [];
    let bondNames = [];
    for(let i = 0; i < numBonds; i ++) {
        let bond = bonds.random();
        while(chosenBonds.includes(bond)) {
            bond = bonds.random();
        }
        chosenBonds.push(bond[0]);
        let name;
        let genderRand = Math.floor(Math.random()*10);
        let nameList;
        let bondLastName;
        if(bond[2] === "Family") {
            if(bond[3] === "Older" || (!nationality.includes("-American") && bond[3] === "Same")) {
                nameList = setNames(nationality.toTitleCase().replace("-American", ""))
            }
            else {
                nameList = names.get("American");
            }
            bondLastName = lastName;
            console.log("FAMILY");
            console.log("LAST NAME " + bondLastName);
        }
        else {
            nameList = names.get("American");
            bondLastName = nameList.last.random();
            console.log("NOT FAMILY")
        }
        console.log("LAST NAME " + bondLastName);
        if(bond[1] === "M" || (bond[1] === "FM" && (genderRand % 2) === 0)) {
            name = nameList.male.random() + " " + bondLastName
        }
        if(bond[1] === "F" || (bond[1] === "FM" && (genderRand % 2) !== 0)) {
            name = nameList.female.random() + " " + bondLastName;
        }
        bondNames.push([name, bond[0]]);
    }
    return bondNames;
}

function pickRandomInput(skillName) {
    console.log("Picking random input for " + skillName);
    return inputSkills.get(skillName).random();
}

function randomSkills() {
    resetSkills();
    resetOtherSkills();
    let profession = document.getElementById("professions").getAttribute("name");
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
            let fullSkillName = skillName;
            while(inputSkills.has(fullSkillName) || skills.has(fullSkillName)) {
                fullSkillName = skillName.replaceAll("-", " ").toTitleCase() + " (" + pickRandomInput(skillName) +")";
            }
            skillName = fullSkillName;
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
        let rand = Math.floor(Math.random()*skill_checks.length);
        console.log(rand);
        console.log(skill_checks[rand]);
        let skill = skill_checks.splice(rand, 1)[0];
        let skillName = skill.getAttribute("name");
        while(skills.has(skillName)) {
            console.log("Skills has " + skillName);
            skill = skill_checks.splice((Math.floor(Math.random()*skill_checks.length)), 1)[0];
            skillName = skill.getAttribute("name");
        }
        console.log("Skill name: " + skillName);
        let fullSkillName;
        if(inputSkills.has(skillName)) {
            fullSkillName = skillName.replaceAll("-", " ").toTitleCase() + " (" + pickRandomInput(skillName) +")";
            console.log("Full skill name " + fullSkillName);
            while(skills.has(fullSkillName)) {
                console.log("Input skill before: " + skillName);
                fullSkillName = skillName.replaceAll("-", " ").toTitleCase() + " (" + pickRandomInput(skillName) +")";
                console.log("Input skill after: " + skillName)
            }
            skillName = fullSkillName
        }
        skills.set(skillName, skill.getAttribute("base"));

    }

    console.log(skills.size + " skills");
    skills.forEach((value, key) => {
        setSkill(value, key)
    })
}

function randomDescription(gender) {

    document.getElementById("description").value = generateRandomDescription(gender);
}

function generateRandomDescription(gender) {
    let descriptionText = "";
    descriptionText += description.eye_description.random() + " " + description.eye_color.random() + " eyes, "
        + description.hair_texture.random() + " " + description.hair_color.random() + " hair, " +
        description.skin.random() + " skin,";
    if(gender === "M" && (Math.floor(Math.random()*2) === 1)) {
        descriptionText += " a " + description.beards.random() + ","
    }
    if((Math.floor(Math.random()*4) === 1)) {
        descriptionText += " " + description.glasses.random() + " glasses,";
    }
    let demeanor = description.demeanor.random();
    descriptionText += " " + description.clothing.random() + " clothing, " + description.speech.random()
        + " speech, and " + getAOrAn(demeanor) + " " + demeanor + " demeanor";
    return descriptionText;
}

function randomSkillImprovements() {
    let pluses = removeInvisiblePluses(document.getElementsByClassName("plus"));
    while(pluses.length > 0) {
        addToSkill(pluses.random(), 20);
        updateSkillIncreaseButtons();
        pluses = removeInvisiblePluses(document.getElementsByClassName("plus"));
    }
}

function getAOrAn(input) {
    if (input.charAt(0).match(/[AEIOUaeiuo]/)) {
        return  'an';
    }
    else return 'a';
}

function removeInvisiblePluses(pluses) {
    let visiblePluses = [];
    for(let i = 0; i < pluses.length; i ++) {
        console.log("Plus " + pluses[i]);
        if(pluses[i].style.display === "none") {
            console.log("Remove plus");
        }
        else {
            visiblePluses.push(pluses[i]);
        }
    }
    console.log("Visible pluses " + visiblePluses.length);
    return visiblePluses;
}

function randomGear() {
    let profession = document.getElementById("professions").getAttribute("name");
    let gear = "";
    profession_details.get(profession).other_gear.forEach(value => {
        gear += value + "\n";
    });
    document.getElementById("gear").value = gear;
}
function randomWeapons() {
    let weaponRows = document.getElementsByClassName("weapon-row");
    for(let i = 0; i < weaponRows.length; i++) {
        weaponRows[i].getElementsByClassName("weapon-select")[0].value = "other";
        weaponRows[i].getElementsByClassName("weapon-name")[0].value = "";
        weaponRows[i].getElementsByClassName("weapon-skill")[0].value = "";
        weaponRows[i].getElementsByClassName("weapon-range")[0].value = "";
        weaponRows[i].getElementsByClassName("weapon-damage")[0].value = "";
        weaponRows[i].getElementsByClassName("weapon-piercing")[0].value = "";
        weaponRows[i].getElementsByClassName("weapon-lethality")[0].value = "";
        weaponRows[i].getElementsByClassName("weapon-kill-radius")[0].value = "";
        weaponRows[i].getElementsByClassName("weapon-ammo")[0].value = "";
    }

    let profession = document.getElementById("professions").getAttribute("name");
    let weaponSelects = document.getElementsByName("weapon-select");
    let weaponNames = document.getElementsByClassName("weapon-name");
    let weapons = profession_details.get(profession).weapons;
    for(let j = 0; j < weapons.length; j ++) {
        console.log(weaponSelects[j]);
        weaponSelects[j].value = weapons[j][0];
        weaponSelectListener(weaponSelects[j]);
        weaponNames[j].value = weapons[j][1];
    }
}

function recalculateWeapons() {
    let weaponSelects = document.getElementsByName("weapon-select");
    for(let j = 0; j < weaponSelects.length; j ++) {
        weaponSelectListener(weaponSelects[j]);
    }
}

function getStrBonusDamage() {
    let str = parseInt(document.getElementById("str-score").value);
    if(1 <= str && str <=4) {
        return -2;
    }
    else if(5 <= str && str <=8) {
        return -1;
    }
    else if(9 <= str && str <=12) {
        return 0;
    }
    else if(13 <= str && str <=16) {
        return 1;
    }
    else {
        return 2;
    }

}

function randomNPC() {
    let nationality = nationalities.random().toTitleCase();
    let gender = generateRandomGender();
    let name = generateRandomName(nationality.toLowerCase(), gender);
    let codeName = name.substring(name.lastIndexOf(" "));
    name = name.substring(0, name.lastIndexOf(" ")-1);
    let nameParts = name.split(" ");
    console.log("name: " + name);
    console.log(nameParts);
    let lastName = nameParts[0].replace(",", "");
    let profession = generateRandomProfession();
    let employer = generateRandomEmployer(profession);
    let description = generateRandomDescription(gender);
    console.log("lastname " + lastName);
    let bonds = generateRandomBonds(profession_details.get(profession).bonds, lastName, nationality);
    let out = "";
    for(let i = 1; i < nameParts.length; i ++) {
        out += nameParts[i].replace(",", "") + " ";
    }
    out += lastName + " is " + getAOrAn(nationality) + " " + nationality + " " + profession.replaceAll("-", " ") + " " + employer[1] + " " + employer[0]
        + " and has " + description + ". Their most important relationships are with ";
    for(let i = 0; i < bonds.length-1; i ++) {
        out += " their " + bonds[i][1].toLowerCase() + " " + bonds[i][0] + ",";
    }
    out += " and their " + bonds[bonds.length-1][1].toLowerCase() + " " + bonds[bonds.length-1][0] + ".";
    return out;
}

function setGenerateNPCListener() {
    document.getElementById("generate-npcs").addEventListener("click", event => {
        let numNPCs = parseInt(document.getElementById('num-npcs').value);
        console.log(numNPCs);
        let npcDiv = document.getElementById("npcs-div");
        for(let i = 0; i < numNPCs; i ++) {
            let div = document.createElement("div");
            div.className =  "npc-div";
            div.textContent = randomNPC();
            npcDiv.appendChild(div);
            npcDiv.appendChild(document.createElement("br"));

        }
    })
}
