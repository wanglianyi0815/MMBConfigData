package com.wly.controller;

import com.wly.outterService.SubjectClient;
import com.wly.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Created by wanglianyi on 2017/4/17 0017.
 */
@RestController
public class FeginController {

    @Autowired
    WordService wordService;

    @RequestMapping("/feginsen")
    public String getSentence() {
        return
                "<h3>造句:</h3><br/>" +
                        buildSentence() + "<br/><br/>" +
                        buildSentence() + "<br/><br/>" +
                        buildSentence() + "<br/><br/>" +
                        buildSentence() + "<br/><br/>" +
                        buildSentence() + "<br/><br/>"
                ;
    }
    public String buildSentence() {

        return wordService.getSubject();
    }

}
