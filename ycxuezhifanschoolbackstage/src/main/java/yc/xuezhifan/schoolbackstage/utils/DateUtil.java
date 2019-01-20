package yc.xuezhifan.schoolbackstage.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * @author liuke
 * @date   2018年8月4日
 *
 */
public class DateUtil {
    /**
     * 根据日期获得毫秒值
     * @param str
     * @return
     */
    public static long getMs(String str, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date date = sdf.parse(str);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getDate(String time, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date(Long.parseLong(time));
        return sdf.format(date);
    }

    /**
     * 获得当天的毫秒值开始
     * @return
     *//*
    public static long getStartDay(){
        Date time = new Date();
        String date = time.toString("yyyy-MM-dd HH:mm");
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
        time = Date.parse(date, format);
        long start = time.getMillis();
        return start;
    }*/

  /*  public static long getEndDay(){
        DateTime time = new DateTime();
        String date = time.toString("yyyy-MM-dd HH:mm");
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
        time = DateTime.parse(date, format);
        long start = time.getMillis();
        return start+Constants.DAY_MILLISECOND;
    }
*/
    /* *//**
     *
     * @param now  当前时间
     * @param day  比当前时间差几天  正的就是当天时间之前几天   负的就是当前时间之后几天
     * @return
     *//*
    public static Object[] getDayInterval(long now, int day){
        long mis = now-(day*Constants.DAY_MILLISECOND);
        DateTime time = new DateTime(mis);
        String date = time.toString("yyyy-MM-dd HH:mm");
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
        time = DateTime.parse(date, format);
        long start = time.getMillis();
        return new Object[]{start, start+Constants.DAY_MILLISECOND, date};
    }*/

    public static String  getDateAndTime(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
        String hehe = dateFormat.format( now );
        return hehe;
    }

    public static String  getDateAndTimeTwo(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
        String hehe = dateFormat.format( now );
        return hehe;
    }
    public static String  getDateAndTimeThree(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//可以方便地修改日期格式
        String hehe = dateFormat.format( now );
        return hehe;
    }







    /**
     *
     * @param hour
     * @return
     */
    public static String getTimeByHour(Date now,int hour) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);

        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);

        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());

    }

    /*

     *��ȡ��ǰʱ��֮ǰ��֮�󼸷��� minute

     */

    public static String getTimeByMinute(Date now,int minute) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);

        calendar.add(Calendar.MINUTE, minute);

        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());

    }
    /**
     * ָ�������ƺ������ǰ����
     * @param date ָ��������
     * @param amount ���� �� ����� ������ǰ��
     * @return
     */
    public  static String getTimeByday(Date date, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add( Calendar.DATE, amount);

        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());

    }
    /**
     * ָ�������ƺ������ǰ����
     * @param date ָ��������
     * @param amount ���� �� ����� ������ǰ��
     * @return
     *
     */
    public  static Date addInteger(Date date, int amount) {
        Date myDate = null;
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add( Calendar.DATE, amount);
            myDate=calendar.getTime();

        }
        return myDate;
    }

    public static String  getDateAndTimes(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MM dd HH mm ss");//���Է�����޸����ڸ�ʽ
        String hehe = dateFormat.format( now );
        return hehe;
    }


    public static String  getDateAndfour(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//���Է�����޸����ڸ�ʽ
        String hehe = dateFormat.format( now );
        return hehe;
    }
    public static String  getDateAndfive(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");//���Է�����޸����ڸ�ʽ
        String hehe = dateFormat.format( now );
        return hehe;
    }

    public static String  getDateAndsix(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");//���Է�����޸����ڸ�ʽ
        String hehe = dateFormat.format( now );
        return hehe;
    }

    /**
     * �ַ��������ڸ�ʽ�ļ���
     * @param smdate��ʼʱ��
     * @param bdate����ʱ��
     * @return
     * @throws ParseException
     */
    public static int daysBetween(String smdate,String bdate) throws ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }
    public static int daysBetweenmin(long time2,long time1) throws ParseException{
        long between_days=(time2-time1)/(1000);

        return Integer.parseInt(String.valueOf(between_days));
    }
}