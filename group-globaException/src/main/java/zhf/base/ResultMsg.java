package zhf.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @Autor zhenghf
 * @Date 2022/8/8
 * @ClassName
 * @Customer
 **/
@Data
public class ResultMsg implements Serializable {
    private boolean success;
    private String errorCode;
    private String message;
    private Object result;
}
