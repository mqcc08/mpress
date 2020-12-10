package mc.mpress.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("mc.mpress")
public class MpressApplication {
    public static void main(String[] args) {
        SpringApplication.run(MpressApplication.class , args);
    }
}
