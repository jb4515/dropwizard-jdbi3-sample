package unicorn.service;


import java.util.List;

import unicorn.dao.EmployeeDAO;
import unicorn.model.Employee;


/**
 * Created by jitesh-kumar on 8/5/18.
 */
public class EmployeeService {

  EmployeeDAO employeeDAO;

  public EmployeeService() {
  }

  public EmployeeService(final EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public List<Employee> getAll() {
    return employeeDAO.getAll();
  }

  public Employee getById(int id) {
    return employeeDAO.getById(id);
  }

  public int add(Employee employee) {
    employeeDAO.add(employee);
    return 1;
  }
}
