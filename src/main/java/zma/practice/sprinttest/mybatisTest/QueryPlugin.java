package zma.practice.sprinttest.mybatisTest;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;

import java.lang.reflect.Method;
import java.sql.Statement;
import java.util.Properties;

@Intercepts({@Signature(
        type= StatementHandler.class,
        method = "query",
        args = {Statement.class, ResultHandler.class})})
public class QueryPlugin implements Interceptor {

  public Object intercept(Invocation invocation) throws Throwable {

    Object[] args = invocation.getArgs();
    System.out.print("Mybatis查询插件:" );
    for (Object arg : args) {
      System.out.print(String.valueOf(arg) + " ");
    }
    System.out.println();
    return invocation.proceed();
  }

  public Object plugin(Object target) {
    return Plugin.wrap(target, this);
  }

  public void setProperties(Properties var1) {

  }
}
