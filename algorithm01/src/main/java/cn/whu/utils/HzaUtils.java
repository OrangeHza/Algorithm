package cn.whu.utils;

import java.util.*;

public class HzaUtils {
    public static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void shuffle(int[] array) {
        Random rnd = new Random();
        int size = array.length;
        for (int i = size; i > 1; i--) {
            swap(array, i - 1, rnd.nextInt(i));
        }
    }

    public static int[] randomArray(int n) {
        int lastVal = 1;
        Random r = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            int v = lastVal + Math.max(r.nextInt(10), 1);
            array[i] = v;
            lastVal = v;
        }
        shuffle(array);
        return array;
    }

    public static int[] evenArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i * 2;
        }
        return array;
    }

    public static int[] sixteenArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i * 16;
        }
        return array;
    }

    public static int[] lowSameArray(int n) {
        int[] array = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = r.nextInt() & 0x7FFF0002;
        }
        return array;
    }

    public static String replace(String strs, String rep) {
        //String rep = "{[]}";
        for (int i = 0; i < rep.length(); i++) {
            strs = strs.replace("" + rep.charAt(i), "");
        }
        return strs;
    }

    public static String[] string2Strings(String strs) {
        if (strs == null || strs.trim().length() == 0) return null;
        strs = replace(strs, "{[]}");
        String[] split = strs.split(",");
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].trim();
        }
        return split;
    }


    public static int[] string2Ints(String strs) {
        if (strs == null || strs.trim().length() == 0) return null;
        strs = replace(strs, "{[]}");

        String[] split = strs.split(",");
        int[] ans = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                int x = Integer.parseInt(split[i].trim());
                ans[i] = x;
            } catch (NumberFormatException e) {
                throw new RuntimeException("无法转换为int数组，有非法元素存在");
            }
        }
        return ans;
    }

    public static Integer[] string2Integers(String strs) {
        if (strs == null || strs.trim().length() == 0) return null;
        strs = replace(strs, "{[]}");

        String[] split = strs.split(",");
        Integer[] ans = new Integer[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                int x = Integer.parseInt(split[i].trim());
                ans[i] = x;
            } catch (NumberFormatException e) {
                ans[i] = null;
            }
        }
        return ans;
    }


    public static double[] string2Doubles(String strs) {
        if (strs == null || strs.trim().length() == 0) return null;
        strs = replace(strs, "{[]}");

        String[] split = strs.split(",");
        double[] ans = new double[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                double x = Double.parseDouble(split[i].trim());
                ans[i] = x;
            } catch (NumberFormatException e) {
                throw new RuntimeException("无法转换为int数组，有非法元素存在");
            }
        }
        return ans;
    }

    public static String[][] string2StringArray2D(String strs) {
        List<List<String>> lists = HzaUtils.string2StringList2D(strs);
        int m = lists.size();
        int n = lists.get(0).size();
        String[][] array = new String[m][n];
        if (m == 0 || n == 0) return array;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = lists.get(i).get(j);
            }
        }
        return array;
    }

    public static char[][] string2CharArray2D(String strs) {
        List<List<String>> lists = HzaUtils.string2StringList2D(strs);
        int m = lists.size();
        int n = lists.get(0).size();
        char[][] array = new char[m][n];
        if (m == 0 || n == 0) return array;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String s = lists.get(i).get(j);
                if (s.length() == 1) {
                    array[i][j] = s.charAt(0);
                } else {
                    throw new RuntimeException(s + " 无法转换为char");
                }
            }
        }
        return array;
    }

    // string2StringArry
    // string2StringList2D
    public static List<List<String>> string2StringList2D(String strs) {

        if (strs == null || strs.trim().length() == 0) return null;
        strs = strs.trim();
        strs = strs.replaceAll(" ", "");//去掉所有的空格 输入字符串就可以随意打空格了

        Stack<String> stack = new Stack<>();

        String[] split = strs.split("],\\[");//   根据 ],[ 进行拆分即可
        if (split.length == 1) split = strs.split("]\n,\\["); // 根据 ]\n,[ 进行拆分
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].replaceAll("\\[", "");//去掉多余的修饰符
            split[i] = split[i].replaceAll("]", "");
            split[i] = split[i].replaceAll("\"", "");//去掉引号 完全不必要 完全用不着啊
            split[i] = split[i].trim();
            //System.out.println(split[i]);// a,b
            String[] ss = split[i].split(",");
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < ss.length; j++) {
                list.add(ss[j]);
            }
            ans.add(list);
        }
        return ans;
    }

    public static <T> List<T> string2List(String strs) {
        String[] strings = string2Strings(strs);
        ArrayList<T> list = new ArrayList<>();
        for (String string : strings) {
            list.add((T) string);
        }
        return list;
    }



    public static List<List<Integer>> string2IntegerList2D(String strs) {

        List<List<Integer>> ans = new ArrayList<>();

        List<List<String>> lists = string2StringList2D(strs);
        for (List<String> list : lists) {
            List<Integer> ints = new ArrayList<>();
            for (String s : list) {
                try {
                    if (s.trim().length() != 0) {//空串直接忽略
                        int i = Integer.parseInt(s);
                        ints.add(i);
                    }
                } catch (NumberFormatException e) {
                    throw new RuntimeException(s + " 无法转换为Integer");
                }
            }
            ans.add(ints);
        }

        return ans;
    }

    public static int[][] string2IntegerArray2D(String strs) {

        if ("[]".equals(strs)) return new int[0][];

        List<List<String>> lists = string2StringList2D(strs);
        int m = lists.size(), n = lists.get(0).size();
        int[][] ans = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                try {
                    int x = Integer.parseInt(lists.get(i).get(j));
                    ans[i][j] = x;
                } catch (NumberFormatException e) {
                    throw new RuntimeException("无法转换为整数:" + lists.get(i).get(j));
                }
            }
        }
        return ans;
    }


    public static void printList(List<TreeNode> list) {
        for (TreeNode treeNode : list) {
            System.out.print(treeNode.val + " ");
        }
        System.out.println();
    }

    public static void print2DimArr(Object[][] arr) {
        for (Object[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static void print2DimIntArr(int[][] arr) {
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        Integer[][] ints = {
                {1, 2, 3},
                {4, 5, 6}
        };
        print2DimArr(ints);
    }


}


