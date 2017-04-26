package com.wly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class BalanceController {
    @Autowired
    LoadBalancerClient loadBalancer;

    @RequestMapping("/balance")
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
        ServiceInstance instance = loadBalancer.choose(service);
        if(instance==null){
            return null;
        }else{
            return (new RestTemplate()).getForObject(instance.getUri(),String.class);
        }
    }
}
