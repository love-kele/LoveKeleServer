package com.kele.web;

import com.kele.service.SpeechRecognitionService;
import com.kele.request.AndroidRequest;
import com.kele.respone.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpeechController {

    @Autowired
    private SpeechRecognitionService speechRecognitionService;

    @RequestMapping(value = "/voice",method = RequestMethod.POST)
    public BaseResponse dialogue(AndroidRequest androidRequest) {

        return
                speechRecognitionService.voice(androidRequest);

    }
}
