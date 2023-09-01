package com.bing.utils;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Dict;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 周期计算过程
 *
 * @author Administrator
 */
public class DateUtils {

    /**
     * 自智网络月报表起止时间计算
     *
     * @param date            前端入参
     * @param databaseMaxDate 数据库最新日期
     * @return 报表开始时间  start 结束时间 end 报表应统计天数 day
     */
    public static Dict getReportDate(String date, final Date databaseMaxDate) {
        ///-- ------------------
        //日期格式 2022-08-26 但只使用 2022-08 （最新月份）
        Date thisYearMonth = DateUtil.date(databaseMaxDate);
        //当前日期是否为下个月报表（如2022-08-26为 9月报表）
        if (DateUtil.dayOfMonth(databaseMaxDate) >= 26) {
            //下个月（最新月份）
            thisYearMonth = DateUtil.offsetMonth(thisYearMonth, 1);
        }
        //解析前端传过来的日期
        DateTime h5Date = DateUtil.parse(date, DatePattern.SIMPLE_MONTH_PATTERN);
        //查询月份的上个月（根据前端日期固定26号）
        DateTime lastDate = DateUtil.offsetMonth(DateUtil.parse(date + "26", DatePattern.PURE_DATE_PATTERN), -1);

        //如果是最新月份 计算出报表开始日期（结束日期是数据库中的最大日期 -> databaseMaxDate）
        if (DateUtil.year(thisYearMonth) == DateUtil.year(h5Date) && DateUtil.month(thisYearMonth) == DateUtil.month(h5Date)) {
            //如果数据库中的日期大于25号，那么报表开始时间就是数据库（databaseMaxDate）月中的26号
            if (DateUtil.dayOfMonth(databaseMaxDate) > 25) {
                //数据库中最大月的 26号 （这里26号是固定的，所以把databaseMaxDate日期重置到1号在 + 25 = 26 ）
                lastDate = DateUtil.offsetDay(DateUtil.beginOfMonth(databaseMaxDate), 25);
            }
            //如果查询最新月报表-结束日期永远是数据库中的最大日期
            h5Date = DateUtil.date(databaseMaxDate);
        } else {
            //如果是历史报表结束日期是 前端传过来月（date）的 25日，开始日期是date上个月的26号
            h5Date = DateUtil.parse(date + "25", DatePattern.PURE_DATE_PATTERN);
        }

        return Dict.create()
                .set("start", DateUtil.format(lastDate, DatePattern.NORM_DATE_PATTERN))
                .set("end", DateUtil.format(h5Date, DatePattern.NORM_DATE_PATTERN))
                .set("day", DateUtil.between(lastDate, h5Date, DateUnit.DAY) + 1);

    }

    /**
     *  java 获取 获取某年某月 所有日期（yyyy-mm-dd格式字符串）
     * @param year
     * @param month
     * @return
     */
    public static List<String> getMonthFullDay(int year, int month){
        SimpleDateFormat dateFormatYYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
        List<String> fullDayList = new ArrayList<>(32);
        // 获得当前日期对象
        Calendar cal = Calendar.getInstance();
        cal.clear();// 清除信息
        cal.set(Calendar.YEAR, year);
        // 1月从0开始
        cal.set(Calendar.MONTH, month-1 );
        // 当月1号
        cal.set(Calendar.DAY_OF_MONTH,1);
        int count = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int j = 1; j <= count ; j++) {
            fullDayList.add(dateFormatYYYYMMDD.format(cal.getTime()));
            cal.add(Calendar.DAY_OF_MONTH,1);
        }
        return fullDayList;
    }

    public static List<String> getYearFullMonth(int year){
        List<String> data = new ArrayList<>();
        try {
            Calendar c = Calendar.getInstance();
            // 定义时间格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            // 开始日期为当前年拼接1月份
            Date startDate = sdf.parse(year + "-01");
            // 结束日期为当前年拼接12月份
            Date endDate = sdf.parse(year + "-12");
            // 设置calendar的开始日期
            c.setTime(startDate);
            // 当前时间小于等于设定的结束时间
            while(c.getTime().compareTo(endDate) <= 0){
                String time = sdf.format(c.getTime());
                data.add(time);
                // 当前月份加1
                c.add(Calendar.MONTH, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }


    /**
     * 获得 当前时间的格式化日期
     *
     * @param pattern 转换的格式
     * @param calendar 操作的维度（年：Calendar.YER、月：Calendar.MONTH、日...）
     * @param difference 时间差（正数加，负数减）
     * @return
     */
    public static String getFormatTime(String pattern, int calendar, int difference){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(calendar, difference);
        Date startData = c.getTime();
        return format.format(startData);
    }

    public static String getToday(){
        return getFormatTime("yyyy-MM-dd",Calendar.DAY_OF_MONTH,0);
    }

    public static String getTwoDaysAgo(){
        return getFormatTime("yyyy-MM-dd",Calendar.DAY_OF_MONTH,-2);
    }

    public static Long parseDate(String dateTime) throws ParseException {

        System.out.println(dateTime);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = dateFormat.parse(dateTime);

        return date.getTime()/1000;

    }

    /**
    * 计算两个日期间的天数
     */
    public static long calculateDurationDays(String sDate,String eDate) {
        LocalDate sDateObj = LocalDate.parse(sDate);
        LocalDate eDateObj = LocalDate.parse(eDate);
        return Math.abs(eDateObj.toEpochDay() - sDateObj.toEpochDay());
    }

    /**
     * 计算该月份的天数
     */
    public static int getMonthToDays(String monthArg) {
        int year = Integer.parseInt(monthArg.substring(0, 4));
        int month = Integer.parseInt(monthArg.substring(5, 7));
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 0;
        }
    }
}
