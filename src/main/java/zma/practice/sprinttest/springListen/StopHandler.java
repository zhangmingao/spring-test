package zma.practice.sprinttest.springListen;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

@Component
public class StopHandler implements ApplicationListener<ContextStoppedEvent> {

  @Override
  public void onApplicationEvent(ContextStoppedEvent contextStoppedEvent) {
    System.out.println("停止事件触发");
  }
}
