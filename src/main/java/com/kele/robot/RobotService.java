package com.kele.robot;

import com.kele.respone.RobotResponse;

/**
 * 机器人接口
 */
public interface RobotService {

    RobotResponse talk(String text);
}
