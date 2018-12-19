package com.sjenterprises.java.duplicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Solution {
    public int solution(int[] A) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int a : A) {
            list.add(a);
        }

        Collections.sort(list);
        System.out.println("list = " + list);
        Integer prev = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > 0) {
                if (prev != list.get(i)) {
                    if ((prev + 1) != list.get(i)) {
                        return prev + 1;
                    }else{
                        prev = list.get(i);
                    }
                } else
                    prev = list.get(i);
                    continue;
            } else
                return 1;

        }
        return prev + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {1,2,3};
        System.out.println("s.solution(A) = " + s.solution(A));
    }

}