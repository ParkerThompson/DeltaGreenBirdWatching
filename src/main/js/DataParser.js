const ROOT = "charactercreator:8099/";

const skillRegex = /([\[\]{}"])/g;

function get(path) {
    const request = new XMLHttpRequest();
    request.open("GET", path, false);
    request.send(null);
    return request.responseText;
}

function parseSkills() {
    return JSON.parse(get(ROOT + "skills"));
}

function parseEmployers() {
    let data = get(ROOT + "employers.txt");
    let employers = new Map();
    let employerTexts = data.split('\n');
    employerTexts.forEach(value => {
        let values = [];
        let employerParts = value.split(";");
        for(let i = 1; i < employerParts.length; i++) {
            values.push(employerParts[i]);
        }
        employers.set(employerParts[0], values);
    });
    return employers;
}

function getWeapons() {
    return JSON.parse(get(ROOT + "weapons"));

}
