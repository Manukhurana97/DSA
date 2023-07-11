package com.example.dsa.NewCode.Recursion2;

import java.util.ArrayList;
import java.util.List;

public class palandromepartiton11 {

    private boolean isPalindrome(String s, int i, int n) {
        while (i < n) {
            if (s.charAt(i++) != s.charAt(n--)) {
                return false;
            }
        }
        return true;
    }

    private void palindromePartition(List<List<String>> listList, List<String> list, String s, int index) {
        if (index == s.length()) {
            listList.add(new ArrayList<>(list));
            return;
        }


        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                list.add(s.substring(index, i + 1));
                palindromePartition(listList, list, s, index + 1);
                list.remove(list.size() - 1);
            }
        }
    }


    public List<List<String>> partition(String s) {
        List<List<String>> listList = new ArrayList<>();
        this.palindromePartition(listList, new ArrayList<>(), s, 0);
        return listList;
    }


    public static void main(String[] args) {
        palandromepartiton11 palandromepartiton11 = new palandromepartiton11();
        var response = palandromepartiton11.partition("aab");
        for (var i : response) {
            System.out.println(i);
        }
    }
}
