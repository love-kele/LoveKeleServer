package com.kele.speech.client;

import com.baidu.aip.speech.AipSpeech;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

public class SpeechRecognitionClient {

    @Value("${AppID}")
    private String APP_ID="15777587";

    @Value("${APIKey}")
    private String API_Key="8CmfvoP1df6Ak9DSN948R1WW";

    @Value("${SercetKey}")
    private String Sercet_Key="fuN1BoEDm18FWMH5Ea9eW3XPiWcljRgR";

    @Test
    public void Speech(){

        AipSpeech  speechclient = new AipSpeech(APP_ID,API_Key,Sercet_Key);

        speechclient.setConnectionTimeoutInMillis(2000);
        speechclient.setSocketTimeoutInMillis(2000);

        System.out.println(API_Key+"  "+APP_ID+"  "+Sercet_Key);
        JSONObject wav = speechclient.asr("D:\\test.pcm", "pcm", 16000, null);


        System.out.println(wav.toString(2));


    }

}
