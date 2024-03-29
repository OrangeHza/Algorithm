package cn.whu.utils;

import java.util.List;

public class Debug {

    public static void print1(List<TreeNode> list){
        for (TreeNode treeNode : list) {
            System.out.print(treeNode.val+" ");
        }
        System.out.println();
    }

    public static void printArr(Object[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i+"\t");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }

}
