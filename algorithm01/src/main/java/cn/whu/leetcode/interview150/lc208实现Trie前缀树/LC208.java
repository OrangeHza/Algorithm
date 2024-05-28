package cn.whu.leetcode.interview150.lc208实现Trie前缀树;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;
import cn.whu.utils.TreeNode;

import java.util.TreeMap;

class Trie {

    Trie[] next;
    boolean tail;// 结尾标记 26叉树 前缀相同 结尾应该是唯一的，不必害怕


    public Trie() {
        this.tail = false;
        this.next = new Trie[26]; // 没有头节点，为当前节点开辟空间
        // 直接new 并不会陷入死循环 // 因为并没有new对象，只是声明了长度为26的数组
        //Trie trie = new Trie(); // 写这行就会抱错，循环音乐

    }

    public void insert(String word) {
        Trie now = this;
        for (int i = 0; i < word.length(); i++) {
            int t = word.charAt(i) - 'a';
            if (now.next[t] == null) now.next[t] = new Trie();//这是真正申请对象内存
            now = now.next[t];
        }
        now.tail = true;
    }

    public boolean search(String word) {
        Trie now = this;
        for (int i = 0; i < word.length(); i++) {
            int t = word.charAt(i) - 'a';
            if (now.next[t] == null) return false;
            now = now.next[t];
        }
        return now.tail;
    }

    public boolean startsWith(String prefix) {
        Trie now = this;
        for (int i = 0; i < prefix.length(); i++) {
            int t = prefix.charAt(i) - 'a';
            if (now.next[t] == null) return false;
            now = now.next[t];
        }
        return true;
    }
}

public class LC208 extends Solution {

    public static void main(String[] args) {
        String[] cmds = HzaUtils.string2Strings("[Trie, insert, search, search, startsWith, insert, search]");
        String[] datas = HzaUtils.string2Strings("[[], [apple], [apple], [app], [app], [app], [app]]");
        print(cmds);
        print(datas);

        Trie t = new Trie();
        print("null", "\t");
        for (int i = 1; i < cmds.length; i++) {
            String cmd = cmds[i];
            String data = datas[i];
            if ("insert".equals(cmd)) {
                t.insert(data);
                print("null", "\t");
            } else if ("search".equals(cmd)) {
                boolean b = t.search(data);
                print(b, "\t");
            } else if ("startsWith".equals(cmd)) {
                boolean b = t.startsWith(data);
                print(b, "\t");
            }
        }
        print();

    }


}
