package cn.whu.leetcode.interview150.lc212单词搜索2;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC212 extends Solution {

    public List<String> findWords(char[][] board, String[] words) {
        ArrayList<String> ans = new ArrayList<>();
        int m = board.length, n = board[0].length;
        this.visited = new boolean[m][n];
        for (String word : words) {
            loop:for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(board[i][j]==word.charAt(0)) {
                        for (boolean[] booleans : visited) Arrays.fill(booleans,false); // visited数组初始化
                        if(dfs(board,word,i,j,0)){
                            ans.add(word);
                            break loop;
                        }
                    }
                }
            }
        }
        return ans;
    }

    boolean[][] visited;

    public boolean dfs(char[][] board, String word, int i,int j,int k) {
        if(i<0||i>=board.length||j<0||j>=board[0].length||visited[i][j]||board[i][j]!=word.charAt(k)) return false;
        //print(board[i][j]," ");
        visited[i][j] = true;
        if(k==word.length()-1) return true;

        boolean b = dfs(board,word,i+1,j,k+1) ||
                dfs(board,word,i-1,j,k+1) ||
                dfs(board,word,i,j+1,k+1) ||
                dfs(board,word,i,j-1,k+1);
        visited[i][j] = false; // 回退的都改为false
        return b;
    }


    public static void main(String[] args) {
        test("[[o,a,a,n],[e,t,a,e],[i,h,k,r],[i,f,l,v]]", "[oath,pea,eat,rain]");
        test("[[a,b,c],[a,e,d],[a,f,g]]", "[abcdefg,gfedcbaaa,eaabcdgfa,befa,dgc,ade]");
        //test("[[a,b,c],[a,e,d],[a,f,g]]", "[eaabcdgfa]");

    }

    private static void test(String strs, String strs1) {
        char[][] board = HzaUtils.string2CharArray2D(strs);
        String[] words = HzaUtils.string2Strings(strs1);
        print2(board);

        LC212 t = new LC212();
        List<String> ans = t.findWords(board, words);
        print(ans);
        print();
    }

}
