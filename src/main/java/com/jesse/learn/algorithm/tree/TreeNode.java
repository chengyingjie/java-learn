package com.jesse.learn.algorithm.tree;

import lombok.Data;

@Data
public class TreeNode {

     TreeNode left;
     TreeNode right;
     String data;

    TreeNode(String data) {
        this.data = data;
    }

//    boolean isSymmetrical(TreeNode pRoot)
//    {
//        /*
//        思路：首先根结点以及其左右子树，左子树的左子树和右子树的右子树相同，
//        左子树的右子树，和右子树的左子树相同。我们采用递归的方式
//        */
//        if(pRoot == null){
//            return false;
//        }
//        return comRoot(pRoot.left, pRoot.right);
//    }
//    public static boolean comRoot(TreeNode left, TreeNode right){
//        if(left == null){
//            return right == null;
//        }
//        if(right == null){
//            return false;//能执行到这一步，说明他的左子树肯定是不为空，此时比较右子树如果为空，那么肯定返回false
//        }
//        if(left.val != right.val){
//            return false;
//        }
//        //能执行到这一步，说明其传进来的左子树和右子树不为null，且对应值相等，此时我们只需要，进行递归比较
//        //传进来的左子树的左子树和传进来右子树的右子树。传进来的左子树的右子树和传进来的右子树的左子树。
//        return comRoot(left.left, right.right) && comRoot(left.right, right.left);
//    }


}
