package java基础案例.文件操作;

import java.io.File;

/**
 * 演示list()和listFiles()
 */
public class Demo02 {
    public static void main(String[] args) {
        File dir = new File("D:\\software\\java\\java_work\\DataStruct\\DataStructureAndAlgorithm\\src\\二叉树");
        String[] names = dir.list();
        for(String name : names){
            System.out.println(name);
        }
        System.out.println("-------------------------------------------------");
        File[] files = dir.listFiles();
        for(File file : files){
            System.out.println(file);
        }
    }
}
