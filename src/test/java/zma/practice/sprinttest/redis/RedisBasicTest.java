package zma.practice.sprinttest.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisBasicTest {

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Autowired
  @Qualifier("objectRedisTemplate")
  private RedisTemplate<String, Object> objectRedisTemplate;

  @Test
  public void test1() {
    redisTemplate.opsForValue().set("Zma:test1", "aaa", 180, TimeUnit.SECONDS);
  }

  @Test
  public void test2(){
    String s = redisTemplate.opsForValue().get("Zma:test1");
    System.out.println(s);
  }

  @Test
  public void demo1() {
    Long p = 9L;
    //从左边插入，即插入到列表头部
    p = redisTemplate.opsForList().leftPush("product:list", "iphone xs max");
    System.out.println(p);
    p = redisTemplate.opsForList().leftPush("product:list", "thinkpad x1 carbon");
    System.out.println(p);
    p = redisTemplate.opsForList().leftPush("product:list", "mackBook pro13");
    System.out.println(p);
    p = redisTemplate.opsForList().leftPush("product:list", "HuaWei Mate20 pro");
    System.out.println(p);
  }

  @Test
  public void demo2() {
    for(int i = 0; i < 4; i++) {
      System.out.println(redisTemplate.opsForList().leftPop("product:list"));
    }
  }


  @Test
  public void diyTest1() {
    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList.add(2);
    arrayList.add(5);
    arrayList.add(33);
    objectRedisTemplate.opsForValue().set("Zma:testObj", arrayList, 180, TimeUnit.SECONDS);
  }

  @Test
  public void diyTest2() {
    ArrayList<Integer> arrayList = (ArrayList<Integer>)objectRedisTemplate.opsForValue().get("Zma:testObj");
    for(Integer i : arrayList) {
      System.out.println(i);
    }
  }

  @Autowired
  private RedisLockRegistry redisLockRegistry;

  @Test
  public void lockTest() {
    boolean locked = false;
    Lock lock = redisLockRegistry.obtain("Zma:Lock");
    try{
      System.out.println("尝试获取锁");
      locked = lock.tryLock(2, TimeUnit.SECONDS);
      if(!locked) {
        throw new Exception("没有等到锁");
      }
      System.out.println("获取锁成功");
    } catch (Exception e){
      e.printStackTrace();
    } finally {
      if(locked) {
        lock.unlock();
        System.out.println("释放锁");
      }
    }
  }

}
