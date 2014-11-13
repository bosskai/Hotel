package main.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by bosskai on 2014/11/12.
 */
public class dForW {
    /**
     * 判断当前日期是星期几
     *
     * @param pTime 修要判断的时间
     * @return dayForWeek 判断结果
     * @Exception 发生异常
     */
    public static int dayForWeek(String pTime) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
//        c.setTime(pTime);
        c.setTime(format.parse(pTime));
        int dayForWeek = 0;
        if(c.get(Calendar.DAY_OF_WEEK) == 1){
            dayForWeek = 7;
        }else{
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }

    private static BigDecimal getDecimal(String literal) {
        if (literal == null || literal.length() == 0) {
            return new BigDecimal("0");// 改成"0"，为了兼容Java 1.4
        }
        if (literal.charAt(0) == '.') {
            return new BigDecimal("0" + literal);
        }
        return new BigDecimal(literal);
    }

    /**
     *
     * <DL>
     * <DT><B> 字符串的比较 </B></DT>
     * <p>
     * <DD> 详细介绍:字符串的比较 .</DD>
     * </DL>
     * <p>
     *
     * @param decimalLiteral1
     *            字符串一
     * @param decimalLiteral2
     *            字符串二
     * @return 比较两个数字的大小，相等返回0，前者大于后者返回1，若小于返回-1
     */
    public static int compare(String decimalLiteral1, String decimalLiteral2) {
        decimalLiteral1 = decimalLiteral1.replaceAll(",", "");
        decimalLiteral2 = decimalLiteral2.replaceAll(",", "");
        return getDecimal(decimalLiteral1).compareTo(
                getDecimal(decimalLiteral2));
    }

}
