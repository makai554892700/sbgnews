package com.mayousheng.www.sbgnews.controller;

import com.mayousheng.www.sbgnews.api.BSBDJApi;
import com.mayousheng.www.sbgnews.vo.request.LimitSearchRequest;
import com.mayousheng.www.sbgnews.service.BSBDJService;
import com.mayousheng.www.sbgnews.utils.ResultUtils;
import com.mayousheng.www.sbgnews.vo.response.*;
import com.mayousheng.www.sbgnews.vo.response.base.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class BSBDJController implements BSBDJApi {
    private Logger log = LoggerFactory.getLogger(BSBDJController.class);

    @Resource(name = "bsbdjServiceImpl")
    private BSBDJService bsbdjService;

    @Override
    public Result<List<VideoResponse>> getVideos(@RequestBody @Valid LimitSearchRequest bsbdjLimit
            , BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new Exception(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtils.succeed(bsbdjService.getVideoBySearch(bsbdjLimit));
    }

    @Override
    public Result<List<PunsterResponse>> getPunsters(@RequestBody @Valid LimitSearchRequest bsbdjLimit
            , BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new Exception(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtils.succeed(bsbdjService.getPunsterBySearch(bsbdjLimit));
    }

    @Override
    public Result<List<PhotoResponse>> getPhotos(@RequestBody @Valid LimitSearchRequest bsbdjLimit
            , BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new Exception(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtils.succeed(bsbdjService.getPhotoBySearch(bsbdjLimit));
    }

    @Override
    public Result<List<VoiceResponse>> getVoices(@RequestBody @Valid LimitSearchRequest bsbdjLimit
            , BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new Exception(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtils.succeed(bsbdjService.getVoiceBySearch(bsbdjLimit));
    }
}
