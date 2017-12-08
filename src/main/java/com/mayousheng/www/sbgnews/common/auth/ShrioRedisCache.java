package com.mayousheng.www.sbgnews.common.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.mayousheng.www.sbgnews.common.conf.ShiroConfig;
import com.mayousheng.www.sbgnews.common.conf.StaticParam;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.google.common.collect.Sets;

public class ShrioRedisCache<K, V> implements Cache<K, V> {
    private Logger log = LoggerFactory.getLogger(ShiroConfig.class);
    private RedisTemplate<String, V> redisTemplate;
    private String prefix = StaticParam.SHIRO_PREFIX;

    public ShrioRedisCache(RedisTemplate<String, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public ShrioRedisCache(RedisTemplate<String, V> redisTemplate, String prefix) {
        this(redisTemplate);
        setPrefix(prefix);
    }

    @Override
    public V get(K key) throws CacheException {
        log.debug("get Key: {}", key);
        if (key == null) {
            return null;
        }
        String realKey = getRealKey(key);
        return redisTemplate.opsForValue().get(realKey);
    }

    @Override
    public V put(K key, V value) throws CacheException {
        log.debug(" put Key: {}, value: {}", key, value);
        if (key == null || value == null) {
            return null;
        }
        String realKey = getRealKey(key);
        redisTemplate.opsForValue().set(realKey, value, StaticParam.SHIRO_SESSION_TIME_OUT, TimeUnit.SECONDS);
        return value;
    }

    @Override
    public V remove(K key) throws CacheException {
        log.debug("remove Key: {}", key);
        if (key == null) {
            return null;
        }
        String realKey = getRealKey(key);
        ValueOperations<String, V> vo = redisTemplate.opsForValue();
        V value = vo.get(realKey);
        redisTemplate.delete(realKey);
        return value;
    }

    @Override
    public void clear() throws CacheException {
        redisTemplate.getConnectionFactory().getConnection().flushDb();
    }

    @Override
    public int size() {
        Long len = redisTemplate.getConnectionFactory().getConnection().dbSize();
        return len.intValue();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Set<K> keys() {
        Set<String> set = redisTemplate.keys(getPrefix());
        Set<K> result = Sets.newHashSet();
        if (CollectionUtils.isEmpty(set)) {
            return Collections.emptySet();
        }
        for (String key : set) {
            result.add((K) key);
        }
        return result;
    }

    @Override
    public Collection<V> values() {
        Set<K> keys = keys();
        List<V> values = new ArrayList<>(keys.size());
        for (K k : keys) {
            values.add(redisTemplate.opsForValue().get(getRealKey(k)));
        }
        return values;
    }

    private String getRealKey(K key) {
        return this.prefix + key;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}