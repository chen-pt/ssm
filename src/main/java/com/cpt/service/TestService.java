package com.cpt.service;

import com.cpt.util.CacheSetConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestService {



    @CachePut(value = "common", key = CacheSetConfig.CACHE_TEST)
    public Map cahePutMap(Integer themeId , Integer siteId){
        Map<String,Object> map = new HashMap<>();

        map.put("K1","第一个");
        map.put("K2","第二个");
        map.put("K3","第三个");
        map.put("themeId",themeId);
        map.put("siteId",siteId);

        return map;
    }

    @CachePut(value = "common", key = CacheSetConfig.CACHE_TEST)
    public String getTest(Integer themeId , Integer siteId){

        return "缓存成功";
    }

    @Cacheable(value = "common", key = CacheSetConfig.CACHE_TEST)
    public String put(Integer themeId , Integer siteId){

        return "缓存成功2";
    }
}
