package simm.cloud.attence.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String sayHello(String name){
        String content = name+": hello world everybody!";
        System.out.println(content);
        return content;
    }
}
