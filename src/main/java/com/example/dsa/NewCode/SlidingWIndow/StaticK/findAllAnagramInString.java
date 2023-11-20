package com.example.dsa.NewCode.SlidingWIndow.StaticK;

import java.util.ArrayList;
import java.util.List;

public class findAllAnagramInString {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int i=0, j=0, n=s.length(), k=p.length();
        int[] expected = new int[26];
        int[] actual = new int[26];

        for(var ch: p.toCharArray()) expected[ch-'a'] +=1;

        while(j<n){
            char val = s.charAt(j);
            actual[val-'a'] +=1;

            while(j-i >= k){
                actual[s.charAt(i)-'a'] -=1;
                i++;
            }

            boolean flag=true;
            for(int ii=0;ii<26;ii++){
                if(actual[ii] != expected[ii]) {
                    flag = false;
                    break;
                }
            }

            if(flag){
                result.add(i);
            }

            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }

}
