
# Spring Boot Security ACL Postgres

Start PostgreSQL database.

```
docker compose up -d
```

Start the application.

```
./gradlew bootrun
```

Use `TRACE` for the logging level.

```
logging.level.org.springframework.security=TRACE
```

You should see the following error message.

```
2024-12-06T23:03:33.972+01:00 DEBUG 99015 --- [demo] [           main] o.s.security.acls.jdbc.AclClassIdUtils   : Unable to obtain the class id type

org.postgresql.util.PSQLException: The column name class_id_type was not found in this ResultSet.
        at org.postgresql.jdbc.PgResultSet.findColumn(PgResultSet.java:3094) ~[postgresql-42.7.4.jar:42.7.4]
        at org.postgresql.jdbc.PgResultSet.getString(PgResultSet.java:2930) ~[postgresql-42.7.4.jar:42.7.4]
        at com.zaxxer.hikari.pool.HikariProxyResultSet.getString(HikariProxyResultSet.java) ~[HikariCP-5.1.0.jar:na]
        at org.springframework.security.acls.jdbc.AclClassIdUtils.classIdTypeFrom(AclClassIdUtils.java:90) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.security.acls.jdbc.AclClassIdUtils.hasValidClassIdType(AclClassIdUtils.java:81) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.security.acls.jdbc.AclClassIdUtils.identifierFrom(AclClassIdUtils.java:71) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.security.acls.jdbc.BasicLookupStrategy$ProcessResultSet.convertCurrentResultIntoObject(BasicLookupStrategy.java:580) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.security.acls.jdbc.BasicLookupStrategy$ProcessResultSet.extractData(BasicLookupStrategy.java:532) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.security.acls.jdbc.BasicLookupStrategy$ProcessResultSet.extractData(BasicLookupStrategy.java:504) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.jdbc.core.JdbcTemplate$1.doInPreparedStatement(JdbcTemplate.java:733) ~[spring-jdbc-6.2.0.jar:6.2.0]
        at org.springframework.jdbc.core.JdbcTemplate.execute(JdbcTemplate.java:658) ~[spring-jdbc-6.2.0.jar:6.2.0]
        at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:723) ~[spring-jdbc-6.2.0.jar:6.2.0]
        at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:754) ~[spring-jdbc-6.2.0.jar:6.2.0]
        at org.springframework.security.acls.jdbc.BasicLookupStrategy.lookupObjectIdentities(BasicLookupStrategy.java:335) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.security.acls.jdbc.BasicLookupStrategy.readAclsById(BasicLookupStrategy.java:300) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.security.acls.jdbc.JdbcAclService.readAclsById(JdbcAclService.java:136) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.security.acls.jdbc.JdbcAclService.readAclById(JdbcAclService.java:117) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.security.acls.jdbc.JdbcAclService.readAclById(JdbcAclService.java:125) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.security.acls.jdbc.JdbcMutableAclService.createAcl(JdbcMutableAclService.java:130) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at com.example.demo.DataSourcePopulator.lambda$afterPropertiesSet$0(DataSourcePopulator.java:97) ~[main/:na]
        at org.springframework.transaction.support.TransactionTemplate.execute(TransactionTemplate.java:140) ~[spring-tx-6.2.0.jar:6.2.0]
        at com.example.demo.DataSourcePopulator.afterPropertiesSet(DataSourcePopulator.java:95) ~[main/:na]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1849) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1798) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:601) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:523) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:336) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:288) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:334) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.instantiateSingleton(DefaultListableBeanFactory.java:1122) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingleton(DefaultListableBeanFactory.java:1093) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:1030) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:987) ~[spring-context-6.2.0.jar:6.2.0]
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:627) ~[spring-context-6.2.0.jar:6.2.0]
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:752) ~[spring-boot-3.4.0.jar:3.4.0]
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:439) ~[spring-boot-3.4.0.jar:3.4.0]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:318) ~[spring-boot-3.4.0.jar:3.4.0]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1361) ~[spring-boot-3.4.0.jar:3.4.0]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1350) ~[spring-boot-3.4.0.jar:3.4.0]
        at com.example.demo.DemoApplication.main(DemoApplication.java:10) ~[main/:na]
```

