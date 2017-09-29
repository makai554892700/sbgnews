package com.mayousheng.www.sbgnews.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mayousheng.www.sbgnews.common.conf.enums.ResultEnum;
import com.mayousheng.www.sbgnews.common.conf.pojo.JokeConf;
import com.mayousheng.www.sbgnews.common.exception.JokeException;
import com.mayousheng.www.sbgnews.mapper.JokesMapper;
import com.mayousheng.www.sbgnews.pojo.Joke;
import com.mayousheng.www.sbgnews.pojo.JokeBack;
import com.mayousheng.www.sbgnews.pojo.JokeLimit;
import com.mayousheng.www.sbgnews.service.JokeService;
import com.mayousheng.www.sbgnews.utils.HttpUtils;
import com.mayousheng.www.sbgnews.utils.vo.JokeUtils;
import com.mayousheng.www.sbgnews.vo.response.JokeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.nio.charset.Charset;
import java.util.List;

@Service("jokeServiceImpl")
public class JokeServiceImpl implements JokeService {

    private Logger log = LoggerFactory.getLogger(JokeServiceImpl.class);

    @Resource(name = "jokesMapper")
    private JokesMapper jokesMapper;

    @Resource(name = "jokeConf")
    private JokeConf jokeConf;

    @Override
    public void loadJokes() {
        byte[] tempData = HttpUtils.getInstance().getURLResponse(jokeConf.getBaseurl(), null);
        if (tempData == null) {
            return;
        }
        String tempStr = new String(tempData, Charset.forName("UTF-8"));
//        log.error("Start load joke tempStr=" + tempStr);
        JokeBack jokeBack = JSONObject.parseObject(tempStr, JokeBack.class);
        if (!jokeConf.getShowapiResCode().equals(jokeBack.getShowapiResCode())) {
            return;
        }
        JokeBack.ShowapiResBody showapiResBody = jokeBack.getShowapiResBody();
        if (!jokeConf.getRetCode().equals(showapiResBody.getRetCode())) {
            return;
        }
        Joke tempJoke;
        for (Joke joke : showapiResBody.getContentlist()) {
            tempJoke = jokesMapper.getJokesByTitle(joke.getTitle());
            if (tempJoke != null) {
                continue;
            }
            try {
                jokesMapper.save(joke);
            } catch (Exception e) {
                log.error("loadJokes e=" + e);
            }
        }
        try {
            Thread.sleep(jokeConf.getSleepTime());
        } catch (Exception e) {
        }
    }

    @Override
    public List<JokeResponse> getJokesBySearch(@Valid JokeLimit jokeLimit) throws Exception {
        List<Joke> result = jokesMapper.getJokeByOffset(
                jokeLimit.getCount() * jokeLimit.getPage(),
                jokeLimit.getCount());
        if (result == null || result.isEmpty()) {
            throw new JokeException(ResultEnum.TOP_NEWS_NO_DATA);
        }
        return JokeUtils.jokes2Responses(result);
    }
}
