package huawei;

import java.io.*;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-05-22
 **/
public class TestDemos {
    public static void main(String[] args) {
        String content = "Hello World!";
        String filePath = "D:\\java_work\\DataStruct\\DataStructureAndAlgorithm\\src\\huawei\\wenjian.txt";

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            PrintWriter printWriter = new PrintWriter(fileOutputStream);

            printWriter.print(content);

            printWriter.close();
            fileOutputStream.close();

            System.out.println("内容已成功写入文件。");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
