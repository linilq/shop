package linilq.shop.config;

import linilq.shop.bean.api.ApiResponse;
import linilq.shop.bean.exception.BusinessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lizhijian
 * @description 全局异常处理
 * @date 2019/7/10
 */
@ControllerAdvice(annotations = Controller.class)
public class ShopControllerAdvice {

    @ExceptionHandler(BusinessException.class)
    public ApiResponse<String> handleBusinessException(BusinessException e){
        ApiResponse<String> resonse = new ApiResponse(e);
        return resonse;
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<String> handleURLException(BusinessException e){
        ApiResponse<String> resonse = new ApiResponse(e);
        return resonse;
    }
}
