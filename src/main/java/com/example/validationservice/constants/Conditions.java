package com.example.validationservice.constants;

public enum Conditions {
    NEW,
    OPEN_BOX,
    CERTIFIED_REFURBISHED,
    SELLER_REFURBISHED,
    USED;

    static public boolean isCondition(String aName) {
        Conditions[] conditions = Conditions.values();
        for (Conditions itemCondition : conditions) {
            if (itemCondition.toString().equals(aName)) {
                return true;
            }
        }
        return false;
    }
}

