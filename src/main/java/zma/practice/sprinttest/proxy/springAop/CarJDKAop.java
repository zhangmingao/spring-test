package zma.practice.sprinttest.proxy.springAop;


import zma.practice.sprinttest.proxy.Car;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 用jdk动态代理实现
 */
public class CarJDKAop implements InvocationHandler {

  // 代理类中的真实对象
  private Car realObject;

  // 给真实对象赋值的构造函数
  public CarJDKAop() {

  }
  public CarJDKAop(Car object) {
    this.realObject = object;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args)
          throws Throwable {
    System.out.println("之前");
    Object invoke = method.invoke(realObject, args);
    System.out.println("之后");
    return invoke;
  }
}
