package linilq.shop.bean.exception;

/**
 * 异常信息设定
 */
public enum BusinessRespondEnum {
    SUCCESS(200,"处理成功"),
    ERROR(400,"登陆失败"),
    ERROR_FIRST(40001,"简单级别的异常");

    BusinessRespondEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    private int code;
    private String msg;

    public Integer getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

}
