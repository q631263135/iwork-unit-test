package com.example.main.dfzq.邮件方案;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2020/2/9 16:25
 */
public class Main1 {

    public static void main(String[] args) {
        String prodPattern = "(.*)\\((.*)\\)$";
        Pattern compile = Pattern.compile(prodPattern);
        Matcher matcher = compile.matcher("slj-自营产品（托管与外包）(N33023)");
        boolean b = matcher.find();
        String group1 = matcher.group(1);
        String group2 = matcher.group(2);

        String filePattern = "D:\\temp\\[yyyy][mm][dd]\\*\\*.pdf";

        File file = new File(filePattern);
        Stack<String> stack = new Stack<String>();

        while (!file.exists()) {

            int i = filePattern.lastIndexOf("\\");
            stack.push(filePattern.substring(i));

            filePattern = filePattern.substring(0, i);
            file = new File(filePattern);
        }

        System.out.println(file.getName());

        List<File> fileList = listFile(file, stack);
        System.out.println(fileList);
    }

    private static List<File> listFile(File file, Stack<String> stack) {
        List<File> files = new ArrayList<File>();

        String popPath = stack.pop();
        File[] listFiles = file.listFiles();

        if (!stack.isEmpty()) {
            if (listFiles != null && listFiles.length > 0) {
                for (int i = 0; i < listFiles.length; i++) { // 我现在在中文状态

                    File file1 = listFiles[i];
                    if (match(file1.getName(), popPath)) {
                        files.addAll(listFile(file1, (Stack<String>) stack.clone()));
                    }
                }
            }
        } else {
            if (listFiles != null && listFiles.length > 0) {
                for (int i = 0; i < listFiles.length; i++) {
                    File file1 = listFiles[i];
                    if (match(file1.getName(), popPath)) {
                        files.add(file1);
                    }
                }
            }
        }
        return files;
    }

    private static int countSlash(String text) {
        Pattern pattern = Pattern.compile("\\\\");

        Matcher matcher = pattern.matcher(text);
        int count = 0;

        while (matcher.find()) { // 如果匹配,则数量+1
            count++;
        }
        return count;
    }

    private static boolean match(String fileName, String pattern) {
        pattern = pattern.substring(1);
        pattern = pattern.replace("[yyyy]", "\\d{4}").replace("[mm]", "\\d{2}")
                .replace("[dd]", "\\d{2}")
                .replace("[prod_code]", "\\w+").replace("[org_name]", "\\+")
                .replace("*", ".*");
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(fileName);
        return matcher.find();
    }
}
