package com.kele.context.robot;

public class InputText {
    /**
     * 直接输入文本
     */
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "InputText{" +
                "text='" + text + '\'' +
                '}';
    }
}
