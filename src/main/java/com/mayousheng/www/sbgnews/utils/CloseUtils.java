package com.mayousheng.www.sbgnews.utils;

import java.io.Closeable;

public class CloseUtils {

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                System.out.println("e=" + e);
            }
        }
    }

}