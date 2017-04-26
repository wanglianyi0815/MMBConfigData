package com.wly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    DiscoveryClient client;

    @RequestMapping("/sentence")
    public  String getSentence() {
        return
                getWord("mmb-eureka-client-subject") + " "
                        + getWord("MMB-EUREKA-CLIENT-VERB") + " "
                        + getWord("mmb-eureka-client-article") + " "
                        + getWord("mmb-eureka-client-adjective") + " "
                        + getWord("mmb-eureka-client-noun") + "."
                ;//大小写不区分
    }

    public String getWord(String service) {
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0 ) {
            URI uri = list.get(0).getUri();
            if (uri !=null ) {
                return (new RestTemplate()).getForObject(uri,String.class);
            }
        }
        return null;
    }
}
