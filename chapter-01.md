# Java Fundamentals

- _NOTE:_ **"struct"** is a keyword that does not exist in Java.

- **Java 9** & **Java 10** neither of these versions is a Long Term Support (LTS), so after Java 8, Java 11 is the next LTS version.
- The keywords **"final"** & **"static"** positions can be inter-changed.



## Initialize a _final_ variable

The following are the different ways to initialize a variable marked final

```java
/**
* MEmbers marked final can be instantiated in a block OR
* in a constructor
* they CANNOT be re-assigned
*/
public class PolarBear {
    final int age = 10;
    final int fishEaten;
    final String name;
    
    {
        fishEaten = 4; // Compiles
    }
    
    public PolarBear() {
        name = "Robart" // Also compiles
    }
}
```

## Enums

The following is the most complicated way of Defining an Enumeration or Enum class. And it compiles.

### Practical Uses:

This is a very practical way and finds its uses in a RESTful project to define all Client side error responses

```java
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
```

### Another Valid Enum class

The following is also a valid enum class

- Java treats Enum values in a switch-case statement as **implicit** so no need to specify case statements like ``Season.WINTER`
- The following instances / objects within Java API are considered as immutable objects
  - String
  - java.time - package

```java
/**
 * Instances within the enum can have their own implementation of abstract methods
 */
public enum Season {
    WINTER {
        public String getHours() { return "11am-12pm"; }
    },
    SUMMER, FALL;

    public String getHours() {
        return "9am - 5pm";
    }
    
}

/**
 * Another class, accessing Season
*/
import Season;

public class EnumSwitchCase {
    public String testSeason() {
        switch(Season) {
            case SUMMER: // compiles
                System.out.println("Summar starts from: " + Season.SUMMER.getHours());
                break;
            case Season.WINTER:  // DOEST NOT compile
                System.out.println("throws a compiler error: ");
        }
    }
}

```

## NESTED Classes

Nest Classes come in 4 types

- **Inner Class**
  - You need an instance of the Parent class to access the inner class
- **Static nested class**
  - Parent class acts like a namespace to access the inner class, inner class cannot identify the parents instance variables
- **Local Class:**
  - Class defined within a method :scream:_why sweet Lord ?_
- **Anonymous Class:**
  - 

