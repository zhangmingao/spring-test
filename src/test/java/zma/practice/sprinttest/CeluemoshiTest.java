package zma.practice.sprinttest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zma.practice.sprinttest.celuemoshiSpring.Master;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CeluemoshiTest {

  @Autowired
  private List<Master> lists;

  @Test
  public void test() {
    Optional<Master> optional =  lists.stream().filter(e -> e.support("Slave1")).findFirst();
    optional.ifPresent(master -> System.out.println("找到Bean" + master.getClass().getSimpleName()));
  }
}
