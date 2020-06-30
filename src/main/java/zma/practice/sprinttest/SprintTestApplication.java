package zma.practice.sprinttest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"zma.practice.sprinttest.mybatisTest.mapper"})
@SpringBootApplication
public class SprintTestApplication {


  public static void main(String[] args) {
//    ApplicationContext applicationContext = SpringApplication.run(SprintTestApplication.class, args);
//    ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("applicationContext.xml");
//    ApplicationContext applicationContext3 = new FileSystemXmlApplicationContext("F:/workspace/example/src/appcontext.xml");
//    applicationContext.publishEvent(new DIYEvent(""));
    SpringApplication.run(SprintTestApplication.class, args);
  }

}
