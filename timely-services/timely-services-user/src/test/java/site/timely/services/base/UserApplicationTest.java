package site.timely.services.base;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class UserApplicationTest {

  public static void main(String[] args) {
    SpringApplication.run(UserApplicationTest.class, args);
  }
}
