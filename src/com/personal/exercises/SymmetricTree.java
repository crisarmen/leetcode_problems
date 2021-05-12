package com.personal.exercises;

import com.personal.exercises.utils.TreeNode;

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        } else {
            return symm(root.left, root.right);
        }
    }

    private boolean symm(TreeNode t1, TreeNode t2) {
        if(t1 == null) {
            return t2 == null;
        } else if (t2 == null) {
            return false;
        } else {
            return t1.val == t2.val &&
                    symm(t1.left, t2.right) &&
                    symm(t1.right, t2.left);
        }
    }
}
