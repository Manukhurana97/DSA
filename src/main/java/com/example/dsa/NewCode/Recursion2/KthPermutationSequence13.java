package com.example.dsa.NewCode.Recursion2;


import java.util.ArrayList;
import java.util.List;

/**
 * find all the number in factorial
 * create a permutation
 * order the permutation
 */
public class KthPermutationSequence13 {

    public String getFactorialNumbers(int n) {
        System.out.println(n);
        String perm = "";
        for (int i = 1; i <= n; i++) {
            perm += i;
        }
        return perm;
    }

    public String swap(String str, int from, int to) {
        char[] ch = str.toCharArray();
        char temp = ch[from];
        ch[from] = ch[to];
        ch[to] = temp;

        return new String(ch);
    }

    private void allPermutation(String perm, int j, List<String> resp) {

        if (j == perm.length()) {
            resp.add(perm);
            return;
        }
        for (int i = j; i < perm.length(); i++) {
            perm = swap(perm, i, j);
            allPermutation(perm, j + 1, resp);
            perm = swap(perm, j, i);
        }
    }

    private String KthPermutationSequence(int n, int k) {
        var lst = getFactorialNumbers(n);

        List<String> resp = new ArrayList<>();

        allPermutation(lst, 0, resp);

        return resp.get(k - 1);

    }



    /**
    * 4: 1234, fac = 6
     * k = 17-1
     * while(true)
     *      res += lst.get(k / fact):: lst. lst.get(16 /6))=2:: rest = 3
     *      lst.remove(k / fact):: lst.remove(16/6):: lst = 124
     *      k =  k % fact:: 16%6:: k=4
     *      fac = fact/lst.size(): fac=2
     *
     * ----------------------------------------
     *      res+= lst.get(4/2)=2:: rest = 34
     *      lst.remove(4/2):: lst = 12
     *      k = 4/2:: k=2
     *      fact = fact/lst.size():: fac=0
     *
     *---------------------------------------
     *      resp+= lst.get(2/0) resp = 341
     *      lst.remove(2/0):: lst = 1
     *      k = 2%0:: k=2;
     *      fact = fact/lst.size():: fac=0
     *---------------------------------------
     *
    * */

    private String compute(int n, int k) {
        int fact = 1;
        List<Integer> lst = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            fact *= i;
            lst.add(i);
        }

        lst.add(n);
        String ans = "";
        k = k - 1;

        while (true) {
            ans += lst.remove(k / fact);

            if (lst.isEmpty()) {
                break;
            }

            k = k % fact;
            fact = fact /lst.size();
        }
        return ans;
    }

    public static void main(String[] args) {
        KthPermutationSequence13 kthPermutationSequence13 = new KthPermutationSequence13();
//        var a = kthPermutationSequence13.KthPermutationSequence(4, 17);
       var a =  kthPermutationSequence13.compute(4, 17);
        System.out.println(a);



    }
}
