package zma.practice.sprinttest.mybatisTest.mapper;

import zma.practice.sprinttest.mybatisTest.entity.Employee;
import zma.practice.sprinttest.mybatisTest.entity.StudentEntity;

import java.util.List;

public interface EmployeeMapper {
  //批量保存员工
  Long addEmp(Employee employee);

  List<StudentEntity> getByName(String name);
}
