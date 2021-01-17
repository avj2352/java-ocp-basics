package com.scjp.www.nested;

public class StaticNestedClasses {

    public static class Nested {
        public int price = 5;
    }


    public static void main(String[] args) {
        Nested nested = new Nested();
        System.out.println("Value of static inner class is: " + nested.price);
    }
    
}
