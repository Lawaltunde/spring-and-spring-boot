package com.amigoscode.config;

// TODO: 22 - Enable JPA Auditing:
//  - Add @Configuration and @EnableJpaAuditing annotations to this class
//  - Create a @Bean method that returns AuditorAware<String>
//  - For now, return () -> Optional.of("system") as the auditor
//  Then go back to Student and add:
//  - @CreatedBy on a new field: private String createdBy
//  - @LastModifiedBy on a new field: private String updatedBy
public class AuditingConfig {

}
