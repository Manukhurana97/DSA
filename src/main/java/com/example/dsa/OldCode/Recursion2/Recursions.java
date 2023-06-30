package OldCode.Recursion2;


import java.util.Stack;

public class Recursions {


    public static int printNTo1(int num) {

        if (num == 0) return num;

        System.out.println(num);

        return printNTo1(num - 1);

    }


    public static void print1ToN(int num) {

        if (num != 0) print1ToN(num - 1);

        System.out.println(num);
    }

    Node head;

    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static int getHeightOfATree(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeightOfATree(root.left), getHeightOfATree(root.right));
    }


    public static void sortArray(int[] arr, int size) {
        if (size == 1) return;


        for (int i = 0; i < size - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        sortArray(arr, size - 1);

    }


    // time complexity: {On}+{O(NlogN)}+{On} :: O(NlogN)
    // space complexity: O(N)
    public static void sortStackA1(Stack<Integer> stack, int index) {

        if (index == 0) return;

        int i = 0;
        int[] arr = new int[stack.size() - index];

        while (i < arr.length) arr[i++] = stack.pop();


        sortArray(arr, arr.length); // use any sorting also to sort array


        int z = stack.pop();
        i = 0;
        boolean zInserted = false;
        while (i < arr.length) {
            if (!zInserted && z < arr[i]) {
                stack.push(z);
                zInserted = true;
            } else stack.push(arr[i++]);
        }
        if (!zInserted) stack.push(z);


        sortStackA1(stack, index - 1);
    }
//        5,1,6,4,2,3  ->  1, 2, 3, 4, 5
//        5,1,6,4,2 -> 3
//        5,1,6,4   -> 2,3
//        5,1,6     -> 2,3,4
//        5,1       -> 1,2,3,4,
//        5         -> 1,2,3,4,6
//        -       -> 1,2,3,4,5,6
//        bc  : if(stack.size==0) return;
//        ind :
//        hyp :


    // time complexity: {On}+{O(N^2)}+{On} :: O(N^2)
    // space complexity: O(0)
    public static Stack<Integer> sortStackA2(Stack<Integer> stack) {
        if (stack.size() == 0) return stack;

        int a = stack.pop();
        sortStackA2(stack);

        return sortStackA2Impl(stack, a);
    }

    public static Stack<Integer> sortStackA2Impl(Stack<Integer> stack, int a) {
        if (stack.isEmpty() || stack.peek() <= a) {
            stack.push(a);

            return stack;
        }

        int a1 = stack.pop();
        sortStackA2Impl(stack, a);
        stack.push(a1);

        return stack;
    }


    public static void removeElement(Stack<Integer> stack) {
        int mid = stack.size() / 2 + 1;
        removeElementImpl(stack, mid);
    }

    private static void removeElementImpl(Stack<Integer> stack, int mid) {
        if (mid == 0) {
            stack.pop();
            return;
        }

        int a = stack.pop();
        removeElementImpl(stack, --mid);
        stack.push(a);
    }



    private static String grammarS(int n) {
        if (n == 1) return "0";

        String s = grammarS(n - 1);

        StringBuilder temp = new StringBuilder();
        for (Character c : s.toCharArray())
            temp.append((c == '0') ? "01" : "10");
        s = String.valueOf(temp);


        return s;
    }

    public static int kthGrammar1(int n, int k) {
        return grammarS(n).charAt(k - 1) == '1' ? 1 : 0;
    }

    public static int kthGrammar2(int n, int k) {
        if (n == 1 && k == 1) return 0;


        int mid = (int) (Math.pow(2, n - 1) / 2);

        if (k <= mid) return kthGrammar2(n - 1, k);

        return kthGrammar2(n - 1, k - mid)^12;

    }

    public static int kthGrammar3(int N, int K) {
        return Integer.bitCount(K - 1) & 1;
    }

    public static int kthGrammar4(int N, int K) {
        return (N==1)?0:(K-1+kthGrammar4(N-1,(K+1)/2))%2;
    }


    // 3, 'a', 'b', 'c'
    public static void towerOfBarhma(int n, char source, char aux, char destination) {
        if (n == 0) return;

        towerOfBarhma(n - 1, source, destination, aux);

        System.out.println("move disk " + n + " from " + source + " to " + destination);

        towerOfBarhma(n - 1, aux, source, destination);
    }





    /**
     * Find the number of ways in m*n Matrix
     */

    /**
     * we can go in right and bottom direction only.
     * <p>
     * f(n,m)
     * /    \
     * f(n-1, m)  f(n,m-1)
     */
    public static int findWaysInMatrix(int n, int m) {

        if (m == 1 || n == 1) return 1;

        return findWaysInMatrix(n - 1, m) + findWaysInMatrix(n, m - 1);
    }


    /**
     * we have (let) 5 people we will kill current + k and then we will pass the gun to the next person and we need to
     * find out the person who will win the game.
     * */

    /**
     * if( we have 1 person it will the winner.
     * <p>
     * function: from 5 to 4
     * f(n,k) = f(n-1, k)+ .......
     * <p>
     * one we kill the first person start from 0+2 =2
     * original : 0,1,2,3,4
     * first kill: 0,1,3,4 current gun is with 3
     * similar to: 0,1,2,3
     * relation : 0 = 3 , 1 = 4, 2 = 0 , 3 = 1 :: (current + k) % n
     * eg : (1+3)/5 = 4, (2 + 3) % 5 = 0
     * <p>
     * <p>
     * function: from 5 to 4
     * f( n,k ) = ( f ( n - 1, k)  + k ) % n
     * <p>
     * for 5 people
     * f(5,3) {3}: (f(4, 3)+3)%5 {0+2%5=3} -> (f(3, 3)+3)%4 {1+3%4=0} -> (f(2, 3)+3)%3 {1+3%3=1} -> (f(1, 3)+3)%2 {0+3%2=1}
     */
    public static int josephusProb(int n, int k) {

        if (n == 1) return 0;
        return (josephusProb(n - 1, k) + k) % n;

    }


//    --------------------------------------------- String OldCode.Recursion  --------------------------------------------------


    public static boolean palindrome(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;

        return palindrome(str, start + 1, end - 1);
    }


    public static void powerSet(String s, int i, String curr) {
        if (i == s.length()) {
            System.out.println(curr);
            return;
        }

        powerSet(s, i + 1, curr + s.charAt(i));
        powerSet(s, i + 1, curr);
    }

    public static void getSubSets(String s) {
        powerSet(s, 0, "");
    }

    public static String swap(String s, int from, int to) {
        char[] ch = s.toCharArray();
        char temp = ch[from];
        ch[from] = ch[to];
        ch[to] = temp;
        return new String(ch);
    }


    // abc -> {abc, acb, bac, bca, cab, cba}
//                        abc
//                a        b          c
//            abc   abc  bac  bca   cab   cba

    public static void AllPermutation(String s, int l, int r) {
        if (l == r) {
            System.out.println(s);
            return;
        }

        for (int i = l; i <= r; i++) {
            s = swap(s, l, i);
            AllPermutation(s, l + 1, r);
            s = swap(s, l, i);
        }
    }

    public static void AllPermutation(String s) {
        AllPermutation(s, 0, s.length() - 1);
    }


    public static void main(String[] args) {
//        System.out.println(findWaysInMatrix(3,3));
//        System.out.println(josephusProb(5, 3));
        getSubSets("abc");
//        AllPermutation("abc");
    }
}
