package com.kele.service.imp;

import com.kele.service.SpeechRecognitionService;
import com.kele.speech.client.SpeechRecognitionClient;
import com.kele.speech.request.SpeechRequest;
import com.kele.speech.response.BaiduSdkResponse;
import com.kele.speech.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpeechRecognitionServiceImpl implements SpeechRecognitionService {
    @Autowired
    private SpeechRecognitionClient speechRecognitionClient;

    public BaseResponse voice(SpeechRequest speechRequest) {

        BaiduSdkResponse baiduSdkResponse = speechRecognitionClient.voiceToText(speechRequest);
        if(baiduSdkResponse.getErr_no()!=0){
            return new BaseResponse(baiduSdkResponse.getErr_no(),baiduSdkResponse.getErr_msg(),baiduSdkResponse);
        }
        return new BaseResponse(baiduSdkResponse);
    }
}
