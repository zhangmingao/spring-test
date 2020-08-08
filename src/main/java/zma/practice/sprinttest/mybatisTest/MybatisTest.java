package zma.practice.sprinttest.mybatisTest;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import zma.practice.sprinttest.mybatisTest.entity.Employee;
import zma.practice.sprinttest.mybatisTest.mapper.EmployeeMapper;

import java.io.IOException;
import java.util.UUID;

public class MybatisTest {

//  public static void main(String[] args) {
//    DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory();
//    defaultSqlSessionFactory.openSession(ExecutorType.BATCH);
//    defaultSqlSessionFactory.openSession(ExecutorType.REUSE);
//    SqlSession sqlSession = defaultSqlSessionFactory.openSession(ExecutorType.SIMPLE);
//    sqlSession.close();
//  }

  //批量保存方法测试
  public void testBatch() throws IOException {
    SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    //可以执行批量操作的sqlSession
    SqlSession openSession = sqlSessionFactory.openSession(ExecutorType.BATCH);

    //批量保存执行前时间
    long start = System.currentTimeMillis();
    try {
      EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
      for (int i = 0; i < 1000; i++) {
        mapper.addEmp(new Employee(UUID.randomUUID().toString().substring(0, 5), "b", "1"));
      }

      openSession.commit();
      long end = System.currentTimeMillis();
      //批量保存执行后的时间
      System.out.println("执行时长" + (end - start));
      //批量 预编译sql一次==》设置参数==》10000次==》执行1次   677
      //非批量  （预编译=设置参数=执行 ）==》10000次   1121

    } finally {
      openSession.close();
    }
  }
}
