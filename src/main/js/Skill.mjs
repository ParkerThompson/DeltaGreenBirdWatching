class Skill {
    name;
    _input;
    base;
    _profBase;
    _value;
    randomInputs;

    constructor(name, base) {
        this._name = name;
        this._base = base;
        this._value = base;
    }

    constructor(name, base, randomInputs) {
        this._name = name;
        this._base = base;
        this._value = base;
        this._randomInputs = randomInputs;
    }

    get input() {
        return this._input;
    }

    set input(value) {
        this._input = value;
    }

    get profBase() {
        return this._profBase;
    }

    set profBase(value) {
        this._profBase = value;
    }

    get value() {
        return this._value;
    }

    set value(value) {
        this._value = value;
    }

    get hasInput() {
        return this.randomInputs !== undefined;
    }

    get name() {
        return this._name;
    }

    set name(value) {
        this._name = value;
    }

    get base() {
        return this._base;
    }

    set base(value) {
        this._base = value;
    }

    get randomInputs() {
        return this._randomInputs;
    }

    set randomInputs(value) {
        this._randomInputs = value;
    }

    toString() {
        return this._name + ": " + this._value;
    }
}