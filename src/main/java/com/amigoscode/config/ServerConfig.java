package com.amigoscode.config;

// TODO: 19 - Change the embedded web server from Tomcat to Jetty:
//  Open pom.xml and:
//  1. Add an exclusion to spring-boot-starter-web to exclude spring-boot-starter-tomcat
//  2. Add the spring-boot-starter-jetty dependency
//  Example:
//    <dependency>
//        <groupId>org.springframework.boot</groupId>
//        <artifactId>spring-boot-starter-web</artifactId>
//        <exclusions>
//            <exclusion>
//                <groupId>org.springframework.boot</groupId>
//                <artifactId>spring-boot-starter-tomcat</artifactId>
//            </exclusion>
//        </exclusions>
//    </dependency>
//    <dependency>
//        <groupId>org.springframework.boot</groupId>
//        <artifactId>spring-boot-starter-jetty</artifactId>
//    </dependency>

// TODO: 20 - Configure server properties in application.yml:
//  server:
//    port: 9090
//    servlet:
//      context-path: /amigoscode
//    jetty:
//      connection-idle-timeout: 30s
//  After this change, your API will be at: http://localhost:9090/amigoscode/api/v1/orders
