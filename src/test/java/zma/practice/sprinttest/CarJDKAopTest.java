package zma.practice.sprinttest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zma.practice.sprinttest.proxy.Car;
import zma.practice.sprinttest.proxy.WheelThings;
import zma.practice.sprinttest.proxy.springAop.CarJDKAop;

import java.lang.reflect.Proxy;


public class CarJDKAopTest {

  @Test
  public void test() {
    CarJDKAop carJDKAop = new CarJDKAop(new Car());
    Class<?>[] classes = Car.class.getInterfaces();
    WheelThings proxy = (WheelThings) Proxy.newProxyInstance(carJDKAop.getClass().getClassLoader(), Car.class.getInterfaces(), carJDKAop);
    System.out.println(proxy.run());
  }
}
