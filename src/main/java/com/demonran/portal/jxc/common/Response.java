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
public class Response<T> {

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

    public static Response ok() {
        return SFbinResultBuilder.build(ErrorCode.SUCCESS);
    }

    public static <T> Response<T> ok(T data) {
        return SFbinResultBuilder.build(ErrorCode.SUCCESS, data);
    }

    public static Response fail(Throwable e) {
        return SFbinResultBuilder.build(ErrorCode.REFUSED, e.getMessage());
    }

    public static Response fail(String message) {
        return SFbinResultBuilder.build(ErrorCode.REFUSED, message);
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

        public Response build() {
            return new Response(status, msg, data);
        }


        public static <T> Response<T> build(ErrorCode code, String msg, T data) {
            return new Response(code.getCode(), msg, data);
        }

        public static <T> Response<T> build(ErrorCode errorCode) {
            return build(errorCode, null, null);
        }

        public static <T> Response<T> build(ErrorCode errorCode, T data) {
            return build(errorCode, errorCode.getMsg(), data);
        }
    }
}
