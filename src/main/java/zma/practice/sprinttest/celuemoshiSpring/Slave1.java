package zma.practice.sprinttest.celuemoshiSpring;

import org.springframework.stereotype.Service;

@Service
public class Slave1 implements Master {

  @Override
  public boolean support(String code) {
    System.out.println(this.getClass().getSimpleName());
    return this.getClass().getSimpleName().equals(code);
  }
}
