package cn.whu.leetcode.interview150.lc133克隆图;

import cn.whu.utils.HzaUtils;
import javafx.scene.effect.Bloom;

import java.util.*;

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public static Node create(String strs) {
        int[][] nodes = HzaUtils.string2IntegerArray2D(strs);
        return create(nodes);
    }

    public static Node create(int[][] nodes) {
        // 先创建好各个节点
        int n = nodes.length;
        if(n==0) return null;
        Node[] graph = new Node[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new Node(i + 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                graph[i].neighbors.add(graph[nodes[i][j] - 1]);
            }
        }
        return graph[0];
    }

    public void show() {
        show(this);
    }

    // 对象和方法名都可以访问到 多好
    public static void show(Node root) {
        if(root==null) System.out.println("null");
        else System.out.println(getAdj(root));
    }

    private static ArrayList<ArrayList<Integer>> getAdj(Node root) {
        HashMap<Integer, Node> map = new HashMap<>();
        dfs(root, map);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < map.size() + 1; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (Node neighbor : map.get(i).neighbors) {
                temp.add(neighbor.val);
            }
            ans.add(temp);
        }
        return ans;
    }

    private static void dfs(Node root, Map<Integer, Node> map) {
        map.put(root.val, root);
        for (Node neighbor : root.neighbors) {
            if (!map.containsKey(neighbor.val)) {
                dfs(neighbor, map);
            }
        }
    }


    public static void main(String[] args) {
        Node node = Node.create("[[2,4],[1,3],[2,4],[1,3]]");
        node.show();

    }


}
