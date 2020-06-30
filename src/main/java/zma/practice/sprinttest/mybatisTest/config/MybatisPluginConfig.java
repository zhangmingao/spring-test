package zma.practice.sprinttest.mybatisTest.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zma.practice.sprinttest.mybatisTest.QueryPlugin;
import zma.practice.sprinttest.mybatisTest.QueryPlugin2;

@Configuration
@MapperScan({"zma.practice.sprinttest.mybatisTest.mapper"})
public class MybatisPluginConfig {

  @Bean
  public QueryPlugin getQueryPlugin() {
    return new QueryPlugin();
  }

  @Bean
  public QueryPlugin2 getQueryPlugin2() {
    return new QueryPlugin2();
  }
}
