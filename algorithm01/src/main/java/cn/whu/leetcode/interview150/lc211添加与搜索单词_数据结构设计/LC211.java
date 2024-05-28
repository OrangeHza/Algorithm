package cn.whu.leetcode.interview150.lc211添加与搜索单词_数据结构设计;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;

class WordDictionary {

    WordDictionary[] next;
    boolean end; // 是否是end

    public WordDictionary() {
        this.next = new WordDictionary[26];
        this.end = false;
    }

    public void addWord(String word) {
        WordDictionary node = this;
        for (int i = 0; i < word.length(); i++) {
            int t = word.charAt(i) - 'a'; // 插入的时候没有'.'
            if (node.next[t] == null) node.next[t] = new WordDictionary();
            node = node.next[t];
        }
        node.end = true;
    }

    public boolean search(String word) {
        return dfs(this, word, 0);//循环不好写 用递归吧
    }

    public boolean dfs(WordDictionary t, String word, int k) {
        if (k == word.length()) return t.end; // 这里k不要-1  就是最后一个字符的下一个next[c]里面
        int i = word.charAt(k) - 'a';
        if (i >= 0) {// 字符
            if(t.next[i]==null) return false;
            else return dfs(t.next[i], word, k + 1);
        } else {// 通配符 '*'
            for (int j = 0; j < 26; j++) {
                if (t.next[j] != null && dfs(t.next[j], word, k + 1)) return true;
            }
        }
        return false;
    }
}

public class LC211 extends Solution {

    public static void main(String[] args) {

        //System.out.println('.' - 'a');
        //test("[WordDictionary,addWord,addWord,addWord,search,search,search,search]", "[[],[bad],[dad],[mad],[pad],[bad],[.ad],[b..]]");
        test("[WordDictionary,addWord,addWord,addWord,addWord,search,search,addWord,search,search,search,search,search,search]", "[[],[at],[and],[an],[add],[a],[.at],[bat],[.at],[an.],[a.d.],[b.],[a.d],[.]]");
    }

    private static void test(String strs1, String strs2) {
        String[] cmds = HzaUtils.string2Strings(strs1);
        String[] datas = HzaUtils.string2Strings(strs2);

        WordDictionary t = new WordDictionary();
        print("null", "\t");

        for (int i = 1; i < cmds.length; i++) {
            String cmd = cmds[i];
            String data = datas[i];
            if ("addWord".equals(cmd)) {
                t.addWord(data);
                print("null", "\t");
            } else if ("search".equals(cmd)) {
                boolean b = t.search(data);
                print(b, "\t");
            }
        }
    }


}
