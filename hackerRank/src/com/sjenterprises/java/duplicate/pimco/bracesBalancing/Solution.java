package com.sjenterprises.java.duplicate.pimco.bracesBalancing;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the braces function below.
    static String[] braces(String[] values) {
        String[] returnArray = new String[values.length];
        int i = 0;
        for (String aString : values) {
            boolean balancedFlag = true;
            Stack<Character> bracesStack = new Stack<>();
            char[] thisArray = aString.toCharArray();
            for (char aChar : thisArray) {
                if (aChar == '{' || aChar == '(' || aChar == '[') {
                    bracesStack.push(aChar);
                } else if (aChar == '}' || aChar == ')' || aChar == ']') {
                    if(bracesStack.isEmpty()){
                        balancedFlag = false;
                        break;
                    } else{
                        char topChar = bracesStack.peek();
                        if ((topChar == '{' && aChar == '}') || (topChar == '(' && aChar == ')') || (topChar == '[' && aChar == ']')) {
                            bracesStack.pop();
                        } else {
                            balancedFlag = false;
                            break;
                        }
                    }
                }
            }

            if (balancedFlag && bracesStack.size() == 0) {
                returnArray[i++] = "YES";
            } else {
                returnArray[i++] = "NO";
            }
        }

        return returnArray;
    }

    public static void main(String[] args) {
        String[] x = {"}][}}(}][))]",
                "[](){()}",
                "()",
                "({}([][]))[]()",
                "{)[](}]}]}))}(())(",
                "([[)"};

        Arrays.stream(braces(x)).forEach(yy -> System.out.println(yy));
        ;
    }
}

