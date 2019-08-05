package linilq.shop.bean.api;

import linilq.shop.bean.exception.BusinessRespondEnum;

import java.io.Serializable;

/**
 * @author lizhijian
 * @description 响应接口信息基础bean
 * @date 2019/7/2
 */
public class ApiResponse<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public ApiResponse(T t){
        this(BusinessRespondEnum.SUCCESS,t);
    }

    public ApiResponse(BusinessRespondEnum code){
        this(code.getCode(),code.getMsg(),null);
    }
    public ApiResponse(BusinessRespondEnum code, T t){
        this(code.getCode(),code.getMsg(),t);
    }
    private ApiResponse(int code, String msg, T t){
        this.code = code;
        this.msg = msg;
        this.data = t;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
