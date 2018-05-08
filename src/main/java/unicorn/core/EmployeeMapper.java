package unicorn.core;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import unicorn.model.Employee;


/**
 * Created by jitesh-kumar on 7/5/18.
 */
public class EmployeeMapper implements RowMapper<Employee> {

  public EmployeeMapper() {
  }

  @Override
  public Employee map(ResultSet resultSet, StatementContext statementContext) throws SQLException {
    return new Employee(resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email")
    );
  }
}
