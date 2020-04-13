package site.morn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import site.morn.boot.data.jpa.JpaRepositoryFactoryProducer;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = JpaRepositoryFactoryProducer.class)
@EnableTransactionManagement
public class TimelyTestApplication {

  public static void main(String[] args) {
    SpringApplication.run(TimelyTestApplication.class, args);
  }
}
