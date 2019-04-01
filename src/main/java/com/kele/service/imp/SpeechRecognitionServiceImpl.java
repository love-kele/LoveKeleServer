package com.kele.service.imp;

import com.baidu.aip.util.Util;
import com.kele.service.SpeechRecognitionService;
import com.kele.speech.client.SpeechRecognitionClient;
import com.kele.speech.request.AndroidRequest;
import com.kele.speech.request.SpeechRequest;
import com.kele.speech.response.BaiduSdkResponse;
import com.kele.speech.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class SpeechRecognitionServiceImpl implements SpeechRecognitionService {
    @Autowired
    private SpeechRecognitionClient speechRecognitionClient;

    public BaseResponse voice(AndroidRequest androidRequest) {

        SpeechRequest speechRequest = new SpeechRequest();
        MultipartFile multipartFile = androidRequest.getMultipartFile();
        byte[] data = null;
        String name = multipartFile.getOriginalFilename();
        System.out.println(name);
        try {
             data = multipartFile.getBytes();
             speechRequest.setData(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String substring = name.substring(name.indexOf(".")+1);
        System.out.println(substring);
        speechRequest.setFormat(substring);


        BaiduSdkResponse baiduSdkResponse = speechRecognitionClient.voiceToText(speechRequest);
        if (baiduSdkResponse.getErr_no() != 0) {
            return new BaseResponse(baiduSdkResponse.getErr_no(), baiduSdkResponse.getErr_msg(), baiduSdkResponse);
        }
        return new BaseResponse(baiduSdkResponse);
    }
}
