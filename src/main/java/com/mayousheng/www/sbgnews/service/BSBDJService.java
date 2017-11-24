package com.mayousheng.www.sbgnews.service;

import com.mayousheng.www.sbgnews.pojo.bsbdj.BSBDJBack;
import com.mayousheng.www.sbgnews.pojo.bsbdj.BSBDJLimit;
import com.mayousheng.www.sbgnews.vo.response.PhotoResponse;
import com.mayousheng.www.sbgnews.vo.response.PunsterResponse;
import com.mayousheng.www.sbgnews.vo.response.VideoResponse;
import com.mayousheng.www.sbgnews.vo.response.VoiceResponse;

import java.util.List;

public interface BSBDJService {

    public List<BSBDJBack> loadData();

    public List<PhotoResponse> getPhotoBySearch(BSBDJLimit bsbdjLimit) throws Exception;

    public List<PunsterResponse> getPunsterBySearch(BSBDJLimit bsbdjLimit) throws Exception;

    public List<VoiceResponse> getVoiceBySearch(BSBDJLimit bsbdjLimit) throws Exception;

    public List<VideoResponse> getVideoBySearch(BSBDJLimit bsbdjLimit) throws Exception;

    public void loadAllDatas() throws Exception;

    public void setLoaded(boolean loaded);
}
