package com.mayousheng.www.sbgnews.utils;

import com.mayousheng.www.sbgnews.common.conf.StaticParam;
import com.mayousheng.www.sbgnews.pojo.*;
import com.mayousheng.www.sbgnews.pojo.bsbdj.*;
import com.mayousheng.www.sbgnews.pojo.ffmpeg.AudioInfo;
import com.mayousheng.www.sbgnews.utils.ffmpeg.AudioUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class BSBDJPojoUtils {

    private static final Logger log = LoggerFactory.getLogger(BSBDJPojoUtils.class);

    public static User BSBDJ2User(BSBDJ bsbdj) {
        if (bsbdj == null) {
            return null;
        }
        return new User(bsbdj.getName(), bsbdj.getName(), StaticParam.SEX_NONE
                , StaticParam.EMPTY_STR, StaticParam.DEFAULT_PASS
                , StaticParam.EMPTY_STR, StaticParam.EMPTY_STR
                , bsbdj.getProfileImage(), bsbdj.getWeixinUrl());
    }

    public static PhotoBSBDJ BSBDJ2PhotoBSBDJ(BSBDJ bsbdj) {
        if (bsbdj == null) {
            return null;
        }
        String imgUrl = getImgUrl(bsbdj);
        AudioInfo audioInfo = AudioUtils.getAudioInfo(imgUrl);
        if (audioInfo == null) {
            return null;
        }
        String scImg = imgUrl;
        String mark = getMark(bsbdj);
        if (audioInfo.getWidth() * 2 < audioInfo.getHeight()) {
            String localPath = PathUtils.getBSBDJImgPath(mark);
            File localFile = AudioUtils.getShortCut(imgUrl
                    , localPath, true, audioInfo);
            if (localFile != null) {
                scImg = PathUtils.getBSBDJImgUrl(bsbdj.get_id());
            }
        }
        return new PhotoBSBDJ(mark, StaticParam.DEFAULT_USER_ID, bsbdj.getWeixinUrl()
                , bsbdj.getText(), imgUrl, scImg, audioInfo.getWidth()
                , audioInfo.getHeight(), bsbdj.getCreateTime());
    }

    public static PunsterBSBDJ BSBDJ2PunsterBSBDJ(BSBDJ bsbdj) {
        if (bsbdj == null) {
            return null;
        }
        String mark = getMark(bsbdj);
        return new PunsterBSBDJ(mark, StaticParam.DEFAULT_USER_ID, bsbdj.getWeixinUrl()
                , bsbdj.getText(), bsbdj.getCreateTime());
    }

    public static VideoBSBDJ BSBDJ2VideoBSBDJ(BSBDJ bsbdj) {
        if (bsbdj == null) {
            return null;
        }
        AudioInfo audioInfo = AudioUtils.getAudioInfo(bsbdj.getVideoUri());
        if (audioInfo == null) {
            return null;
        }
        String scImg;
        String mark = getMark(bsbdj);
        String localPath = PathUtils.getBSBDJImgPath(mark);
        File localFile = AudioUtils.getShortCut(bsbdj.getVideoUri()
                , localPath, false, audioInfo);
        if (localFile != null) {
            scImg = PathUtils.getBSBDJImgUrl(mark);
        } else {
            return null;
        }
        int playTime = TimeUtils.getTimeByStr(audioInfo.getTimeLen());
        return new VideoBSBDJ(mark, StaticParam.DEFAULT_USER_ID, bsbdj.getWeixinUrl()
                , bsbdj.getText(), bsbdj.getVideoUri(), scImg
                , audioInfo.getWidth(), audioInfo.getHeight()
                , playTime, bsbdj.getCreateTime());
    }

    public static VoiceBSBDJ BSBDJ2VoiceBSBDJ(BSBDJ bsbdj) {
        if (bsbdj == null) {
            return null;
        }
        AudioInfo audioInfo = AudioUtils.getAudioInfo(bsbdj.getVoiceUri());
        if (audioInfo == null) {
            return null;
        }
        String imgUrl = getImgUrl(bsbdj);
        String mark = getMark(bsbdj);
        int playTime = TimeUtils.getTimeByStr(audioInfo.getTimeLen());
        return new VoiceBSBDJ(mark, StaticParam.DEFAULT_USER_ID, bsbdj.getWeixinUrl()
                , bsbdj.getText(), bsbdj.getVoiceUri(), imgUrl
                , playTime, bsbdj.getCreateTime());
    }

    public static String getMark(BSBDJ bsbdj) {
        return bsbdj == null ? null : (bsbdj.get_id() == null
                ? String.valueOf(bsbdj.getId()) : bsbdj.get_id());
    }

    public static String getImgUrl(BSBDJ bsbdj) {
        return bsbdj == null ? null : (bsbdj.getCdnImg() == null
                ? bsbdj.getImage3() : bsbdj.getCdnImg());
    }

}
