var checkIfInstanceOf = function(obj, classFunction) {

    if (obj === null || obj === undefined || typeof classFunction !== "function") {
        return false;
    }

    if (typeof obj !== "object" && typeof obj !== "function") {
        obj = Object(obj);
    }

    let proto = Object.getPrototypeOf(obj);

    while (proto !== null) {

        if (proto === classFunction.prototype) {
            return true;
        }

        proto = Object.getPrototypeOf(proto);
    }

    return false;
};
