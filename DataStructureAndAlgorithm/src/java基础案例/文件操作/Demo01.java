package java基础案例.文件操作;

import java.io.File;
import java.io.IOException;

/**
 * 演示文件的操作,创建,判断和删除
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
//        File f = new File("src/java基础案例/文件操作/aaa.txt");
//        File f = new File("src\\java基础案例\\文件操作\\bbb.txt");
//        File f = new File("D:\\software\\java\\java_work\\DataStruct\\DataStructureAndAlgorithm\\src\\java基础案例\\文件操作\\ccc.txt");
        File f = new File("D:/software/java/java_work/DataStruct/DataStructureAndAlgorithm/src/java基础案例/文件操作/ccc.txt");
        System.out.println("是否存在"+f.exists());
        System.out.println("是否创建"+f.createNewFile());
        System.out.println("是否存在"+f.exists());
        
        File f2 = new File("src/java基础案例/文件操作/newDir");
        System.out.println("是否存在"+f2.exists());
        System.out.println("是否创建"+f2.mkdirs());
        System.out.println("是否存在"+f2.exists());


        System.out.println(f.delete());
        System.out.println(f2.delete());
    }
}
