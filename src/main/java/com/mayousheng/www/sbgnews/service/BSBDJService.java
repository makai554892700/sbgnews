package com.mayousheng.www.sbgnews.service;

import com.mayousheng.www.sbgnews.pojo.BSBDJBack;
import com.mayousheng.www.sbgnews.pojo.BSBDJLimit;
import com.mayousheng.www.sbgnews.vo.response.VideoResponse;

import java.util.List;

public interface BSBDJService {

    public List<BSBDJBack> loadData();

    public List<VideoResponse> getPhotoBySearch(BSBDJLimit bsbdjLimit) throws Exception;

    public List<VideoResponse> getPunsterBySearch(BSBDJLimit bsbdjLimit) throws Exception;

    public List<VideoResponse> getVoiceBySearch(BSBDJLimit bsbdjLimit) throws Exception;

    public List<VideoResponse> getVideoBySearch(BSBDJLimit bsbdjLimit) throws Exception;

    public void loadAllDatas() throws Exception;
}
