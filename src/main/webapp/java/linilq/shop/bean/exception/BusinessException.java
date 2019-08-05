package linilq.shop.bean.exception;

/**
 * @author lizhijian
 * @description 业务异常
 * @date 2019/7/10
 */
public class BusinessException extends RuntimeException {

    private BusinessRespondEnum exceptionEnum;
    private Object data;

    public BusinessException(BusinessRespondEnum exceptionEnum, Object object){
        super();
        this.exceptionEnum = exceptionEnum;
        this.data = object;
    }
    public BusinessException(BusinessRespondEnum exceptionEnum, Object object, Throwable throwable){
        super(throwable);
        this.exceptionEnum = exceptionEnum;
        this.data = object;
    }


}
