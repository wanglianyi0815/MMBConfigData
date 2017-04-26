package com.wly.outterService;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * Created by wanglianyi on 2017/4/17 0017.
 */
@FeignClient("mmb-eureka-client-subject")
public interface SubjectClient {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getWord();
}
