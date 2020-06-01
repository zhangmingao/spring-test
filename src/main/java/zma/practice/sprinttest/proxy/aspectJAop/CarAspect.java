package zma.practice.sprinttest.proxy.aspectJAop;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 小汽车某些动作代理
 */

@Component
@Aspect
public class CarAspect {

  @Pointcut("execution(* zma.practice.sprinttest.proxy.Car.run(..))")
  public void carPoint(){}

  @Pointcut("execution(* zma.practice.sprinttest.proxy.Car.turnLeft(..))")
  public void carTurnLeftPoint(){}

  @Before(value = "carPoint()")
  public void beforeMethod() {
    System.out.println("代理：汽车要启动了");
  }

  // 也可以这么写，不定义切点就很麻烦
//  @Before("execution(* zma.practice.sprinttest.proxy.Car.run(..))")
//  public void beforeMethod() {
//
//  }

  @After(value = "carPoint()")
  public void afterMethod() {
    System.out.println("代理 afterMethod：汽车跑完了");
  }

  @AfterReturning(value = "carPoint()", returning="result")
  public void afterReturning(Object result) {
    System.out.println("代理 afterReturning：" + result);
  }


//  @Before(value = "carTurnLeftPoint()")
//  public void beforeMethod() {
//    System.out.println("代理：汽车要启动了");
//  }
//
//  @After(value = "carTurnLeftPoint()")
//  public void afterMethod() {
//    System.out.println("代理 afterMethod：汽车跑完了");
//  }
//
//  @AfterReturning(value = "carTurnLeftPoint()", returning="result")
//  public void afterReturning(Object result) {
//    System.out.println("代理 afterReturning：" + result);
//  }
//
//  @AfterThrowing(value = "carTurnLeftPoint()", throwing = "e")
//  public void afterThrowing(Exception e) {
//    System.out.println("代理 afterThrowing: 发生了异常" + e.getMessage());
//    e.printStackTrace();
//  }

  @Around(value = "carPoint()")
  public String around() {
    System.out.println("代理 around：包围");
    return "代理 around：包围返回";
  }


}
