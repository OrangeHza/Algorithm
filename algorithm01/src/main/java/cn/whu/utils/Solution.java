package cn.whu.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Solution {

    private static Random random = new Random();

    /**
     * [l,r]的随机整数
     * @param l 起点l
     * @param r 终点r
     * @return
     */
    public static int Random(int l,int r){
        int d = r-l+1;
        return random.nextInt(d)+l;
        // [0,d)+l => [l,d+l) => [l,d+l-1] == [l,r]
        // d就是产生随机数的宽度 但是起点为0，加上一个起点偏移量就符合要求了
    }
    public static Scanner setIn(Class clazz,String in) {
        // 设置当前(给定字节码)包路径下文件的重定向
        String pname = clazz.getPackage().getName().replace(".", "/");
        String path = "src/" + pname + "/" + in;
        //print(path);
        try {
            System.setIn(new FileInputStream(path));
        } catch (FileNotFoundException e) {
            System.out.println("文件"+path+"不存在");
            System.exit(-1);
        }
        return new Scanner(System.in);
    }

    public static void print() {
        System.out.println();
    }

    public static void print(Object obj) {
        System.out.println(obj);
    }
    public static void print(Object obj,String end) {
        System.out.print(obj);
        System.out.print(end);
    }

    public static void print(Object[] arr) {
        System.out.println(Arrays.toString(arr));
    }
    public static void print(Object[] arr,String end) {
        System.out.print(Arrays.toString(arr));
        System.out.print(end);
    }
    public static void print(int[] arr) {
        if(arr==null) {print("null"); return;}
        System.out.println(Arrays.toString(arr));
    }
    public static void print(float[] arr) {
        if(arr==null) {print("null"); return;}
        System.out.println(Arrays.toString(arr));
    }
    public static void print(double[] arr) {
        if(arr==null) {print("null"); return;}
        System.out.println(Arrays.toString(arr));
    }
    public static void print(char[] arr) {
        if(arr==null) {print("null"); return;}
        System.out.println(Arrays.toString(arr));
    }
    public static void print(boolean[] arr) {
        if(arr==null) {print("null"); return;}
        System.out.println(Arrays.toString(arr));
    }

    public static void print2(Object[][] arr) {
        System.out.println("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("]");
    }
    public static void print2(int[][] arr) {
        System.out.println("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("]");
    }
    public static void print2(double[][] arr) {
        System.out.println("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("]");
    }
    public static void print2(float[][] arr) {
        System.out.println("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("]");
    }
    public static void print2(char[][] arr) {
        System.out.println("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                if(j>0) System.out.print(",");
                System.out.print(arr[i][j]);
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
    public static void print2(boolean[][] arr) {
        System.out.println("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("]");
    }

    public static void prints(Object... args) {
        for (Object arg : args)  print(arg," ");
        System.out.println();
        //尝试了大半天了  基本类型无法统一处理  这是java的弊端
        // int -> Object 可以强转 (其实是自动装箱)
        // int[][]->Object 不行 二维无法强转  或者说无法自动装箱
    }


    // IO

    /**
     * 根据全路径创建文件
     * 目录不存在，自动创建
     * @param path
     * @return
     */
    public static boolean createFile(String path){
        File file = new File(path);


        try {
           return file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("文件创建失败");
        }
    }

    public static boolean mkdirs(String path){
        File file = new File(path);
        return file.mkdirs();
    }


}
