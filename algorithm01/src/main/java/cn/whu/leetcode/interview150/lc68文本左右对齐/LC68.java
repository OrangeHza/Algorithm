package cn.whu.leetcode.interview150.lc68文本左右对齐;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.Solution;

import java.util.ArrayList;
import java.util.List;

public class LC68 extends Solution {

    String getBlankStr(int n) {
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) sb.append(' ');
        return sb.toString();
    }

    String getRow(List<String> temp, int maxWidth) {
        if (temp.size() == 1) return temp.get(0) + getBlankStr(maxWidth-temp.get(0).length());

        int strTotalLen = 0;
        for (String s : temp) strTotalLen += s.length();
        int blankTotalLen = maxWidth - strTotalLen;
        int blankNum = temp.size() - 1;
        // 总长度maxWidth   实际长度len  实际个数n+1  中间空隙n  需要添加的空格数blank
        int simpleBlankLen2 = blankTotalLen / blankNum; // 但间隔 空格数  偏少
        int simpleBlankLen1 = blankTotalLen - (blankNum - 1) * simpleBlankLen2;
        ArrayList<String> ret = new ArrayList<>();
        StringBuilder ans = new StringBuilder(temp.get(0));
        for (int i = 1; i < temp.size(); i++) {
            if (i == 1) ans.append(getBlankStr(simpleBlankLen1));
            else ans.append(getBlankStr(simpleBlankLen2));
            ans.append(temp.get(i));
        }
        return ans.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> ans = new ArrayList<>();
        int len = 0;
        ArrayList<String> temp = new ArrayList<>();

        for (String word : words) {
            if (len + word.length() + 1 <= maxWidth) {
                len += word.length() + 1;
                temp.add(word);
            } else {
                ans.add(getRow(temp, maxWidth));
                // 首行第一个直接进来即可
                temp.clear();
                temp.add(word);
                len = word.length() + 1;
            }
        }

        // 最后一行的需要单独处理
        StringBuilder sb = null;
        if (temp.size() > 0) {
            sb = new StringBuilder(temp.get(0));
            for (int i = 1; i < temp.size(); i++) {
                sb.append(" ").append(temp.get(i));
            }
            String str = sb.toString();
            ans.add(str + getBlankStr(maxWidth - str.length())); // 测试代码写错了 所以末尾要加空格
        }
        return ans;
    }

    public static void main(String[] args) {
        //words = [This, is, an, example, of, text, justification.], maxWidth = 16
        test("[This, is, an, example, of, text, justification.]", 16);
        test("[What, must, be, acknowledgment, shall, be]", 16);
        test("[Science, is, what, we, understand, well, enough, to, explain, to, a, computer., Art, is, everything, else, we, do]", 20);
    }

    private static void test(String strs, int maxWidth) {
        String[] words = HzaUtils.string2Strings(strs);
        LC68 t = new LC68();
        List<String> ans = t.fullJustify(words, maxWidth);
        for (String an : ans) {
            print(an);
        }
        print();
    }
}
