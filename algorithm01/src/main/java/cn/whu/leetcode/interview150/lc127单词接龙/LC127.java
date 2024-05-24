package cn.whu.leetcode.interview150.lc127单词接龙;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;

import java.util.HashSet;
import java.util.List;

public class LC127 extends Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hashSet = new HashSet<>(wordList);
        visited.clear();
        dfs(beginWord, endWord, hashSet, 1);
        return ans;
    }

    int ans = 0;
    HashSet<String> visited = new HashSet<>();

    public void dfs(String begin, String end, HashSet<String> wordList, int k) {
        if (begin.equals(end)) {
            if (ans == 0 || ans > k) ans = k;
            return;
        }
        if(k>wordList.size()+1) return;
        prints(k,begin,wordList.size());
        for (String s : wordList) {
            if (!visited.contains(s) && siNext(s, begin)) {
                visited.add(s);
                dfs(s, end, wordList, k + 1);
                visited.remove(s);//一次只能走一步
            }
        }
    }


    public boolean siNext(String str1, String str2) {
        int d = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) d++;
            if (d > 1) break;
        }
        return d == 1;
    }


    public static void main(String[] args) {
        //test("hit", "cog", "[hot,dot,dog,lot,log,cog]");
        //test("hit", "cog", "[hot,dot,dog,lot,log]");
        test("qa", "sq", "[[si,go,se,cm,so,ph,mt,db,mb,sb,kr,ln,tm,le,av,sm,ar,ci,ca,br,ti,ba,to,ra,fa,yo,ow,sn,ya,cr,po,fe,ho,ma,re,or,rn,au,ur,rh,sr,tc,lt,lo,as,fr,nb,yb,if,pb,ge,th,pm,rb,sh,co,ga,li,ha,hz,no,bi,di,hi,qa,pi,os,uh,wm,an,me,mo,na,la,st,er,sc,ne,mn,mi,am,ex,pt,io,be,fm,ta,tb,ni,mr,pa,he,lr,sq,ye]]");

        //beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]

    }

    private static void test(String beginWord, String endWord, String str) {
        List<String> wordList = HzaUtils.string2List(str);

        //print(wordList);

        LC127 t = new LC127();
        int ans = t.ladderLength(beginWord, endWord, wordList);
        print(ans);
    }

}
