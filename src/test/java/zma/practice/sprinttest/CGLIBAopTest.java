package zma.practice.sprinttest;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import zma.practice.sprinttest.proxy.Car;

import java.lang.reflect.Method;

public class CGLIBAopTest {

  @Test
  public void test() {

    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(Car.class);
    enhancer.setCallback(new MethodInterceptor() {
      @Override
      public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB before");
        Object object = methodProxy.invokeSuper(obj, args);
        System.out.println("CGLIB after");
        return object;
      }
    });

    Car car = (Car) enhancer.create();
    System.out.println(car.run());
  }
}
