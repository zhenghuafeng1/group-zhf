package zhf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zhf.base.ResultMsg;
import zhf.service.FetchService;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @Autor zhenghf
 * @Date 2022/8/8
 * @ClassName
 * @Customer
 **/
@RestController
public class FetchController {

    @Autowired
    private FetchService fetchService;

    @GetMapping("/test")
    public ResultMsg test() throws Exception{
        ResultMsg msg=new ResultMsg();
            fetchService.test();
            msg.setErrorCode("0");
            msg.setSuccess(true);
            msg.setMessage("查询成功");
        return msg;
    }

    @GetMapping("/test1")
    public ResultMsg test1(){
        ResultMsg msg=new ResultMsg();
        msg.setErrorCode("0");
        msg.setSuccess(true);
        msg.setMessage("查询成功");

        Map<String,String> map=new HashMap<>();

        map.put("11","1");
        map.put("22","2");
        map.put("33","3");
        map.put("44","4");
        msg.setResult(map);


        return msg;
    }

}