When we change `OBJECT_ID_IDENTITY` to `BIGINT` you should see the following error.

```
Caused by: org.postgresql.util.PSQLException: ERROR: operator does not exist: bigint = character varying
  Hint: No operator matches the given name and argument types. You might need to add explicit type casts.
  Position: 190
        at org.postgresql.core.v3.QueryExecutorImpl.receiveErrorResponse(QueryExecutorImpl.java:2733) ~[postgresql-42.7.4.jar:42.7.4]
        at org.postgresql.core.v3.QueryExecutorImpl.processResults(QueryExecutorImpl.java:2420) ~[postgresql-42.7.4.jar:42.7.4]
        at org.postgresql.core.v3.QueryExecutorImpl.execute(QueryExecutorImpl.java:372) ~[postgresql-42.7.4.jar:42.7.4]
        at org.postgresql.jdbc.PgStatement.executeInternal(PgStatement.java:517) ~[postgresql-42.7.4.jar:42.7.4]
        at org.postgresql.jdbc.PgStatement.execute(PgStatement.java:434) ~[postgresql-42.7.4.jar:42.7.4]
        at org.postgresql.jdbc.PgPreparedStatement.executeWithFlags(PgPreparedStatement.java:194) ~[postgresql-42.7.4.jar:42.7.4]
        at org.postgresql.jdbc.PgPreparedStatement.executeQuery(PgPreparedStatement.java:137) ~[postgresql-42.7.4.jar:42.7.4]
        at com.zaxxer.hikari.pool.ProxyPreparedStatement.executeQuery(ProxyPreparedStatement.java:52) ~[HikariCP-5.1.0.jar:na]
        at com.zaxxer.hikari.pool.HikariProxyPreparedStatement.executeQuery(HikariProxyPreparedStatement.java) ~[HikariCP-5.1.0.jar:na]
        at org.springframework.jdbc.core.JdbcTemplate$1.doInPreparedStatement(JdbcTemplate.java:732) ~[spring-jdbc-6.2.0.jar:6.2.0]
        at org.springframework.jdbc.core.JdbcTemplate.execute(JdbcTemplate.java:658) ~[spring-jdbc-6.2.0.jar:6.2.0]
        at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:723) ~[spring-jdbc-6.2.0.jar:6.2.0]
        at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:754) ~[spring-jdbc-6.2.0.jar:6.2.0]
        at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:767) ~[spring-jdbc-6.2.0.jar:6.2.0]
        at org.springframework.jdbc.core.JdbcTemplate.queryForObject(JdbcTemplate.java:889) ~[spring-jdbc-6.2.0.jar:6.2.0]
        at org.springframework.jdbc.core.JdbcTemplate.queryForObject(JdbcTemplate.java:918) ~[spring-jdbc-6.2.0.jar:6.2.0]
        at org.springframework.security.acls.jdbc.JdbcMutableAclService.retrieveObjectIdentityPrimaryKey(JdbcMutableAclService.java:325) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.security.acls.jdbc.JdbcMutableAclService.createAcl(JdbcMutableAclService.java:116) ~[spring-security-acl-6.4.1.jar:6.4.1]
        ... 22 common frames omitted
```

Modifying the `acl_class` table and adding `class_id_type` also doesn't help.

```sql
create table acl_class(
    id bigserial not null primary key,
    class varchar(100) not null,
    class_id_type text,                        -- new line
    constraint unique_uk_2 unique(class)
);
```

It shows the same error message.

