package com.experiment08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class IOTest {
    public static void main(String[] args) {
        String fileName = "D:/example/from.txt";

        System.out.println("----- 创建文件 ------");
        createFile(fileName);

        System.out.println("-----  将字符串写入文件 -------");
        // \r\n在txt文本中换行
        String str =
                "白日依山尽\r\n" +
                        "黄河入海流\r\n" +
                        "欲穷千里目\r\n" +
                        "更上一层楼\r\n";
        writeToFile(str, fileName);

        System.out.println("--------- 基于基本IO流实现文件的复制 ----------");
        String toFile = "D:/example/to.txt";
        copyByIO(fileName, toFile);

        System.out.println("--------- 基于NIO实现文件的复制 ----------");
        String toFile2 = "D:/example/to.txt";
        copyByNIO(fileName, toFile2);

        System.out.println("---------- 删除指定文件 -------------");
        deleteFile(toFile);
        System.out.println("---------- 遍历指定目录文件 -------------");
        String dir = "D:/example";
        walkDirectories(dir);
    }

    /**
     * 基于指定文件名称创建目录及文件
     * 如果文件已经存在，则忽略
     *
     * @param fileName
     */
    private static void createFile(String fileName) {
        try {
            Files.createDirectories(Paths.get(fileName).getParent());
            Files.createFile(Paths.get(fileName));
        }catch (FileAlreadyExistsException ignored) {

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提示：文件以字节操作，因此可以
     * 字符串，转字节数组，直接基于Files写入文件
     *
     * @param fileName
     * @param content
     */
    private static void writeToFile(String content, String fileName) {
        try {
            Files.write(Paths.get(fileName),content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 基于基本IO，以及字节数组缓冲区，复制文件
     * 打印显示循环读写循环次数
     *
     * @param sourceFile
     * @param targetFile
     */
    private static void copyByIO(String sourceFile, String targetFile) {
        int b,cnt=0;
        try(FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(targetFile);) {
            while((b = fis.read())!=-1) {
                fos.write(b);
                cnt++;
            }
            System.out.println("Cycle: "+cnt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 基于NIO，实现文件的复制
     *
     * @param sourceFile
     * @param targetFile
     */
    private static void copyByNIO(String sourceFile, String targetFile) {
        try {
            Files.copy(Paths.get(sourceFile), Paths.get(targetFile), REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件
     *
     * @param fileName
     */
    private static void deleteFile(String fileName) {
        try {
            Files.delete(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历打印指定目录下全部目录/文件名称
     *
     * @param dir
     */
    private static void walkDirectories(String dir) {
        try {
            Files.walk(Paths.get(dir)).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

