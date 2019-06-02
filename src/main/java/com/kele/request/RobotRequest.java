package com.kele.request;

import com.kele.context.robot.Perception;
import com.kele.context.robot.UserInfo;

public class RobotRequest {

    private final int reqType=0;

    private Perception perception;

    private UserInfo userInfo;

    public int getReqType() {
        return reqType;
    }

    public Perception getPerception() {
        return perception;
    }

    public void setPerception(Perception perception) {
        this.perception = perception;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
