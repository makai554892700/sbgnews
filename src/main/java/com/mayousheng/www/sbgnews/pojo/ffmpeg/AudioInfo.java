package com.mayousheng.www.sbgnews.pojo.ffmpeg;

public class AudioInfo {

    private int width;
    private int height;
    private String timeLen;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getTimeLen() {
        return timeLen;
    }

    public void setTimeLen(String timeLen) {
        this.timeLen = timeLen;
    }

    @Override
    public String toString() {
        return "AudioInfo{" +
                "width=" + width +
                ", height=" + height +
                ", timeLen='" + timeLen + '\'' +
                '}';
    }
}
