package com.mayousheng.www.sbgnews.vo.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class NewsCommentRequest {

    @NotNull(message = "评论标记不能为空")
    private NewsOperateRequest newsMark;
    @NotEmpty(message = "评论信息不能为空")
    private String commentInfo;

    public NewsOperateRequest getNewsMark() {
        return newsMark;
    }

    public void setNewsMark(NewsOperateRequest newsMark) {
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
        return "NewsCommentRequest{" +
                "newsMark=" + newsMark +
                ", commentInfo='" + commentInfo + '\'' +
                '}';
    }
}
