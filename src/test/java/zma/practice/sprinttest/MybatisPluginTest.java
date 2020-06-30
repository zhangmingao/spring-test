package zma.practice.sprinttest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zma.practice.sprinttest.mybatisTest.mapper.EmployeeMapper;
import zma.practice.sprinttest.mybatisTest.entity.StudentEntity;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPluginTest {

  @Autowired
  private EmployeeMapper employeeMapper;

  @Test
  public void test() {
    List<StudentEntity> list = employeeMapper.getByName("李四");
    System.out.println("Zma");
  }
}
