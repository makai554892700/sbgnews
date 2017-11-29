package com.mayousheng.www.sbgnews.service;

import com.mayousheng.www.sbgnews.pojo.bsbdj.BSBDJBack;
import com.mayousheng.www.sbgnews.vo.request.LimitSearchRequest;
import com.mayousheng.www.sbgnews.vo.response.PhotoResponse;
import com.mayousheng.www.sbgnews.vo.response.PunsterResponse;
import com.mayousheng.www.sbgnews.vo.response.VideoResponse;
import com.mayousheng.www.sbgnews.vo.response.VoiceResponse;

import java.util.List;

public interface BSBDJService {

    public List<BSBDJBack> loadData();

    public List<PhotoResponse> getPhotoBySearch(LimitSearchRequest bsbdjLimit) throws Exception;

    public List<PunsterResponse> getPunsterBySearch(LimitSearchRequest bsbdjLimit) throws Exception;

    public List<VoiceResponse> getVoiceBySearch(LimitSearchRequest bsbdjLimit) throws Exception;

    public List<VideoResponse> getVideoBySearch(LimitSearchRequest bsbdjLimit) throws Exception;

    public void loadAllDatas() throws Exception;

    public void setLoaded(boolean loaded);
}
