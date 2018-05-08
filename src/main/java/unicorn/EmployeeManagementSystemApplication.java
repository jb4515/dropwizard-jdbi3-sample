package unicorn;


import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;
import unicorn.core.JdbiFactory;
import unicorn.dao.EmployeeDAO;
import unicorn.resources.EmployeeResource;
import unicorn.service.EmployeeService;


public class EmployeeManagementSystemApplication extends Application<EmployeeManagementSystemConfiguration> {

  private static final String DATABASE_DIALECT = "postgresql";
  private static final String EMPLOYEE_MANAGEMENT_SERVICE = "Employee Management service";

  public static void main(final String[] args) throws Exception {
    new EmployeeManagementSystemApplication().run(args);
  }

  @Override
  public String getName() {
    return EMPLOYEE_MANAGEMENT_SERVICE;
  }

  @Override
  public void initialize(final Bootstrap<EmployeeManagementSystemConfiguration> bootstrap) {
  }

  @Override
  public void run(final EmployeeManagementSystemConfiguration config,
                  final Environment environment) {

    final JdbiFactory factory = new JdbiFactory(true);
    final Jdbi jdbi = factory.build(environment, config.getDataSourceFactory(), DATABASE_DIALECT);
    final EmployeeDAO employeeDAO = jdbi.onDemand(EmployeeDAO.class);
    final EmployeeResource employeeResource = new EmployeeResource(environment.getValidator(), new EmployeeService(employeeDAO));
    environment.jersey().register(employeeResource);

  }

}
