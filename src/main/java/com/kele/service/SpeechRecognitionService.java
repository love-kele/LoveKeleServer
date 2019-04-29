package com.kele.service;

import com.kele.speech.request.AndroidRequest;
import com.kele.speech.response.BaseResponse;

public interface SpeechRecognitionService {

    BaseResponse<?> voice(AndroidRequest androidRequest);
}
