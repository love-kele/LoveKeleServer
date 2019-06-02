package com.kele.context.robot;

import java.util.Map;

public class Intent {
    /**
     * 输出功能code
     */
    private Integer code;
    /**
     * 意图名称
     */
    private String intentName;
    /**
     * 意图动作名称
     */
    private String actionName;
    /**
     * 功能相关参数
     */
    private Map  parameters;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getIntentName() {
        return intentName;
    }

    public void setIntentName(String intentName) {
        this.intentName = intentName;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Map getParameters() {
        return parameters;
    }

    public void setParameters(Map parameters) {
        this.parameters = parameters;
    }
}
