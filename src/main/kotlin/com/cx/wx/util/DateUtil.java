package com.cx.wx.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @NotNull
    public static String getCurrentDate() {
        Date date = new Date();
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    @NotNull
    public static Long getCurrentSecond() {
        // getTime获取毫秒数
        return (new Date().getTime() / 1000);
    }

    @NotNull
    public static Long timeStr2Second(String str) {
        try {
            return (sdf.parse(str).getTime() / 1000);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @NotNull
    @Contract(value = "_ -> new", pure = true)
    public static Date timeSecond2Date(Long time) {
        return new Date(time * 1000);
    }

    @NotNull
    public static String date2Str(Date date) {
        return sdf.format(date);
    }

    @NotNull
    public static Long date2Second(@NotNull Date date) {
        return (date.getTime() / 1000);
    }
}
