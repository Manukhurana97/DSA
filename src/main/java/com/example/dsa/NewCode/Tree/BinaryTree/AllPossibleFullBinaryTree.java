package com.example.dsa.NewCode.Tree.BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AllPossibleFullBinaryTree {
    Map<Integer, List<TreeNode>> map = new HashMap<>(); // cashing

    public List<TreeNode> allPossibleFBT(int n) {

        return backTrack(n);
    }

    private List<TreeNode> backTrack(int n) {
        List<TreeNode> list = new LinkedList<>();
        if (n == 0) {
            return list;
        }
        if (n == 1) {
            list.add(new TreeNode(0));
            return list;
        }
        if (map.containsKey(n)) { // cashing case , if already compute then just retuurn the data
            return map.get(n);
        }

        List<TreeNode> result = new LinkedList<>();
        for (int l = 0; l < n; l++) { // for all the left nodes (0, n-1)
            var r = n - l - 1; // nodes on right (remaining)

            var left = backTrack(l); // get all the left nodes
            var right = backTrack(r); // get all the right nodes

            // create a combination of left and right subtree , to form a tree
            // l : [t1, t2]
            // r : [t3, t4]
            for (var t1 : left) {
                for (var t2 : right) {
                    result.add(new TreeNode(0, t1, t2));
                }
            }

            map.put(n, result);
        }

        return result;

    }
}
