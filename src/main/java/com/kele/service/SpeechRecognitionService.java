package com.kele.service;

import com.kele.request.AndroidRequest;
import com.kele.request.TalkRequest;
import com.kele.respone.BaseResponse;

public interface SpeechRecognitionService {

    BaseResponse<?> voice(AndroidRequest androidRequest);

    BaseResponse<?> talk(TalkRequest talkRequest);
}
