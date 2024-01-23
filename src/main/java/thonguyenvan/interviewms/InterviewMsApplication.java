package thonguyenvan.interviewms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class InterviewMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterviewMsApplication.class, args);
    }

}
