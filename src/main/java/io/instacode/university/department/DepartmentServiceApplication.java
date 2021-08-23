package io.instacode.university.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("io.instacode.university.department.model")
@SpringBootApplication
@EnableJpaRepositories
@EnableDiscoveryClient
@RibbonClient(name = "department-service")
public class DepartmentServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(DepartmentServiceApplication.class, args);
  }

}
