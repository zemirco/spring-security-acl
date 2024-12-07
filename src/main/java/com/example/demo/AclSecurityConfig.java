package com.example.demo;

import javax.sql.DataSource;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.acls.AclPermissionCacheOptimizer;
import org.springframework.security.acls.AclPermissionEvaluator;
import org.springframework.security.acls.domain.AclAuthorizationStrategyImpl;
import org.springframework.security.acls.domain.ConsoleAuditLogger;
import org.springframework.security.acls.domain.DefaultPermissionGrantingStrategy;
import org.springframework.security.acls.domain.SpringCacheBasedAclCache;
import org.springframework.security.acls.jdbc.BasicLookupStrategy;
import org.springframework.security.acls.jdbc.JdbcMutableAclService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Configuration
public class AclSecurityConfig {

  final DataSource dataSource;

  public AclSecurityConfig(final DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Bean
  public JdbcMutableAclService aclService() {
    var authorizationStrategy =
        new AclAuthorizationStrategyImpl(new SimpleGrantedAuthority("ROLE_ADMIN"));
    var auditLogger = new ConsoleAuditLogger();
    var cache = new ConcurrentMapCache("acl");
    var strategy = new DefaultPermissionGrantingStrategy(auditLogger);
    var aclCache = new SpringCacheBasedAclCache(cache, strategy, authorizationStrategy);

    var lookupStrategy =
        new BasicLookupStrategy(dataSource, aclCache, authorizationStrategy, auditLogger);

    var service = new JdbcMutableAclService(dataSource, lookupStrategy, aclCache);

    service.setSidIdentityQuery("select currval(pg_get_serial_sequence('acl_sid', 'id'))");
    service.setClassIdentityQuery("select currval(pg_get_serial_sequence('acl_class', 'id'))");

    // service.setSidIdentityQuery("SELECT currval('acl_sid_id_seq')");
    // service.setClassIdentityQuery("SELECT currval('acl_class_id_seq')");

    return service;
  }

  @Bean
  public DefaultMethodSecurityExpressionHandler expressionHandler() {
    var expressionHandler = new DefaultMethodSecurityExpressionHandler();
    var permissionEvaluator = new AclPermissionEvaluator(aclService());
    expressionHandler.setPermissionEvaluator(permissionEvaluator);
    expressionHandler.setPermissionCacheOptimizer(new AclPermissionCacheOptimizer(aclService()));
    return expressionHandler;
  }
}
