package com.mayousheng.www.sbgnews.api;


import com.mayousheng.www.sbgnews.pojo.BSBDJLimit;
import com.mayousheng.www.sbgnews.vo.response.*;
import com.mayousheng.www.sbgnews.vo.response.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/bsbdj")
@Api(value = "百思不得姐")
public interface BSBDJApi {

    @PostMapping(value = "/getVideos")
    @ApiOperation(value = "根据查找信息获取视频", notes = "根据查找信息获取视频", tags = {"bsbdj"})
    // http://localhost:8080/bsbdj/getVideos {"count":10,"page":0,"needRealText":true}
    public Result<List<VideoResponse>> getVideos(@RequestBody @Valid BSBDJLimit bsbdjLimit, BindingResult bindingResult) throws Exception;

    @PostMapping(value = "/getPunsters")
    @ApiOperation(value = "根据查找信息获取文本", notes = "根据查找信息获取文本", tags = {"bsbdj"})
    // http://localhost:8080/bsbdj/getPunsters {"count":10,"page":0,"needRealText":true}
    public Result<List<PunsterResponse>> getPunsters(@RequestBody @Valid BSBDJLimit bsbdjLimit, BindingResult bindingResult) throws Exception;

    @PostMapping(value = "/getPhotos")
    @ApiOperation(value = "根据查找信息获取图片", notes = "根据查找信息获取图片", tags = {"bsbdj"})
    // http://localhost:8080/bsbdj/getPhotos {"count":10,"page":0,"needRealText":true}
    public Result<List<PhotoResponse>> getPhotos(@RequestBody @Valid BSBDJLimit bsbdjLimit, BindingResult bindingResult) throws Exception;

    @PostMapping(value = "/getVoices")
    @ApiOperation(value = "根据查找信息获取声音", notes = "根据查找信息获取声音", tags = {"bsbdj"})
    // http://localhost:8080/bsbdj/getVoices {"count":10,"page":0,"needRealText":true}
    public Result<List<VoiceResponse>> getVoices(@RequestBody @Valid BSBDJLimit bsbdjLimit, BindingResult bindingResult) throws Exception;

}
