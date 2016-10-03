package com.ccsi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        TreeNode head=buildTree();
        System.out.println(isBalanced2(head));
    }
    //1.该方法容易理解。
    public static boolean isBalanced1(TreeNode root){
        if(root==null)return true;
        int left=getHeight(root.left);                      //左子树的高度
        int right=getHeight(root.right);                    //右子树的高度
        if(Math.abs(left-right)>1)return false;             //比较左右子树的高度，大于一则返回false
        return isBalanced1(root.left)&&isBalanced1(root.right);  //继续比较下面节点的两子树。
    }
    public static int getHeight(TreeNode root){              //计算树高
        if(root==null)return -1;
        return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }

    //2.九章算法
    public static boolean isBalanced2(TreeNode root){
        return maxDepth(root)!=-1;
    }
    public static int maxDepth(TreeNode root){
        if(root==null)return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        if(left==-1||right==-1||Math.abs(left-right)>1){
            return -1;
        }else {
            return 1+Math.max(left,right);
        }
    }
    public static TreeNode buildTree(){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(5);
        root.right.right=new TreeNode(4);
        root.right.right.left=new TreeNode(9);
        //root.right.right.left.left=new TreeNode(9);
        return root;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

