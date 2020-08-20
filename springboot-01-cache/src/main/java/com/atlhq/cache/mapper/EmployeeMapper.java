package com.atlhq.cache.mapper;

import com.atlhq.cache.bean.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EmployeeMapper {
    @Select("select * from employee where id=#{id}")
    public Employee getById(Integer id);
    @Update("update employee set lastName=#{lastName},email=#{email}," +
            "gender=#{gender},d_id=#{dId} where id=#{id}")
    public void updEmp(Employee employee);
    @Delete("delete from employee where id=#{id}")
    public void delEmp(Integer id);
    @Insert("insert into employee(lastName,email,gender,d_id)" +
            "values(#{lastName},#{email},#{gender},#{d_id})")
    public void insertEmp(Employee employee);
    @Select("select * from employee where lastName=#{lastName}")
    public Employee getEmpByLastName(String lastName);
}
