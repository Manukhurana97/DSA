package com.example.dsa.NewCode.DP.Strings;

//  n + m - len(lcs)
public class ShortestCommonSupersequence {

    private static String scs(String s, String t) {

        int i = s.length(), j = t.length();
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int l1 = 0; l1 <= s.length(); l1++) {
            for (int l2 = 0; l2 <= t.length(); l2++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = (s.charAt(l1 - 1) == t.charAt(l2 - 1)) ? 1 + dp[l1 - 1][l2 - 1]
                            : Math.max(dp[l1 - 1][l2], dp[l1][l2 - 1]);
            }
        }

        StringBuilder builder = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(i - 1)) {
                dp[i][j] = 1 + dp[i - 1][j - 1];
                builder.append(s.charAt(i - 1));
                i -= 1;
                j -= 1;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    builder.append(s.charAt(i - 1));
                    i -= 1;
                } else {
                    builder.append(s.charAt(j - 1));
                    j -= 1;
                }
            }
        }

        while (i > 0)
            builder.append(s.charAt(i++));
        while (j > 0)
            builder.append(t.charAt(j++));

        return builder.reverse().toString();

    }

}
