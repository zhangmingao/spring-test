package zma.practice.sprinttest.springListen;

import org.springframework.context.ApplicationEvent;

public class DIYEvent extends ApplicationEvent {

  public DIYEvent(Object source) {
    super(source);
  }
}
