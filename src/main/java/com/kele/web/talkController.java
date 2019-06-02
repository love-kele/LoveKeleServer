package com.kele.web;

import com.kele.request.TalkRequest;
import com.kele.respone.BaseResponse;
import com.kele.robot.RobotService;
import com.kele.service.SpeechRecognitionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class talkController {

    @Autowired
    private SpeechRecognitionService speechRecognitionService;
    @Autowired
    private RobotService robotService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/talk", method = RequestMethod.POST)
    public BaseResponse<?> talkToKele(TalkRequest talkRequest) {

        if (StringUtils.isBlank(talkRequest.getText()))

            return speechRecognitionService.talk(talkRequest);
        else
            return new BaseResponse<>(robotService.talk(talkRequest.getText()));
    }
}
