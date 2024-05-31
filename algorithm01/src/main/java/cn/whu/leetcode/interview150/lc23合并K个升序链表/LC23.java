package cn.whu.leetcode.interview150.lc23合并K个升序链表;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.ListNode;
import cn.whu.utils.Solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC23 extends Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = new ListNode();
        ListNode tail = root;
        //for (ListNode list : lists) list.show();
        ListNode def = new ListNode(Integer.MAX_VALUE);

        while (true) {
            ListNode h = def;
            int cnt = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < h.val) {
                    h = lists[i];
                    cnt = i;
                }
            }
            if (h == def) break;
            tail.next = h;
            tail = h;
            lists[cnt]=lists[cnt].next;
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
        LC23 t = new LC23();
        ListNode ans = t.mergeKLists(lists);
        if(ans==null) print("null");
        else ans.show();
    }

}
