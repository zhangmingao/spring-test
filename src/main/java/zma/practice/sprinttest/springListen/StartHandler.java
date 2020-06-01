package zma.practice.sprinttest.springListen;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartHandler implements ApplicationListener<ContextStartedEvent> {

  @Override
  public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
    System.out.println("上下文启动了ZMA");
  }
}
