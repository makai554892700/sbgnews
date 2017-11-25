package com.mayousheng.www.sbgnews.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.Reader;

public class CloseUtils {
    private static final Logger log = LoggerFactory.getLogger(CloseUtils.class);

    public static void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                log.error("e=" + e);
            }
        }
    }

    public static void closeReader(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (Exception e) {
                log.error("e=" + e);
            }
        }
    }

}