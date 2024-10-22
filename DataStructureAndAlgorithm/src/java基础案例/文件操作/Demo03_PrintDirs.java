package java基础案例.文件操作;

import java.io.File;

/**
 * 利用递归思想打印多层目录
 */
public class Demo03_PrintDirs {
    public static void main(String[] args) {
        File dir = new File("D:\\software\\java\\java_work\\DataStruct\\DataStructureAndAlgorithm\\src\\二叉树");
        printDir(dir);
    }

    private static void printDir(File dir){
        File[] files = dir.listFiles();
        for(File file : files){
            if(file.isFile()){
                System.out.println("文件名"+file.getAbsolutePath());
            }else{
                System.out.println("目录名"+file.getAbsolutePath());
                printDir(file);
            }
            System.out.println("-------------------------");
        }
    }
    
}
