package cn.whu.leetcode.interview150.lc433最小基因变化;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class LC433 extends Solution {

    public int minMutation(String startGene, String endGene, String[] bank) {
        if(startGene.equals(endGene)) return 0;
        if(bank==null||bank.length==0) return -1;
        return dfs(startGene.toCharArray(), endGene.toCharArray(), new HashSet<String>(Arrays.asList(bank)), 0);
    }


    int dfs(char[] now, char[] end, HashSet<String> bank, int deep) {
        if (Arrays.equals(now, end)) return deep;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 8; i++) {
            char c = now[i];
            if (now[i] != end[i]) {
                now[i] = end[i];
                if (bank.contains(new String(now))) {
                    ans = Math.min(ans, dfs(now, end, bank, deep + 1));
                }
                now[i] = c; // 回退 一步只能变一个
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;//即使上层返回-1 ans=-1 返回-1也没事儿
    }

    public static void main(String[] args) {
        test("AACCGGTT", "AACCGGTA", "[AACCGGTA]");
        test("AACCGGTT", "AACCGGTA", "");

    }

    private static void test(String start, String end, String bank_s) {
        String[] bank = HzaUtils.string2Strings(bank_s);
        LC433 t = new LC433();
        int ans = t.minMutation(start, end, bank);
        print(ans);
    }
}
