package com.boot.demo.controller;

import com.boot.feign.redis.IRedisFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/common")
public class CommonController
{

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IRedisFeign iRedisFeign;

    /**
     * <pre>
     * <一句话功能简述>
     * 数据存储
     * <功能详细描述>
     * </pre>
     */
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public void save()
    {
        String result = "";

        result = iRedisFeign.set("people_one", "Mr.hao", 60);
        logger.info("result:{}", result);

        Map<String,Object> map = new HashMap<>();
        map.put("key","people_two");
        map.put("value","Mr.yong");
        map.put("seconds",120);
        result = iRedisFeign.set(map);
        logger.info("result:{}", result);
    }

}
