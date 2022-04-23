package a_日期;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class D_DateUtils {
    public static void main(String[] args) throws ParseException {
        // 目标1: 将时间戳 转成 指定格式的时间字符串
        long timestamp = 1650245131000L;
        // 分解式
        Date d1 = new Date(timestamp);

        // System.out.println(d1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = sdf.format(d1);

        // 合并式
        String result2 = timestamp2datestr(timestamp);

        System.out.println(result2);

        // 目标2: 将指定格式的时间字符串 转成 时间戳
        String str = "2022-04-18 09:25:31";

        // 分解式
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d2 = sdf2.parse(str);
        System.out.println(d2);
        long timestamp2 = d2.getTime();
        System.out.println(timestamp2);

        // 合并式
        long timestamp3 = datestr2timestamp(str);
        System.out.println(timestamp3);


    }

    // 目标: 将日期字符串 转成 时间戳
    public static long datestr2timestamp(String str) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime();
    }

    // 目标: 将时间戳 转成 日期字符串
    public static String timestamp2datestr(long timestamp) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(timestamp));
    }
}
