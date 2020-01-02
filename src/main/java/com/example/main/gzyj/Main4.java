package com.example.main.gzyj;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import javax.swing.JFrame;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/12/21 17:08
 */
public class Main4 {


    public static void main(String[] args) throws ParseException {

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
//        String sendDate = "2019-04-01";
//        String sendDate = "2019-12-31";
//        String sendDate = "2019-12-28";
        String sendDate = "2020-12-02";
//        String sendDate = "2019-12-28";

        int step = 0;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        calendar.setTime(dateFormat.parse(sendDate));

        calendar.add(Calendar.WEEK_OF_MONTH, step);

        int weekNo = calendar.get(Calendar.WEEK_OF_MONTH);

        String currentMonth = new SimpleDateFormat("yyyyMM").format(calendar.getTime());
        System.out.println(currentMonth + "-" + weekNo);

    }
}
