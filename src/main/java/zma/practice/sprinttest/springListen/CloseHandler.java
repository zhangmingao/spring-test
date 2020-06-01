package zma.practice.sprinttest.springListen;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
public class CloseHandler implements ApplicationListener<ContextClosedEvent> {

  @Override
  public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
    System.out.println("关闭事件触发ZMA");
  }
}
