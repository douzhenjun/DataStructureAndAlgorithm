package java基础案例.匹配新目录下的package声明;

import java.io.*;
import java.nio.file.*;
import java.util.regex.*;

/**
 * 修复 Java 文件的 package 声明，使其与文件实际所在目录匹配
 * 
 * 功能:
 * - 遍历 src 目录下所有.java 文件
 * - 检查 package 声明是否与文件实际路径一致
 * - 如果不一致，自动修正 package 声明
 * 
 * 使用方法:
 * 1. 编译：javac -encoding UTF8 java基础案例.匹配新目录下的package声明.FixPackageDeclarations.java
 * 2. 运行：java java基础案例.匹配新目录下的package声明.FixPackageDeclarations
 */
public class FixPackageDeclarations {
    private static int fixedCount = 0;
    private static int totalCount = 0;
    
    public static void main(String[] args) throws IOException {
        Path srcPath = Paths.get("D:\\java_work\\DataStructureAndAlgorithm\\src");
        
        // 可以通过参数指定 src 目录
        if (args.length > 0) {
            srcPath = Paths.get(args[0]);
        }
        
        System.out.println("开始检查 package 声明...");
        System.out.println("源目录：" + srcPath.toAbsolutePath());
        System.out.println();
        
        fixAllFiles(srcPath);
        
        System.out.println("==========================================");
        System.out.println("共检查文件数：" + totalCount);
        System.out.println("已修复文件数：" + fixedCount);
        System.out.println("==========================================");
    }
    
    /**
     * 递归处理目录下所有 Java 文件
     */
    private static void fixAllFiles(Path srcPath) throws IOException {
        Files.walk(srcPath)
            .filter(p -> p.toString().endsWith(".java"))
            .forEach(FixPackageDeclarations::fixFile);
    }
    
    /**
     * 修复单个文件的 package 声明
     */
    private static void fixFile(Path filePath) {
        totalCount++;
        try {
            // 读取文件内容
            String content = new String(Files.readAllBytes(filePath), "UTF-8");
            String[] lines = content.split("\\r?\\n");
            
            if (lines.length == 0) return;
            
            // 提取 package 声明
            Pattern pattern = Pattern.compile("^package\\s+([^\\s;]+)\\s*;");
            Matcher matcher = pattern.matcher(lines[0]);
            
            if (matcher.matches()) {
                String currentPkg = matcher.group(1);
                
                // 计算期望的包名 (基于文件实际路径)
                Path srcRoot = Paths.get("D:\\java_work\\DataStructureAndAlgorithm\\src");
                Path relativePath = srcRoot.relativize(filePath.getParent());
                String expectedPkg = relativePath.toString().replace("\\", ".");
                
                // 如果当前包名与期望包名不匹配，则修复
                if (!currentPkg.equals(expectedPkg)) {
                    lines[0] = "package " + expectedPkg + ";";
                    
                    // 写回文件
                    String newContent = String.join("\n", lines);
                    Files.write(filePath, newContent.getBytes("UTF-8"));
                    
                    System.out.println("✓ 已修复：" + filePath.getFileName());
                    System.out.println("  原包名：" + currentPkg);
                    System.out.println("  新包名：" + expectedPkg);
                    System.out.println();
                    
                    fixedCount++;
                }
            }
        } catch (IOException e) {
            System.err.println("✗ 处理文件时出错：" + filePath);
            e.printStackTrace();
        }
    }
}
