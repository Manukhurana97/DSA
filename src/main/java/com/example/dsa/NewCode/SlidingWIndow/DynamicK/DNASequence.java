package com.example.dsa.NewCode.SlidingWIndow.DynamicK;

import java.util.*;

public class DNASequence {

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> lst = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        if (s.length() <= 10) return lst;

        int i = 0, j = 0, n = s.length();
        StringBuilder temp = new StringBuilder();

        while (j < n) {
            temp.append(s.charAt(j));

            if ((j - i + 1) > 10) {
                temp.deleteCharAt(0);
                i++;
            }

            map.put(String.valueOf(temp), map.getOrDefault(String.valueOf(temp), 0) + 1);

            j++;
        }


        for (Map.Entry<String, Integer> k_v : map.entrySet()) {
            if (k_v.getValue() > 1) {
                lst.add(k_v.getKey());
            }
        }


        return lst;
    }

    public static List<String> findRepeatedDnaSequences1(String s) {
        List<String> lst = new ArrayList<>();


        if (s.length() <= 10) return lst;

        int i = 0, j = 9, n = s.length();
        Map<String, Integer> map = new HashMap<>();

        while (j < n) {
            var temp = s.substring(i, j+1);
            map.put(String.valueOf(temp), map.getOrDefault(String.valueOf(temp), 0) + 1);

            i++;
            j++;
        }


        for (Map.Entry<String, Integer> k_v : map.entrySet()) {
            if (k_v.getValue() > 1) {
                lst.add(k_v.getKey());
            }
        }


        return lst;
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeat = new HashSet<>();


        int i = 0, j = 9, n = s.length();

        while (j < n) {
            var temp = s.substring(i, j+1);

            if(!seen.add(temp))
                repeat.add(temp);


            i++;
            j++;
        }




        return new ArrayList(repeat);
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
//        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAAA"));
//        System.out.println(findRepeatedDnaSequences("AAAAAAAA"));
    }
}
