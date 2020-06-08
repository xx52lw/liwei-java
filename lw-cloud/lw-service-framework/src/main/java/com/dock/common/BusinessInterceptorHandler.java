package com.dock.common;


import com.alibaba.fastjson.JSON;
import enums.*;
import model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class BusinessInterceptorHandler {


    @Autowired
    protected CacheService cacheService;

    public boolean process(HttpServletRequest req, HttpServletResponse resp, String token) throws IOException {
        String reqURI = req.getRequestURI();


//        String orgId = null;
//        if(reqURI.contains(Constant.PLATFORM.APP)) {
//            orgId = req.getHeader(Constant.REQUEST_ORGID);
//            if (StringUtils.isBlank(orgId)) {
//                orgId = req.getParameter(Constant.REQUEST_ORGID);
//            }
//            log.info("reqURI = " + reqURI + ", orgId = " + orgId);
//        }

        User user = (User) cacheService.get(Constant.Cache.TOKEN + Constant.COLON + token);

        if(StringUtils.isBlank(token)) {
            log.warn("用户未登录或token过期 token = " + token);
            printResult(resp, JSON.toJSONString(Result.fail(ResultCode.USER_NOT_LOGIN)));
            return false;
        }
        user.setToken(token);
        SystemContext.setCurrentValue(SystemContextType.CURRENT_USER, User.class, user);

        return true;
    }

    private void printResult(HttpServletResponse resp, String result) throws IOException {
        resp.setContentType("application/json; charset=UTF-8");
        resp.setHeader("Cache-Control", "no-cache"); // 取消浏览器缓存
        PrintWriter out = resp.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }

    public void clean() {
        SystemContext.clearCurrentValue(SystemContextType.CURRENT_USER);
        SystemContext.clearCurrentValue(SystemContextType.CURRENT_ORG);
    }

    public static interface CacheService {

        void set(String key, Object value);

        void set(String key, Object value, long timeout);

        void set(String key, Object value, Duration timeout);

        Object get(String key);

        Boolean tryLock(String key);

        Boolean unLock(String key);

    }

    @Service
    public static class CacheServiceImpl implements CacheService {

        @Autowired
        private RedisTemplate redisTemplate;

        @Override
        public void set(String key, Object value) {
            redisTemplate.opsForValue().set(key, value);
        }

        @Override
        public void set(String key, Object value, long timeout) {
            redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
        }

        @Override
        public void set(String key, Object value, Duration timeout) {
            redisTemplate.opsForValue().set(key, value, timeout);
        }

        @Override
        public Object get(String key) {
            return redisTemplate.opsForValue().get(key);
        }

        public Long decr(String key) {
            return redisTemplate.opsForValue().decrement(key);
        }

        public void leftPushAll(String key, String... values) {
            redisTemplate.opsForList().leftPushAll(key, values);
        }

        public Boolean delete(String key) {
            return redisTemplate.delete(key);
        }

        public Object leftPop(String key) {
            return redisTemplate.opsForList().leftPop(key);
        }

        public Boolean tryLock(String key) {
            return redisTemplate.opsForValue().setIfAbsent(key, "lock", 60, TimeUnit.SECONDS);
        }

        public Boolean unLock(String key) {
            return redisTemplate.delete(key);
        }
    }
}
