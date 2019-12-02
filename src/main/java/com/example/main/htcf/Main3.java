package com.example.main.htcf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.vfs.FileUtil;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/12/14 14:19
 */
public class Main3 {

    public static void main(String[] args) throws IOException {

        File more = new File(
                "C:\\Users\\joyin\\Desktop\\lib1");
        File[] moreFiles = more.listFiles();

        File less = new File("C:\\Users\\joyin\\Desktop\\lib2");
        File[] lessFiles = less.listFiles();

        File[] toDelFiles = new File[moreFiles.length];

        int k = 0;
        for (int i = 0; i < moreFiles.length; i++) {
            File file = moreFiles[i];
            for (int j = 0; j < lessFiles.length; j++) {
                File f = lessFiles[j];
                if (file.getName().equals(f.getName())) {
                    toDelFiles[k++] = file;
                    break;
                }
            }
        }

        for (int i = 0; i < lessFiles.length; i++) {
            File file = toDelFiles[i];
            file.delete();
        }

//        List<File> lessFileList = Arrays.asList(lessFiles);
//        List<File> moreFileList = Arrays.asList(moreFiles);
//        List<File> lessFileList = new ArrayList<>();
//        List<File> moreFileList = new ArrayList<>();
//
//        Collections.addAll(lessFileList, lessFiles);
//        Collections.addAll(moreFileList, moreFiles);
//
//        System.out.println(moreFileList.removeAll(lessFileList));
//
//        System.out.println(moreFileList.size());
//        System.out.println(lessFileList.size());


//        for (int i = 0; i < moreFileList.size(); i++) {
//            File file = moreFileList.get(i);
//            String fileName = file.getName();
//
//            File file1 = new File("D:\\temp\\20191214\\" + fileName);
//            file1.createNewFile();
//            FileCopyUtils.copy(file, file1);
//        }

    }

}
