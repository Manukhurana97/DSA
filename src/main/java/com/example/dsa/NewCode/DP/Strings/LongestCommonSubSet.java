package com.example.dsa.NewCode.DP.Strings;

// subsequece : continus order (consequtive)
public class LongestCommonSubSet {

    private static int lcs(String s1, String s2) {
        return lcsRecursion(s1.length() - 1, s1, s2.length() - 1, s2);
    }

    // base case
    // iterate all path
    // return max;
    private static int lcsRecursion(int l1, String s1, int l2, String s2) {

        if (l1 == 0 || l2 == 0) {
            return 0;
        }

        if (s1.charAt(l1) == s2.charAt(l2))
            return 1 + lcsRecursion(l1 - 1, s1, l2 - 1, s2);
        return lcsRecursion(l1 - 1, s1, l2 - 1, s2);

    }

    public static void main(String[] args) {

        String s1 = "abcd";
        String s2 = "abzd";
        System.out.println(lcs(s1, s2));
    }

}
