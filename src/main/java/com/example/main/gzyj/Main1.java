package com.example.main.gzyj;

import com.example.util.DateUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import org.springframework.util.StringUtils;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/12/3 10:53
 */
public class Main1 {


    public static void main(String[] args) throws ParseException {
        List<String> holidayList = Arrays
                .asList(new String[]{"2019-01-01", "2019-01-05", "2019-01-06", "2019-01-12", "2019-01-13", "2019-01-19",
                        "2019-01-20", "2019-01-26", "2019-01-27", "2019-02-02", "2019-02-03", "2019-02-05",
                        "2019-02-06",
                        "2019-02-07", "2019-02-08", "2019-02-09", "2019-02-10", "2019-02-16", "2019-02-17",
                        "2019-02-23",
                        "2019-02-24", "2019-03-02", "2019-03-03", "2019-03-09", "2019-03-10", "2019-03-16",
                        "2019-03-17",
                        "2019-03-23", "2019-03-24", "2019-03-30", "2019-03-31", "2019-04-05", "2019-04-06",
                        "2019-04-07",
                        "2019-04-13", "2019-04-14", "2019-04-20", "2019-04-21", "2019-04-27", "2019-05-01",
                        "2019-05-02",
                        "2019-05-03", "2019-05-04", "2019-05-11", "2019-05-12", "2019-05-18", "2019-05-19",
                        "2019-05-25",
                        "2019-05-26", "2019-06-01", "2019-06-02", "2019-06-07", "2019-06-08", "2019-06-09",
                        "2019-06-15",
                        "2019-06-16", "2019-06-22", "2019-06-23", "2019-06-29", "2019-06-30", "2019-07-06",
                        "2019-07-07",
                        "2019-07-13", "2019-07-14", "2019-07-20", "2019-07-21", "2019-07-27", "2019-07-28",
                        "2019-08-03",
                        "2019-08-04", "2019-08-10", "2019-08-11", "2019-08-17", "2019-08-18", "2019-08-24",
                        "2019-08-25",
                        "2019-08-31", "2019-09-01", "2019-09-07", "2019-09-08", "2019-09-13", "2019-09-14",
                        "2019-09-15",
                        "2019-09-17", "2019-09-22", "2019-09-27", "2019-09-28", "2019-09-29", "2019-10-01",
                        "2019-10-02",
                        "2019-10-03", "2019-10-04", "2019-10-05", "2019-10-06", "2019-10-07", "2019-10-12",
                        "2019-10-13",
                        "2019-10-15", "2019-10-19", "2019-10-20", "2019-10-26", "2019-10-27", "2019-11-02",
                        "2019-11-03",
                        "2019-11-09", "2019-11-10", "2019-11-16", "2019-11-17", "2019-11-23", "2019-11-24",
                        "2019-11-30", "2019-12-01",
                        "2019-12-07", "2019-12-08", "2019-12-14", "2019-12-15", "2019-12-21", "2019-12-22",
                        "2019-12-28",
                        "2019-12-29", "2019-12-30"});

        String date;
        int step = -1;
        String weekOf = "";

        String sendDate = "2019-12-10";
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        calendar.setTime(dateFormat.parse(sendDate));

        calendar.add(Calendar.WEEK_OF_MONTH, step);

        if (!StringUtils.isEmpty(weekOf)) {
            if (weekOf.equals("L")) {
                calendar.setFirstDayOfWeek(Calendar.MONDAY);
                calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6);
            } else {
                calendar.setFirstDayOfWeek(Calendar.MONDAY);
                calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + Integer.parseInt(weekOf) - 1);
            }

            date = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
            date = DateUtil.getDateAdjustForward(date, holidayList);
            date = date.replace("-", "");

            System.out.println(date);
        } else {
            int w = calendar.get(Calendar.WEEK_OF_MONTH);
            date = String.valueOf(w + step);
            String currentMonth = new SimpleDateFormat("yyyyMM").format(calendar.getTime());
            date = currentMonth + "-" + date;
        }

    }
}