```
2024-12-07T08:54:52.074+01:00 DEBUG 53186 --- [demo] [           main] o.s.security.acls.jdbc.AclClassIdUtils   : Unable to obtain the class id type

org.postgresql.util.PSQLException: The column name class_id_type was not found in this ResultSet.
        at org.postgresql.jdbc.PgResultSet.findColumn(PgResultSet.java:3094) ~[postgresql-42.7.4.jar:42.7.4]
        at org.postgresql.jdbc.PgResultSet.getString(PgResultSet.java:2930) ~[postgresql-42.7.4.jar:42.7.4]
        at com.zaxxer.hikari.pool.HikariProxyResultSet.getString(HikariProxyResultSet.java) ~[HikariCP-5.1.0.jar:na]
        at org.springframework.security.acls.jdbc.AclClassIdUtils.classIdTypeFrom(AclClassIdUtils.java:90) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.security.acls.jdbc.AclClassIdUtils.hasValidClassIdType(AclClassIdUtils.java:81) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.security.acls.jdbc.AclClassIdUtils.identifierFrom(AclClassIdUtils.java:71) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.security.acls.jdbc.BasicLookupStrategy$ProcessResultSet.convertCurrentResultIntoObject(BasicLookupStrategy.java:580) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.security.acls.jdbc.BasicLookupStrategy$ProcessResultSet.extractData(BasicLookupStrategy.java:532) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.security.acls.jdbc.BasicLookupStrategy$ProcessResultSet.extractData(BasicLookupStrategy.java:504) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.jdbc.core.JdbcTemplate$1.doInPreparedStatement(JdbcTemplate.java:733) ~[spring-jdbc-6.2.0.jar:6.2.0]
        at org.springframework.jdbc.core.JdbcTemplate.execute(JdbcTemplate.java:658) ~[spring-jdbc-6.2.0.jar:6.2.0]
        at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:723) ~[spring-jdbc-6.2.0.jar:6.2.0]
        at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:754) ~[spring-jdbc-6.2.0.jar:6.2.0]
        at org.springframework.security.acls.jdbc.BasicLookupStrategy.lookupObjectIdentities(BasicLookupStrategy.java:335) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.security.acls.jdbc.BasicLookupStrategy.readAclsById(BasicLookupStrategy.java:300) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.security.acls.jdbc.JdbcAclService.readAclsById(JdbcAclService.java:136) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.security.acls.jdbc.JdbcAclService.readAclById(JdbcAclService.java:117) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.security.acls.jdbc.JdbcAclService.readAclById(JdbcAclService.java:125) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at org.springframework.security.acls.jdbc.JdbcMutableAclService.updateAcl(JdbcMutableAclService.java:357) ~[spring-security-acl-6.4.1.jar:6.4.1]
        at com.example.demo.DataSourcePopulator.lambda$afterPropertiesSet$0(DataSourcePopulator.java:106) ~[main/:na]
        at org.springframework.transaction.support.TransactionTemplate.execute(TransactionTemplate.java:140) ~[spring-tx-6.2.0.jar:6.2.0]
        at com.example.demo.DataSourcePopulator.afterPropertiesSet(DataSourcePopulator.java:101) ~[main/:na]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1849) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1798) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:601) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:523) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:336) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:288) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:334) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.instantiateSingleton(DefaultListableBeanFactory.java:1122) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingleton(DefaultListableBeanFactory.java:1093) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:1030) ~[spring-beans-6.2.0.jar:6.2.0]
        at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:987) ~[spring-context-6.2.0.jar:6.2.0]
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:627) ~[spring-context-6.2.0.jar:6.2.0]
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:752) ~[spring-boot-3.4.0.jar:3.4.0]
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:439) ~[spring-boot-3.4.0.jar:3.4.0]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:318) ~[spring-boot-3.4.0.jar:3.4.0]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1361) ~[spring-boot-3.4.0.jar:3.4.0]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1350) ~[spring-boot-3.4.0.jar:3.4.0]
        at com.example.demo.DemoApplication.main(DemoApplication.java:10) ~[main/:na]
```
