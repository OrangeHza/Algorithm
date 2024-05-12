package cn.whu.leetcode.interview150.lc433最小基因变化;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class LC433_2_BFS extends Solution {

    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) return 0;
        if (bank == null || bank.length == 0) return -1;
        if (!Arrays.asList(bank).contains(endGene)) return -1;
        HashSet<String> visited = new HashSet<>();

        LinkedList<String> q = new LinkedList<>();
        q.offer(startGene);
        int k = 0;
        while (!q.isEmpty()){
            int size = q.size();
            k++;
            for (int i = 0; i < size; i++) {
                String top = q.poll();
                for (String s : bank) {
                    if(isNext(s,top)&&!visited.contains(s)){
                        q.offer(s);
                        visited.add(s);
                        if(s.equals(endGene)) return k;
                    }
                }
            }
        }
        return -1;
    }

    // 判断s1和s2的距离是否是1
    boolean isNext(String s1, String s2) {
        int k = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) k++;
            if (k > 1) break;
        }
        return k == 1;
    }

    public static void main(String[] args) {
        //test("AACCGGTT", "AACCGGTA", "[AACCGGTA]");
        //test("AACCGGTT", "AACCGGTA", "");
        test("AACCGGTT", "AAACGGTA", "[AACCGATT,AACCGATA,AAACGATA,AAACGGTA]");

    }

    private static void test(String start, String end, String bank_s) {
        String[] bank = HzaUtils.string2Strings(bank_s);
        LC433_2_BFS t = new LC433_2_BFS();
        int ans = t.minMutation(start, end, bank);
        print(ans);
    }
}
