package com.kele.service;

import com.kele.speech.request.SpeechRequest;
import com.kele.speech.response.BaseResponse;

public interface SpeechRecognitionService {

    BaseResponse voice(SpeechRequest speechRequest);
}
