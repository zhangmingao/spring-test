package zma.practice.sprinttest.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * redisTemplate 默认只支持RedisTemplate<String, String>，只能存字符串，所以我们要用自定义模版
 * 这里我们先实验目前提供的String
 * 见单测
 */
public class RedisBasic {
}
