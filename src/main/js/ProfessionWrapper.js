
function parseProfessions() {
    const wrappers = [];
    //Read in each profession
    const data = JSON.parse(readFile("resources/professions.txt"));

    //For each profession
    Object.keys(data).forEach(key => {
        let prof = data[key];

        //Creates the wrapper (except for skills)
        const wrapper = createProfessionWrapper(key, prof.skillText, prof.description, prof.stats, prof.bonds, prof.numOptionalSkills);
        const defaultSkills = wrapper.getElementsByClassName("default-skills")[0];
        prof.defaultSkills.forEach(skill => {
            Object.keys(skill).forEach(key => {
                console.log(key + " " + skill[key]);
            })
            let skillChild = getSkillChild(skill.name, skill.value, false, key, wrapper);
            defaultSkills.appendChild(skillChild)
        });
        const optionalSkills = wrapper.getElementsByClassName("optional-skills")[0];
        if(prof.optionalSkills !== undefined) {
            prof.optionalSkills.forEach(skill => {
                optionalSkills.appendChild(getSkillChild(skill.name, skill.value, true, key, wrapper))
            });
        }
        wrappers.push(wrapper);
        maxChecked.set(key, prof.numOptionalSkills);
    });
    return wrappers
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

function getSkillChild(skillString, value, opt, profName, wrapper) {
    if (skillString.includes(" or ")) {
        const exclusiveSkills = (skillString.split(" or "));
        const exclusiveSkillNames = [];
        const exclusiveSkillValues = [];
        const exclusiveSkillFriendlyNames = [];
        let combinedName = profName;
        for (let j = 0; j < exclusiveSkills.length; j++) {
            let skill = exclusiveSkills[j].split(" ");
            combinedName = combinedName + "-" + skill[0];
            exclusiveSkillNames.push(skill[0]);
            exclusiveSkillValues.push(value);
            exclusiveSkillFriendlyNames.push(skill[0].replace("-", " ").toTitleCase() + " " + value + "%")
        }
        return createRadioSkills(profName, combinedName, exclusiveSkillNames, exclusiveSkillValues, exclusiveSkillFriendlyNames)
    }
    else if(skillString.includes("(")) {
        let skill = skillString.split(") ");
        let friendlyName = (skill[0]).replace("-", " ").toTitleCase();
        if (opt) {
            return createOptionalSkill(profName, skill[0].replace(/\s\(.*/, ""), value, friendlyName, " " + value + "%")
        }
        else {
            return createDefaultSkill(profName, skill[0], value, skill[0].replace("-", " ").toTitleCase() + " " + value + "%")
        }
    }

    let skill = skillString.split(" ");
    if (inputSkills.has(skill[0])) {
        if (opt) {
            return createOptionalSkillInput(profName, skill[0], value, skill[0].replace("-", " ").toTitleCase(), " " + value + "%:")
        } else {
            return createSkillInput(profName, skill[0], value, skill[0].replace("-", " ").toTitleCase() + " " + value + "%:", wrapper)
        }
    } else {
        if (opt) {
            return createOptionalSkill(profName, skill[0], value, skill[0].replace("-", " ").toTitleCase(), " " + value + "%")
        } else {
            return createDefaultSkill(profName, skill[0], value, skill[0].replace("-", " ").toTitleCase() + " " + value + "%")
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

    for (let i = 0; i < skillNames.length; i++) {
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
        console.log("SKILL WITH PARAN " + friendlyName)
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