package cn.whu.utils;

import java.util.LinkedList;
import java.util.Queue;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    //根据数组初始化一个链表 当前对象为链表头
    public ListNode(int[] vals){
        this.val = vals[0];
        ListNode tail = this;
        for (int i = 1; i < vals.length; i++) {
            tail.next = new ListNode(vals[i]);
            tail = tail.next;
        }
    }

    public static ListNode create(int[] vals){
        if(vals.length==0) return null;
        ListNode root = new ListNode(vals[0]);
        ListNode tail = root;
        for (int i = 1; i < vals.length; i++) {
            tail.next = new ListNode(vals[i]);
            tail = tail.next;
        }
        return root;
    }

    public static void show(ListNode head){
        if(head==null) System.out.println("null");
        else head.show();
    }

    public ListNode(Queue<Integer> vals){
        this.val = vals.poll();
        ListNode tail = this;
        while (!vals.isEmpty()){
            tail.next = new ListNode(vals.poll());
            tail = tail.next;
        }
    }

    public static ListNode create(String strs){
        if(strs==null||strs.trim().length()==0) return null;
        String rep = "{[]}";
        for (int i = 0; i < rep.length(); i++) {
            strs = strs.replace(""+rep.charAt(i),"");
        }
        if(strs.trim().length()==0) return null;
        String[] splits = strs.split(",");
        if(splits.length == 0) return null;
        Queue<Integer> q = new LinkedList<Integer>();
        for (String s : splits) {

            Integer i = null;
            try {
                i = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new RuntimeException(s+"不能转换为int");
            }
            q.offer(i);
        }
        return new ListNode(q);
    }

    public static ListNode create(String strs,String sep){
        if(strs==null||strs.trim().length()==0) return null;
        String rep = "{[]}";
        for (int i = 0; i < rep.length(); i++) {
            strs = strs.replace(""+rep.charAt(i),"");
        }
        if(strs.trim().length()==0) return null;
        String[] splits = strs.split(sep);
        if(splits.length == 0) return null;
        Queue<Integer> q = new LinkedList<Integer>();
        for (String s : splits) {

            Integer i = null;
            try {
                i = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new RuntimeException(s+"不能转换为int");
            }
            q.offer(i);
        }
        return new ListNode(q);
    }

    public void show(){
        ListNode p = this;
        while (p!=null){
            System.out.print(p.val+" ");
            p = p.next;
        }
        System.out.println();
    }



}
