package com.demonran.portal.jxc.common;

/**
 * 接口响应码
 * Created by 80002387 on 2018/3/19.
 */
public enum ResponseCode {

    SUCCESS(200,"执行成功"), REFUSED(500), NO_RESULT_FOUND(404), FAILED(400);

    private int code;

    private String msg;

    ResponseCode(int code) {
        this.code = code;
    }

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
