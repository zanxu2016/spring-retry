package info.luckydog.springretry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

/**
 * RetryApplication
 *
 * @author eric
 * @since 2019/12/2
 */
@SpringBootApplication
@EnableRetry
public class RetryApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetryApplication.class);
    }
}
