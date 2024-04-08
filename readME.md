In this particular demo project, the different layers of an application are being mirrored on.
The different layers are
- API Layer
- Service Layer
- Data Access Layer
  And there's also a database

The dependencies for this demo project are - JPA, Spring boot Web and postgreSQL

JPA needs a database to connect to, to actually run
Here the database used in PostgreSQL
open sql shell and
CREATE DATABASE student;
GRANT ALL PRIVILEGES ON DATABASE "student" TO postgres;
and then run
\c student
which will run the database server in port 5432 which also has been put in application.properties file