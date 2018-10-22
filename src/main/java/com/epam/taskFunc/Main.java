package com.epam.taskFunc;

public class Main {
    public static void main(String[] args) {
        StringConcatination sc = (String str1, String str2) -> str1 + str2;
        System.out.println(sc.doConc("Hello ", "friend"));

    }
}
