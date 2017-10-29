package com.mayousheng.www.sbgnews.utils;

import com.mayousheng.www.sbgnews.utils.CloseUtils;
import com.mayousheng.www.sbgnews.utils.StreamUtils;

import java.io.InputStream;
import java.io.SequenceInputStream;

public class CMDUtils {

    public static String execute(String... commands) {
        if (commands == null || commands.length == 0) {
            return null;
        }
        ProcessBuilder builder = new ProcessBuilder();
        builder.command(commands);
        Process process;
        try {
            process = builder.start();
        } catch (Exception e) {
            System.out.println("e=" + e);
            return null;
        }
        return process2Result(process);
    }

    public static String run(String commandStr) {
        if (commandStr == null || commandStr.isEmpty()) {
            return null;
        }
        Runtime runtime = Runtime.getRuntime();
        runtime.traceMethodCalls(true);
        Process process;
        try {
            process = runtime.exec(commandStr);
        } catch (Exception e) {
            System.out.println("e=" + e);
            return null;
        }
        return process2Result(process);
    }

    private static String process2Result(Process process) {
        InputStream inputStream = process.getInputStream();
        InputStream errorStream = process.getErrorStream();
        SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStream, errorStream);
        String result = StreamUtils.sequenceInputStream2Str(sequenceInputStream);
        CloseUtils.close(sequenceInputStream);
        CloseUtils.close(errorStream);
        CloseUtils.close(inputStream);
        return result;
    }

}
