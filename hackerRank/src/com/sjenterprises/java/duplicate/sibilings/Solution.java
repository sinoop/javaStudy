package com.sjenterprises.java.duplicate.sibilings;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");



import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int N) {
        //Initialize as 0
        String finalString = "0";

        ArrayList<Character> list = new ArrayList<Character>();
        //Add each char array to the list
        for (char ac : Integer.toString(N).toCharArray()) {
            list.add(ac);
        }
        //Sort desc. Significant bits needs to be the highest
        Collections.sort(list, Collections.reverseOrder());

        //Create the String from the array
        for (char ac : list) {
            finalString += ac;
        }
        return Integer.parseInt(finalString);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int A = 213;
        System.out.println("s.solution(A) = " + s.solution(A));
    }
}