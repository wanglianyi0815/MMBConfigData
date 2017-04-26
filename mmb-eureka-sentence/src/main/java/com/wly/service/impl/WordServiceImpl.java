package com.wly.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wly.outterService.SubjectClient;
import com.wly.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Created by wly on 2017/4/17 0017.
 */
@Service
public class WordServiceImpl implements WordService {
    @Autowired
    SubjectClient subjectClient;

    @HystrixCommand(fallbackMethod="getFallbackSubject")
    public String getSubject() {
        return subjectClient.getWord();
    }

    public String getFallbackSubject() {
        return "竟然失败了";
    }
}
