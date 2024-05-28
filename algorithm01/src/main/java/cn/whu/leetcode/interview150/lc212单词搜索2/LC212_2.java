package cn.whu.leetcode.interview150.lc212单词搜索2;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;
import cn.whu.utils.TreeNode;

import java.util.*;


class Trie {

    String word; // 以我为结尾的单词是哪个
    HashMap<Character, Trie> children; // 就是next

    public Trie() {
        this.children = new HashMap<>();
        this.word = "";
    }

    public void insert(String s) {
        Trie node = this;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new Trie());
            }
            node = node.children.get(c);
        }
        node.word = s;
    }

}

public class LC212_2 extends Solution {

    public List<String> findWords(char[][] board, String[] words) {
        this.ans = new ArrayList<>();//自动去重
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        HashSet<String> wordsSet = new HashSet<>(Arrays.asList(words));//保证全局唯一实例
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) { // 确定起点
                dfs(board, wordsSet, trie, i, j);
            }
        }

        return ans;
    }

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    private void dfs(char[][] board, HashSet<String> words, Trie trie, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        char c = board[i][j];
        Trie next = trie.children.getOrDefault(c, null);
        if (next == null) return;//靠前缀树来减枝叶
        if (!"".equals(next.word)) { // 因为按照trie存在的路径走的，走到了肯定有
            ans.add(next.word);//真正的word在next中
            //words.remove(next.word); // 防止重复
        }
        board[i][j] = '#';//标记为访问过了
        for (int k = 0; k < 4; k++) {
            dfs(board, words, next, i + dx[k], j + dy[k]);
        }
        board[i][j] = c;//访问完回溯 直接回溯当前节点，多省事儿
    }

    List<String> ans;


    public static void main(String[] args) {
        test("[[o,a,a,n],[e,t,a,e],[i,h,k,r],[i,f,l,v]]", "[oath,pea,eat,rain]");
        test("[[a,b,c],[a,e,d],[a,f,g]]", "[abcdefg,gfedcbaaa,eaabcdgfa,befa,dgc,ade]");
        test("[[o,a,b,n],[o,t,a,e],[a,h,k,r],[a,f,l,v]]", "[oa,oaa]");
        //test("[[a,b,c],[a,e,d],[a,f,g]]", "[eaabcdgfa]");

    }

    private static void test(String strs, String strs1) {
        char[][] board = HzaUtils.string2CharArray2D(strs);
        String[] words = HzaUtils.string2Strings(strs1);
        print2(board);

        LC212_2 t = new LC212_2();
        List<String> ans = t.findWords(board, words);
        print(ans);
        print();
    }

}
