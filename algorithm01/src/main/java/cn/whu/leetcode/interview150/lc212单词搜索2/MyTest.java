package cn.whu.leetcode.interview150.lc212单词搜索2;

import cn.whu.utils.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyTest extends Solution {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        HashSet<String> set = new HashSet<>();
        set.add("set0");
        set.add("set1");
        ArrayList<String> list = new ArrayList<>();
        list.add("list0");
        list.add("list1");
        Obj obj = new Obj("zs", 19);

        MyTest t = new MyTest();
        print(set);
        print(list);
        print(obj);
        t.func1(set,list,obj);
        print(set);
        print(list);
        print(obj);

    }

    public void func1(Set<String> set, List<String> list,Obj obj){
        set.remove("set0");
        list.remove("list0");
        obj.name="";
        obj.age=0;
    }
}



class Obj{
    public String name;
    public Integer age;
    public Obj(){}
    public Obj(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Obj{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}