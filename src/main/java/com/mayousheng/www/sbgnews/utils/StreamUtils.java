package com.mayousheng.www.sbgnews.utils;

import com.mayousheng.www.sbgnews.utils.CloseUtils;
import com.mayousheng.www.sbgnews.common.conf.StaticParam;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;

public class StreamUtils {

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
                System.out.println("e=" + e);
                return stringBuilder.toString();
            }
            stringBuilder.append(line);
            stringBuilder.append(StaticParam.LINE);
        } while (line != null);
        CloseUtils.close(bufferedReader);
        CloseUtils.close(inputStreamReader);
        return stringBuilder.toString();
    }

}
