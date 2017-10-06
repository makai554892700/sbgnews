package com.mayousheng.www.sbgnews.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mayousheng.www.sbgnews.common.base.BaseShowApiResBody;
import com.mayousheng.www.sbgnews.common.conf.enums.ResultEnum;
import com.mayousheng.www.sbgnews.common.conf.pojo.JokeConf;
import com.mayousheng.www.sbgnews.common.exception.JokeException;
import com.mayousheng.www.sbgnews.common.sort.JokeComparator;
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
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.List;

@Service("jokeServiceImpl")
public class JokeServiceImpl implements JokeService {

//    private static boolean isInitOk = false;
    private Logger log = LoggerFactory.getLogger(JokeServiceImpl.class);

    @Resource(name = "jokesMapper")
    private JokesMapper jokesMapper;

    @Resource(name = "jokeConf")
    private JokeConf jokeConf;

    @Override
    public JokeBack loadJokes() {
        return loadJokesByPage(jokeConf.getDefaultPage(), jokeConf.getDefaultCount());
//        if (isInitOk) {
//            return loadJokesByPage(jokeConf.getDefaultPage(), jokeConf.getDefaultCount());
//        } else {
//            return null;
//        }
    }

    @Override
    public List<JokeResponse> getJokesBySearch(JokeLimit jokeLimit) throws Exception {
        List<Joke> result = jokesMapper.getJokeByOffset(
                jokeLimit.getCount(),
                jokeLimit.getCount() * jokeLimit.getPage());
        if (result == null || result.isEmpty()) {
            throw new JokeException(ResultEnum.NO_DATA);
        }
        return JokeUtils.jokes2Responses(result);
    }

    @Override
    @Async("defaultAsync")
    public synchronized void loadAllJokes() throws Exception {
//        log.error("isInitOk=" + isInitOk);
//        if (!isInitOk) {
//            JokeBack jokeBack;
//            int currentPage = 0;
//            boolean haveNext;
//            do {
//                log.error("Loading current Page=" + currentPage);
//                jokeBack = loadJokesByPage(currentPage--, jokeConf.getDefaultCount());
//                if (jokeBack != null) {
//                    if (currentPage < 0) {
//                        currentPage = jokeBack.getShowapiResBody().getAllPages();
//                        haveNext = true;
//                    } else {
//                        haveNext = currentPage > 0;
//                    }
//                } else {
//                    log.error("jokeBack is null.");
//                    haveNext = false;
//                }
//                Thread.sleep(jokeConf.getInitSleepTime());
//            }
//            while (haveNext);
//            isInitOk = true;
//        }
    }

    private JokeBack loadJokesByPage(Integer page, Integer count) {
        byte[] tempData = HttpUtils.getInstance().getURLResponse(String.format(jokeConf.getBaseurl(), page, count), null);
        if (tempData == null) {
            return null;
        }
        String tempStr = new String(tempData, Charset.forName("UTF-8"));
//        log.error("Start load joke tempStr=" + tempStr);
        JokeBack jokeBack = JSONObject.parseObject(tempStr, JokeBack.class);
        if (!jokeConf.getShowapiResCode().equals(jokeBack.getShowapiResCode())) {
            return null;
        }
        BaseShowApiResBody<Joke> showapiResBody = jokeBack.getShowapiResBody();
        List<Joke> jokes = showapiResBody.getContentlist();
        if (!jokeConf.getRetCode().equals(showapiResBody.getRetCode()) || jokes == null) {
            return null;
        }
        Joke tempJoke;
        jokes.sort(new JokeComparator());
        for (Joke joke : jokes) {
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
        return jokeBack;
    }

}
