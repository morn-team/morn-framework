package site.morn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import site.morn.boot.support.JpaRepositoryFactoryBean;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = JpaRepositoryFactoryBean.class)
@EnableTransactionManagement
public class TimelyTestApplication {

  public static void main(String[] args) {
    SpringApplication.run(TimelyTestApplication.class, args);
  }
}
