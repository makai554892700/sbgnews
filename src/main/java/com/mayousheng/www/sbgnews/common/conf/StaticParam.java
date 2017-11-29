package com.mayousheng.www.sbgnews.common.conf;

import java.io.File;

public class StaticParam {

    public static final String[] HEX_STR = new String[]{"0", "1", "2"
            , "3", "4", "5", "6", "7", "8", "9", "A", "B"
            , "C", "D", "E", "F"};

    public static final int SEX_NONE = -1;
    public static final int SEX_MAN = 1;
    public static final int SEX_WOMAN = 2;

    public static final int DEFAULT_USER_ID = 1;

    public static final String EMPTY_STR = "";
    public static final String DEFAULT_PASS = "123456";

    public static final String TABLE_NAME_JOKE = "joke";
    public static final String TABLE_NAME_PHOTOBSBDJ = "photobsbdj";
    public static final String TABLE_NAME_PUNSTERBSBDJ = "punsterbsbdj";
    public static final String TABLE_NAME_VIDEOBSBDJ = "videobsbdj";
    public static final String TABLE_NAME_VOICEBSBDJ = "voicebsbdj";

    public static final String LINE = "\n";
    public static final String COMMA = ",";
    public static final String SPACE = "/";
    public static final String BLANK = " ";
    public static final String OK = "ok";

    public static final String FFMPEG_SHORTCUT_WH =
            "ffmpeg -i %s -y -f image2 -t 0.001 -s %sx%s %s";
    public static final String FFMPEG_CUT_PICTURE =
            "ffmpeg -i %s -vf crop=%s:%s:%s:%s %s";
    public static final String FFMPEG_INFO = "ffmpeg -i %s";
    public static final String FFMPEG_DURATION = "Duration:";
    public static final String FFMPEG_VIDEO = "Video:";
    public static final String FFMPEG_X = "x";

    public static final String BSBDJ = "bsbdj";
    public static final String IMG = "img";
    public static final String PNG_END = ".png";
    public static final String ROOT_PATH = "/data";
    public static final String BSBDJ_PATH = ROOT_PATH + File.separator + BSBDJ;
    public static final String BSBDJ_IMG_PATH = BSBDJ_PATH + File.separator + IMG;

    public static final String BASE_URL = "http://news.woaizhuangbi.com/sbgnews";
    public static final String BSBDJ_URL = BASE_URL + SPACE + BSBDJ;
    public static final String BSBDJ_IMG_URL = BSBDJ_URL + SPACE + IMG;

    public static final String SHIRO_USER = "shiro_user";
    public static final int SHIRO_EVER = -10001;
    public static final String SHIRO_PREFIX = "shiro_prefix";
    public static final long SHIRO_SESSION_TIME_OUT = 18000;

}
