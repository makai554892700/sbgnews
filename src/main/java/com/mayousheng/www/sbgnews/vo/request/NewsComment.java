package com.mayousheng.www.sbgnews.vo.request;

import org.hibernate.validator.constraints.NotEmpty;

public class NewsComment {

    @NotEmpty(message = "评论标记不能为空")
    private NewsMark newsMark;
    @NotEmpty(message = "评论信息不能为空")
    private String commentInfo;

    public NewsMark getNewsMark() {
        return newsMark;
    }

    public void setNewsMark(NewsMark newsMark) {
        this.newsMark = newsMark;
    }

    public String getCommentInfo() {
        return commentInfo;
    }

    public void setCommentInfo(String commentInfo) {
        this.commentInfo = commentInfo;
    }


    @Override
    public String toString() {
        return "NewsComment{" +
                "newsMark=" + newsMark +
                ", commentInfo='" + commentInfo + '\'' +
                '}';
    }
}
