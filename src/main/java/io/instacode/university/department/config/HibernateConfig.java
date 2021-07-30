package io.instacode.university.department.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

  @Bean(name = "entityManagerFactory")
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());
    sessionFactory.setPackagesToScan("io.instacode.university.department");
    sessionFactory.setHibernateProperties(hibernateProperties());
    return sessionFactory;
  }

  private final Properties hibernateProperties() {
    Properties hibernateProperties = new Properties();
    hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
    hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");


    return hibernateProperties;
  }

  @Bean
  public DataSource dataSource() {
    DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();

    dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
    dataSourceBuilder.url("jdbc:mysql://localhost:3306/university-department-db?allowPublicKeyRetrieval=true&createDatabaseIfNotExist=true");
    dataSourceBuilder.username("springuser");
    dataSourceBuilder.password("ThePassword");
    return dataSourceBuilder.build();
  }

  @Bean
  public PlatformTransactionManager hibernateTransactionManager() {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory().getObject());
    return transactionManager;
  }
}
