package simm.cloud.attence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "simm.cloud.attence")
@Import({MybatisConfig.class})
public class AttenceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AttenceApplication.class, args);
    }
}
