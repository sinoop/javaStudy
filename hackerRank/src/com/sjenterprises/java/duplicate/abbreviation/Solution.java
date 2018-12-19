package com.sjenterprises.java.duplicate.abbreviation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static final int diff = 'a' - 'A';

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        char[] firstStringArray = a.toCharArray();
        char[] secondStringArray = b.toCharArray();
        int i = 0;
        int j = 0;

        boolean exitFlag = false;
        while (!exitFlag) {
            if (i >= firstStringArray.length || j >= secondStringArray.length) {
                exitFlag = true;
                break;
            }
            while ( i < firstStringArray.length && j < secondStringArray.length) {
                // If chars are same, continue
                if(matches(firstStringArray[i] ,secondStringArray[j])){
                    System.out.println("matched " + firstStringArray[i] + " with " + secondStringArray[j]);
                    i++;
                    j++;
                } else if (firstStringArray[i] >= 'a' && firstStringArray[i] <= 'z' ){
                    System.out.println("skipped " + firstStringArray[i]);
                    i++;
                } else {
                    exitFlag = true;
                    break;
                }
            }
        }

        if(j == secondStringArray.length && matches(firstStringArray[i-1] ,secondStringArray[j-1]) && i < firstStringArray.length ){
            while(i < firstStringArray.length && firstStringArray[i] >= 'a' && firstStringArray[i] <= 'z' ){
                System.out.println("skipped " + firstStringArray[i]);
                i++;
            }
        }



        if (i == firstStringArray.length && j == secondStringArray.length ) return "YES";
//        if(j == secondStringArray.length && i<firstStringArray.length && firstStringArray[i-1] == secondStringArray[j-1]) return "YES";

        return "NO";

    }

    private static boolean matches(char a , char b){
        if(a == b || (a - diff) == b) return true;
        else return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String a = "KXzQ";
        String b = "K";
        System.out.println(abbreviation(a, b));

    }
}

