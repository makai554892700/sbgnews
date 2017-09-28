package com.mayousheng.www.sbgnews.utils;

import javax.servlet.http.HttpServletRequest;

public class IPUtils {
    private static final String IP_SPLIT = "\\.";
    private static final String IP_ZERO = "0.0.0.0";

    public static String getIP(HttpServletRequest request) {
        String ip = request.getHeader("x-real-ip");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip != null && !ip.isEmpty()) {
            ip = ip.split(",")[0];
        }
        return ip;
    }


    public static int ip2Key(String ip) {
        int result = 0;
        if (ip != null && !ip.isEmpty()) {
            String[] parts = ip.split(IP_SPLIT);
            if (parts.length == 4) {
                try {
                    result = ((Integer.valueOf(parts[0]) % 256) << 16) + ((Integer.valueOf(parts[1]) % 256) << 8) + (Integer.valueOf(parts[2]) % 256);
                } catch (Exception e) {
                    System.out.println("e=" + e);
                }
            } else {
                System.out.println("parts.length=" + parts.length + ";ip=" + ip);
            }
        }
        return result;
    }

    public static long ip2LIP(String ip) {
        long result = ip2Key(ip);
        if (result != 0) {
            try {
                result += Integer.valueOf(ip.split(IP_SPLIT)[3]);
            } catch (Exception e) {
                System.out.println("e=" + e);
            }
        }
        return result;
    }

    public static boolean isIpMath(String ip) {
        return ip2LIP(ip) != 0 || IP_ZERO.equals(ip);
    }

}
