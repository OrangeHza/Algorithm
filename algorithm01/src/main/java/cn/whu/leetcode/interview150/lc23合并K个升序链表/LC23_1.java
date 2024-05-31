package cn.whu.leetcode.interview150.lc23合并K个升序链表;

import cn.whu.leetcode.interview150.lc117填充每个节点的下一个右侧节点指针2.Node;
import cn.whu.utils.HzaUtils;
import cn.whu.utils.ListNode;
import cn.whu.utils.Solution;

import javax.swing.plaf.nimbus.State;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class LC23_1 extends Solution {

    class Status implements Comparable<Status> {
        int val;
        ListNode list;
        Status(int val, ListNode list) {
            this.val = val;
            this.list = list;
        }
        @Override
        public int compareTo(Status status) {
            return this.val - status.val;
        }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Status> pq = new PriorityQueue<>();
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(new Status(list.val, list));//自动O(logN)维护最小
            }
        }
        ListNode root = new ListNode();
        ListNode tail = root;
        while (!pq.isEmpty()) {
            Status top = pq.poll();
            tail.next = top.list;
            tail = tail.next;
            if (top.list.next != null) {
                pq.offer(new Status(top.list.next.val, top.list.next));
            }
        }
        return root.next;
    }


    public static void main(String[] args) {
        test("[[1,4,5],[1,3,4],[2,6]]");
        test("[]");
        test("[[]]");
    }

    private static void test(String strs) {
        List<List<Integer>> list2D = HzaUtils.string2IntegerList2D(strs);
        ListNode[] lists = new ListNode[list2D.size()];
        for (int i = 0; i < list2D.size(); i++) {
            lists[i] = ListNode.create(list2D.get(i));
        }
        LC23_1 t = new LC23_1();
        ListNode ans = t.mergeKLists(lists);
        if (ans == null) print("null");
        else ans.show();
    }

}
