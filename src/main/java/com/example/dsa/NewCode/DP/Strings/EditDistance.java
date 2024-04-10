package com.example.dsa.NewCode.DP.Strings;

public class EditDistance {

    private int editDistance(String s1, String s2) {
        return editDistanceRecursion(s1.length(), s2.length(), s1, s2);
    }

    private int editDistanceRecursion(int l1, int l2, String s1, String s2) {

        if (l1 < 0)
            return l2 + 1;
        if (l2 < 0)
            return l1 + 1;

        if (s1.charAt(l1) == s2.charAt(l2)) {
            return editDistanceRecursion(l1 - 1, l2 - 1, s1, s2);
        } else {
            int insertion = editDistanceRecursion(l1 - 1, l2, s1, s2);
            int deletion = editDistanceRecursion(l1, l2 - 1, s1, s2);
            int replace = editDistanceRecursion(l1 - 1, l2 - 1, s1, s2);
            return 1 + Math.min(replace, Math.min(insertion, deletion));
        }
    }

    public static void main(String[] args) {

    }
}
