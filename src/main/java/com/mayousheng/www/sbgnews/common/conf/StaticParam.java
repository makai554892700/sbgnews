package com.mayousheng.www.sbgnews.common.conf;

public class StaticParam {

    public static final String[] HEX_STR = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B"
            , "C", "D", "E", "F"};

    public static final int SEX_NONE = -1;
    public static final int SEX_MAN = 1;
    public static final int SEX_WOMAN = 2;

    public static final int DEFAULT_USER_ID = 1;

    public static final String EMPTY_STR = "";

    public static final String TABLE_NAME_JOKE = "joke";
    public static final String TABLE_NAME_PHOTOBSBDJ = "photobsbdj";
    public static final String TABLE_NAME_PUNSTERBSBDJ = "punsterbsbdj";
    public static final String TABLE_NAME_VIDEOBSBDJ = "videobsbdj";
    public static final String TABLE_NAME_VOICEBSBDJ = "voicebsbdj";

    public static final String LINE = "\n";
    public static final String COMMA = ",";

    public static final String FFMPEG_SHORTCUT_WH = "ffmpeg -i %s -y -f image2 -t 0.001 -s %sx%s %s";
    public static final String FFMPEG_INFO = "ffmpeg -i %s";
    public static final String FFMPEG_DURATION = "Duration:";
    public static final String FFMPEG_VIDEO = "Video:";
    public static final String FFMPEG_X = "x";

}
