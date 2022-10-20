package com.nagarro.access.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
@PropertySource("classpath:config.properties")
@EnableJpaRepositories("com.nagarro.access.management.dao")
@EntityScan("com.nagarro.access.management.bean")
@ComponentScan("module-service")
public class AccessManagementAPIMain extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(AccessManagementAPIMain.class, args);
	}
	  @Override protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(AccessManagementAPIMain.class);
	    }
	  
	  @RequestMapping("/")
	  public String home() {
	    return "Hello Docker World";
	  }
}
