package com.kele.robot.impl;

import com.kele.context.Constants;
import com.kele.context.robot.InputText;
import com.kele.context.robot.Perception;
import com.kele.context.robot.UserInfo;
import com.kele.request.RobotRequest;
import com.kele.respone.RobotResponse;
import com.kele.robot.RobotService;
import com.kele.utils.BeanUtil;
import com.kele.utils.GsonUtil;
import com.kele.utils.HttpCilentUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RobotServiceImpl implements RobotService {

    private static final Logger logger = LoggerFactory.getLogger(RobotServiceImpl.class);

    private static final String url = Constants.Common.ROBOT_API;

    @Override
    public RobotResponse talk(String text) {
        RobotRequest req = getReq(text);

        String s = GsonUtil.beanToJson(req);
        logger.info(String.format("请求参数  =%s ", s));
        String result = HttpCilentUtil.doPostJson(url, s);

        RobotResponse robotResponse = GsonUtil.jsonToBean(result, RobotResponse.class);
        logger.info(String.format("ask = %s , ans = %s", text, robotResponse.getResults()[0].getValues()));
        return robotResponse;
    }


    private RobotRequest getReq(String text) {

        UserInfo userInfo = new UserInfo();
        Perception perception = new Perception();
        InputText inputText = new InputText();
        inputText.setText(text);
        perception.setInputText(inputText);
        RobotRequest robotRequest = new RobotRequest();
        robotRequest.setUserInfo(userInfo);
        robotRequest.setPerception(perception);

        return robotRequest;
    }


}
