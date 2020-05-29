package zma.practice.sprinttest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zma.practice.sprinttest.proxy.Car;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CarAspectTest {

  @Autowired
  private Car car;

  @Test
  public void runTest() {
    System.out.println("实际调用：" + car.run());
  }

  @Test
  public void leftTest() throws Exception {
    car.turnLeft();
  }
}
