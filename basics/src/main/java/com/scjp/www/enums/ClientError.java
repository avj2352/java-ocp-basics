package com.scjp.www.enums;

public enum ClientError {

    /**
     * in built methods include
     * name() - value of enum
     * values() - for looping through an enum
     * valueOf() - comparing a String value to Enum
     */

    UNHANDLED_EXCEPTION(100, "Unhandled Exception"),
    ALREADY_PURCHASED_CONTET(101, "Customer has already purchased Content Insurance");

    private final int code;
    private final String description;
    
    /**
     * All enum constructors are implicitly private
     * @param code
     * @param description
     */
    private ClientError(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() { return this.code; }
    public String getDescription() { return this.description; }

    public String toString() {
        return this.code + " " + this.description;
    }
}

/**
 * Instances within the enum can have their own implementation of abstract methods
 */
enum Season {
    WINTER {
        public String getHours() { return "11am-12pm"; }
    },
    SUMMER, FALL;

    public String getHours() {
        return "9am - 5pm";
    }

}
