package com.demonran.portal.jxc.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 01182799
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SFbinResult<T> {

    /**
     * 响应业务状态
     */
    private int status;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应中的数据
     */
    private T data;

    public static SFbinResultBuilder builder() {
        return new SFbinResultBuilder();
    }

    public static SFbinResult ok() {
        return SFbinResultBuilder.build(ResponseCode.SUCCESS);
    }

    public static <T> SFbinResult<T> ok(T data) {
        return SFbinResultBuilder.build(ResponseCode.SUCCESS, data);
    }

    public static SFbinResult fail(Throwable e) {
        return SFbinResultBuilder.build(ResponseCode.REFUSED, e.getMessage());
    }

    public static SFbinResult fail(String message) {
        return SFbinResultBuilder.build(ResponseCode.REFUSED, message);
    }

    public static class SFbinResultBuilder<T> {

        // 响应业务状态
        private int status;

        // 响应消息
        private String msg;

        // 响应中的数据
        private T data;

        public SFbinResultBuilder status(int status) {
            this.status = status;
            return this;
        }

        public SFbinResultBuilder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public SFbinResultBuilder data(T data) {
            this.data = data;
            return this;
        }

        public SFbinResult build() {
            return new SFbinResult(status, msg, data);
        }


        public static <T> SFbinResult<T> build(ResponseCode code, String msg, T data) {
            return new SFbinResult(code.getCode(), msg, data);
        }

        public static <T> SFbinResult<T> build(ResponseCode responseCode) {
            return build(responseCode, null, null);
        }

        public static <T> SFbinResult<T> build(ResponseCode responseCode, T data) {
            return build(responseCode, responseCode.getMsg(), data);
        }
    }
}
