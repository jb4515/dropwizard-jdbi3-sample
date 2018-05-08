package unicorn.core;


import io.dropwizard.db.ManagedDataSource;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;


/**
 * Created by jitesh-kumar on 8/5/18.
 */
public class JdbiFactory {

  private boolean autoInstallPlugins = false;

  public JdbiFactory() {
  }

  public JdbiFactory(boolean autoInstallPlugins) {
    this.autoInstallPlugins = autoInstallPlugins;
  }

  public Jdbi build(Environment environment,
                    PooledDataSourceFactory configuration,
                    String name) {
    ManagedDataSource dataSource = configuration.build(environment.metrics(), name);
    Jdbi jdbi = Jdbi.create(dataSource);
    if (autoInstallPlugins) {
      jdbi.installPlugins();
    }
    environment.lifecycle().manage(dataSource);
    return jdbi;
  }
}
