package com.SoulMen.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/**
 * 时间工具类
 * Created by scumbag on 2020/10/9.
 */
public class DateUtils {
    public static final String YEAR_MONTH_DAY_PATTERN = "yyyy-MM-dd";
    public static final String HOUR_MINUTE_SECOND_PATTERN = "HH:mm:ss";
    public static final String YMDHMS_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String YMDHMS_LIST_PATTERN = "yyyyMMddHHmmss";
    public static final String YMDHMS_LIST_PATTERN1 = "yyyyMMddHH";
    public static final String DEFAULT_PATTERN = "yyyyMMdd";

    /**
     * String 转时间戳
     */
    public static long getLongDate( String strDate, String format) {

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Long longDate = 0l;
        try {
            longDate = sdf.parse(strDate).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return longDate ;
    }
    /**
     * 时间戳  转  Date
     * @throws ParseException
     */
    public static Date getLongDate( Long date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String d = sdf.format(date);
        return sdf.parse(d) ;
    }

    /**
     * 时间戳  转  Date
     * @throws ParseException
     */
    public static String getStrDate( Long date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }


    /**
     * 得到当前时间long类型，适用于insert into [DB]
     */
    public static long getLongTime() {
        return System.currentTimeMillis();
    }

    /**
     * 格式化日期,格式化后可直接insert into [DB],格式化后的日期为：2006-10-12 14:42:47
     * <P>
     * 把日期转换成字符串
     */
    public static String dateToStr(Date date) {

        if (date == null)
            return "";
        else {
            SimpleDateFormat sdFormat = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            String str_Date = sdFormat.format(date);

            if (str_Date.substring(11).equals("00:00:00")){
                str_Date = dateToStrEn(date);
            }
            return str_Date;
        }
    }

    /**
     * 格式化后的日期为：2006年10月12
     * <P>
     * 把日期转换成字符串
     */
    public static String dateToStrCN(Date date) {

        if (date == null)
            return "";
        else {
            SimpleDateFormat sdFormat = new SimpleDateFormat(YEAR_MONTH_DAY_PATTERN,
                    Locale.getDefault());
            String str_Date = sdFormat.format(date);
            return str_Date;
        }
    }

    /**
     * 格式化后的日期为：2006-10-12
     * <P>
     * 把日期转换成字符串
     */
    public static String dateToStrEn(Date date) {

        if (date == null)
            return "";
        else {
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd",
                    Locale.getDefault());
            String str_Date = sdFormat.format(date);
            return str_Date;
        }
    }

    public static String dateToStrEn(Date date,String format) {

        if (date == null)
            return "";
        else {
            SimpleDateFormat sdFormat = new SimpleDateFormat(format,
                    Locale.getDefault());
            String str_Date = sdFormat.format(date);
            return str_Date;
        }
    }

