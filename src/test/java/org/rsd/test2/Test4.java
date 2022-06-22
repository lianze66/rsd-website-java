package org.rsd.test2;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test4 {

    List<FileHelper> list = new ArrayList<>();
    public List<FileHelper> printFileName(String path) {
        File file = new File(path);

        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                printFileName(f.getPath());
            } else {
                FileHelper fileHelper = new FileHelper();
                fileHelper.setFileName(f.getName());
                fileHelper.setFilePath(f.getPath());
                fileHelper.setFile(true);

                list.add(fileHelper);
            }
        }
        return list;
    }

    @Test
    public void test1() {
        List<FileHelper> list = printFileName("D:/apache-hive-3.1.3");
        for (FileHelper fileHelper : list) {
            System.out.println(fileHelper.getFileName() + "\t" + fileHelper.getFilePath());
        }
    }
}
