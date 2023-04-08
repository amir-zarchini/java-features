package com.company;

public class Main {

    public static void main(String[] args) {
	    StringToInt stringToInt = (String strs) -> strs.length();
        int length = stringToInt.map("test lambda");
        System.out.println(length);
    }

    interface StringToInt {
        int map(String str);
    }
}
