package unicorn.dao;


import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import unicorn.core.EmployeeMapper;
import unicorn.model.Employee;


/**
 * Created by jitesh-kumar on 7/5/18.
 */

@RegisterRowMapper(EmployeeMapper.class)
public interface EmployeeDAO {

  @SqlQuery("select * from employee")
  List<Employee> getAll();

  @SqlQuery("select * from employee where id = :id")
  Employee getById(@Bind("id") int id);

  @SqlUpdate("insert into employee (firstname, lastname, email) values (:firstname, :lastname, :email)")
  int add(@BindBean Employee employee);
}
