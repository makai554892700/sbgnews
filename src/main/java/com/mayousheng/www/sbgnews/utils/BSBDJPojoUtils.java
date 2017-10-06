package com.mayousheng.www.sbgnews.utils;

import com.mayousheng.www.sbgnews.common.conf.StaticParam;
import com.mayousheng.www.sbgnews.pojo.*;

public class BSBDJPojoUtils {

    public static User BSBDJ2User(BSBDJ bsbdj) {
        if (bsbdj == null) {
            return null;
        }
        return new User(bsbdj.getName(), bsbdj.getName(), StaticParam.SEX_NONE, StaticParam.EMPTY_STR
                , StaticParam.EMPTY_STR, StaticParam.EMPTY_STR, StaticParam.EMPTY_STR, bsbdj.getProfileImage()
                , bsbdj.getWeixinUrl());
    }

    public static PhotoBSBDJ BSBDJ2PhotoBSBDJ(BSBDJ bsbdj) {
        if (bsbdj == null) {
            return null;
        }
        return new PhotoBSBDJ(bsbdj.getId(), StaticParam.DEFAULT_USER_ID, bsbdj.getWeixinUrl()
                , bsbdj.getLove(), bsbdj.getHate(), bsbdj.getText(), bsbdj.getCdnImg(), bsbdj.getCreateTime());
    }

    public static PunsterBSBDJ BSBDJ2PunsterBSBDJ(BSBDJ bsbdj) {
        if (bsbdj == null) {
            return null;
        }
        return new PunsterBSBDJ(bsbdj.getId(), StaticParam.DEFAULT_USER_ID, bsbdj.getWeixinUrl()
                , bsbdj.getLove(), bsbdj.getHate(), bsbdj.getText(), bsbdj.getCreateTime());
    }

    public static VideoBSBDJ BSBDJ2VideoBSBDJ(BSBDJ bsbdj) {
        if (bsbdj == null) {
            return null;
        }
        return new VideoBSBDJ(bsbdj.getId(), StaticParam.DEFAULT_USER_ID, bsbdj.getWeixinUrl()
                , bsbdj.getLove(), bsbdj.getHate(), bsbdj.getText(), bsbdj.getVideoUri(), bsbdj.getCreateTime());
    }

    public static VoiceBSBDJ BSBDJ2VoiceBSBDJ(BSBDJ bsbdj) {
        if (bsbdj == null) {
            return null;
        }
        return new VoiceBSBDJ(bsbdj.getId(), StaticParam.DEFAULT_USER_ID, bsbdj.getWeixinUrl()
                , bsbdj.getLove(), bsbdj.getHate(), bsbdj.getText(), bsbdj.getVoiceUri(), bsbdj.getCdnImg()
                , bsbdj.getCreateTime());
    }

}
