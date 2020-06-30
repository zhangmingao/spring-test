package zma.practice.sprinttest.mybatisTest;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Method;
import java.util.Properties;

@Intercepts({@Signature(
        type= Executor.class,
        method = "query",
        args = {MappedStatement.class,Object.class})})
public class ExamplePlugin implements Interceptor {

  public Object intercept(Invocation invocation) throws Throwable {
    Object target = invocation.getTarget(); //被代理对象
    Method method = invocation.getMethod(); //代理方法
    Object[] args = invocation.getArgs(); //方法参数
    // do something ...... 方法拦截前执行代码块
    Object result = invocation.proceed();
    // do something .......方法拦截后执行代码块
    return result;
  }

  public Object plugin(Object target) {
    return Plugin.wrap(target, this);
  }

  public void setProperties(Properties var1) {

  }
}
