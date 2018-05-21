package com.gy.love.loveapi.utils.response;

import static com.gy.love.loveapi.utils.response.HttpStatusAndMsg.exs;

/**
 * @Author gy
 * @Date: Create in 2018/3/30 20:37
 * @Description 统一实例返回格式
 * @Modified By:
 */
public class HttpResponseAndStatus {


    public final static BaseResponse baseResponse(int status) {
        return baseResponse(status, null);
    }


    public final static BaseResponse baseResponse(int status, String msg) {

        if (msg != null) {
            return new BaseResponse(status, exs.get(status) + ":" + msg);
        } else {
            return new BaseResponse(status, exs.get(status));
        }
    }


    public final static SimpleResponse simpleResponse(int status) {
        return simpleResponse(status, null, null);
    }

    public final static SimpleResponse simpleResponse(int status, String msg) {
        return simpleResponse(status, msg, null);
    }

    public final static SimpleResponse simpleResponse(int status, Object data) {
        return simpleResponse(status, null, data);
    }


    public final static SimpleResponse simpleResponse(int status, String msg, Object data) {

        SimpleResponse response = new SimpleResponse();
        response.setStatus(status);
        if (msg != null) {
            response.setMsg(msg);
        } else {
            response.setMsg(exs.get(status));
        }
        response.setData(data);
        return response;
    }
}
