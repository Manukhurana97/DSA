package com.example.dsa.NewCode.SlidingWIndow.DynamicK;

public class MinimumNumberOfFlips {

    public static int minFlips(String s) {
        int n = s.length();
        s += s;
        StringBuilder alt1 = new StringBuilder();
        StringBuilder alt2 = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            alt1.append((i % 2 == 0) ? 0 : 1);
            alt2.append(!(i % 2 == 0) ? 0 : 1);
        }


        int i = 0, j = 0, result = Integer.MAX_VALUE, diff1 = 0, diff2 = 0;
        while (j < s.length()) {

            var ch = s.charAt(j);
            if (ch != alt1.charAt(j)) diff1++;
            if (ch != alt2.charAt(j)) diff2++;



            if (j - i + 1 > n) {
                var ithElement = s.charAt(i);
                if (ithElement != alt1.charAt(i)) diff1--;
                if (ithElement != alt2.charAt(i)) diff2--;
                i++;
            }

            if (j - i + 1 == n) result = Math.min(result, Math.min(diff1, diff2));

            j++;
        }

        return result;
    }


    public static void main(String[] args) {
        String s = "111000";

        System.out.println(minFlips(s));
    }


}
