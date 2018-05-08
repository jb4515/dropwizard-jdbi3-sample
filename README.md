# dropwizard-jdbi3-sample
# EmployeeManagementSystem

# Pre-Requisites if you are going to use default db as postgres:
Run commands under unicorn/src/main/resources/db/migration/V1__init.sql for creating a user, database and table before
running application. Would be including flyway later.

How to start the EmployeeManagementSystem application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/unicorn-0.1.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---
-- not yet working.
To see your applications health enter url `http://localhost:8081/healthcheck`

