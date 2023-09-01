package com.bing.utils;

import com.bing.exception.ServiceException;
import lombok.Data;

import java.util.Date;

/**
 * @Description cron工具类
 * @Author zhj
 * @Date 2022/11/25 9:31
 */
public class CronUtils {
  public static String getCronString(Date currDate,String hhmm,int dayInterval) {
    Date hmDate = DateUtils.dateTime("hh:mm",hhmm);
    if (hmDate == null){
      throw  new ServiceException("录入的时间格式不正确");
    }
    CronObject cronObject = new CronObject();
    cronObject.setHours(DateUtils.getHour(hmDate)+"");
    cronObject.setMinutes(DateUtils.getMinute(hmDate)+"");
    cronObject.setDayOfMonthInterval(dayInterval);
    if (dayInterval == 1){
      cronObject.setDayOfMonth("1");
      return cronObject.getCronString();
    }else {
      if (DateUtils.getDay(currDate) % dayInterval == 0){
        cronObject.setDayOfMonth(dayInterval + "");
      }else {
        cronObject.setDayOfMonth(DateUtils.getDay(currDate) % dayInterval+"");
      }
      return cronObject.getCronString();
    }
  }

  public static void main(String[] args) {
    String cron = getCronString(new Date(),"10:20",3);
    System.out.println(cron);
  }

  @Data
  static class CronObject{

    /**
     * seconds
     */
    private String seconds = "0";
    /**
     * minutes
     */
    private String minutes = "0";
    /**
     * 小时
     */
    private String hours = "0";
    /**
     * 日期
     */
    private String dayOfMonth = "1";
    /**
     * month
     */
    private String month = "*";
    /**
     * 周几
     */
    private String dayOfWeek = "?";
    /**
     * 年
     */
    private String year = "*";
    /**
     * 日期间隔
     */
    private Integer dayOfMonthInterval = 1;

    public String getCronString(){
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append(seconds);
      stringBuffer.append(" ");
      stringBuffer.append(minutes);
      stringBuffer.append(" ");
      stringBuffer.append(hours);
      stringBuffer.append(" ");
      stringBuffer.append(dayOfMonth);
      stringBuffer.append("/");
      stringBuffer.append(dayOfMonthInterval);
      stringBuffer.append(" ");
      stringBuffer.append(month);
      stringBuffer.append(" ");
      stringBuffer.append(dayOfWeek);
      stringBuffer.append(" ");
      stringBuffer.append(year);

      String cron = stringBuffer.toString();
      return cron;
    }
  }
}
