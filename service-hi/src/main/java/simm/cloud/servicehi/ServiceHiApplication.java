package simm.cloud.servicehi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceHiApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServiceHiApplication.class, args);
    }
    @Value("${server.port}")
    String port;
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String home(@RequestParam String name,HttpServletRequest request) {
        return "【ServiceHi】hi "+name+",i am from eureka port:" + port;
    }
}
