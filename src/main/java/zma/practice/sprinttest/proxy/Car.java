package zma.practice.sprinttest.proxy;

import org.springframework.stereotype.Component;

@Component
public class Car {

  public String run() {
    System.out.println("小汽车跑啊跑");
    return "小汽车run的返回值";
  }

  public String turnLeft() throws Exception {
    System.out.println("小汽车左拐");
    throw new Exception("左拐异常");
  }

}
