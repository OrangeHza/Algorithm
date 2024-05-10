package cn.whu.leetcode.interview150.lc210课程表2;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class LC210 extends Solution {

    public int[] findOrder(int n, int[][] prerequisites) {
        int[] order = new int[n];
        if (prerequisites == null) {
            for (int i = 0; i < n; i++) order[i] = i;
            return order;
        }

        // 创建邻接表 和 入度数组
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        // 入度栈 和 顺序队列
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) s.push(i);
        }

        // 拓扑排序
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.isEmpty()) break;
            Integer pop = s.pop();
            order[cnt++] = pop;
            for (Integer x : adj.get(pop)) {
                inDegree[x]--;
                if (inDegree[x] == 0) {
                    s.push(x);
                }
            }

        }

        if (cnt < n) return new int[0];
        return order;
    }


    public static void main(String[] args) {
        //test(2, "[[1,0]]");
        //test(4, "[[1,0],[2,0],[3,1],[3,2]]");
        //test(1, "[]");
        test(2, "[[0,1],[1,0]]");


    }

    private static void test(int numCourses, String strs) {
        int[][] prerequisites = HzaUtils.string2IntegerArray2D(strs);
        //print2(prerequisites);
        LC210 t = new LC210();
        int[] order = t.findOrder(numCourses, prerequisites);
        print(order);
    }
}
