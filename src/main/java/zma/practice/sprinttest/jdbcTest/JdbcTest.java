package zma.practice.sprinttest.jdbcTest;

import java.sql.*;

public class JdbcTest {

  public static void main(String[] args) throws Exception {
    Class aClass = Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/my_test";
    String name = "root";//将要连接数据库的账户
    String password = "123456";//将要连接数据库的密码
    Connection connection = DriverManager.getConnection(url,name,password);

    try {
      String sql = "insert into student(student_no, name, age)values(?,?,?)";//定义一个要执行的SQL语句
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setString(1,"S1");//设置SQL语句的第一个参数
      ps.setString(2,"张三");//设置SQL语句的第二个参数
      ps.setInt(3,18);//设置SQL语句的第二个参数
      int result = ps.executeUpdate();
      System.out.println("插入数据:" + result);
      ps.close();

      String sql2 = "SELECT * FROM student";
      Statement statement = connection.createStatement();//sql语句的执行对象
      ResultSet row = statement.executeQuery(sql2);//执行SQL语句
      while(row.next()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("有数据查询到: ");
        stringBuilder.append(" " + row.getInt("age"));
        stringBuilder.append(" " + row.getString("student_no"));
        stringBuilder.append(" " + row.getString("name"));
        System.out.println(stringBuilder.toString());
      }
      statement.close();
    } finally {
      connection.close();
    }
  }
}
