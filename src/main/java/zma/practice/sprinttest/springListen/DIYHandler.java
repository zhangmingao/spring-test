package zma.practice.sprinttest.springListen;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DIYHandler implements ApplicationListener<DIYEvent> {

  @Override
  public void onApplicationEvent(DIYEvent diyEvent) {
    System.out.println("自定义事件触发");
  }
}
