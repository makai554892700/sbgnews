package com.mayousheng.www.sbgnews.utils.vo;

import com.mayousheng.www.sbgnews.pojo.TopNews;
import com.mayousheng.www.sbgnews.vo.response.TopNewsResponse;

import java.util.ArrayList;
import java.util.List;

public class TopNewsUtils {

    public static TopNewsResponse topNews2Response(TopNews topNews) {
        if (topNews == null) {
            return null;
        }
        return new TopNewsResponse(topNews.getType(), topNews.getTitle(),
                topNews.getDate(), topNews.getAuthor_name(), topNews.getUrl(),
                topNews.getThumbnail_pic_s(), topNews.getThumbnail_pic_s02(),
                topNews.getThumbnail_pic_s03());
    }

    public static List<TopNewsResponse> topNewss2Responses(List<TopNews> topNewss) {
        if (topNewss == null) {
            return null;
        }
        List<TopNewsResponse> result = new ArrayList<>();
        for (TopNews topNews : topNewss) {
            result.add(topNews2Response(topNews));
        }
        return result;
    }

}
