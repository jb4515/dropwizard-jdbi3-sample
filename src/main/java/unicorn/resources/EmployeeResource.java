package unicorn.resources;


import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import unicorn.model.Employee;
import unicorn.service.EmployeeService;


/**
 * Created by jitesh-kumar on 7/5/18.
 */
@Path("/employees")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class EmployeeResource {

  private final Validator validator;
  private final EmployeeService employeeService;

  public EmployeeResource(Validator validator, EmployeeService employeeService) {
    this.validator = validator;
    this.employeeService = employeeService;
  }

  @GET
  public List<Employee> getAll() {
    return employeeService.getAll();
  }

  @GET
  @Path("/{id}")
  public Response getEmployeeById(@PathParam("id") Integer id) {
    System.out.println("---------&&&&&&&&&---------------");
    System.out.println("employeeService :" + employeeService);
    Employee employee = employeeService.getById(id);
    if (employee != null) {
      return Response.ok(employee).build();
    }
    else {
      return Response.status(NOT_FOUND).build();
    }
  }

  @POST
  public Response addEmployee(Employee employee) throws URISyntaxException {
    Set<ConstraintViolation<Employee>> violations = validator.validate(employee);
    if (violations.size() > 0) {
      ArrayList<String> validationMessages = new ArrayList<>();
      for (ConstraintViolation<Employee> violation : violations) {
        validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
      }
      return Response.status(BAD_REQUEST).entity(validationMessages).build();
    }
    employeeService.add(employee);
    return null;
  }
}
