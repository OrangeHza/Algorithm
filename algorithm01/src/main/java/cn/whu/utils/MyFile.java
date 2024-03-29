package cn.whu.utils;

import java.io.File;
import java.io.IOException;


public class MyFile extends Solution{

    /**
     * 文件名
     */
    public String name;

    /**
     * 文件所在目录
     */
    public String dir;

    /**
     * 文件全路径名
     */
    public String allName;
    public String path;


    /**
     * 文件类型：文件or目录
     */
    public String type;

    /**
     * 文件后缀名
     */
    public String extend;


    /**
     * 文件本身 File类型
     */
    public File file;


    public MyFile(String allName) {

        this.file = new File(allName);

        this.name = file.getName();
        this.dir = file.getParent();
        this.allName = allName;
        this.path = allName;

        String[] split = file.getName().split("\\.");
        char c = allName.charAt(allName.length() - 1);
        if(split.length<=1||c=='/'||c=='\\'){
            this.extend = "这是目录";
            this.type = "dir";
        }else {
            this.extend = split[1];
            this.type = "file";
        }

    }

    @Override
    public String toString() {
        String sep = "\n";

        return "MyFile{" + sep +
                "allName='" + allName + '\'' + sep +
                "path='" + path + '\'' + sep +
                "dir='" + dir + '\'' + sep +
                "name='" + name + '\'' + sep +
                "file=" + file + sep +
                "type=" + type + sep +
                '}';
    }




    public boolean createFile() {

        // 文件所在目录不存在 先创建
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        if (!this.file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("创建文件失败");
            }
        }
        return true;
    }

    // delete
    /*public boolean delete(){
        return this.file.delete();
    }*/

    public boolean save(){
        boolean ans = false;
        if("file".equals(this.type)) ans = this.createFile();
        else ans =  this.file.mkdirs();

        if(ans==false){
            throw new RuntimeException("创建失败,同名目录或文件均只能出现一个");
        }else {
            return true;
        }
    }

    public String[] list(){
        File dir = this.file;
        if("file".equals(this.type)){
            dir = dir.getParentFile();
        }
        File[] files = dir.listFiles();
        String[] list = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            list[i] = files[i].getName();
        }
        return list;
    }

    public static void main(String[] args) {
        MyFile file = new MyFile("E:/temp/java/hza2.TXT");

        System.out.println(file);

        //System.out.println(file.file.isFile());
        //System.out.println(file.file.isDirectory());

        //System.out.println(file);
        //
        //System.out.println(file.file.isDirectory());
        //System.out.println(file.file.isFile());

        //System.out.println(file.save());


        //System.out.println(file.file.listFiles().length);
        //for (File listFile : file.file.listFiles()) {
        //    System.out.println(listFile);
        //}
        //System.out.println(file.file.listFiles());

        print(file.list());

    }

}
