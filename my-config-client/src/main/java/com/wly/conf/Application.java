package com.wly.conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * Created by wanglianyi on 2017/4/17 0017.
 */
@SpringBootApplication(scanBasePackages = {"com.**.controller"})
@Controller
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @RequestMapping("/home")
    @ResponseBody
    String home() {
        return "welcome to the test system";
    }
}
