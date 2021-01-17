# Jackson Introduction

Understanding how to parse, write Java objects into JSON data. Also understanding how serialisation, deserialization of JSON works in Java



## Important Links

- [Course Link](https://app.pluralsight.com/course-player?clipId=2d8253b1-3f83-4ef3-9ed7-cf639c8e1c7c)
- [Link to Maven Repository](https://search.maven.org)
- [Link to the Jackson Library search on Maven](https://search.maven.org/search?q=g:com.fasterxml.jackson.core)



## About Jackson

There are actually 2 versions of Jackson Library / JARs

- Codehouse - _old lib_
- FasterXML - _recent lib_

There are three libraries as part of the Jackson module

- **Jackson Core** - Core module of Jackson which defines Streaming API
- **Jackson Databind** - Converts JSON to & from POJO (Plain Old Java Object). Consists of the ObjectMapper class.
- **Jackson Annotations** - Contains annotations which makes it easy to parse & write JSON data. Consists for example - JsonFormat, JsonSerialize annotations

### i. POM Dependency for Jackson

```xml
<dependencies>
  	<!--For Junit Testing-->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
    	<!--Jackson Libraries-->
  		<!--For Databinding : ObjectMapper class -->
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.11.3</version>
    </dependency>
  	<!--Core: consists of the Streaming API-->
  	<dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>2.11.3</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-annotations</artifactId>
      <version>2.11.3</version>
    </dependency>

  </dependencies>
```





## Creating a Model for JSON data

A Typical Java Model for converting to JSON consists of the following

- **Fields** (Primitive / Custom datatype)
- **Getters & Setters ()**
- **Equals () & Hashcode ()** 
- **toString ()**

``````java
/**
* Data Model for Deductible Object - DeductibleDetail
*/
package org.example.model;

import java.util.Objects;

public class DeductibleDetail {

    private Integer dedutibleId;
    private Integer deductibleValue;
    private String alias;

    public DeductibleDetail() {}

    public DeductibleDetail(Integer dedutibleId, Integer deductibleValue, String alias) {
        this.dedutibleId = dedutibleId;
        this.deductibleValue = deductibleValue;
        this.alias = alias;
    }

   // Getters & Setters
    public Integer getDedutibleId() {
        return dedutibleId;
    }

    public DeductibleDetail setDedutibleId(Integer dedutibleId) {
        this.dedutibleId = dedutibleId;
        return this;
    }

    public Integer getDeductibleValue() {
        return deductibleValue;
    }

    public DeductibleDetail setDeductibleValue(Integer deductibleValue) {
        this.deductibleValue = deductibleValue;
      	return this;
    }

    public String getAlias() {
        return alias;
    }

    public DeductibleDetail setAlias(String alias) {
        this.alias = alias;
      	return this;
    }

   // Equals & Hashcode - For Assert.equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeductibleDetail that = (DeductibleDetail) o;
        return Objects.equals(dedutibleId, that.dedutibleId) &&
                Objects.equals(deductibleValue, that.deductibleValue) &&
                Objects.equals(alias, that.alias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dedutibleId, deductibleValue, alias);
    }

   // toString - for JUnit Testing
    @Override
    public String toString() {
        return "DeductibleDetail{" +
                "dedutibleId=" + dedutibleId +
                ", deductibleValue=" + deductibleValue +
                ", alias='" + alias + '\'' +
                '}';
    }
}

``````



## Serializing & Parsing JSON

In order to parse, write JSON data, we use the `ObjectMapper` class

the `ObjectMapper` class has 2 important methods

| readValue()                                                  | writeValue()                                   |
| ------------------------------------------------------------ | ---------------------------------------------- |
| to Parse or Deserialize JSON data                            | Serialize Java POJOs to JSON objects           |
| Takes 2 arguments - String / File instance, POJO.class       | Takes 2 arguments - file object, POJO instance |
| also has a `readTree()` which can parse InputStream instances | Also similar method - `writeValueAsString()`   |

### i. Write to a JSON file

```java
import com.fasterXML.jackson.databind.*
import java.io.*
  
public class Demo {
  // main method
  public static void main (String [] args) {
    ObjectMapper mapper = new ObjectMapper();
    // Formats / Beautifies JSON output 
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    try {
      DeductibleDetail detail = new DeductibleDetail();
      detail.setAlias("ROBBERY");
      detail.setDeductibleId(12345678);
      detail.setDeductibleValue(45000);
      // create a JSO
      mapper.writeValue(new File("deductible.json"), detail);
    } catch (IOException error) {
      System.out.println("Error occured");
      error.printStackTrae();
    }
  }
}
```

### ii. Read from a JSON file

```java
private void loadData () {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream in = new FileInputStream("src/main/resources/lambda.json");
            // you can parse JsonNode from an InputStream
            JsonNode root = mapper.readTree(in);
            JsonNode deductibleDetails = root.path("deductibles");
            // readValue either takes a String / File instance 
            DeductibleDetail config  = mapper.readValue(deductibleDetails.toString(),  DeductibleDetail.class);
            System.out.println("Config Value is: " + config);
        } catch (IOException err) {
            System.out.println("Error encountered while reading file");
            err.printStackTrace();
        }
    }
```

## Working with List, Array & Enums

The main class that we will 