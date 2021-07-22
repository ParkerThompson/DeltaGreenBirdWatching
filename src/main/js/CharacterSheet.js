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
let foriegn_service = [["US State Department", "at the"]];
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
    ["foreign-service-officer", {'employer': [foriegn_service], 'education': ["PHD in Foreign Affairs", "PHD in International Relations"],
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

maxChecked = new Map();
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

weapons = new Map([
    ['Hand-to-Hand Weapons', new Map([
        ['unarmed', {weapon_name: 'Unarmed Attack', skill: 'unarmed-combat', damage: '1D4-1', armor_piercing: 'N/A', expense: "None"}],
        ['brass_knuckles', {weapon_name: 'Brass knuckles, heavy flashlight, or steel-toe boots', skill: 'unarmed-combat', damage: '1D4', armor_piercing: 'N/A', expense: "Incidental"}],
        ['garotte', {weapon_name: 'Garotte', skill: 'unarmed-combat', damage: 'special', armor_piercing: 'N/A', expense: "Incidental"}],
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
    weapons.forEach((value) => {
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
        modifyPdf();
        // setClassVisibility('dont-print', 'none');
        // setClassVisibility('print', '');
        // html2canvas(document.body).then(function (canvas) {
        //     const imgData = canvas.toDataURL("image/jpeg", 1);
        //     const pdf = new jsPDF("p", "mm", "a4");
        //     const pageWidth = pdf.internal.pageSize.width;
        //     const pageHeight = pdf.internal.pageSize.height;
        //     const imageWidth = canvas.width;
        //     const imageHeight = canvas.height;
        //     const ratio = imageWidth / imageHeight >= pageWidth / pageHeight ? pageWidth / imageWidth : pageHeight / imageHeight;
        //
        //     pdf.addImage(imgData, 'JPEG', 0, 0, imageWidth * ratio, imageHeight * ratio);
        //     pdf.save("character-sheet.pdf");
        // });
        // setClassVisibility('dont-print', '');
        // setClassVisibility('print', 'none');
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
    console.log(value + ": " + key);
    if (value.includes(" ")) {
        addOtherSkill(value.replaceAll(": ", ":\n").replaceAll(") ", ")"), key)
    } else {
        const skill = document.querySelector("#" + value.toLowerCase());
        if (skill != null) {
            skill.value = key;
            skill.setAttribute("prof-base", key)
        }
    }
}

function addOtherSkill(skillName, skillValue) {
    console.log(skillName + ": " + skillValue)
    const skillNames = document.getElementsByClassName("other-skill-name");
    const skills = document.getElementsByClassName("other-skill");
    console.log(skillNames.length);
    for (let i = 0; i < skillNames.length; i++) {
        console.log("skillNames[i].value: " + skillNames[i].value)
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
    for (i = 0; i < professionSelect.length; i++) {
        professionSelect[i].addEventListener("change", function (selChange) {
            setClassVisibility("skill-wrapper", "none");
            const wrapper = document.getElementById(selChange.target.value + "-wrapper");
            wrapper.style.display = "block";

            const skillChecks = document.getElementsByClassName("skill-check");
            for (i = 0; i < skillChecks.length; i++) {
                skillChecks[i].checked = false;
            }
            disableOrEnableUnchecked(false);
            const profSelect = document.querySelector("#professions");
            profSelect.setAttribute("name" ,selChange.target.value);
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
        document.querySelector("#" + profSelect.getAttribute("name") + "-wrapper").style = "visible"
    });

    let skillChecks = document.getElementsByClassName("skill-check");
    for (let i = 0; i < skillChecks.length; i++) {
        skillChecks[i].addEventListener("change", function (event) {
            skillCheckListener(event);
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

function skillCheckListener(event) {
    let skill = event.target.getAttribute("name")
        .replace(/\s\d{1,2}%:/, "")
        .replace(" ", "-")
        .toLowerCase();
    let profession = event.target.id.replace("-check", "")
        .replace("-" + skill, "")
        .replace(/\d/,"");
    updateSkills(profession, event.target.getAttribute("max"))
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
    let skillChecks = document.getElementsByClassName("skill-check");

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

function parseNames() {
    data = readFile("resources/names/code-names.txt");
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
                if(optSkillList[n] !== "") {
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
            return createOptionalSkillInput(profName, skill[0], skill[1], skill[0].replace("-", " ").toTitleCase() + " " + skill[1] + "%:")
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
    input.className = professionName + " skill-check skill-check-input";
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
    input.className = professionName + " skill-check skill-check-name";
    input.id = professionName + "-" + skillName;
    input.value = skillName;
    if(inputSkills.has(skillName)) {
        friendlyName = (skillName.toTitleCase() + friendlyValue + ":\n" + friendlyName.substring(friendlyName.indexOf("(")))
        friendlyValue = "";
        input.name = friendlyName;
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
    skillDiv.className = professionName + " prof-modal default-skill-input " + skillName;

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
    div.className = "skill-radio-div";
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
    let skillDivs = document.getElementsByClassName("skill-container");
    let numIncreases = 0;
    for(let i =0; i < skillDivs.length; i ++) {
        let skills = skillDivs[i].getElementsByClassName("skill");
        let skill;
        if(skills.length === 0) {
            skill = skillDivs[i].getElementsByClassName("other-skill")[0];
        }
        else {
            skill = skills[0]
        }
        let minus = skillDivs[i].getElementsByClassName("minus")[0];
        let plus = skillDivs[i].getElementsByClassName("plus")[0];
        let value = parseInt(skill.value);
        let base = parseInt(skill.getAttribute("prof-base"));

        if(skill.value === "") {
            minus.style = "visibility: hidden;";
            plus.style = "visibility: hidden;";
            continue;
        }
        if(value === base) {
            minus.style = "visibility: hidden;"
        }
        else  {
            minus.style = "";
            numIncreases += ((value-base)/20);
        }
        //No skill can be greater than 80 so disable the 'add 20 points' button if it's above 60
        if(value > 60) {
            plus.style = "visibility: hidden;"
        }
        else {
            plus.style = "";
        }
    }
    if(numIncreases >= 8) {
        let pluses = document.getElementsByClassName("plus");
        for(let i =0; i < pluses.length; i ++) {
            pluses[i].style = "visibility: hidden;"
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
    console.log(parent.getElementsByClassName("flex-row"));
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
        let plus = pluses[i];
        let style = pluses[i].style;
        console.log("Plus " + pluses[i]);
        console.log("Plus style " + pluses[i].style.visibility);
        console.log(pluses[i].style.display === "");
        if(pluses[i].style.visibility === "hidden") {
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

function getValue(id) {
    return document.getElementById(id).value;
}

function  getName() {
    return getValue("name")
}

function getEmployer() {
    return getValue("employer")
}

function getNationality() {
    return getValue("nationality")
}

function getAge() {
    return getValue("age")
}

function getEducation() {
    return getValue("education")
}

function getProfession() {
    return getValue("profession")
}

function isChecked(id) {
    return document.getElementById(id).checked;
}

function setPDFFields() {
    /*
    this.setName = function setName(name) {
    this.setProfession = function setProfession(profession) {
    this.setEmployer = function setEmployer(employer) {
    this.setNationality = function setNationality(nationality) {
    this.setFemale = function setFemale(isFemale) {
    this.setMale = function setMale(isMale) {
    this.setOtherGender = function setOtherGender(isOtherGender) {
    this.setOtherGenderInput = function setOtherGenderInput(gender) {
    this.setAge = function setAge(age) {
    this.setEducation = function setName(education) {
    this.setStr = function setStr (str) {
    this.setStrFive = function setStrFive (strFive) {
    this.setStrFeatures = function setStr (str) {
    this.setDex = function setDex (dex) {
    this.setDexFive = function setDexFive (dexFive) {
    this.setDexFeatures = function setDex (dex) {
    this.setCon = function setCon (con) {
    this.setConFive = function setConFive (conFive) {
    this.setConFeatures = function setCon (con) {
    this.setInt = function setInt (int) {
    this.setIntFive = function setIntFive (intFive) {
    this.setIntFeatures = function setInt (int) {
    this.setPow = function setPow (pow) {
    this.setPowFive = function setPowFive (powFive) {
    this.setPowFeatures = function setPow (pow) {
    this.setCha = function setCha (cha) {
    this.setChaFive = function setChaFive (chaFive) {
    this.setChaFeatures = function setCha (cha) {
    this.setBondOne = function setBondOne (bond) {
    this.setBondOneScore = function setBondOneScore (bond) {
    this.setMaxHp = function setMaxHp (maxHp) {
    this.setCurrHp = function setCurrHp (currHp) {
    this.setMaxWill = function setMaxWill (maxWill) {
    this.setCurrWill = function setCurrWill (currWill) {
    this.setMaxSan = function setMaxSan (maxSan) {
    this.setCurrSan = function setCurrSan (currSan) {
    this.setBreakingPoint = function setBreakingPoint (breakingPoint) {
    this.setMotivations = function setMotivations (motivations) {
    this.setDescriptions = function setDescriptions (descriptions) {
    this.setViolenceOne = function setViolenceOne (violence) {
    this.setViolenceTwo = function setViolenceTwo (violence) {
    this.setViolenceThree = function setViolenceThree (violence) {
    this.setHelplessnessOne = function setHelplessnessOne (helplessness) {
    this.setHelplessnessTwo = function setHelplessnessTwo (helplessness) {
    this.setHelplessnessThree = function setHelplessnessThree (helplessness) {
    this.setAccounting = function setAccounting (accounting) {
    this.setAlertness = function setAlertness (alertness) {
    this.setAnthropology = function setAnthropology (anthropology) {
    this.setArcheology = function setArcheology (archeology) {
    this.setArtInput = function setArtInput (art) {
    this.setArt = function setArt (art) {
    this.setArtillery = function setArtillery (artillery) {
    this.setAthletics = function setAthletics (athletics) {
    this.setBureaucracy = function setBureaucracy (bureaucracy) {
    this.setComputerScience = function setComputerScience (computerScience) {
    this.setCraftInput = function setCraftInput (craft) {
    this.setCraft = function setCraft (craft) {
    this.setCriminology = function setCriminology (criminology) {
    this.setDemolitions = function setDemolitions (demolitions) {
    this.setDisguise = function setDisguise (disguise) {
    this.setDodge = function setDodge (dodge) {
    this.setDrive = function setDrive (drive) {
    this.setFirearms = function setFirearms (firearms) {
    this.setFirstAid = function setFirstAid (firstAid) {
    this.setForensics = function setForensics (forensics) {
    this.setHeavyMachinery = function setHeavyMachinery (heavyMachinery) {
    this.setHeavyWeapons = function setHeavyWeapons (heavyWeapons) {
    this.setHistory = function setHistory (history) {
    this.setHumint = function setHumint (humint) {
    this.setLaw = function setLaw (law) {
    this.setMedicine = function setMedicine (medicine) {
    this.setMeleeWeapons = function setMeleeWeapons (meleeWeapons) {
    this.setMilitaryScienceInput = function setMilitaryScienceInput (militaryScience) {
    this.setMilitaryScience = function setMilitaryScience (militaryScience) {
    this.setNavigate = function setNavigate (navigate) {
    this.setOccult = function setOccult (occult) {
    this.setPersuade = function setPersuade (persuade) {
    this.setPharmacy = function setPharmacy (pharmacy) {
    this.setPilotInput = function setPilotInput (pilot) {
    this.setPilot = function setPilot (pilot) {
    this.setPsychotherapy = function setPsychotherapy (psychotherapy) {
    this.setRide = function setRide (ride) {
    this.setScienceInput = function setScienceInput (science) {
    this.setScience = function setScience (science) {
    this.setSearch = function setSearch (search) {
    this.setSigint = function setSigint (sigint) {
    this.setStealth = function setStealth (stealth) {
    this.setSurgery = function setSurgery (surgery) {
    this.setSurvival = function setSurvival (survival) {
    this.setSwim = function setSwim (swim) {
    this.setUnarmedCombat = function setUnarmedCombat (unarmedCombat) {
    this.setUnnatural = function setUnnatural (unnatural) {
    this.setOtherSkillsOne = function setOtherSkillsOne (otherSkill) {
    this.setOtherSkillsOneScore = function setOtherSkillsOneScore (otherSkill) {
    this.setWounds = function setWounds (wounds) {
    this.setArmor = function setArmor (armor) {
    this.setWeaponA = function setWeaponA (weapon) {
    this.setWeaponASkill = function setWeaponASkill (skill) {
    this.setWeaponABaseRange = function setWeaponABaseRange (range) {
    this.setWeaponADamage = function setWeaponADamage (damage) {
    this.setWeaponAPiercing = function setWeaponAPiercing (piercing) {
    this.setWeaponAKillDamage = function setWeaponAKillDamage(damage) {
    this.setWeaponARadius = function setWeaponARadius(radius) {
    this.setWeaponAAmmo = function setWeaponAAmmo (ammo) {
    this.setNotes = function setNotes (notes) {
    this.setDevelopments = function setDevelopments (developments) {
    this.setSpecialTrainingA = function setSpecialTrainingA (specialTraining) {
    this.setSpecialTrainingASkill = function setSpecialTrainingASkill (specialTraining) {
    this.setSpecialTrainingB = function setSpecialTrainingB (specialTraining) {
    this.setSpecialTrainingBSkill = function setSpecialTrainingBSkill (specialTraining) {
    this.setSpecialTrainingC = function setSpecialTrainingC (specialTraining) {
    this.setSpecialTrainingCSkill = function setSpecialTrainingCSkill (specialTraining) {
    this.setSpecialTrainingD = function setSpecialTrainingD (specialTraining) {
    this.setSpecialTrainingDSkill = function setSpecialTrainingDSkill (specialTraining) {
    this.setSpecialTrainingE = function setSpecialTrainingE (specialTraining) {
    this.setSpecialTrainingESkill = function setSpecialTrainingESkill (specialTraining) {
    this.setSpecialTrainingFSkill = function setSpecialTrainingFSkill (specialTraining) {
    this.setSpecialTrainingF = function setSpecialTrainingF (specialTraining) {
     */
}

async function modifyPdf() {
    let dataLoaded = false;
    let timeoutms = 1000;
    console.log("modifyPdf")
    // import("https://unpkg.com/pdf-lib/dist/pdf-lib.js")
    //     .then(async (PDF) => {
    const url = 'resources/Delta-Green-RPG-Character-Sheet.pdf'
    const existingPdfBytes = await fetch(url).then(res => res.arrayBuffer())
    const pdfDoc = await PDFLib.PDFDocument.load(existingPdfBytes)

    let pdf = new CharacterPDF(pdfDoc)
    pdf.loadDataFromWeb(new CharacterWeb());
    pdf.download();
    // pdf.download();
    // // const helveticaFont = await pdfDoc.embedFont(StandardFonts.Helvetica)
    //
    // const form = pdfDoc.getForm()
    // const fields = form.getFields()
    // // fields.forEach(field => {
    // //     const type = field.constructor.name
    // //     const name = field.getName()
    // //     console.log(`${type}: ${name}`)
    // // });
    // let name = getName();
    // const nameField = form.getTextField('1 LAST NAME FIRST NAME MIDDLE INITIAL')
    // nameField.setText(name)
    //
    // form.getTextField('2 PROFESSION RANK IF APPLICABLE').setText(getProfession())
    // form.getTextField('3 EMPLOYER').setText(getEmployer())
    // form.getTextField('4 NATIONALITY').setText(getNationality())
    // let female = form.getCheckBox('Check Box7');
    // let male = form.getCheckBox('Check Box8');
    // let otherGender = form.getCheckBox('Check Box9');
    // if(isChecked("sex1")) {
    //     female.check();
    // }
    // else {
    //     female.uncheck();
    // }
    // if(isChecked("sex2")) {
    //     male.check();
    // }
    // else {
    //     male.uncheck();
    // }
    // if(isChecked("sex3Check")) {
    //     otherGender.check();
    // }
    // else {
    //     otherGender.uncheck();
    // }
    // // console.log("Box7" + form.getCheckBox('Check Box7').isChecked())
    // // console.log("Box8" + form.getCheckBox('Check Box8').isChecked())
    // // console.lo
    // const pdfBytes = await pdfDoc.save()
    // // id = "profesclassName/>
    // // id = "sex1"
    // // id = "sex2"
    // // id = "sex3Check"
    // // " id=" sex3
    //
    // download(pdfBytes, name + ".pdf", "pdf");
    // });
    // CharacterSheet.js:1702 PDFCheckBox: Check Box7
    // CharacterSheet.js:1702 PDFCheckBox: Check Box8
    // CharacterSheet.js:1702 PDFCheckBox: Check Box9
    // CharacterSheet.js:1702 PDFTextField: SEX
    // CharacterSheet.js:1702 PDFTextField: 6 AGE AND DOB
    // CharacterSheet.js:1702 PDFTextField: 7 EDUCATION AND OCCUPATION
    // CharacterSheet.js:1702 PDFTextField: STR
    // CharacterSheet.js:1702 PDFTextField: STRx5
    // CharacterSheet.js:1702 PDFTextField: STR DISTINGUISHING FEATURES
    // CharacterSheet.js:1702 PDFTextField: CON
    // CharacterSheet.js:1702 PDFTextField: CONx5
    // CharacterSheet.js:1702 PDFTextField: CON DISTINGUISHING FEATURES
    // CharacterSheet.js:1702 PDFTextField: DEX
    // CharacterSheet.js:1702 PDFTextField: DEXx5
    // CharacterSheet.js:1702 PDFTextField: DEX DISTINGUISHING FEATURES
    // CharacterSheet.js:1702 PDFTextField: INT
    // CharacterSheet.js:1702 PDFTextField: INTx5
    // CharacterSheet.js:1702 PDFTextField: INT DISTINGUISHING FEATURES
    // CharacterSheet.js:1702 PDFTextField: POW
    // CharacterSheet.js:1702 PDFTextField: POWx5
    // CharacterSheet.js:1702 PDFTextField: POW DISTINGUISHING FEATURES
    // CharacterSheet.js:1702 PDFTextField: CHA
    // CharacterSheet.js:1702 PDFTextField: CHAx5
    // CharacterSheet.js:1702 PDFTextField: CHA DISTINGUISHING FEATURES
    // CharacterSheet.js:1702 PDFTextField: BOND 1
    // CharacterSheet.js:1702 PDFTextField: BOND 1 SCORE
    // CharacterSheet.js:1702 PDFTextField: BOND 2
    // CharacterSheet.js:1702 PDFTextField: BOND 2 SCORE
    // CharacterSheet.js:1702 PDFTextField: BOND 3
    // CharacterSheet.js:1702 PDFTextField: BOND 3 SCORE
    // CharacterSheet.js:1702 PDFTextField: BOND 4
    // CharacterSheet.js:1702 PDFTextField: BOND 4 SCORE
    // CharacterSheet.js:1702 PDFTextField: BOND 5
    // CharacterSheet.js:1702 PDFTextField: BOND 5 SCORE
    // CharacterSheet.js:1702 PDFTextField: BOND 6
    // CharacterSheet.js:1702 PDFTextField: BOND 6 SCORE
    // CharacterSheet.js:1702 PDFTextField: MAXIMUMHit Points HP
    // CharacterSheet.js:1702 PDFTextField: CURRENTHit Points HP
    // CharacterSheet.js:1702 PDFTextField: MAXIMUMWillpower Points WP
    // CharacterSheet.js:1702 PDFTextField: CURRENTWillpower Points WP
    // CharacterSheet.js:1702 PDFTextField: MAXIMUMSanity Points SAN
    // CharacterSheet.js:1702 PDFTextField: CURRENTSanity Points SAN
    // CharacterSheet.js:1702 PDFTextField: CURRENTBreaking Point BP
    // CharacterSheet.js:1702 PDFTextField: 12 MOTIVATIONS AND MENTAL DISORDERSPSYCHOLOGICAL DATA
    // CharacterSheet.js:1702 PDFTextField: 10 PHYSICAL DESCRIPTION
    // CharacterSheet.js:1702 PDFCheckBox: Check Box1
    // CharacterSheet.js:1702 PDFCheckBox: Check Box2
    // CharacterSheet.js:1702 PDFCheckBox: Check Box3
    // CharacterSheet.js:1702 PDFCheckBox: Check Box4
    // CharacterSheet.js:1702 PDFCheckBox: Check Box5
    // CharacterSheet.js:1702 PDFCheckBox: Check Box6
    // CharacterSheet.js:1702 PDFTextField: Accounting 10
    // CharacterSheet.js:1702 PDFTextField: Alertness 20
    // CharacterSheet.js:1702 PDFTextField: Anthropology 0
    // CharacterSheet.js:1702 PDFTextField: Archeology 0
    // CharacterSheet.js:1702 PDFTextField: Art
    // CharacterSheet.js:1702 PDFTextField: Art 0
    // CharacterSheet.js:1702 PDFTextField: Artillery 0
    // CharacterSheet.js:1702 PDFTextField: Athletics 30
    // CharacterSheet.js:1702 PDFTextField: Bureaucracy 10
    // CharacterSheet.js:1702 PDFTextField: Computer Science 0
    // CharacterSheet.js:1702 PDFTextField: Craft
    // CharacterSheet.js:1702 PDFTextField: Craft 0
    // CharacterSheet.js:1702 PDFTextField: Criminology 10
    // CharacterSheet.js:1702 PDFTextField: Demolitions 0
    // CharacterSheet.js:1702 PDFTextField: Disguise 10
    // CharacterSheet.js:1702 PDFTextField: Dodge 30
    // CharacterSheet.js:1702 PDFTextField: Drive 20
    // CharacterSheet.js:1702 PDFTextField: Firearms 20
    // CharacterSheet.js:1702 PDFTextField: First Aid 10
    // CharacterSheet.js:1702 PDFTextField: Forensics 0
    // CharacterSheet.js:1702 PDFTextField: Heavy Machinery 10
    // CharacterSheet.js:1702 PDFTextField: Heavy Weapons 0
    // CharacterSheet.js:1702 PDFTextField: History 10
    // CharacterSheet.js:1702 PDFTextField: HUMINT 10
    // CharacterSheet.js:1702 PDFTextField: Law 0
    // CharacterSheet.js:1702 PDFTextField: Medicine 0
    // CharacterSheet.js:1702 PDFTextField: Melee Weapons 30
    // CharacterSheet.js:1702 PDFTextField: Military Science
    // CharacterSheet.js:1702 PDFTextField: Military Science 0
    // CharacterSheet.js:1702 PDFTextField: Navigate 10
    // CharacterSheet.js:1702 PDFTextField: Occult 10
    // CharacterSheet.js:1702 PDFTextField: Persuade 20
    // CharacterSheet.js:1702 PDFTextField: Pharmacy 0
    // CharacterSheet.js:1702 PDFTextField: Pilot
    // CharacterSheet.js:1702 PDFTextField: Pilot 0
    // CharacterSheet.js:1702 PDFTextField: Psychotherapy 10
    // CharacterSheet.js:1702 PDFTextField: Ride 10
    // CharacterSheet.js:1702 PDFTextField: Science
    // CharacterSheet.js:1702 PDFTextField: Science 0
    // CharacterSheet.js:1702 PDFTextField: Search 20
    // CharacterSheet.js:1702 PDFTextField: SIGINT 0
    // CharacterSheet.js:1702 PDFTextField: Stealth 10
    // CharacterSheet.js:1702 PDFTextField: Surgery 0
    // CharacterSheet.js:1702 PDFTextField: Survival 10
    // CharacterSheet.js:1702 PDFTextField: Swim 20
    // CharacterSheet.js:1702 PDFTextField: Unarmed Combat 40
    // CharacterSheet.js:1702 PDFTextField: Unnatural 0
    // CharacterSheet.js:1702 PDFTextField: Foreign Languages and Other Skills 1
    // CharacterSheet.js:1702 PDFTextField: Foreign Languages and Other Skills 1 Score
    // CharacterSheet.js:1702 PDFTextField: Foreign Languages and Other Skills 2
    // CharacterSheet.js:1702 PDFTextField: Foreign Languages and Other Skills 2 Score
    // CharacterSheet.js:1702 PDFTextField: Foreign Languages and Other Skills 3
    // CharacterSheet.js:1702 PDFTextField: Foreign Languages and Other Skills 3 Score
    // CharacterSheet.js:1702 PDFTextField: Foreign Languages and Other Skills 4
    // CharacterSheet.js:1702 PDFTextField: Foreign Languages and Other Skills 4 Score
    // CharacterSheet.js:1702 PDFTextField: Foreign Languages and Other Skills 5
    // CharacterSheet.js:1702 PDFTextField: Foreign Languages and Other Skills 5 Score
    // CharacterSheet.js:1702 PDFTextField: Foreign Languages and Other Skills 6
    // CharacterSheet.js:1702 PDFTextField: Foreign Languages and Other Skills 6 Score
    // CharacterSheet.js:1702 PDFTextField: 14 WOUNDS AND AILMENTS_2
    // CharacterSheet.js:1702 PDFTextField: 15 ARMOR AND GEAR
    // CharacterSheet.js:1702 PDFTextField: WEAPONa
    // CharacterSheet.js:1702 PDFTextField: SKILL a
    // CharacterSheet.js:1702 PDFTextField: BASE RANGEa
    // CharacterSheet.js:1702 PDFTextField: DAMAGEa
    // CharacterSheet.js:1702 PDFTextField: ARMOR PIERCINGa
    // CharacterSheet.js:1702 PDFTextField: KILL DAMAGEa
    // CharacterSheet.js:1702 PDFTextField: KILL RADIUSa
    // CharacterSheet.js:1702 PDFTextField: AMMO a
    // CharacterSheet.js:1702 PDFTextField: WEAPONb
    // CharacterSheet.js:1702 PDFTextField: SKILL b
    // CharacterSheet.js:1702 PDFTextField: BASE RANGEb
    // CharacterSheet.js:1702 PDFTextField: DAMAGEb
    // CharacterSheet.js:1702 PDFTextField: ARMOR PIERCINGb
    // CharacterSheet.js:1702 PDFTextField: KILL DAMAGEb
    // CharacterSheet.js:1702 PDFTextField: KILL RADIUSb
    // CharacterSheet.js:1702 PDFTextField: AMMO b
    // CharacterSheet.js:1702 PDFTextField: WEAPONc
    // CharacterSheet.js:1702 PDFTextField: SKILL c
    // CharacterSheet.js:1702 PDFTextField: BASE RANGEc
    // CharacterSheet.js:1702 PDFTextField: DAMAGEc
    // CharacterSheet.js:1702 PDFTextField: ARMOR PIERCINGc
    // CharacterSheet.js:1702 PDFTextField: KILL DAMAGEc
    // CharacterSheet.js:1702 PDFTextField: KILL RADIUSc
    // CharacterSheet.js:1702 PDFTextField: AMMO c
    // CharacterSheet.js:1702 PDFTextField: WEAPONd
    // CharacterSheet.js:1702 PDFTextField: SKILL d
    // CharacterSheet.js:1702 PDFTextField: BASE RANGEd
    // CharacterSheet.js:1702 PDFTextField: DAMAGEd
    // CharacterSheet.js:1702 PDFTextField: ARMOR PIERCINGd
    // CharacterSheet.js:1702 PDFTextField: KILL DAMAGEd
    // CharacterSheet.js:1702 PDFTextField: KILL RADIUSd
    // CharacterSheet.js:1702 PDFTextField: AMMO d
    // CharacterSheet.js:1702 PDFTextField: WEAPONe
    // CharacterSheet.js:1702 PDFTextField: SKILL e
    // CharacterSheet.js:1702 PDFTextField: BASE RANGEe
    // CharacterSheet.js:1702 PDFTextField: DAMAGEe
    // CharacterSheet.js:1702 PDFTextField: ARMOR PIERCINGe
    // CharacterSheet.js:1702 PDFTextField: KILL DAMAGEe
    // CharacterSheet.js:1702 PDFTextField: KILL RADIUSe
    // CharacterSheet.js:1702 PDFTextField: AMMO e
    // CharacterSheet.js:1702 PDFTextField: WEAPONf
    // CharacterSheet.js:1702 PDFTextField: SKILL f
    // CharacterSheet.js:1702 PDFTextField: BASE RANGEf
    // CharacterSheet.js:1702 PDFTextField: DAMAGEf
    // CharacterSheet.js:1702 PDFTextField: ARMOR PIERCINGf
    // CharacterSheet.js:1702 PDFTextField: KILL DAMAGEf
    // CharacterSheet.js:1702 PDFTextField: KILL RADIUSf
    // CharacterSheet.js:1702 PDFTextField: AMMO f
    // CharacterSheet.js:1702 PDFTextField: WEAPONg
    // CharacterSheet.js:1702 PDFTextField: SKILL g
    // CharacterSheet.js:1702 PDFTextField: BASE RANGEg
    // CharacterSheet.js:1702 PDFTextField: DAMAGEg
    // CharacterSheet.js:1702 PDFTextField: ARMOR PIERCINGg
    // CharacterSheet.js:1702 PDFTextField: KILL DAMAGEg
    // CharacterSheet.js:1702 PDFTextField: KILL RADIUSg
    // CharacterSheet.js:1702 PDFTextField: AMMO g
    // CharacterSheet.js:1702 PDFTextField: 17 PERSONAL DETAILS AND NOTES
    // CharacterSheet.js:1702 PDFTextField: 18 DEVELOPMENTS WHICH AFFECT HOME AND FAMILY
    // CharacterSheet.js:1702 PDFTextField: SPECIAL TRAININGa
    // CharacterSheet.js:1702 PDFTextField: SKILL OR STATa
    // CharacterSheet.js:1702 PDFTextField: SPECIAL TRAININGb
    // CharacterSheet.js:1702 PDFTextField: SKILL OR STATb
    // CharacterSheet.js:1702 PDFTextField: SPECIAL TRAININGc
    // CharacterSheet.js:1702 PDFTextField: SKILL OR STATc
    // CharacterSheet.js:1702 PDFTextField: SPECIAL TRAININGd
    // CharacterSheet.js:1702 PDFTextField: SKILL OR STATd
    // CharacterSheet.js:1702 PDFTextField: SPECIAL TRAININGe
    // CharacterSheet.js:1702 PDFTextField: SKILL OR STATe
    // CharacterSheet.js:1702 PDFTextField: SPECIAL TRAININGf
    // CharacterSheet.js:1702 PDFTextField: SKILL OR STATf
    // $.getScript('https://unpkg.com/pdf-lib/dist/pdf-lib.js', async function () {
    //
    // });
    // new Promise((r, j)=>{
    //     let check = () => {
    //         console.warn('checking');
    //         if(dataLoaded)
    //             r();
    //         else if((timeoutms -= 100) < 0)
    //             j('timed out!');
    //         else
    //             setTimeout(check, 100)
    //     };
    //     setTimeout(check, 100)
    // })

}



