package zma.practice.sprinttest.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer1 {

  @KafkaListener(topics = {"ecm_test_p"}, groupId = "group1")
  public void consumer2(String message) {
    System.out.println("zma group1: " + message);
  }

  @KafkaListener(topics = {"ecm_test_p"}, groupId = "group0")
  public void consumer1(String message) {
    System.out.println("zma group0: " + message);

  }

}
