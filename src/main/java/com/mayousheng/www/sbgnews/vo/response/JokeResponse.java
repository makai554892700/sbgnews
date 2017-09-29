package com.mayousheng.www.sbgnews.vo.response;

public class JokeResponse {

    private String title;//标题
    private String text;//内容
    private String time;//笑话创建时间

    public JokeResponse() {
    }

    public JokeResponse(String title, String text, String time) {
        this.title = title;
        this.text = text;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "JokeResponse{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
