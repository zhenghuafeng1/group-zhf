package zhf.base;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Autor zhenghf
 * @Date 2022/8/8
 * @ClassName
 * @Customer
 **/
@ControllerAdvice
public class GlobaException{

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResultMsg throwGlobaException(Exception e){
        ResultMsg msg=new ResultMsg();
        msg.setErrorCode("-1");
        msg.setSuccess(false);
        msg.setMessage("系统异常");
        return msg;
    }
}
