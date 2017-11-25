package com.mayousheng.www.sbgnews.utils;

import com.mayousheng.www.sbgnews.common.conf.StaticParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class StreamUtils {

    private static final Logger log = LoggerFactory.getLogger(StreamUtils.class);

    public static String sequenceInputStream2Str(SequenceInputStream inputStream) {
        return inputStream2Str(inputStream);
    }

    public static String inputStream2Str(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        do {
            try {
                line = bufferedReader.readLine();
            } catch (Exception e) {
                log.error("e=" + e);
                return stringBuilder.toString();
            }
            if (line != null) {
                stringBuilder.append(line);
                stringBuilder.append(StaticParam.LINE);
            }
        } while (line != null);
        CloseUtils.closeSilently(bufferedReader);
        CloseUtils.closeSilently(inputStreamReader);
        return stringBuilder.toString();
    }

    public static boolean inputStream2OutputStream(InputStream inputStream, OutputStream outputStream) {
        if (inputStream != null && outputStream != null) {
            byte[] tempByte = new byte[1024];
            int len;
            try {
                while ((len = inputStream.read(tempByte)) != -1) {
                    outputStream.write(tempByte, 0, len);
                }
                return true;
            } catch (Exception e) {
                log.error("e=" + 3);
            }
        }
        return false;
    }

}
