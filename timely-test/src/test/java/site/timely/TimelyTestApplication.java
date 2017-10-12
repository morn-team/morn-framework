package site.timely;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TimelyTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TimelyTestApplication.class, args);
    }
}
