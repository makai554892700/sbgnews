package com.mayousheng.www.sbgnews.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mayousheng.www.sbgnews.common.base.BaseShowApiResBody;
import com.mayousheng.www.sbgnews.common.conf.StaticParam;
import com.mayousheng.www.sbgnews.common.conf.enums.BaseResultEnum;
import com.mayousheng.www.sbgnews.common.conf.pojo.DefaultUserConf;
import com.mayousheng.www.sbgnews.common.conf.pojo.JokeConf;
import com.mayousheng.www.sbgnews.common.exception.BaseException;
import com.mayousheng.www.sbgnews.common.sort.JokeComparator;
import com.mayousheng.www.sbgnews.mapper.JokesMapper;
import com.mayousheng.www.sbgnews.mapper.UserMapper;
import com.mayousheng.www.sbgnews.pojo.Joke;
import com.mayousheng.www.sbgnews.pojo.JokeBack;
import com.mayousheng.www.sbgnews.pojo.JokeLimit;
import com.mayousheng.www.sbgnews.pojo.User;
import com.mayousheng.www.sbgnews.service.JokeService;
import com.mayousheng.www.sbgnews.service.NewsDescService;
import com.mayousheng.www.sbgnews.utils.HttpUtils;
import com.mayousheng.www.sbgnews.utils.RC4Utils;
import com.mayousheng.www.sbgnews.utils.UserUtils;
import com.mayousheng.www.sbgnews.vo.response.JokeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Service("jokeServiceImpl")
public class JokeServiceImpl implements JokeService {

    private static boolean isInitOk;
    private Logger log = LoggerFactory.getLogger(JokeServiceImpl.class);

    @Resource(name = "jokesMapper")
    private JokesMapper jokesMapper;
    @Resource(name = "jokeConf")
    private JokeConf jokeConf;
    @Resource(name = "newsDescServiceImpl")
    private NewsDescService newsDescService;
    @Resource(name = "userMapperImpl")
    private UserMapper userMapper;
    @Resource(name = "defaultUserConf")
    private DefaultUserConf defaultUserConf;

    @Override
    public void setLoaded(boolean loaded) {
        isInitOk = loaded;
    }

    @Override
    public JokeBack loadJokes() {
        if (isInitOk) {
            return loadJokesByPage(jokeConf.getDefaultPage(), jokeConf.getDefaultCount());
        } else {
            return null;
        }
    }

    @Override
    public List<JokeResponse> getJokesBySearch(JokeLimit jokeLimit) throws Exception {
        List<Joke> result = jokesMapper.getJokeByOffset(
                jokeLimit.getCount(),
                jokeLimit.getCount() * jokeLimit.getPage());
        if (result == null || result.isEmpty()) {
            throw new BaseException(BaseResultEnum.NO_DATA);
        }
        return jokes2Responses(result, jokeLimit);
    }

    @Override
    @Async("defaultAsync")
    public synchronized void loadAllJokes() throws Exception {
        log.error("isInitOk=" + isInitOk);
        if (!isInitOk) {
            JokeBack jokeBack;
            int currentPage = 0;
            boolean haveNext;
            do {
                log.error("Loading current Page=" + currentPage);
                jokeBack = loadJokesByPage(currentPage--, jokeConf.getDefaultCount());
                if (jokeBack != null) {
                    if (currentPage < 0) {
                        currentPage = jokeBack.getShowapiResBody().getAllPages();
                        haveNext = true;
                    } else {
                        haveNext = currentPage > 0;
                    }
                } else {
                    log.error("jokeBack is null.");
                    haveNext = false;
                }
                Thread.sleep(jokeConf.getInitSleepTime());
            }
            while (haveNext);
            isInitOk = true;
        }
    }

    private JokeBack loadJokesByPage(Integer page, Integer count) {
        byte[] tempData = HttpUtils.getInstance().getURLResponse(String.format(jokeConf.getBaseurl(), page, count), null);
        if (tempData == null) {
            return null;
        }
        String tempStr = new String(tempData, Charset.forName("UTF-8"));
//        log.error("Start load joke tempStr=" + tempStr);
        JokeBack jokeBack;
        try {
            jokeBack = JSONObject.parseObject(tempStr, JokeBack.class);
        } catch (Exception e) {
            log.error("tempStr=" + tempStr + ";e=" + e);
            return null;
        }
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
            joke.setUserId(defaultUserConf.getUser().getId());
            joke.setText(RC4Utils.strToHexString(joke.getText()));
            try {
                jokesMapper.save(joke);
            } catch (Exception e) {
                log.error("loadJokes e=" + e);
            }
        }
        return jokeBack;
    }

    private JokeResponse joke2Response(Joke joke) {
        if (joke == null) {
            return null;
        }
        User user = userMapper.findOne(joke.getUserId());
        if (user == null) {
            user = defaultUserConf.getUser();
        }
        return new JokeResponse(joke.getId(), newsDescService.getNewsDesc(joke.getCt()
                , joke.getId(), StaticParam.TABLE_NAME_JOKE), UserUtils.user2UserDesc(user)
                , joke.getText(), joke.getTitle());
    }

    private List<JokeResponse> jokes2Responses(List<Joke> jokes, JokeLimit jokeLimit) {
        if (jokes == null) {
            return null;
        }
        List<JokeResponse> jokeRespons = new ArrayList<>();
        for (Joke joke : jokes) {
            if (jokeLimit.isNeedRealText()) {
                joke.setText(RC4Utils.hexStringToString(joke.getText()));
            }
            jokeRespons.add(joke2Response(joke));
        }
        return jokeRespons;
    }

}
