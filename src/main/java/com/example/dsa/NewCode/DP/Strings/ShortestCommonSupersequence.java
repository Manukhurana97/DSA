package com.example.dsa.NewCode.DP.Strings;

//  n + m - len(lcs)
public class ShortestCommonSupersequence {

    private static String scs(String s, String t) {

        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int l1 = 0; l1 <= m; l1++) {
            for (int l2 = 0; l2 <= n; l2++) {
                if (l1 == 0 || l2 == 0)
                    dp[l1][l2] = 0;
                else
                    dp[l1][l2] = (s.charAt(l1 - 1) == t.charAt(l2 - 1)) ? 1 + dp[l1 - 1][l2 - 1]
                            : Math.max(dp[l1 - 1][l2], dp[l1][l2 - 1]);
            }
        }

        StringBuilder builder = new StringBuilder();
        int l1 = m, l2 = n;
        while (l1 > 0 && l2 > 0) {
            if (s.charAt(l1 - 1) == t.charAt(l2 - 1)) {
                builder.append(s.charAt(l1 - 1));
                l1--;
                l2--;
            } else {
                if (dp[l1 - 1][l2] > dp[l1][l2 - 1]) {
                    builder.append(s.charAt(l1 - 1));
                    l1--;
                } else {
                    builder.append(t.charAt(l2 - 1));
                    l2--;
                }
            }
        }

        while (l1 > 0)
            builder.append(s.charAt(--l1));
        while (l2 > 0)
            builder.append(t.charAt(--l2));

        return builder.reverse().toString();

    }

}
