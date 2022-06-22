package org.rsd.test2;

import org.junit.jupiter.api.Test;

import java.io.File;

public class Test3 {

    void printJavaFileName(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                printJavaFileName(f.getPath());
            } else {
                if (f.getName().endsWith(".java")) {
                    System.out.println(f.getName() + "\t" + f.getPath());
                }
            }
        }
    }

    void searchFile(String path, String fileName) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                searchFile(f.getPath(), fileName);
            } else {
                if (f.getName().equals(fileName)) {
                    System.out.println(f.getName() + "\t" + f.getPath());
                }
            }
        }
    }

    @Test
    public void test1() {
        searchFile("D:\\idea_space\\rsd-website-java\\src", "SysUserController.java");
    }
}
