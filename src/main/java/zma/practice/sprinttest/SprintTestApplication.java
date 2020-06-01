package zma.practice.sprinttest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import zma.practice.sprinttest.springListen.DIYEvent;

@SpringBootApplication
public class SprintTestApplication {


  public static void main(String[] args) {
    ApplicationContext applicationContext = SpringApplication.run(SprintTestApplication.class, args);
//    ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("applicationContext.xml");
//    ApplicationContext applicationContext3 = new FileSystemXmlApplicationContext("F:/workspace/example/src/appcontext.xml");
    applicationContext.publishEvent(new DIYEvent(""));
  }

}
