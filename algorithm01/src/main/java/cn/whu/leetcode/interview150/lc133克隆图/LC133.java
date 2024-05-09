package cn.whu.leetcode.interview150.lc133克隆图;

import cn.whu.utils.ListNode;
import cn.whu.utils.Solution;

import java.util.HashMap;
import java.util.Map;

public class LC133 extends Solution {

    public Node cloneGraph(Node root) {
        if(root==null) return null;
        HashMap<Integer, Node> map = new HashMap<>();
        dfs(root,map);
        return map.get(1);
    }

    private void dfs(Node root, Map<Integer, Node> map) {
        map.put(root.val, new Node(root.val));
        for (Node neighbor : root.neighbors) {
            if (!map.containsKey(neighbor.val)) {
                dfs(neighbor, map);
            }
            map.get(root.val).neighbors.add(map.get(neighbor.val)); // 放在判断外面，才能保证所有无向边都在 ！！！千万不要放到if判断里面
        }
    }

    public static void main(String[] args) {
        //test("[[2,4],[1,3],[2,4],[1,3]]");
        test("[]");
    }

    private static void test(String strs) {
        Node root = Node.create(strs);
        Node.show(root);
        LC133 t = new LC133();
        Node ans = t.cloneGraph(root);
        Node.show(ans);
        print();
    }

}
