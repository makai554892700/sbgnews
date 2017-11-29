package com.mayousheng.www.sbgnews;

import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {

    private Logger log = LoggerFactory.getLogger(RedisTests.class);

    @Test
    public void testDefaultUserConf() {

    }


    private Session session = new Session() {
        @Override
        public Serializable getId() {
            return "session id";
        }

        @Override
        public Date getStartTimestamp() {
            return null;
        }

        @Override
        public Date getLastAccessTime() {
            return null;
        }

        @Override
        public long getTimeout() throws InvalidSessionException {
            return 0;
        }

        @Override
        public void setTimeout(long maxIdleTimeInMillis) throws InvalidSessionException {

        }

        @Override
        public String getHost() {
            return null;
        }

        @Override
        public void touch() throws InvalidSessionException {

        }

        @Override
        public void stop() throws InvalidSessionException {

        }

        @Override
        public Collection<Object> getAttributeKeys() throws InvalidSessionException {
            return null;
        }

        @Override
        public Object getAttribute(Object key) throws InvalidSessionException {
            return null;
        }

        @Override
        public void setAttribute(Object key, Object value) throws InvalidSessionException {

        }

        @Override
        public Object removeAttribute(Object key) throws InvalidSessionException {
            return null;
        }
    };

}
