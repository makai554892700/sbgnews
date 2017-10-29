package com.mayousheng.www.sbgnews.utils.ffmpeg;

import com.mayousheng.www.sbgnews.common.conf.StaticParam;
import com.mayousheng.www.sbgnews.pojo.ffmpeg.VideoInfo;
import com.mayousheng.www.sbgnews.utils.CMDUtils;

import java.io.File;

public class VideoUtils {

    public static File getShortCut(String url, String path) {
        if (url == null || url.isEmpty()) {
            return null;
        }
        VideoInfo videoInfo = VideoUtils.getVideoInfo(url);
        if (videoInfo == null || videoInfo.getWidth() == 0 || videoInfo.getHeight() == 0) {
            return null;
        }
        String result = CMDUtils.run(String.format(StaticParam.FFMPEG_SHORTCUT_WH, url
                , videoInfo.getWidth(), videoInfo.getHeight(), path));
        if (result == null) {
            return null;
        }
        return new File(path);
    }

    public static VideoInfo getVideoInfo(String url) {
        if (url == null || url.isEmpty()) {
            return null;
        }
        String tempResult = CMDUtils.run(String.format(StaticParam.FFMPEG_INFO, url));
        if (tempResult == null) {
            return null;
        }
        VideoInfo result = new VideoInfo();
        String[] tempStrs = tempResult.split(StaticParam.LINE);
        for (String tempStr : tempStrs) {
            if (tempStr.contains(StaticParam.FFMPEG_DURATION)) {
                result.setTimeLen(tempStr.substring(
                        tempStr.indexOf(StaticParam.FFMPEG_DURATION) + StaticParam.FFMPEG_DURATION.length()
                        , tempStr.indexOf(StaticParam.COMMA)
                ).trim());
            }
            if (tempStr.contains(StaticParam.FFMPEG_VIDEO)) {
                String[] strs = tempStr.split(StaticParam.COMMA);
                if (strs.length < 3) {
                    break;
                }
                strs = strs[2].split(StaticParam.FFMPEG_X);
                if (strs.length != 2) {
                    break;
                }
                try {
                    result.setWidth(Integer.parseInt(strs[0].trim()));
                } catch (Exception e) {
                    System.out.println("e=" + e + ";str=" + strs[0]);
                }
                try {
                    result.setHeight(Integer.parseInt(strs[1].trim()));
                } catch (Exception e) {
                    System.out.println("e=" + e + ";str=" + strs[1]);
                }
            }
        }
        return result;
    }

}
