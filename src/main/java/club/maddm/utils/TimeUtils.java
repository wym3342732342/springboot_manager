package club.maddm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式化工具类
 * @author King
 * @version 1.0
 * @date 2019/11/19 14:05
 */
public class TimeUtils {
    private static final String DATA_AND_TIME = "yyy-MM-dd HH:mm:ss";
    private static final String DATA = "yyy-MM-dd";
    private static final String TIME = "HH:mm:ss";

    private static final String FILE_NAME = "yyyMMddHHmmss";

    private static final SimpleDateFormat DATA_AND_TIME_FROMAT = new SimpleDateFormat(DATA_AND_TIME);
    private static final SimpleDateFormat DATA_FROMAT = new SimpleDateFormat(DATA);
    private static final SimpleDateFormat TIME_FROMAT = new SimpleDateFormat(TIME);
    private static final SimpleDateFormat FILE_NAME_FROMAT = new SimpleDateFormat(FILE_NAME);


    public static String getFileName() {
        return FILE_NAME_FROMAT.format(new Date());
    }

    /**
     * 根据规定的日期格式，格式化
     * @param format
     * @param date
     * @return
     */
    public static String dataFormat(String format, Date date) {
        String str = "yyy-MM-dd HH:mm:ss";
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 格式化成默认的日期时间格式
     * @param date
     * @return
     */
    public static String dataTime(Date date) {
        return DATA_AND_TIME_FROMAT.format(date);
    }


    /**
     * 格式化成默认的日期格式
     * @param date
     * @return
     */
    public static String data(Date date) {
        return DATA_FROMAT.format(date);
    }

    /**
     * 格式化成默认的时间格式
     * @param date
     * @return
     */
    public static String time(Date date) {
        return TIME_FROMAT.format(date);
    }
}