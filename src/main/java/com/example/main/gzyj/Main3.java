package com.example.main.gzyj;

import sun.applet.Main;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @string 2019/12/3 11:16
 */
public class Main3 {

    public static void main(String[] args) {

        String str = "cba";

        Main3 main3 = new Main3();
        main3.test(str);

        System.out.println(str);

        StringBuilder stringBuilder = new StringBuilder("1122");
        main3.test(stringBuilder);

        System.out.println(stringBuilder);

    }

    private void test(String string) {
        string = "abc";
    }

    private void test(StringBuilder string) {
//        string = new StringBuilder("111222");
        string = string.delete(0, string.length());
        string.append("abc");
    }

}
