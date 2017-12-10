package com.mayousheng.www.sbgnews.utils.ffmpeg;

import com.mayousheng.www.sbgnews.common.conf.StaticParam;
import com.mayousheng.www.sbgnews.pojo.ffmpeg.AudioInfo;
import com.mayousheng.www.sbgnews.utils.CMDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class AudioUtils {

    private static final Logger log = LoggerFactory.getLogger(AudioUtils.class);

    public synchronized static File getShortCut(String url, String path, boolean isPicture, AudioInfo audioInfo) {
        if (url == null || url.isEmpty()) {
            return null;
        }
        if (audioInfo == null || audioInfo.getWidth() == 0 || audioInfo.getHeight() == 0) {
            return null;
        }
        File result = new File(path);
        if (result.exists()) {
            return result;
        }
        String cmdStr = isPicture ?
                String.format(StaticParam.FFMPEG_CUT_PICTURE, url
                        , audioInfo.getWidth(), audioInfo.getWidth(), 0, 0, path) :
                String.format(StaticParam.FFMPEG_SHORTCUT_WH, url
                        , audioInfo.getWidth(), audioInfo.getHeight(), path);
        String cmdResult = CMDUtils.run(cmdStr);
        if (cmdResult == null) {
            return null;
        } else if (!result.exists()) {
            log.error("run cmd.CMD=" + cmdStr);
            log.error(cmdResult);
            return null;
        }
        return result;
    }


    public static File getShortCut(String url, String path, boolean isPicture) {
        return getShortCut(url, path, isPicture, getAudioInfo(url));
    }

    public static AudioInfo getAudioInfo(String url) {
        if (url == null || url.isEmpty()) {
            return null;
        }
        String tempResult = CMDUtils.run(String.format(StaticParam.FFMPEG_INFO, url));
        if (tempResult == null) {
            return null;
        }
        AudioInfo result = new AudioInfo();
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
                for (int i = 2; i < strs.length; i++) {
                    if (strs[i].contains(StaticParam.FFMPEG_X)) {
                        strs = strs[i].split(StaticParam.FFMPEG_X);
                        break;
                    }
                }
                if (strs.length != 2) {
                    break;
                }
                try {
                    result.setWidth(Integer.parseInt(strs[0].trim()));
                } catch (Exception e) {
                    log.error("e=" + e + ";str=" + strs[0]);
                }
                try {
                    result.setHeight(Integer.parseInt(strs[1].split(StaticParam.BLANK)[0].trim()));
                } catch (Exception e) {
                    log.error("e=" + e + ";str=" + strs[1]);
                }
            }
        }
        return result;
    }

}
