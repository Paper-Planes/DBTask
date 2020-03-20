package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Format {
    /**
     * 将一个字符串转换为日期
     * @param string: 一个格式为 yyyy-MM-dd 字符串
     * @return： 返回一个日期 date
     * @throws ParseException
     */
    public static Date StringToDate(String string) throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date = sdf.parse(string);
        return date;
    }

    public static String DateToString(Date date) {
        String string = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static String DatetimeToString(Date date) {
        String string = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(date);
    }
}