    /**
     * 把字符串转换成日期类型yyyy-MM-dd HH:mm:ss
     */
    public static Date strToDate(String str) {
        Date date = null;
        try{
            if (StringUtils.isNotEmpty(str)){
                if (str.length() >= 12) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    date = formatter.parse(str);
                }else if(str.length() == 10){
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    date = formatter.parse(str);
                }else{
                    date = DateFormat.getDateInstance().parse(str);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 日期计算
     *
     * @param date
     *            起始日期
     * @param yearNum
     *            年增减数
     * @param monthNum
     *            月增减数
     * @param dateNum
     *            日增减数
     * @param dateForm
     *            日期格式
     *
     */
    public static String calDate(String date, int yearNum, int monthNum,
                                 int dateNum, int hourNum,int minuteNum,String dateForm) {
        String result = "";
        try {

            SimpleDateFormat sd = new SimpleDateFormat(dateForm);
            Date parse = sd.parse(sd.format(Long.valueOf(date)));
            Calendar cal = Calendar.getInstance();
            cal.setTime(parse);
            cal.add(Calendar.MONTH, monthNum);
            cal.add(Calendar.YEAR, yearNum);
            cal.add(Calendar.DATE, dateNum);
            cal.add(Calendar.HOUR, hourNum);
            cal.add(Calendar.MINUTE, minuteNum);
            result = sd.format(cal.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *
     * @param date  日期
     * @param yearNum 变量  [天]
     * @param monthNum  变量 [月]
     * @param dateNum 变量  [日]
     * @param hourNum 变量  [时]
     * @param minuteNum 变量 [分]
     * @param secNum 变量 [秒]
     * @param fmt 时间格式
     * @return  String
     */
    public static String changeDate(Date date, int yearNum, int monthNum,
                                    int dateNum,int hourNum,int minuteNum,int secNum,String  fmt) {

        String result = "";
        try {
            SimpleDateFormat sd = new SimpleDateFormat(fmt);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, monthNum);
            cal.add(Calendar.YEAR, yearNum);
            cal.add(Calendar.DATE, dateNum);
            cal.add(Calendar.HOUR, hourNum);
            cal.add(Calendar.MINUTE, minuteNum);
            cal.add(Calendar.SECOND, secNum);
            result = sd.format(cal.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public static String calDate(Date date, int yearNum, int monthNum,
                                 int dateNum) {
        String result = "";
        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, monthNum);
            cal.add(Calendar.YEAR, yearNum);
            cal.add(Calendar.DATE, dateNum);
            result = sd.format(cal.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String delFrontZero(String mord) {
        int im = -1;
        try {
            im = Integer.parseInt(mord);
            return String.valueOf(im);
        } catch (Exception e) {
            return mord;
        }
    }

    /**
     * DateUtil.parseDate("20070423123754") 转换为：Mon Apr 23 12:37:54 CST 2007
     *
     * @param orlTime
     * @return
     */
    public static Date parseDate(String orlTime) {
        Date date = null;
        if (orlTime == null || orlTime.length() <= 0) {
            return null;
        }

        if (!(orlTime.length() == 14)) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            date = (Date) formatter.parse(orlTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    /**
     * DateUtil.parseDate("20070423") 转换为：Mon Apr 23 00:00:00 CST 2007
     *
     * @param orlTime
     * @return
     */
    public static Date parseDateDB(String orlTime) {
        Date date = null;
        if (orlTime == null || orlTime.length() <= 0) {
            return null;
        }

        if (!(orlTime.length() == 8)) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        try {
            date = (Date) formatter.parse(orlTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    /**
     * DateUtil.parseCnDate("2006-10-12") 转换为：2006年10月12日
     *
     * @param orlTime
     * @return
     */
    public static String parseCnDate(String orlTime) {
        if (orlTime == null || orlTime.length() <= 0) {
            return "";
        }

        if (orlTime.length() < 10) {
            return "";
        }
        String sYear = orlTime.substring(0, 4);
        String sMonth = delFrontZero(orlTime.substring(5, 7));
        String sDay = delFrontZero(orlTime.substring(8, 10));
        return sYear + "年" + sMonth + "月" + sDay + "日";
    }

    /**
     * DateUtil.parsePointDate("2006-10-12") 转换为：10.12
     *
     * @param orlTime
     * @return
     */
    public static String parsePointDate(String orlTime) {
        if (orlTime == null || orlTime.length() <= 0) {
            return "";
        }
        String sMonth = delFrontZero(orlTime.substring(5, 7));
        String sDay = delFrontZero(orlTime.substring(8, 10));
        return sMonth + "." + sDay;
    }

    /**
     * 得到当前月的最后一天
     *
     * @param
     * @return
     */
    public static Date getLastDayOfMonth(Date sDate1) {
        Calendar cDay1 = Calendar.getInstance();
        cDay1.setTime(sDate1);
        final int lastDay = cDay1.getActualMaximum(Calendar.DAY_OF_MONTH);
        Date lastDate = cDay1.getTime();
        lastDate.setDate(lastDay);
        return lastDate;
    }

    /**
     * 得到当前月的第一天
     *
     * @param
     * @return
     */
    public static Date getFirstDayOfMonth(Date sDate1) {
        Calendar cDay1 = Calendar.getInstance();
        cDay1.setTime(sDate1);
        final int lastDay = cDay1.getActualMinimum(Calendar.DAY_OF_MONTH);
        Date lastDate = cDay1.getTime();
        lastDate.setDate(lastDay);
        return lastDate;
    }

    public static long calendarDayPlus(Date d1, Date d2) {
        long milis = calendarMilisPlus(d1, d2);
        milis = milis / 1000 / 60 / 60 / 24;
        return milis;
    }

    public static long calendarMilisPlus(Date d1, Date d2) {
        return d2.getTime() - d1.getTime();
    }

    /**
     *
     * @param date1
     * @param date2
     * @param format
     * @return 1 :(date1 > date2 ) ;-1 :(date1 < date2 ) ;0 :(date1 = date2 ) ;
     */
    public static String compareDate(String date1, String date2,String format) {
        DateFormat df = new SimpleDateFormat(format);
        try {
            Date dt1 = df.parse(date1);
            Date dt2 = df.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {
                //System.out.println("dt1 在dt2前");
                return "1";
            } else if (dt1.getTime() < dt2.getTime()) {
                //System.out.println("dt1在dt2后");
                return "-1";
            } else {
                return "0";
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "0";
    }

    /**
     *

     * @return 1 :(date1 > date2 ) ;-1 :(date1 < date2 ) ;0 :(date1 = date2 ) ;
     */
    public static String compareDate(Date dt1, Date dt2) {
        try {
            if (dt1.getTime() > dt2.getTime()) {
                //System.out.println("dt1 在dt2前");
                return "1";
            } else if (dt1.getTime() < dt2.getTime()) {
                //System.out.println("dt1在dt2后");
                return "-1";
            } else {
                return "0";
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "0";
    }

    public final static String getBetweenStr(Date beginDate, Date endDate) {
        if (beginDate == null || endDate == null){
            return null;
        }
        long time = endDate.getTime() - beginDate.getTime();
        long hour = (time / (60 * 60 * 1000));
        long minute =((time / (60 * 1000)) - hour * 60);
        long second = (time / 1000  - hour * 60*  60 - minute * 60);
        return hour + "\u5c0f\u65f6" + minute + "\u5206" + second + "\u79d2";
    }

    public final static Date addDay(Date date,int addDays){
        return strToYMDDate(calDate(date, 0, 0, addDays));
    }

    public final static Date addMonth(Date date,int addMonths){
        return strToYMDDate(calDate(date, 0, addMonths, 0));
    }

    /**
     * 把字符串转换成日期类型yyyy-MM-dd
     */
    public static Date strToYMDDate(String str) {
        Date date = null;
        try{
            if (StringUtils.isNotEmpty(str)){
                if (str.length() >= 10) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    date = formatter.parse(str.substring(0, 10));
                }else{
                    date = DateFormat.getDateInstance().parse(str);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return date;
    }



    /**
     * 将传入的日期按照默认形势转换成字符串(yyyy-MM-dd)
     *
     * @param date 要格式化的日期对象
     * @return 格式化后的日期字符串
     */
    public static String format(final Date date) {
        return format(date, YEAR_MONTH_DAY_PATTERN);
    }

    /**
     * 将传入的日期按照默认形势转换成字符串(yyyy-MM-dd HH:mm:ss)
     *
     * @param date 要格式化的日期对象
     * @return 格式化后的日期字符串
     */
    public static String parse(final Date date) {
        return format(date, YMDHMS_PATTERN);
    }

    /**
     * 根据传入的日期格式化pattern将传入的日期格式化成字符串。
     *
     * @param date 要格式化的日期对象
     * @param pattern 日期格式化pattern
     * @return 格式化后的日期字符串
     */
    public static String format(final Date date, final String pattern) {
        if (date == null){
            return null;
        }
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    public static String calDate1(Date date, int yearNum, int monthNum,
                                  int dateNum) {
        String result = "";
        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sd.parse(date.toString()));
            cal.add(Calendar.MONTH, monthNum);
            cal.add(Calendar.YEAR, yearNum);
            cal.add(Calendar.DATE, dateNum);
            result = sd.format(cal.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 获取一天范围的请假、出差、外出 天数
     * @param beginDate 开始时间
     * @param endDate 结束时间
     * @param num 去除休息时间（毫秒数）
     * @return
     * @throws ParseException
     */
    public static double getDays(Date beginDate,Date endDate,Long num) throws ParseException{
        if(beginDate == null || endDate == null){
            return 0 ;
        }
        SimpleDateFormat sdf=new SimpleDateFormat(DateUtils.YMDHMS_PATTERN);
        //跨年不会出现问题
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // 获得两个时间的毫秒时间差异
        long diff=endDate.getTime()-beginDate.getTime();
        diff =diff -num ;
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh*60;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;

        //按照一天8小时计算
        min = min + hour;
        double s = (double) min /(8*60);
        BigDecimal bg = new BigDecimal(s).setScale(2, RoundingMode.UP);
        return bg.doubleValue();
    }
    /**
     * 根据年 月 获取对应的月份 天数
     *
     * @param year 年份
     * @param month 月份
     * @return int
     */
    public static int getDaysByYearMonth(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int date = a.get(Calendar.DATE);
        return date;
    }
}
