package com.bing.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@RestController
@Slf4j
public class LockController {

    @Resource
    private RedisTemplate redisTemplate;


    @GetMapping("/test2")
    public String test2(String key){
        return key;
    }

    @RequestMapping("/test")
    public String test(String key) throws InterruptedException {
        Long timeMillis = System.currentTimeMillis() + 5000;
        //如果下一个线程过来 没拿到锁  一直阻塞
        boolean lock = this.lock(String.valueOf(timeMillis), key);
        if (lock){
            log.error("我被锁住了");
//            Thread.sleep(100000);
            this.unlock(String.valueOf(timeMillis),key);
        }else {
            return "这个锁被别人拿到了已经";
        }

        return "ok";
    }

    private boolean lock(String expireStr, String lockKey) {
        while (true) {
            try {
                if (redisTemplate.opsForValue().setIfAbsent(lockKey, expireStr)) {
                    return true;
                }
//redis里key的时间
                String currentValue = (String) redisTemplate.opsForValue().get(lockKey);
//判断锁是否已经过期，过期则重新设置并获取
                if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()) {
//设置锁并返回旧值
                    String oldValue = (String) redisTemplate.opsForValue().getAndSet(lockKey, expireStr);
//比较锁的时间，如果不一致则可能是其他锁已经修改了值并获取
                    if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                        return true;
                    }
                }
//延时
               /* try {
                    Thread.sleep(RETRY_MILLIS);
                } catch (InterruptedException e) {
                    log.error("【redis分布式锁】sleep异常,lockKey:" + lockKey + “,error:” + e.getMessage(), e);
// Restore interrupted state…
                    Thread.currentThread().interrupt();
                }*/
            } catch (Exception e) {
                log.error("【redis分布式锁】加锁异常,lockKey:" + lockKey + ",error:" + e.getMessage());
            }
        }
    }


    private void unlock(String value, String lockKey) {
        try {
            String currentValue = (String) redisTemplate.opsForValue().get(lockKey);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                redisTemplate.delete(lockKey);
            }
        } catch (Exception e) {
            log.error("【redis分布式锁】解锁异常:" + e.getMessage(), e);
        }
    }
}
