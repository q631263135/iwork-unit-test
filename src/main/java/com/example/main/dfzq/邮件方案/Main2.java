package com.example.main.dfzq.邮件方案;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2020/3/23 15:35
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 根据日期规则 获取 具体日期
 */
public class Main2 {

    public static void main(String[] args) throws ParseException {
        String dateRule = "2"; // 提前/顺延
        String dateRule2 = "2"; // 第几个
        int step = Integer.parseInt(dateRule2);
        step = dateRule.equals("1") ? 0 - step : step;

        char dateRule3 = '5'; // 周末/周初/月末/月初
        String dateType = "2"; // 工作日/自然日
        boolean isAdjustDate = dateType.equals("1") ? true : false; // 1-工作日；2-自然日

        String date = "";

        Calendar calendar = Calendar.getInstance();
        switch (dateRule3) {
            case '1': // 周末
                calendar.add(Calendar.WEEK_OF_MONTH, step);

                calendar.setFirstDayOfWeek(Calendar.MONDAY);
                calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6);

                date = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
                if (isAdjustDate) {
                    date = DateUtil.getDateAdjustForward(date, holidayList());
                }

                break;
            case '2': // 周初
                calendar.add(Calendar.WEEK_OF_MONTH, step);

                calendar.setFirstDayOfWeek(Calendar.MONDAY);

                date = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
                if (isAdjustDate) {
                    date = DateUtil.getDateAdjustForward(date, holidayList());
                }

                break;
            case '3': // 月末
                calendar.add(Calendar.MONTH, step);
                calendar.set(Calendar.DATE, calendar.getActualMaximum(calendar.DATE));

                date = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
                if (isAdjustDate) {
                    date = DateUtil.getDateAdjustForward(date, holidayList());
                }

                break;
            case '4': // 月初
                calendar.add(Calendar.MONTH, step);
                calendar.set(Calendar.DATE, calendar.getActualMinimum(calendar.DATE));

                date = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
                if (isAdjustDate) {
                    date = DateUtil.getDateAdjustForward(date, holidayList());
                }

                break;

            case '5': // 季末

                // 获取前/后 几个 季度的月份
                calendar.set(Calendar.MONTH, (calendar.get(Calendar.MONTH) / 3 + step) * 3 + 2);
                calendar.set(Calendar.DATE, calendar.getActualMaximum(calendar.DATE));

                date = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
                if (isAdjustDate) {
                    date = DateUtil.getDateAdjustForward(date, holidayList());
                }

                break;
            case '6': // 季初
                calendar.set(Calendar.MONTH, (calendar.get(Calendar.MONTH) / 3 + step) * 3 + 2);
                calendar.set(Calendar.DATE, calendar.getActualMinimum(calendar.DATE));

                date = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
                if (isAdjustDate) {
                    date = DateUtil.getDateAdjustForward(date, holidayList());
                }

                break;
        }

        System.out.println(date);
    }

    private static List<String> holidayList() {
        return new ArrayList<>();
    }
}
