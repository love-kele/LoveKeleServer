package com.kele.speech.client;

import com.baidu.aip.speech.AipSpeech;
import com.kele.context.Constants;
import com.kele.speech.request.SpeechRequest;
import com.kele.speech.response.BaiduSdkResponse;
import com.kele.utils.GsonUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class SpeechRecognitionClient {

    private static Logger logger = LoggerFactory.getLogger(SpeechRecognitionClient.class);

    @Value("${AppID}")
    private String APP_ID;

    @Value("${APIKey}")
    private String API_Key;

    @Value("${SercetKey}")
    private String Sercet_Key;


    public BaiduSdkResponse voiceToText(SpeechRequest speechRequest) {

        AipSpeech aipSpeech = new AipSpeech(APP_ID, API_Key, Sercet_Key);

        HashMap<String, Object> options = new HashMap<String, Object>();
//        options.put(Constants.Common.DEV_PID, Constants.LangType.PuTongHua_Model_Input);

        JSONObject jsonObject = aipSpeech.asr(speechRequest.getData(), speechRequest.getFormat(), Constants.Common.rate, options);

        BaiduSdkResponse baiduSdkResponse = GsonUtil.jsonToBean(String.valueOf(jsonObject), BaiduSdkResponse.class);

        return baiduSdkResponse;
    }

}
