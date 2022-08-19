package zhf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zhf.entity.UserEntity;
import zhf.service.QueryUserService;
import zhf.service.imp.TestUserService;

import java.util.List;

@RestController
@RequestMapping("query")
public class LoginController {

    @Autowired
    QueryUserService queryUserService;

    @Autowired
    TestUserService testUserService;

    @GetMapping("/info")
    public List queryById(){
        return queryUserService.queryUserById();
    }

    @GetMapping("/test")
    public Object test(){
        return testUserService.getDefaultUser();
    }

}
